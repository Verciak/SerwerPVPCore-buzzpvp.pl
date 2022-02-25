
package pl.vertty.arivi.utils.guild.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public abstract class ConsoleCommand extends Command
{
    private final String name;
    private final String usage;
    private final GroupType type;
    
    public abstract boolean onExecute(final CommandSender p0, final String[] p1);
    
    public boolean execute(final CommandSender commandSender, final String s, final String[] array) {
        if (commandSender instanceof Player) {
            final User user = UserManager.getUser((Player)commandSender);
            if (user.getGroup().getLevel() < this.type.getLevel()) {
                String msg = "&cWymagana ranga do uzycia tej komendy to &7{GROUP}";
                msg = msg.replace("{GROUP}", this.type.getFullName());
                return ChatUtil.sendMessage(commandSender, msg);
            }
        }
        return this.onExecute(commandSender, array);
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public GroupType getType() {
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ConsoleCommand(final String name, final String usage, final GroupType type, final String[] a) {
        super(name, "", usage, a);
        this.name = name;
        this.usage = usage;
        this.type = type;
    }
}
