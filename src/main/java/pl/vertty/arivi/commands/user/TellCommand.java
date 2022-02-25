package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.TextFormat;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.HashMap;
import java.util.UUID;

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
            return ChatUtil.sendMessage(player, this.getUsage());
        }
        if(Server.getInstance().getPlayer(args[0]) == null){
            return ChatUtil.sendMessage(player, "&cGracz nie jest online!");
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        final User user = UserManager.getUser(o);
        if (o == null) {
            return ChatUtil.sendMessage(player, "&cGracz nie jest online!");
        }
        if (user.isIgnoreTell(o)) {
            return ChatUtil.sendMessage( player, "&cTen gracz zablokowal od Ciebie prywatne wiadomosci!");
        }
        final Long t = TellCommand.times.get(player.getUniqueId());
        if (t != null && System.currentTimeMillis() - t < 3000L && !u.can(GroupType.ADMIN)) {
            return ChatUtil.sendMessage(player, "&4Nie spamuj!");
        }
        final String message = TextFormat.colorize(ChatUtil.fixColor(StringUtils.join(args, " ", 1, args.length)));
        TellCommand.lastMsg.put(player.getUniqueId(), o.getUniqueId());
        TellCommand.lastMsg.put(o.getUniqueId(), player.getUniqueId());
        TellCommand.times.put(player.getUniqueId(), System.currentTimeMillis());
        ChatUtil.sendMessage(player, "&eJa -> " + o.getName() + "&7: " + message);
        return ChatUtil.sendMessage(o, "&e" + player.getName() + " -> Ja: &7" + message);
    }
    
    public static HashMap<UUID, UUID> getLastMsg() {
        return TellCommand.lastMsg;
    }

    static {
        lastMsg = new HashMap<UUID, UUID>();
        times = new HashMap<UUID, Long>();
    }
}
