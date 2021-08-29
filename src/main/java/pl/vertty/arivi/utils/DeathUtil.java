package pl.vertty.arivi.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;

import java.util.concurrent.CopyOnWriteArrayList;

public class DeathUtil {
    public static String deathsMessage(final int plus, int minus, Player player, final Player killer) {
        Guild u = GuildManager.getGuild(player);
        Guild k = GuildManager.getGuild(killer);
        (new NukkitRunnable() {
            int i = 0;

            public void run() {
                this.i++;
                ChatUtil.sendTitle(killer, "", DeathUtil.poKoleiKill(this.i, plus), 1, 1, 1);
                if (this.i >= 18) {
                    ChatUtil.sendTitle(killer, "", DeathUtil.poKoleiKill(18, plus), 1, 5, 1);
                    cancel();
                }
            }
        }).runTaskTimerAsynchronously(Main.getPlugin(), 0, 3);
        String m = "&7Gracz " + ((u == null) ? "" : ("&8[&c" + u.getTag() + "&8] ")) + "&9" + player.getName() + " &8(&c" + ((plus >= 0) ? ("-" + minus) : Integer.valueOf(minus)) + "&8) &7zostal zabity przez " + ((k == null) ? "" : ("&8[&c" + k.getTag() + "&8] ")) + "&9" + killer.getName() + " &8(&a" + ((plus >= 0) ? ("+" + plus) : Integer.valueOf(plus)) + "&8)";
        return ChatUtil.fixColor(m);
    }

    public static String asystaMessage(final int plus, final Player player) {
        Guild g = GuildManager.getGuild(player);
        (new NukkitRunnable() {
            int i = 0;

            public void run() {
                this.i++;
                ChatUtil.sendTitle(player, "", DeathUtil.poKoleiAsysta(this.i, plus), 1, 1, 1);
                if (this.i >= 16) {
                    ChatUtil.sendTitle(player, "", DeathUtil.poKoleiAsysta(16, plus), 1, 5, 1);
                    cancel();
                }
            }
        }).runTaskTimerAsynchronously(Main.getPlugin(), 0, 3);
        String m = "&7Asystowal: " + ((g == null) ? "" : ("&8[&c" + g.getTag() + "&8] ")) + "&9" + player.getName() + " &8(&a" + ((plus >= 0) ? ("+" + plus) : Integer.valueOf(plus)) + "&8)";
        return ChatUtil.fixColor(m);
    }

    public static boolean isLastKill(User u, Player p) {
        return (u.getLastKillTime() > System.currentTimeMillis() && u.getLastKill().equalsIgnoreCase(p.getName()));
    }

    public static boolean killMulti(Player p, Player k) {
        return false;
    }

    public static boolean isAsyst(Combat c) {
        return (c.getLastAsystPlayer() != null && c.getLastAsystTime() > System.currentTimeMillis());
    }

    public static String poKoleiAsysta(int i, int points) {
        String result;
        if (i == 0) {
            result = "&9+";
        } else if (i == 1) {
            result = "&9+" + points;
        } else if (i == 2) {
            result = "&9+" + points + " &8(";
        } else if (i == 3) {
            result = "&9+" + points + " &8(&9a";
        } else if (i == 4) {
            result = "&9+" + points + " &8(&9as";
        } else if (i == 5) {
            result = "&9+" + points + " &8(&9asy";
        } else if (i == 6) {
            result = "&9+" + points + " &8(&9asys";
        } else if (i == 8) {
            result = "&9+" + points + " &8(&9asyst";
        } else if (i == 9) {
            result = "&9+" + points + " &8(&9asysta";
        } else if (i == 10) {
            result = "&9+" + points + " &8(&9asysta&8)";
        } else if (i == 11) {
            result = "&9+" + points + " &8(&fasysta&8)";
        } else if (i == 12) {
            result = "&9+" + points + " &8(&9asysta&8)";
        } else if (i == 13) {
            result = "&9+" + points + " &8(&fasysta&8)";
        } else if (i == 14) {
            result = "&9+" + points + " &8(&9asysta&8)";
        } else if (i == 15) {
            result = "&9+" + points + " &8(&fasysta&8)";
        } else if (i == 16) {
            result = "&9+" + points + " &8(&9asysta&8)";
        } else {
            result = "&9+" + points + " &8(&fasysta&8)";
        }
        return result;
    }

    public static String poKoleiKill(int i, int points) {
        String result;
        if (i == 0) {
            result = "&a+";
        } else if (i == 1) {
            result = "&9+&7" + points;
        } else if (i == 2) {
            result = "&9+&7" + points + " &8(";
        } else if (i == 3) {
            result = "&9+&7" + points + " &8(&9z";
        } else if (i == 4) {
            result = "&9+&7" + points + " &8(&9za";
        } else if (i == 5) {
            result = "&9+&7" + points + " &8(&9zab";
        } else if (i == 6) {
            result = "&9+&7" + points + " &8(&9zabo";
        } else if (i == 7) {
            result = "&9+&7" + points + " &8(&9zaboj";
        } else if (i == 8) {
            result = "&9+&7" + points + " &8(&9zabojs";
        } else if (i == 9) {
            result = "&9+&7" + points + " &8(&9zabojst";
        } else if (i == 10) {
            result = "&9+&7" + points + " &8(&9zabojstw";
        } else if (i == 11) {
            result = "&9+&7" + points + " &8(&9zabojstwo";
        } else if (i == 12) {
            result = "&9+&7" + points + " &8(&9zabojstwo&8)";
        } else if (i == 13) {
            result = "&9+&7" + points + " &8(&fzabojstwo&8)";
        } else if (i == 14) {
            result = "&9+&7" + points + " &8(&9zabojstwo&8)";
        } else if (i == 15) {
            result = "&9+&7" + points + " &8(&fzabojstwo&8)";
        } else if (i == 16) {
            result = "&9+&7" + points + " &8(&9zabojstwo&8)";
        } else if (i == 17) {
            result = "&9+&7" + points + " &8(&fzabojstwo&8)";
        } else if (i == 18) {
            result = "&9+&7" + points + " &8(&9zabojstwo&8)";
        } else {
            result = "&9+&7" + points + " &8(&fzabojstwo&8)";
        }
        return result;
    }

    public static void remove(Combat combat) {
        if (combat == null)
            return;
        combat.setLastAttactTime(0L);
        combat.setLastAsystTime(0L);
        combat.setLastAsystPlayer(null);
        combat.setLastAttactkPlayer(null);
        ChatUtil.sendActionBar(combat.getPlayer(), "");
    }

    public static int calculatePercentage(int obtained, int total) {
        return obtained * 100 / total;
    }
}

