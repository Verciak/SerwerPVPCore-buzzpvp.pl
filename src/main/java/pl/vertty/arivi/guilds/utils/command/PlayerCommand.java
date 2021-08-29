// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils.command;

import pl.vertty.arivi.guilds.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.Player;

public abstract class PlayerCommand extends ConsoleCommand
{
    public abstract boolean onCommand(final Player p0, final String[] p1);
    
    public PlayerCommand(final String s, final String s2, final GroupType s3, final String... array) {
        super(s, s2, s3, array);
    }
    
    @Override
    public boolean onExecute(final CommandSender commandSender, final String[] array) {
        if (!(commandSender instanceof Player)) {
            return ChatUtil.sendMessage(commandSender, "&cTa komende moze wywolac tylko gracz!");
        }
        return this.onCommand((Player)commandSender, array);
    }
}