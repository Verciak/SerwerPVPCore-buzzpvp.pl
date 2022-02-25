package pl.vertty.arivi;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.Entity;
import lombok.SneakyThrows;
import pl.vertty.arivi.entity.*;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.managers.*;
import pl.vertty.arivi.mysql.Store;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.utils.SeralizerUtil;
import java.util.*;
import cn.nukkit.level.Level;
import pl.vertty.arivi.task.SprawdzMessageTimer;
import cn.nukkit.Server;
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
import pl.vertty.arivi.loader.DatabaseLoader;
import pl.vertty.arivi.loader.TimeLoader;
import pl.vertty.arivi.loader.ConfigLoader;
import pl.vertty.arivi.inventory.trade.TradeMenuHandler;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase
{
    public static Main plugin;
    public static long startUpTime;
    
    @SneakyThrows
    public void onEnable() {

        Main.startUpTime = System.currentTimeMillis();
        Main.plugin = this;
        final InventoryMenuHandler handler = new InventoryMenuHandler();
        final TradeMenuHandler handler2 = new TradeMenuHandler();
        this.getServer().getPluginManager().registerEvents(handler, this);
        this.getServer().getPluginManager().registerEvents(handler2, this);
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
        TaskLoader.onTaskLoad();
        LevelLoad.onLevel();
        CraftingLoader.onCraftingLoad();
        MotdLoader.onLoad();
        EntityManager.init();
        ItemShopManager.loadUsers();
        RoleManager.loadUsers();
        registerEntity();
        BlockFactory.registerBlock(12, FixedSand.class);
        try {
            WingsManager.init(this);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        final Level world = Server.getInstance().getDefaultLevel();
        world.setThundering(false);
        world.setTime(2000);
        this.onCombat();
        new SprawdzMessageTimer(this);
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
        MainConstants.set();
        EventsLoader.onEventsLoad();
    }
    
    public void onDisable() {
        for (final Guild user2 : GuildManager.getGuilds().values()) {
            user2.setSkrzynka1(SeralizerUtil.serializeInventory(user2.getSkrzynka()));
        }
        DropsLoader.onDataSaved();
        for (Player p : Server.getInstance().getOnlinePlayers().values()){
            CombatManager.removeCombat(p);
        }
        plugin.getServer().doAutoSave();
        for(FakeWater water : WaterManager.getWaters().values()) {
            water.getLevel().setBlock(water, Block.get(BlockID.AIR));
        }
        plugin.getPlugin().getServer().shutdown();
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


    public static void onRestart(){
        for (final Guild user2 : GuildManager.getGuilds().values()) {
            user2.setSkrzynka1(SeralizerUtil.serializeInventory((Inventory) user2.getSkrzynka()));
        }
        DropsLoader.onDataSaved();
        for (Player p : Server.getInstance().getOnlinePlayers().values()){
            CombatManager.removeCombat(p);
        }
        plugin.getServer().doAutoSave();
        for(FakeWater water : WaterManager.getWaters().values()) {
            water.getLevel().setBlock(water, Block.get(BlockID.AIR));
        }
        plugin.getPlugin().getServer().shutdown();
    }

    private void registerEntity() {
        long startTime = System.nanoTime();
        Entity.registerEntity(Snowball.class.getSimpleName(), Snowball.class);
        Entity.registerEntity(EnderPearl.class.getSimpleName(), EnderPearl.class);
        Entity.registerEntity(Arrow.class.getSimpleName(), Arrow.class);
        long endTime = System.nanoTime();
        getLogger().info("Registered entities in {S}ms".replace("{S}", String.valueOf((endTime - startTime) / 1000000L)));
    }

}
