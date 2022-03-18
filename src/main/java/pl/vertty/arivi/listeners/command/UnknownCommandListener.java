// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.command;

import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;

import cn.nukkit.event.EventPriority;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.ArrayList;
import cn.nukkit.event.Listener;

public class UnknownCommandListener implements Listener
{
    public static ArrayList<String> registeredCommands;


    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String pcmd = e.getMessage();
        Combat combat = CombatManager.getCombat(p);
        if (!UserManager.getUser(p).can(GroupType.HELPER) && combat != null && combat.hasFight())
            for (String cmd : Main.getPlugin().getConfig().getStringList("config.blocked.cmd.incombat")) {
                if (pcmd.toLowerCase().contains("/" + cmd)) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cTa komenda jest zablokowana podczas walki!");
                    return;
                }
            }
    }


    @EventHandler
    private void onPlayerCommandPreprocessEvent(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final User u = UserManager.getUser(p);
        boolean valid = false;
        final Config c = Main.getPlugin().getConfig();
        if (u.can(GroupType.ROOT)) {
            return;
        }
        for (final String cmd : UnknownCommandListener.registeredCommands) {
            final String[] args = e.getMessage().split(" ");
            if (args[0].equalsIgnoreCase("/" + cmd) || args[0].equalsIgnoreCase("/:" + cmd)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            p.sendMessage(ChatUtil.fixColor(c.getString("unknown-command")));
            e.setCancelled(true);
        }
    }
    
    static {
        UnknownCommandListener.registeredCommands = new ArrayList<String>();
    }
}
