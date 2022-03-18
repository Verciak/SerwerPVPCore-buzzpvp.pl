// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import cn.nukkit.potion.Effect;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.managers.TimerManager;
import cn.nukkit.scheduler.TaskHandler;
import pl.vertty.arivi.enums.TimerCallback;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.Main;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.level.Location;
import cn.nukkit.Player;

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
        if (!u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&7Teleportacja nastapi za &e" + delay + " sekund");
        }
        final TaskHandler task = Server.getInstance().getScheduler().scheduleDelayedRepeatingTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            int time = delay;
            
            @Override
            public void run() {

                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time);
                    --this.time;

            }
        }, 0, 20);
        TimerManager.addTask(p, new TimerCallback<Player>() {
            @Override
            public void success(final Player player) {
                player.teleport(location);
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&aPrzeteleportowano!");
            }
            
            @Override
            public void error(final Player player) {
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&cTeleportacja przerwana!");
            }
        }, delay);
    }
    
    public static void teleportSpawn(final Player p, final Location location, int delay) {
        final Combat combat = CombatManager.getCombat(p);
        final User u = UserManager.getUser(p);
        if (u.can(GroupType.MODERATOR)) {
            p.getInventory().clearAll();
            for(Effect e : p.getEffects().values()){
                p.removeEffect(e.getId());
            }
            p.setHealth(p.getMaxHealth());
            p.teleport(location);
            return;
        }
        if (combat != null && combat.hasFight() && !u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&cTeleportacja przerwana!");
            return;
        }
        if (!u.can(GroupType.MODERATOR)) {
            ChatUtil.sendMessage((CommandSender)p, "&7Teleportacja nastapi za &e" + delay + " sekund");
        }

        final int finalDelay = delay;
        final TaskHandler task = Server.getInstance().getScheduler().scheduleDelayedRepeatingTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            int time = finalDelay;
            
            @Override
            public void run() {

                    ChatUtil.sendActionBar(p, "&7Teleport nastapi za: &e" + this.time);
                    --this.time;

            }
        }, 0, 20);
        TimerManager.addTask(p, new TimerCallback<Player>() {
            @Override
            public void success(final Player player) {
                player.teleport(location);
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&aPrzeteleportowano!");
                p.getInventory().clearAll();
                for(Effect e : p.getEffects().values()){
                    p.removeEffect(e.getId());
                }
                p.setHealth(p.getMaxHealth());
            }
            
            @Override
            public void error(final Player player) {
                task.cancel();
                ChatUtil.sendMessage((CommandSender)player, "&cTeleportacja przerwana!");
            }
        }, delay);
    }
}
