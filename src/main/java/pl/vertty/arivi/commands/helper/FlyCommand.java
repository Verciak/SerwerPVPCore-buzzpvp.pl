// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class FlyCommand extends Command
{
    public FlyCommand() {
        super("fly", "Zarzadzanie trybem latania graczy", "/fly [gracz]", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        if (args.length == 0) {
            p.setAllowFlight(!p.getAllowFlight());
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &cFly zostal &6" + (p.getAllowFlight() ? "wlaczony" : "wylaczony"));
        }
        if (!u.can(GroupType.MODERATOR)) {
            return ChatUtil.sendMessage((CommandSender)p, "&cNie masz dostepu!");
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracz jest offline");
        }
        o.setAllowFlight(!o.getAllowFlight());
        ChatUtil.sendMessage((CommandSender)o, "&8>> &cFly zostal &6" + (o.getAllowFlight() ? "wlaczony" : "wylaczony") + " &cprzez &6" + p.getName());
        return ChatUtil.sendMessage((CommandSender)p, "&8>> &cFly zostal &c" + (o.getAllowFlight() ? "wlaczony" : "wylaczony") + " &7dla &6" + o.getName());
    }
}
