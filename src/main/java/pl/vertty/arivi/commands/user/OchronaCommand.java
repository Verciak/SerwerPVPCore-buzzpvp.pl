// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class OchronaCommand extends PlayerCommand {
    public OchronaCommand() {
        super("ochrona", "Zarzadzanie ochrona startowa", "/ochrona off", GroupType.PLAYER, new String[]{""});
    }

    @Override
    public boolean onCommand(final Player p0, final String[] p1) {
        User user = UserManager.getUser(p0);
        if (p1.length == 1 && p1[0].equalsIgnoreCase("off") && user.getOchrona() != 0L) {
            ChatUtil.sendMessage(p0, "&7Ochrona zostala &cwylaczona!");
            user.setOchrona(0L);
            return true;
        }
        ChatUtil.sendMessage(p0, "&7Aby wylaczyc ochrone wpisz &e/ochrona off");
        return false;
    }
}