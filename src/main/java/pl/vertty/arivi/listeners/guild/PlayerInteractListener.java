
package pl.vertty.arivi.listeners.guild;

import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventPriority;
import java.util.Iterator;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.block.Block;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.guild.GuildInfoCommand;
import pl.vertty.arivi.utils.guild.DataUtil;
import pl.vertty.arivi.commands.guild.GuildPanelCommand;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.event.player.PlayerInteractEntityEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.yml.Config;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.utils.guild.RandomUtil;

public class PlayerInteractListener implements Listener
{

    @EventHandler
    public void kowadlo(PlayerInteractEvent e){
        if(e.getBlock().getId() == BlockID.ANVIL){
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void ranking(final PlayerInteractEntityEvent playerInteractEntityEvent) {
        if (playerInteractEntityEvent.getEntity() instanceof Player) {
            final Player player = playerInteractEntityEvent.getPlayer();
            final Player player2 = (Player)playerInteractEntityEvent.getEntity();
            if (player2 != null) {
                final User user1 = UserManager.getUser(player2);
                final User user2 = UserManager.getUser(player);
                final User user3 = UserManager.getUser(player);
                if (user3 == null) {
                    return;
                }
                int n = (int)(94.0D + (user3.getPoints() - user1.getPoints()) * -0.25D);
                if (n <= 0) {
                    n = RandomUtil.getRandInt(8, 19);
                }
                final int i = n / 4 * 3;
                if (user1.isIncognitoNick()) {
                    player.sendMessage(ChatUtil.fixColor(Config.PLAYER_CLICK_SUCCESS.replace("{NICK}", "&cUKRYTO").replace("{POINTS}", Integer.toString(user1.getPoints())).replace("{MINUS}", String.valueOf(i)).replace("{PLUS}", String.valueOf(n))));
                    return;
                }
                player.sendMessage(ChatUtil.fixColor(Config.PLAYER_CLICK_SUCCESS.replace("{NICK}", player2.getName()).replace("{POINTS}", Integer.toString(user1.getPoints())).replace("{MINUS}", String.valueOf(i)).replace("{PLUS}", String.valueOf(n))));
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void interact(PlayerInteractEvent e) {
        if (e.isCancelled()){
            return;
        }
        Guild g = GuildManager.getGuild(e.getBlock().getLocation());
        if (g != null && e.getPlayer().getInventory().getItemInHand().getId() == 333) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        final Player player = playerInteractEvent.getPlayer();
        final Block clickedBlock = playerInteractEvent.getBlock();
        if (!playerInteractEvent.isCancelled() && clickedBlock != null) {
            final Guild guild = GuildManager.getGuild(clickedBlock.getLocation());
            if (clickedBlock.getId() == 19 && guild != null) {
                if (guild.isMember(player.getName())) {
                    GuildPanelCommand.openInv(player);
                    return;
                }
                if (guild.isMember(player.getName())) {
                    final Iterator<String> iterator = Config.GUILD_COMMAND_INFO_SUCCESS.iterator();
                    if (iterator.hasNext()) {
                        player.sendMessage(ChatUtil.fixColor(iterator.next().replace("{TAG}", guild.getTag()).replace("{NAZWA}", guild.getName()).replace("{OWNER}", guild.getOwner()).replace("{POINTS}", Integer.toString(guild.getPoints())).replace("{KILLS}", Integer.toString(guild.getKills())).replace("{LIFE}", Integer.toString(guild.getLife())).replace("{DEATHS}", Integer.toString(guild.getDeaths())).replace("{STARTTIME}", DataUtil.getDate(guild.getCreateTime())).replace("{MEMBERS}", StringUtils.join((Object[])GuildInfoCommand.getMemberList(guild.getMembers()), "&8, ")).replace("{ZASTEPCA}", guild.getLeader()).replace("{PROLONG}", DataUtil.secondsToString(guild.getProlong()))));
                    }
                }
            }
        }
    }
}
