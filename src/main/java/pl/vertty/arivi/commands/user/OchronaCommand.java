// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class OchronaCommand extends PlayerCommand
{
    public OchronaCommand() {
        super("ochrona", "Zarzadzanie ochrona startowa", "/ochrona off", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p0, final String[] p1) {
        if (p1.length == 1 && p1[0].equalsIgnoreCase("off") && UserManager.getUser(p0).getOchrona() != 0L) {
            ChatUtil.sendMessage((CommandSender)p0, "&7Ochrona zostala &cwylaczona!");
            UserManager.getUser(p0).setOchrona(0L);
            return true;
        }
        ChatUtil.sendMessage((CommandSender)p0, "&7Aby wylaczyc ochrone wpisz &e/ochrona off");
        return false;
    }
}
