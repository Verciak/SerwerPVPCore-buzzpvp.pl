// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import cn.nukkit.utils.Config;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.ChatManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class ChatCommand extends Command
{
    public ChatCommand() {
        super("chat", "Chat dla adm", "/chat <cc|on|off|vip>", GroupType.HELPER, new String[] { "czat" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final Config c = Main.getPlugin().getConfig();
        if (args.length < 1) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final String s3;
        final String s4;
        final String s2 = s4 = (s3 = args[0]);
        switch (s4) {
            case "off": {
                if (!ChatManager.enable) {
                    return ChatUtil.sendMessage(sender, "&cBlad: &7Chat jest wylaczony!");
                }
                ChatManager.enable = false;
                return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cChat zostal wylaczony przez &7" + sender.getName() + "&c!");
            }
            case "on": {
                if (ChatManager.enable) {
                    return ChatUtil.sendMessage(sender, "&cBlad: &7Chat jest juz wlaczony!");
                }
                ChatManager.enable = true;
                return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cChat zostal wlaczony przez &7" + sender.getName() + "&c!");
            }
            case "vip": {
                ChatManager.vipChat = !ChatManager.vipChat;
                return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cChat dla vipow &7" + (ChatManager.vipChat ? "wlaczony" : "wylaczony"));
            }
            case "slow": {
                if (args.length < 2) {
                    return ChatUtil.sendMessage(sender, "/chat slow <czas w sekundach>");
                }
                if (!ChatUtil.isInteger(args[1])) {
                    return ChatUtil.sendMessage(sender, "&cBlad: &7To nie jest liczba");
                }
                c.set("slowmode", (Object)Integer.parseInt(args[1]));
                return ChatUtil.sendMessage(sender, "&cUstawiles slow chatu na &7" + Integer.parseInt(args[1]) + " &csekundy!");
            }
            case "cc": {
                for (int i = 0; i < 100; ++i) {
                    ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "");
                }
                return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cChat zostal wyczyszczony przez &7" + sender.getName() + "&c!");
            }
            default: {
                return ChatUtil.sendMessage(sender, this.getUsage());
            }
        }
    }
}
