package pl.vertty.arivi.commands.builder;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;

public abstract class Command extends cn.nukkit.command.Command
{
    private final String name;
    private final String usage;
    private final String description;
    private final GroupType type;
    
    public Command(final String name, final String description, final String usage, final GroupType type, final String[] aliases) {
        super(name, description, usage, aliases);
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.type = type;
    }
    
    public boolean execute(final CommandSender sender, final String label, final String[] args) {
        if (sender instanceof Player) {
            final User user = UserManager.getUser((Player)sender);
            if (user.getGroup().getLevel() < this.type.getLevel()) {
                String msg = "&cWymagana ranga do uzycia tej komendy to &7{GROUP}";
                msg = msg.replace("{GROUP}", this.type.getFullName());
                return ChatUtil.sendMessage(sender, msg);
            }
        }
        return this.onExecute(sender, args);
    }
    
    public abstract boolean onExecute(final CommandSender p0, final String[] p1);
    
    public String getName() {
        return this.name;
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public GroupType getType() {
        return this.type;
    }
}
