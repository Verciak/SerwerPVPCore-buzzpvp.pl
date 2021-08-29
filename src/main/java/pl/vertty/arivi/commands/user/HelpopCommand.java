// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import java.util.UUID;
import java.util.HashMap;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class HelpopCommand extends PlayerCommand
{
    private static final HashMap<UUID, Long> times;
    
    public HelpopCommand() {
        super("helpop", "Wysylanie zgloszenia do administracji", "/helpop <wiadomosc>", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage((CommandSender)p, this.getUsage());
        }
        final User u = UserManager.getUser(p);
        if (!u.can(GroupType.HELPER) && u.isLastHelpop()) {
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Helpop mozesz uzyc za &6" + DataUtil.secondsToString(u.getLastHelpop()));
        }
        u.setLastHelpop(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(1));
        final String msg = StringUtils.join((Object[])args, " ");
        for (final Player players : Server.getInstance().getOnlinePlayers().values()) {
            final User user = UserManager.getUser(players);
            if (user.can(GroupType.HELPER)) {
                ChatUtil.sendMessage((CommandSender)user.getPlayer(), "&c&l[&e&lHelpOp&c&l] &6" + p.getName() + "&8: &7" + msg);
            }
        }
        return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Twoje zgloszenie zostalo wyslane!");
    }
    
    static {
        times = new HashMap<UUID, Long>();
    }
}
