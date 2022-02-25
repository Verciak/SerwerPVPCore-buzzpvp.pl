package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.User;
import cn.nukkit.Server;
import pl.vertty.arivi.objects.Ban;
import pl.vertty.arivi.utils.DataUtil;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class BanCommand extends Command
{
    public BanCommand() {
        super("ban", "Banowanie", "/ban [gracz] [czas] [powod]", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 2) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final Ban b = BanManager.getBan(args[0]);
        if (b != null) {
            return ChatUtil.sendMessage(sender, "&4Blad: &2Ten gracz ma juz bana!");
        }
        final User u = UserManager.getUser(sender.getName());
        if (sender instanceof Player && u == null) {
            return true;
        }
        final String admin = sender.getName().equals("CONSOLE") ? "konsola" : sender.getName();
        String reason = "Brak!";
        if (args.length > 2) {
            reason = StringUtils.join(args, " ", 2, args.length);
        }
        final long time = DataUtil.parseDateDiff(args[1], true);
        if (time > System.currentTimeMillis()) {
            final Ban ban = new Ban(args[0], admin, reason, time);
            BanManager.addBan(args[0], ban);
            return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &7Gracz &c" + args[0] + " &7zostal tymczasowo zbanowany przez &c" + sender.getName() + " &7do: &c" + DataUtil.getDate(time) + " &7powod: &c" + reason);
        }
        final Ban ban = new Ban(args[0], admin, reason, 0L);
        BanManager.addBan(args[0], ban);
        return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &7Gracz &c" + args[0] + " &7zostal permamentnie zbanowany przez &c" + sender.getName() + " &7powod: &c" + reason);
    }
}
