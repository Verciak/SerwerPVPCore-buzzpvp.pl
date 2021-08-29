// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.moderator;

import cn.nukkit.utils.Config;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
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
        final Player p = (Player)sender;
        final Config c = Main.getPlugin().getConfig();
        if (args.length < 2) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final String type = args[0];
        final String message = this.message(args);
        final String s6;
        final String s5;
        final String s7;
        final String s4 = s7 = (s5 = (s6 = type));
        switch (s7) {
            case "title": {
                Server.getInstance().getOnlinePlayers().values().forEach(player -> ChatUtil.sendTitle(player, ChatUtil.fixColor(message), " "));
                break;
            }
            case "subtitle": {
                Server.getInstance().getOnlinePlayers().values().forEach(player -> ChatUtil.sendTitle(player, " ", ChatUtil.fixColor(message)));
                break;
            }
            case "actionbar": {
                Server.getInstance().getOnlinePlayers().values().forEach(player -> ChatUtil.sendActionBar(player, ChatUtil.fixColor(message)));
                break;
            }
            case "chat": {
                Server.getInstance().getOnlinePlayers().values().forEach(player -> player.sendMessage(ChatUtil.fixColor(message)));
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
