// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi;

import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.mysql.Store;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.utils.SeralizerUtil;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.utils.ConfigSection;
import java.util.Iterator;
import java.util.Set;
import cn.nukkit.level.particle.Particle;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.utils.Config;
import cn.nukkit.level.Level;
import pl.vertty.arivi.managers.BackupManager;
import pl.vertty.arivi.task.SprawdzMessageTimer;
import cn.nukkit.entity.Entity;
import pl.vertty.arivi.entity.EntityHead;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.managers.guild.region.LockManager;
import pl.vertty.arivi.guilds.managers.guild.RoleManager;
import pl.vertty.arivi.guilds.managers.guild.WarManager;
import java.sql.SQLException;
import pl.vertty.arivi.wings.WingsManager;
import pl.vertty.arivi.tnt.EntityManager;
import pl.vertty.arivi.loader.MotdLoader;
import pl.vertty.arivi.loader.CraftingLoader;
import pl.vertty.arivi.loader.LevelLoad;
import pl.vertty.arivi.loader.TaskLoader;
import pl.vertty.arivi.loader.EventsLoader;
import pl.vertty.arivi.loader.CommandsLoader;
import pl.vertty.arivi.loader.DropsLoader;
import pl.vertty.arivi.wings.mysql.UserWings;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.managers.WarpManager;
import pl.vertty.arivi.loader.DatabaseLoader;
import pl.vertty.arivi.loader.TimeLoader;
import pl.vertty.arivi.loader.ConfigLoader;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.inventory.trade.TradeMenuHandler;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import java.util.HashMap;
import cn.nukkit.level.particle.FloatingTextParticle;
import cn.nukkit.level.Location;
import java.util.Map;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase
{
    private static Main plugin;
    public static long startUpTime;
    public static Map<Location, FloatingTextParticle> particles;
    public static Map<Location, FloatingTextParticle> particles1;
    private Map<Location, FloatingTextParticle> particles2;
    private Map<Location, String> crateLocations;
    
    public Main() {
        this.particles2 = new HashMap<Location, FloatingTextParticle>();
        this.crateLocations = new HashMap<Location, String>();
    }
    
    public void onEnable() {
        Main.startUpTime = System.currentTimeMillis();
        Main.plugin = this;
        final InventoryMenuHandler handler = new InventoryMenuHandler();
        final TradeMenuHandler handler2 = new TradeMenuHandler();
        this.getServer().getPluginManager().registerEvents((Listener)handler, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)handler2, (Plugin)this);
        ConfigLoader.onConfigLoad();
        TimeLoader.onTimeLoader();
        DatabaseLoader.onDatabaseLoad();
        WarpManager.loadWarp();
        BanManager.loadBans();
        UserManager.loadUsers();
        GuildManager.loadGuilds();
        UserWings.loadUsers();
        DropsLoader.onDropsLoad();
        CommandsLoader.onCommandsLoad();
        EventsLoader.onEventsLoad();
        TaskLoader.onTaskLoad();
        LevelLoad.onLevel();
        CraftingLoader.onCraftingLoad();
        MotdLoader.onLoad();
        EntityManager.init();
        try {
            WingsManager.init(this);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        WarManager.loadWars();
        RoleManager.loadRoles();
        LockManager.loadLocks();
        final Level world = Server.getInstance().getDefaultLevel();
        world.setThundering(false);
        world.setTime(2000);
        this.onCombat();
        Entity.registerEntity(EntityHead.class.getSimpleName(), (Class)EntityHead.class);
        new SprawdzMessageTimer(this);
        this.parseConfig();
        BackupManager.loadBackups();
        Iterator<Player> iterator = Server.getInstance().getOnlinePlayers().values().iterator();
        if (iterator.hasNext()) {
            Player p = iterator.next();
            Combat c = CombatManager.getCombat(p);
            if (c == null) {
                CombatManager.createCombat(p);
            }
            return;
        }
    }
    
    private void parseConfig() {
        final Config cfg = new Config(this.getDataFolder() + "/locations.yml", 2);
        Set<String> keys = (Set<String>)cfg.getKeys();
        keys = (Set<String>)cfg.getKeys(false);
        for (final String key : keys) {
            final ConfigSection cratesSection = cfg.getSection(key);
            final Location location = new Location(cratesSection.getDouble("x"), cratesSection.getDouble("y"), cratesSection.getDouble("z"), this.getServer().getLevelByName(cratesSection.getString("world")));
            final FloatingTextParticle particle = new FloatingTextParticle(location.add(0.5, 2.0, 0.5), ChatUtil.fixColor("&9Magiczna Skrzynka"), ChatUtil.fixColor("&8\u2039-------------------------\u203a\n\n&9Kliknij na nia kluczem, aby otworzyc\n&9Klucz zakupisz na stronie BlazePE.pl\n\n&8\u2039-------------------------\u203a\n"));
            location.getLevel().addParticle((Particle)particle);
            Main.particles.put(location, particle);
            this.crateLocations.put(location, "Magiczna Skrzynka" + key);
        }
    }
    
    public void onDisable() {
        for (final User user : UserManager.getUsers().values()) {
            user.setEnderchest_1(SeralizerUtil.serializeInventory((Inventory) user.getEc1()));
            user.setEnderchest_2(SeralizerUtil.serializeInventory((Inventory) user.getEc2()));
            user.setEnderchest_3(SeralizerUtil.serializeInventory((Inventory) user.getEc3()));
            user.setEnderchest_4(SeralizerUtil.serializeInventory((Inventory) user.getEc4()));
            user.setEnderchest_5(SeralizerUtil.serializeInventory((Inventory) user.getEc5()));
        }
        for (final Guild user2 : GuildManager.getGuilds().values()) {
            user2.setSkrzynka1(SeralizerUtil.serializeInventory((Inventory) user2.getSkrzynka()));
        }
        this.getServer().getServiceManager().cancel((Plugin) this);
        DropsLoader.onDataSaved();
        for (Player p : Server.getInstance().getOnlinePlayers().values()){
            CombatManager.removeCombat(p);
    }
        this.getServer().doAutoSave();
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (DatabaseLoader.store != null) {
            DatabaseLoader.store.disconnect();
        }
        Main.plugin = null;
        this.getServer().getScheduler().cancelAllTasks();
    }
    
    public static Store getStore() {
        return DatabaseLoader.store;
    }
    
    public static Main getPlugin() {
        return Main.plugin;
    }
    
    public void onCombat() {
        final Iterator<Player> iterator = Server.getInstance().getOnlinePlayers().values().iterator();
        if (iterator.hasNext()) {
            final Player p = iterator.next();
            final Combat c = CombatManager.getCombat(p);
            if (c == null) {
                CombatManager.createCombat(p);
            }
        }
    }
    
    public Map<Location, String> getCrateLocations() {
        return this.crateLocations;
    }
    
    public Map<Location, FloatingTextParticle> getParticles() {
        return Main.particles;
    }
    
    public Map<Location, FloatingTextParticle> getParticles1() {
        return Main.particles1;
    }
    
    public Map<Location, FloatingTextParticle> getParticles2() {
        return this.particles2;
    }
    
    static {
        Main.particles = new HashMap<Location, FloatingTextParticle>();
        Main.particles1 = new HashMap<Location, FloatingTextParticle>();
    }
}
