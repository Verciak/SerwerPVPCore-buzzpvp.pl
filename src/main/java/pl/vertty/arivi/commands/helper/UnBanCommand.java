// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.Ban;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class UnBanCommand extends Command
{
    public UnBanCommand() {
        super("unban", "Odbanowywanie graczy", "/unban <gracz>", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        if (args.length < 1) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        if (!(sender instanceof Player) && args[0].equalsIgnoreCase("all")) {
            BanManager.unbanAll();
            return ChatUtil.sendMessage(sender, "&8>> &7Odbanowales wszystkich graczy!");
        }
        final Ban b = BanManager.getBan(args[0]);
        if (b == null) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cTen gracz nie ma bana!");
        }
        if (!u.can(GroupType.MODERATOR) && !b.getAdmin().equalsIgnoreCase(sender.getName())) {
            return ChatUtil.sendMessage(sender, "&8>> &7Ban nalezy do &6" + b.getAdmin());
        }
        BanManager.unban(b);
        return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cGracz &6" + b.getName() + " &czostal odbanowany przez &6" + sender.getName() + "&4!");
    }
}
