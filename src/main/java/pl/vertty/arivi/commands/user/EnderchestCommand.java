// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.utils.EnderchestUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class EnderchestCommand extends PlayerCommand
{
    public EnderchestCommand() {
        super("enderchest", "enderchest", "/enderchest", GroupType.VIP, new String[] { "ec" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        EnderchestUtil.open(p);
        return true;
    }
}
