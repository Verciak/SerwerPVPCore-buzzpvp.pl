// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.utils.TextFormat;
import org.apache.commons.lang3.StringUtils;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import java.util.UUID;
import java.util.HashMap;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class TellCommand extends PlayerCommand
{
    private static final HashMap<UUID, UUID> lastMsg;
    private static final HashMap<UUID, Long> times;
    
    public TellCommand() {
        super("tell", "Napisz prywatna wiadomosc", "/msg <gracz> <wiadomosc>", GroupType.PLAYER, new String[] { "msg" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        final User u = UserManager.getUser(player);
        if (args.length < 2) {
            return ChatUtil.sendMessage((CommandSender)player, this.getUsage());
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        final User user = UserManager.getUser(o);
        if (user.isIgnoreTell(player)) {
            return ChatUtil.sendMessage((CommandSender) player, "&cTen gracz zablokowal od Ciebie prywatne wiadomosci!");
        }
        if (o == null) {
            return ChatUtil.sendMessage((CommandSender)player, "&cGracz nie jest online!");
        }
        final Long t = TellCommand.times.get(player.getUniqueId());
        if (t != null && System.currentTimeMillis() - t < 3000L && !u.can(GroupType.ADMIN)) {
            return ChatUtil.sendMessage((CommandSender)player, "&4Nie spamuj!");
        }
        final String message = TextFormat.colorize(ChatUtil.fixColor(StringUtils.join((Object[])args, " ", 1, args.length)));
        TellCommand.lastMsg.put(player.getUniqueId(), o.getUniqueId());
        TellCommand.lastMsg.put(o.getUniqueId(), player.getUniqueId());
        TellCommand.times.put(player.getUniqueId(), System.currentTimeMillis());
        ChatUtil.sendMessage((CommandSender)player, "&eJa -> " + o.getName() + "&7: " + message);
        return ChatUtil.sendMessage((CommandSender)o, "&e" + player.getName() + " -> Ja: &7" + message);
    }
    
    public static HashMap<UUID, UUID> getLastMsg() {
        return TellCommand.lastMsg;
    }
    
    public static HashMap<UUID, Long> getTimes() {
        return TellCommand.times;
    }
    
    static {
        lastMsg = new HashMap<UUID, UUID>();
        times = new HashMap<UUID, Long>();
    }
}
