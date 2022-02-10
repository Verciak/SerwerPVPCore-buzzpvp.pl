package pl.vertty.arivi;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import lombok.SneakyThrows;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.managers.*;
import pl.vertty.arivi.mysql.Store;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.utils.SeralizerUtil;
import pl.vertty.arivi.guilds.data.User;
import java.util.*;
import cn.nukkit.level.Level;
import pl.vertty.arivi.task.SprawdzMessageTimer;
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
import pl.vertty.arivi.loader.DatabaseLoader;
import pl.vertty.arivi.loader.TimeLoader;
import pl.vertty.arivi.loader.ConfigLoader;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.event.Listener;
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
        EventsLoader.onEventsLoad();
        TaskLoader.onTaskLoad();
        LevelLoad.onLevel();
        CraftingLoader.onCraftingLoad();
        MotdLoader.onLoad();
        EntityManager.init();
        RestartManager.loadRestart();
        WhitelistManager.loadWhiteList();
        WhitelistManager.loadWhiteListReason();
        WhitelistManager.loadWhiteListStatus();
        ItemShopManager.loadUsers();
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
}
