
package pl.vertty.arivi.listeners.guild.region;

import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.utils.guild.Coooldown;
import pl.vertty.arivi.utils.guild.DataUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.utils.guild.region.CuboidUtil;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

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
