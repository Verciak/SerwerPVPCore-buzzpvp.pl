
package pl.vertty.arivi.guilds.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;

public class ActionBarTask extends NukkitRunnable
{
    public void run() {
        for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
            if (!player.isOnline()) {
                return;
            }
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
            final Guild guild2 = GuildManager.getGuild(player.getLocation());
            if (guild2 != null) {
                if (!s.equals("")) {
                    s = s + " &8| ";
                }
                if (guild2 != guild) {
                    if (guild != null && guild.getAlly().contains(guild2.getTag())) {
                        s = s + "&6Jestes na terytorium sojuszniczej gildii &8[&6" + guild2.getTag() + "&8]";
                    }
                    else {
                        s = s + "&cJestes na terytorium wrogiej gildii &8[&c" + guild2.getTag() + "&8]";
                    }
                }
                else {
                    s = s + "&aJestes na terytorium swojej gildi &8[&a" + guild2.getTag() + "&8]";
                }
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
