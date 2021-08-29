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

public class PingCommand extends PlayerCommand
{
    public PingCommand() {
        super("ping", "Sprawdz swoj ping", "/ping", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        ChatUtil.sendMessage(p, "&7Twoj ping to: &9" + p.getPing());
        return true;
    }
}
