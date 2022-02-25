
package pl.vertty.arivi.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.Combat;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.CombatManager;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;

public class ActionBarTask extends NukkitRunnable
{
    public void run() {
        for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
            String s = "";
            final cn.nukkit.utils.Config c = Main.getPlugin().getConfig();
            final User userr = UserManager.getUser(player);
            if (userr.getOchrona() != 0L) {
                if (userr.getOchrona() <= System.currentTimeMillis()) {
                    player.sendTitle(ChatUtil.fixColor(c.getString("protection.end-title")), ChatUtil.fixColor(c.getString("protection.end-subtitle")), 20, 40, 20);
                    userr.setOchrona(0L);
                }
                else {
                    s = ChatUtil.fixColor(c.getString("protection.actionbar").replace("{TIME}", DataUtil.secondsToString(userr.getOchrona()).isEmpty() ? "1s" : DataUtil.secondsToString(userr.getOchrona())));
                }
            }
            final Combat combat = CombatManager.getCombat(player);
            final Guild guild = GuildManager.getGuild(player);
            if (combat != null && combat.wasFight() && !combat.hasFight()) {
                player.sendMessage(pl.vertty.arivi.utils.guild.ChatUtil.fixColor(Config.ANTYLOGAUT_END));
                combat.setLastAttactkPlayer(null);
                combat.setLastAttactTime(0L);
            }
            if (guild != null && guild.isRegeneration()) {
                if (!s.equals("")) {
                    s = s + " &8| ";
                }
                s = s + "&6Trwa Regeneracja terenu &8(&6" + pl.vertty.arivi.utils.guild.DataUtil.secondsToString(System.currentTimeMillis() + guild.getBlocks().size() * 110L) + " &7- &6" + guild.getBlocks().size() + " blokow&8)";
            }
            if (s.equals("")) {
                return;
            }
            pl.vertty.arivi.utils.guild.ChatUtil.sendActionbar(player, pl.vertty.arivi.utils.guild.ChatUtil.fixColor(s));
        }
    }
}
