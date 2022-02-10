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
            return ChatUtil.sendMessage((CommandSender)player, this.getUsage());
        }
        final UUID last = TellCommand.getLastMsg().get(player.getUniqueId());
        if (last == null) {
            return ChatUtil.sendMessage((CommandSender)player, "&cNie masz komu odpisac!");
        }
        if(Server.getInstance().getPlayer(last).get() == null){
            return ChatUtil.sendMessage((CommandSender)player, "&cGracz nie jest online!");
        }
        final Player o = Server.getInstance().getPlayer(last).get();
        if (o == null) {
            return ChatUtil.sendMessage((CommandSender)player, "&cGracz nie jest online!");
        }
        final Long t = ReplyCommand.times.get(player.getUniqueId());
        if (t != null && System.currentTimeMillis() - t < 3000L && !u.can(GroupType.HELPER)) {
            return ChatUtil.sendMessage((CommandSender)player, "&4Nie spam!");
        }
        ReplyCommand.times.put(player.getUniqueId(), System.currentTimeMillis());
        final String message = TextFormat.colorize(ChatUtil.fixColor(StringUtils.join((Object[])args, " ")));
        TellCommand.getLastMsg().put(player.getUniqueId(), o.getUniqueId());
        TellCommand.getLastMsg().put(o.getUniqueId(), player.getUniqueId());
        ChatUtil.sendMessage((CommandSender)player, "&eJa -> " + o.getName() + "&7: " + message);
        return ChatUtil.sendMessage((CommandSender)o, "&e" + player.getName() + " -> Ja: &7" + message);
    }
    
    public static HashMap<UUID, Long> getTimes() {
        return ReplyCommand.times;
    }
    
    static {
        times = new HashMap<UUID, Long>();
    }
}
