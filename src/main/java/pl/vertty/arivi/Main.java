package pl.vertty.arivi;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.Entity;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import lombok.SneakyThrows;
import pl.vertty.arivi.entity.Arrow;
import pl.vertty.arivi.entity.EnderPearl;
import pl.vertty.arivi.entity.Snowball;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.managers.*;
import pl.vertty.arivi.managers.time.TimeObjectManager;
import pl.vertty.arivi.mysql.Store;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import cn.nukkit.level.Level;
import pl.vertty.arivi.task.SprawdzMessageTimer;
import cn.nukkit.Server;

import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import pl.vertty.arivi.wings.WingsManager;
import pl.vertty.arivi.loader.MotdLoader;
import pl.vertty.arivi.loader.LevelLoad;
import pl.vertty.arivi.loader.TaskLoader;
import pl.vertty.arivi.loader.EventsLoader;
import pl.vertty.arivi.loader.CommandsLoader;
import pl.vertty.arivi.wings.mysql.UserWings;
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
        registerEntity();
        ConfigLoader.onConfigLoad();
        TimeLoader.onTimeLoader();
        DatabaseLoader.onDatabaseLoad();
        ShopManager.loadUsers();
        BanManager.loadBans();
        UserManager.loadUsers();
        UserWings.loadUsers();
        CommandsLoader.onCommandsLoad();
        EventsLoader.onEventsLoad();
        TaskLoader.onTaskLoad();
        LevelLoad.onLevel();
        MotdLoader.onLoad();
        ItemShopManager.loadUsers();
        registerEnchants();
        TimeObjectManager.loadUsers();
        try {
            WingsManager.init(this);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        final Level level = Server.getInstance().getDefaultLevel();
        level.setThundering(false);
        level.setTime(2000);
        this.onCombat();
        new SprawdzMessageTimer(this);
        Iterator<Player> iterator = Server.getInstance().getOnlinePlayers().values().iterator();
        if (iterator.hasNext()) {
            Player p = iterator.next();
            Combat c = CombatManager.getCombat(p);
            if (c == null) {
                CombatManager.createCombat(p);
            }
            return;
        }
        File worlds = new File(this.getPlugin().getServer().getDataPath() + "/worlds");
        if (worlds.exists()) {
            for (String world : Objects.requireNonNull(worlds.list())) {
                if (!this.getPlugin().getServer().isLevelLoaded(world)) {
                    this.getPlugin().getServer().loadLevel(world);
                }
            }
        }
    }

    private void registerEnchants() {
        long startTime = System.nanoTime();
        registerEnchant(new CustomKnockback());
        long endTime = System.nanoTime();
        getLogger().info("Registered enchants in {S}ms".replace("{S}", String.valueOf((endTime - startTime) / 1000000L)));
    }

    public void registerEnchant(Enchantment customEnchant) {
        try {
            Field enchants = Enchantment.class.getDeclaredField("enchantments");
            enchants.setAccessible(true);
            Enchantment[] enchantments = (Enchantment[])enchants.get(null);
            enchantments[customEnchant.getId()] = customEnchant;
            enchants.set(null, enchantments);
            enchants.setAccessible(false);
        } catch (Exception exception) {
            getServer().getLogger().warning("Couldn't load enchantment " + customEnchant.getName(), exception);
        }
    }



    private void registerEntity() {
        long startTime = System.nanoTime();
        Entity.registerEntity(Snowball.class.getSimpleName(), Snowball.class);
        Entity.registerEntity(EnderPearl.class.getSimpleName(), EnderPearl.class);
        Entity.registerEntity(Arrow.class.getSimpleName(), Arrow.class);
        long endTime = System.nanoTime();
        getLogger().info("Registered entities in {S}ms".replace("{S}", String.valueOf((endTime - startTime) / 1000000L)));
    }
    
    public void onDisable() {
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
        for (ConcurrentHashMap<String, String> s : AntiGrief.getGrief().values()) {
            Location loc = new Location(Integer.valueOf(s.get("x")).intValue(), Integer.valueOf(s.get("y")).intValue(), Integer.valueOf(s.get("z")).intValue(), Server.getInstance().getLevelByName(s.get("world")));
            Block v = loc.getLevelBlock();
            if (AntiGrief.removeBlock(v))
                loc.getLevel().setBlock(loc, Block.get(0));
        }
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
        for (ConcurrentHashMap<String, String> s : AntiGrief.getGrief().values()) {
            Location loc = new Location(Integer.valueOf(s.get("x")).intValue(), Integer.valueOf(s.get("y")).intValue(), Integer.valueOf(s.get("z")).intValue(), Server.getInstance().getLevelByName(s.get("world")));
            Block v = loc.getLevelBlock();
            if (AntiGrief.removeBlock(v))
                loc.getLevel().setBlock(loc, Block.get(0));
        }
        for (Player p : Server.getInstance().getOnlinePlayers().values()){
            CombatManager.removeCombat(p);
        }
        plugin.getServer().doAutoSave();
        for(FakeWater water : WaterManager.getWaters().values()) {
            water.getLevel().setBlock(water, Block.get(BlockID.AIR));
        }
        plugin.getPlugin().getServer().shutdown();
    }
}
