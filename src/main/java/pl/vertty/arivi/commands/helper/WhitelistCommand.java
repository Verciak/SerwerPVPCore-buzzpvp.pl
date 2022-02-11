package pl.vertty.arivi.commands.helper;

import cn.nukkit.command.CommandSender;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.managers.WhitelistManager;
import pl.vertty.arivi.utils.ChatUtil;

public class WhitelistCommand extends Command
{
    public WhitelistCommand() {
        super("whitelist", "Whitelista", "/wl <add|remove|list|reason|on|off> [gracz]", GroupType.HELPER, new String[] { "wl" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 1) {
            ChatUtil.sendMessage(sender, "/wl <add|remove|list|reason|on|off> [gracz]");
            return false;
        }
        final String s = args[0];
        switch (s) {
            case "wlacz":
            case "on": {
                if (WhitelistManager.getWhiteListStatus(1) != null) {
                    return ChatUtil.sendMessage(sender, "&4Blad: &cWhitelist jest juz on!");
                }
                WhitelistManager.deleteWhitelistStatus(0);
                WhitelistManager.addWhiteListStatus(1);
                return ChatUtil.sendMessage(sender, "&8>> &cWhitelist zostala wlaczona!");
            }
            case "wylacz":
            case "off": {
                if (WhitelistManager.getWhiteListStatus(0) != null) {
                    return ChatUtil.sendMessage(sender, "&4Blad: &cWhitelist jest off!");
                }
                WhitelistManager.deleteWhitelistStatus(1);
                WhitelistManager.addWhiteListStatus(0);
                return ChatUtil.sendMessage(sender, "&8>> &cWhitelist zostala wylaczona!");
            }
            case "dodaj":
            case "add": {
                if (args.length < 2) {
                    return ChatUtil.sendMessage(sender, "/wl add <gracz>");
                }
                final String nick = args[1];
                if (WhitelistManager.getWhiteList(nick) != null) {
                    return ChatUtil.sendMessage(sender, "&4Blad: &c" + nick + " jest juz na whitelist!");
                }
                WhitelistManager.addWhiteList(nick);
                return ChatUtil.sendMessage(sender, "&cGracz &6" + nick + " &czostal dodany do whitelist!");
            }
            case "usun":
            case "remove": {
                if (args.length < 2) {
                    return ChatUtil.sendMessage(sender, "/wl remove <gracz>");
                }
                final String nick = args[1];
                if (WhitelistManager.getWhiteList(nick) == null) {
                    return ChatUtil.sendMessage(sender, "&4Blad: &c" + nick + " nie jest na whitelist!");
                }
                WhitelistManager.deleteWhitelist(nick);
                return ChatUtil.sendMessage(sender, "&cGracz &6" + nick + " &czostal usuniety z whitelist!");
            }
            case "list": {
                return ChatUtil.sendMessage(sender, "&8>> &7Lista graczy na whitelist: &9" + StringUtils.join(WhitelistManager.getWhiteLists().keySet().iterator(), "&8, &9"));
            }
            case "powod":
            case "reason": {
                if (args.length < 2) {
                    return ChatUtil.sendMessage(sender, "/wl reason <numer> <powod>");
                }
                final String reason = StringUtils.join(args, " ", 2, args.length);
                WhitelistManager.setWl_reason(reason, Integer.parseInt(args[1]));
                return ChatUtil.sendMessage(sender, "&8>> &cUstawiles powod whitelist na: &r" + reason);
            }
            default: {
                return ChatUtil.sendMessage(sender, "/wl <add|remove|list|reason|on|off> [gracz]");
            }
        }
    }
}
