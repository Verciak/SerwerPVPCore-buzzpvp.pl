// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.managers.BackupManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class BackupCommand extends Command
{
    public BackupCommand() {
        super("backup", "Komenda do oddwania eq!", "/backup <gracz>", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cGracz jest offline!");
        }
        BackupManager.openInventory(o, (Player)sender);
        return true;
    }
}
