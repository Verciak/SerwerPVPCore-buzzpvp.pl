package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.HashMap;
import java.util.UUID;

public class ReplyCommand extends PlayerCommand
{
    private static final HashMap<UUID, Long> times;

    public ReplyCommand() {
        super("r", "Odpowiedz na prywatna wiadomosc", "/reply", GroupType.PLAYER, new String[] { "reply" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        final User u = UserManager.getUser(player);
        if (args.length < 1) {
            return ChatUtil.sendMessage(player, this.getUsage());
        }
        final UUID last = TellCommand.getLastMsg().get(player.getUniqueId());
        if (last == null) {
            return ChatUtil.sendMessage(player, "&cNie masz komu odpisac!");
        }
        if(Server.getInstance().getPlayer(last).get() == null){
            return ChatUtil.sendMessage(player, "&cGracz nie jest online!");
        }
        final Player o = Server.getInstance().getPlayer(last).get();
        if (o == null) {
            return ChatUtil.sendMessage(player, "&cGracz nie jest online!");
        }
        final Long t = ReplyCommand.times.get(player.getUniqueId());
        if (t != null && System.currentTimeMillis() - t < 3000L && !u.can(GroupType.HELPER)) {
            return ChatUtil.sendMessage(player, "&4Nie spam!");
        }
        ReplyCommand.times.put(player.getUniqueId(), System.currentTimeMillis());
        final String message = TextFormat.colorize(ChatUtil.fixColor(StringUtils.join(args, " ")));
        TellCommand.getLastMsg().put(player.getUniqueId(), o.getUniqueId());
        TellCommand.getLastMsg().put(o.getUniqueId(), player.getUniqueId());
        ChatUtil.sendMessage(player, "&eJa -> " + o.getName() + "&7: " + message);
        return ChatUtil.sendMessage(o, "&e" + player.getName() + " -> Ja: &7" + message);
    }

    static {
        times = new HashMap<UUID, Long>();
    }
}
