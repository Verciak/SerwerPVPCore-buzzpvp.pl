// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.builder;

import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;

public abstract class PlayerCommand extends Command
{
    public PlayerCommand(final String name, final String description, final String usage, final GroupType type, final String[] aliases) {
        super(name, description, usage, type, aliases);
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (!(sender instanceof Player)) {
            return ChatUtil.sendMessage(sender, "&cNie mozesz wywolac tej komendy z poziomu konsoli.");
        }
        return this.onCommand((Player)sender, args);
    }
    
    public abstract boolean onCommand(final Player p0, final String[] p1);
}
