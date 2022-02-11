package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.Main;
import org.apache.commons.lang3.StringUtils;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.commands.builder.Command;

public class MotdCommand extends Command
{
    public static Config c;
    
    public MotdCommand() {
        super("motd", "Ustawianie motd serwera", "/motd <set|reload|obecne> [tekst]", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage(sender, "/motd <set|reload|obecne>");
        }
        switch (args[0]) {
            case "obecne": {
                return ChatUtil.sendMessage(sender, "&8>> &cObecne motd to: " + MotdCommand.c.getString("wl.motd"));
            }
            case "reload": {
                Server.getInstance().getNetwork().setName(ChatUtil.fixColor(MotdCommand.c.getString("wl.motd")));
                return ChatUtil.sendMessage(sender, "&8>> &cMotd zostalo przeladowane!");
            }
            case "set": {
                if (args.length < 2) {
                    return ChatUtil.sendMessage(sender, "/motd set <tekst>");
                }
                final String reason = StringUtils.join(args, " ", 1, args.length);

                MotdCommand.c.set("wl.motd", reason);
                MotdCommand.c.save();

                Server.getInstance().getNetwork().setName(ChatUtil.fixColor(MotdCommand.c.getString("wl.motd")));
                return ChatUtil.sendMessage(sender, "&8>> &cUstawiles motd na: &r" + reason);
            }
            default: {
                return ChatUtil.sendMessage(sender, "/motd <set|reload|obecne>");
            }
        }
    }
    
    static {
        MotdCommand.c = Main.getPlugin().getConfig();
    }
}
