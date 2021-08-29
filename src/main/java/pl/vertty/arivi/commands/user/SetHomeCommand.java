// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.gui.home.HomeInventory;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class SetHomeCommand extends PlayerCommand
{
    public SetHomeCommand() {
        super("sethome", "Ustaw swoj dom", "/sethome", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (p.getLocation().getY() <= 2.0) {
            return ChatUtil.sendMessage((CommandSender)p, "&cHome mozesz ustawic powyzej 2 kratek wysokosci!");
        }
        final User u = UserManager.getUser(p);
        if (u == null) {
            return true;
        }
        HomeInventory.openHome(p);
        return false;
    }
}
