package pl.vertty.arivi.commands.moderator;

import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class BroadcastCommand extends Command
{
    public BroadcastCommand() {
        super("bc", "Ogloszenie wiadomosci", "/bc <title/subtitle/actionbar/chat> <wiadomosc>", GroupType.MODERATOR, new String[] { "bcast" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 2) return ChatUtil.sendMessage(sender, this.getUsage());
        String message = ChatUtil.fixColor(message(args));
        switch (args[0]) {
            case "title": {
                for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                    ChatUtil.sendTitle(player, message, " ");
                }
                break;
            }
            case "subtitle": {
                for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                    ChatUtil.sendTitle(player, " ", message);
                }
                break;
            }
            case "actionbar": {
                for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                    ChatUtil.sendActionBar(player, message);
                }
                break;
            }
            case "chat": {
                for (Player player : Server.getInstance().getOnlinePlayers().values()) {
                    player.sendMessage(message);
                }
                break;
            }
            default: {
                return ChatUtil.sendMessage(sender, this.getUsage());
            }
        }
        return false;
    }
    
    private String message(final String[] args) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            builder.append(args[i]).append(" ");
        }
        return builder.toString();
    }
}
