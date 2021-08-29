// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.headadmin;

import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import java.util.Iterator;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import org.apache.commons.lang3.StringUtils;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class KickAllCommand extends Command
{
    public KickAllCommand() {
        super("kickall", "Wyrzucanie wszystkich graczy z serwera", "/kickall", GroupType.HEADADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final String kick = "\n&4Zostales wyrzocony z serwera przez &c" + sender.getName() + "\n&4Powod: &c" + StringUtils.join((Object[])args, " ");
        for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
            final User u = UserManager.getUser(p);
            if (!u.can(GroupType.HELPER)) {
                final Combat combat = CombatManager.getCombat(p);
                combat.setLastAttactTime(0L);
                combat.setLastAttactkPlayer(null);
                combat.setLastAsystPlayer(null);
                p.kick(ChatUtil.fixColor(kick));
            }
        }
        return ChatUtil.sendMessage(sender, "&8>> &7Wyrzucono wszystkich graczy z serwera!");
    }
}
