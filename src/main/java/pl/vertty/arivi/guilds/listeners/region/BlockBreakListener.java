
package pl.vertty.arivi.guilds.listeners.region;

import java.util.Iterator;
import cn.nukkit.block.Block;
import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.utils.DataUtil;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.guilds.utils.region.CuboidUtil;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class BlockBreakListener implements Listener
{

    @EventHandler
    public void onBreakOBS(BlockBreakEvent e){
        if(e.getBlock().getId() == BlockID.BEDROCK){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreakCentrum(final BlockBreakEvent blockBreakEvent) {
        final Player player = blockBreakEvent.getPlayer();
        final Guild guild = GuildManager.getGuild(player.getLocation());
        if (guild != null && guild.isMember(player) && guild.getRegion().isInCentrum(blockBreakEvent.getBlock().getLocation(), 5, 0, 4)) {
            blockBreakEvent.setCancelled(true);
            ChatUtil.sendMessage((CommandSender)player, Config.GUILD_BUILD_CENTER);
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent) {
        if (blockBreakEvent.getBlock().getId() == 19) {
            blockBreakEvent.setCancelled(CuboidUtil.cancelAction(blockBreakEvent.getPlayer(), blockBreakEvent.getBlock().getLocation(), "", blockBreakEvent.getBlock().getId(), "ZNISZCZENIE"));
        }
        else {
            blockBreakEvent.setCancelled(CuboidUtil.cancelAction(blockBreakEvent.getPlayer(), blockBreakEvent.getBlock().getLocation(), "&cTo nie Twoja gildia!", blockBreakEvent.getBlock().getId(), "ZNISZCZENIE"));
        }
    }
    
    @EventHandler
    public void onBreakEgg(final BlockBreakEvent blockBreakEvent) {
        final Player player = blockBreakEvent.getPlayer();
        final Block block = blockBreakEvent.getBlock();
        final Guild guild = GuildManager.getGuild(block.getLocation());
        final Guild guild2 = GuildManager.getGuild(player);
        if (block.getId() == 19 && guild != null && !guild.isMember(player.getName())) {
            if (guild2 == null) {
                ChatUtil.sendMessage((CommandSender)player, Config.GUILD_INTERACT_ERROR);
                return;
            }
            if (guild.getAlly().contains(guild2.getTag())) {
                ChatUtil.sendMessage((CommandSender)player, Config.GUILD_INTERACT_ERROR1);
                return;
            }
            if (guild.getLifeLastAttack() > System.currentTimeMillis()) {
                ChatUtil.sendMessage((CommandSender)player, Config.GUILD_INTERACT_ERROR2.replace("{TIME}", DataUtil.secondsToString(guild.getLifeLastAttack())));
                return;
            }
            if (guild.getHp() <= 1) {
                guild.setLife(guild.getLife() - 1);
                guild.setHp(500);
                guild.setLifeLastAttack(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_INTERACT_MESSAGE2.replace("{TAG}", guild.getTag()).replace("{TAG2}", guild2.getTag())));
            }
            if (guild2.getLife() < 3) {
                guild2.setLife(guild2.getLife() + 1);
            }
            if (guild.getLife() < 1) {
                for (final Player p : guild.getOnlineMembers()) {
                    ChatUtil.sendMessage((CommandSender)p, "&7Twoja gildia zostala zniszczona przez &3" + guild2.getTag());
                }
                GuildManager.deleteGuild(guild);
                Server.getInstance().broadcastMessage(ChatUtil.fixColor(Config.GUILD_INTERACT_MESSAGE.replace("{TAG}", guild.getTag()).replace("{TAG2}", guild2.getTag())));
            }
            if (guild.getHp() == 499) {
                for (final Player p : guild.getOnlineMembers()) {
                    ChatUtil.sendFullTitle(p, "&cUWAGA", "&cTwoja gildia jest podbijana");
                }
            }
            if (guild.getHp() > 1) {
                guild.setHp(guild.getHp() - 1);
                guild2.title("", ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&7Gildii &3").append(guild2.getTag()).append(" &7pozostalo: &9").append(guild.getHp()).append(" &7HP"))));
                for (final Player p : guild.getOnlineMembers()) {
                    ChatUtil.sendSubTitle(p, String.valueOf(new StringBuilder().append("&7Pozostalo: &9").append(guild.getHp()).append(" &7HP")));
                }
            }
        }
    }
}
