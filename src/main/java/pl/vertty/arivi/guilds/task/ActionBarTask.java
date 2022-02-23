
package pl.vertty.arivi.guilds.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.BossBarColor;
import cn.nukkit.utils.DummyBossBar;
import cn.nukkit.utils.DummyBossBar.Builder;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.objects.BossBar;
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
                player.sendMessage(pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(Config.ANTYLOGAUT_END));
                combat.setLastAttactkPlayer(null);
                combat.setLastAttactTime(0L);
            }
            if (guild != null && guild.isRegeneration()) {
                if (!s.equals("")) {
                    s = s + " &8| ";
                }
                s = s + "&6Trwa Regeneracja terenu &8(&6" + pl.vertty.arivi.guilds.utils.DataUtil.secondsToString(System.currentTimeMillis() + guild.getBlocks().size() * 110L) + " &7- &6" + guild.getBlocks().size() + " blokow&8)";
            }
            if (s.equals("")) {
                return;
            }
            pl.vertty.arivi.guilds.utils.ChatUtil.sendActionbar(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(s));
        }
    }
}
