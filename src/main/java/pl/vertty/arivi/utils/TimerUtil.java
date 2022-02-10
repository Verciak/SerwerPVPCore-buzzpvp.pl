// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.TaskHandler;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimerCallback;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.managers.TimerManager;

public class TimerUtil
{
    public static void teleport(final Player p, final Location location, final int delay) {
        final Combat combat = CombatManager.getCombat(p);
        final User u = UserManager.getUser(p);
        if (u.can(GroupType.MODERATOR)) {
            p.teleport(location);
            return;
        }
        if (combat != null && combat.hasFight() && !u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&cTeleportacja przerwana!");
            return;
        }
        final Guild g = GuildManager.getGuild(p.getLocation());
        if (g != null && !g.isMember(p) && !u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&cTeleportacja przerwana!");
            return;
        }
        if (!u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&7Teleportacja nastapi za &e" + delay + " sekund");
        }
        u.setTeleport(true);
        final TaskHandler task = Server.getInstance().getScheduler().scheduleDelayedRepeatingTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            int time = delay;
            
            @Override
            public void run() {
                if (u.getOchrona() != 0L) {
                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time + " &8:|: &7Ochrona: &e" + (DataUtil.secondsToString(u.getOchrona()).isEmpty() ? "1s" : DataUtil.secondsToString(u.getOchrona())));
                    --this.time;
                }
                else {
                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time);
                    --this.time;
                }
            }
        }, 0, 20);
        TimerManager.addTask(p, new TimerCallback<Player>() {
            @Override
            public void success(final Player player) {
                player.teleport(location);
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&aPrzeteleportowano!");
                u.setTeleport(false);
            }
            
            @Override
            public void error(final Player player) {
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&cTeleportacja przerwana!");
                u.setTeleport(false);
            }
        }, delay);
    }
    
    public static void teleportSpawn(final Player p, final Location location, int delay) {
        final Combat combat = CombatManager.getCombat(p);
        final User u = UserManager.getUser(p);
        if (u.can(GroupType.MODERATOR)) {
            p.teleport(location);
            return;
        }
        if (combat != null && combat.hasFight() && !u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&cTeleportacja przerwana!");
            return;
        }
        if (!u.can(GroupType.MODERATOR)) {
            final Guild g = GuildManager.getGuild(p.getLocation());
            if (!u.can(GroupType.MODERATOR) && g != null && !g.isMember(p)) {
                delay = 60;
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Teleportacja nastapi za &e" + delay + " sekund");
        }
        u.setTeleport(true);
        final int finalDelay = delay;
        final TaskHandler task = Server.getInstance().getScheduler().scheduleDelayedRepeatingTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            int time = finalDelay;
            
            @Override
            public void run() {
                if (u.getOchrona() != 0L) {
                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time + " &8:|: &7Ochrona: &e" + (DataUtil.secondsToString(u.getOchrona()).isEmpty() ? "1s" : DataUtil.secondsToString(u.getOchrona())));
                    --this.time;
                }
                else {
                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time);
                    --this.time;
                }
            }
        }, 0, 20);
        TimerManager.addTask(p, new TimerCallback<Player>() {
            @Override
            public void success(final Player player) {
                player.teleport(location);
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&aPrzeteleportowano!");
                u.setTeleport(false);
            }
            
            @Override
            public void error(final Player player) {
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&cTeleportacja przerwana!");
                u.setTeleport(false);
            }
        }, delay);
    }
}
