
package pl.vertty.arivi.loader;

import pl.vertty.arivi.listeners.consume.ItemConsumeListener;
import pl.vertty.arivi.listeners.macro.MacroListener;
import pl.vertty.arivi.listeners.nuker.NukerListener;
import pl.vertty.arivi.listeners.phase.PhaseListener;
import pl.vertty.arivi.listeners.reach.ReachListener;
import pl.vertty.arivi.listeners.rzucak.RzucakListener;
import pl.vertty.arivi.listeners.spawn.SpawnProtectionListener;
import pl.vertty.arivi.listeners.randomtp.RandomTPListener;
import pl.vertty.arivi.listeners.crafting.CraftingBlockAndCreateListener;
import pl.vertty.arivi.listeners.chat.ServerChatListener;
import pl.vertty.arivi.listeners.action.LiquidFlowListener;
import pl.vertty.arivi.managers.TimerManager;
import pl.vertty.arivi.listeners.cobblex.CobbleXListener;
import pl.vertty.arivi.listeners.weather.WeatherListener;
import pl.vertty.arivi.listeners.logs.LogsListener;
import pl.vertty.arivi.listeners.border.BorderListener;
import pl.vertty.arivi.listeners.player.MovementListener;
import pl.vertty.arivi.listeners.player.GodListener;
import pl.vertty.arivi.listeners.connection.CheckLoginListener;
import pl.vertty.arivi.listeners.protection.ProtectionListener;
import pl.vertty.arivi.listeners.drop.BreakDropListener;
import pl.vertty.arivi.listeners.player.PlayerJoinListener;
import pl.vertty.arivi.listeners.player.PlayerInterractListener;
import pl.vertty.arivi.listeners.premium.PandoraListener;
import pl.vertty.arivi.listeners.SprawdzListener;
import pl.vertty.arivi.guilds.listeners.BlockOpenInventoriesListener;
import pl.vertty.arivi.listeners.EnchantListener;
import pl.vertty.arivi.guilds.listeners.region.PlayerBucketListener;
import pl.vertty.arivi.guilds.listeners.permission.PermissionListener;
import pl.vertty.arivi.guilds.listeners.PlayerDeathListener;
import pl.vertty.arivi.guilds.listeners.PlayerJoinQuitListener;
import pl.vertty.arivi.guilds.listeners.InventoryClickListener;
import pl.vertty.arivi.guilds.listeners.region.GuildExplodeListener;
import pl.vertty.arivi.guilds.listeners.AsyncPlayerChatListener;
import pl.vertty.arivi.guilds.listeners.EntityDamageByEntityListener;
import pl.vertty.arivi.guilds.listeners.region.BlockPlaceListener;
import pl.vertty.arivi.guilds.listeners.PlayerInteractListener;
import pl.vertty.arivi.guilds.listeners.region.BlockBreakListener;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.listeners.region.PlayerMoveListener;
import cn.nukkit.Server;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginManager;

public class EventsLoader
{
    private static PluginManager pluginManager;
    
    public static void registerListener(final Plugin plugin, final Listener... listeners) {
        if (EventsLoader.pluginManager == null) {
            EventsLoader.pluginManager = Server.getInstance().getPluginManager();
        }
        for (final Listener listener : listeners) {
            EventsLoader.pluginManager.registerEvents(listener, plugin);
        }
    }
    
    public static void registerListeners() {
        final PluginManager pluginManager = Server.getInstance().getPluginManager();
        pluginManager.registerEvents(new PlayerMoveListener(), Main.getPlugin());
        pluginManager.registerEvents(new BlockBreakListener(), Main.getPlugin());
        pluginManager.registerEvents(new PlayerInteractListener(), Main.getPlugin());
        pluginManager.registerEvents(new BlockPlaceListener(), Main.getPlugin());
        pluginManager.registerEvents(new EntityDamageByEntityListener(), Main.getPlugin());
        pluginManager.registerEvents(new AsyncPlayerChatListener(), Main.getPlugin());
        pluginManager.registerEvents(new GuildExplodeListener(), Main.getPlugin());
        pluginManager.registerEvents(new EntityDamageByEntityListener(), Main.getPlugin());
        pluginManager.registerEvents(new InventoryClickListener(), Main.getPlugin());
        pluginManager.registerEvents(new PlayerJoinQuitListener(), Main.getPlugin());
        pluginManager.registerEvents(new PlayerDeathListener(), Main.getPlugin());
        pluginManager.registerEvents(new PermissionListener(), Main.getPlugin());
        pluginManager.registerEvents(new PlayerBucketListener(), Main.getPlugin());
    }



    
    public static void onEventsLoad() {
        registerListeners();
        registerListener(Main.getPlugin(), new PhaseListener(), new ReachListener(), new NukerListener(), new MacroListener(), new AsyncPlayerChatListener(), new LiquidFlowListener(), new ItemConsumeListener(), new RzucakListener(), new EnchantListener(), new BlockOpenInventoriesListener(), new SprawdzListener(), new PandoraListener(), new PlayerInterractListener(), new PlayerJoinListener(), new BreakDropListener(), new ProtectionListener(), new CheckLoginListener(), new GodListener(), new MovementListener(), new BorderListener(), new LogsListener(), new WeatherListener(), new CobbleXListener(), new TimerManager(), new ServerChatListener(), new CraftingBlockAndCreateListener(), new RandomTPListener(), new SpawnProtectionListener(), new pl.vertty.arivi.listeners.block.BlockBreakListener(), new pl.vertty.arivi.listeners.block.BlockPlaceListener());
    }
}
