package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;

public class HelpopCommand extends PlayerCommand
{
    
    public HelpopCommand() {
        super("helpop", "Wysylanie zgloszenia do administracji", "/helpop <wiadomosc>", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage(p, this.getUsage());
        }
        final User u = UserManager.getUser(p);
        if (!u.can(GroupType.HELPER) && u.isLastHelpop()) {
            return ChatUtil.sendMessage(p, "&8>> &7Helpop mozesz uzyc za &6" + DataUtil.secondsToString(u.getLastHelpop()));
        }
        u.setLastHelpop(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(1));
        final String msg = StringUtils.join(args, " ");
        for (final Player players : Server.getInstance().getOnlinePlayers().values()) {
            final User user = UserManager.getUser(players);
            if (user.can(GroupType.HELPER)) {
                ChatUtil.sendMessage(user.getPlayer(), "&c&l[&e&lHelpOp&c&l] &6" + p.getName() + "&8: &7" + msg);
            }
        }
        return ChatUtil.sendMessage(p, "&8>> &7Twoje zgloszenie zostalo wyslane!");
    }
}
