package pl.vertty.arivi.commands.helper;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class FlyCommand extends Command
{
    public FlyCommand() {
        super("fly", "Zarzadzanie trybem latania graczy", "/fly [gracz]", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        if (args.length == 0) {
            p.setAllowFlight(!p.getAllowFlight());
            return ChatUtil.sendMessage(p, "&8>> &cFly zostal &6" + (p.getAllowFlight() ? "wlaczony" : "wylaczony"));
        }
        assert u != null;
        if (!u.can(GroupType.MODERATOR)) {
            return ChatUtil.sendMessage(p, "&cNie masz dostepu!");
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline");
        }
        o.setAllowFlight(!o.getAllowFlight());
        ChatUtil.sendMessage(o, "&8>> &cFly zostal &6" + (o.getAllowFlight() ? "wlaczony" : "wylaczony") + " &cprzez &6" + p.getName());
        return ChatUtil.sendMessage(p, "&8>> &cFly zostal &c" + (o.getAllowFlight() ? "wlaczony" : "wylaczony") + " &7dla &6" + o.getName());
    }
}
