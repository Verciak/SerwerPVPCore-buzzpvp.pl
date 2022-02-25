package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.User;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class HealCommand extends Command
{
    public HealCommand() {
        super("heal", "GodCommand", "/heal [gracz]", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.setHealth(p.getMaxHealth());
            return ChatUtil.sendMessage(p, "&8>> &cZostales uleczony!");
        }
        final User u = UserManager.getUser(p);
        if (!u.can(GroupType.ADMIN)) {
            return ChatUtil.sendMessage(p, "&8>> &cNie masz dostepu!");
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
        }
        o.setHealth(p.getMaxHealth());
        ChatUtil.sendMessage(o, "&8>> &cZostales uleczony przez &6" + p.getName());
        return ChatUtil.sendMessage(p, "&8>> &cUleczyles &6" + o.getName());
    }
}
