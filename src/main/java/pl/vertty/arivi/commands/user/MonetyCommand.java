// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class MonetyCommand extends PlayerCommand
{
    public MonetyCommand() {
        super("monety", "Sprawdz swoje monety", "/monety", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        ChatUtil.sendMessage(p, "&7Twoje monety: &9" + UserManager.getUser(p).getCoins());
        return true;
    }
}
