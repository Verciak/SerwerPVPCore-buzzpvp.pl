package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.User;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class GodCommand extends Command
{
    public GodCommand() {
        super("god", "zarzadzanie trybem goda graczy", "/god [gracz]", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            final User u = UserManager.getUser(p.getName());
            if (u == null) {
                return true;
            }
            u.setGod(!u.isGod());
            return ChatUtil.sendMessage(p, "&8>> &cGod zostal &6" + (u.isGod() ? "wlaczony" : "wylaczony"));
        }
        else {
            final User u = UserManager.getUser(p.getName());
            if (!u.can(GroupType.ADMIN)) {
                return ChatUtil.sendMessage(p, "&8>> &cNie masz dostepu!");
            }
            final Player o = Server.getInstance().getPlayer(args[0]);
            if (o == null) {
                return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline");
            }
            final User user = UserManager.getUser(o);
            if (user == null) {
                return true;
            }
            user.setGod(!user.isGod());
            ChatUtil.sendMessage(o, "&8>> &cGod zostal &6" + (user.isGod() ? "wlaczony" : "wylaczony") + " &cprzez &6" + p.getName());
            return ChatUtil.sendMessage(p, "&8>> &cGod zostal &6" + (user.isGod() ? "wlaczony" : "wylaczony") + " &cdla &6" + o.getName());
        }
    }
}
