
package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.Coooldown;
import pl.vertty.arivi.guilds.utils.DataUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.guilds.utils.region.CuboidUtil;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.managers.FakeWater;
import pl.vertty.arivi.managers.WaterManager;

import java.util.concurrent.TimeUnit;

public class BlockPlaceListener implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent blockPlaceEvent) {
        if (blockPlaceEvent.getBlock().getId() == 46 && !Config.ENABLE_TNT) {
            blockPlaceEvent.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_TNT_ERROR2));
            blockPlaceEvent.setCancelled(true);
        }
    }
    
    @EventHandler
    public void slimeblock(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        if (block.getId() == 165 && player.getFloorX() == block.getFloorX() && player.getFloorY() - 1 == block.getFloorY() && player.getFloorZ() == block.getFloorZ()) {
            player.setMotion(new Vector3(0.0, 2.0, 0.0));
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(final BlockPlaceEvent blockPlaceEvent) {
        blockPlaceEvent.setCancelled(CuboidUtil.cancelAction(blockPlaceEvent.getPlayer(), blockPlaceEvent.getBlock().getLocation(), "&cTo nie Twoja gildia!", blockPlaceEvent.getBlock().getId(), "POSTAWIENIE"));
    }
    private static final Coooldown<Player> COOLDOWN = new Coooldown<Player>();

    @EventHandler
    public void onPlaceCentrum(final BlockPlaceEvent blockPlaceEvent) {
        final Player player = blockPlaceEvent.getPlayer();
        final Guild guild = GuildManager.getGuild(player.getLocation());
        final Combat combat = CombatManager.getCombat(player);
        Block i = blockPlaceEvent.getBlock();
        if (guild != null && guild.isMember(player) && combat.hasFight() && player.getFloorY() <= 50) {
            blockPlaceEvent.setCancelled(true);
            ChatUtil.sendMessage((CommandSender) player, "&cStawianie blokow ponizej 50 kratki jest zabronione!");
        }
        if (guild != null && guild.isMember(player) && guild.getRegion().isInCentrum(blockPlaceEvent.getBlock().getLocation(), 5, 0, 4)) {
            blockPlaceEvent.setCancelled(true);
            ChatUtil.sendMessage((CommandSender) player, Config.GUILD_BUILD_CENTER);
            return;
        }
        if (!blockPlaceEvent.getPlayer().isOp() && guild != null && guild.isMember(blockPlaceEvent.getPlayer().getName()) && guild.getLastExplodeTime() > System.currentTimeMillis()) {
            blockPlaceEvent.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_TNT_MESSAGE.replace("{X}", DataUtil.secondsToString(guild.getLastExplodeTime()))));
            blockPlaceEvent.setCancelled(true);
        }
    }
}
