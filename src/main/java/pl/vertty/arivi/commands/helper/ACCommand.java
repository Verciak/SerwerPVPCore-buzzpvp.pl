// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class ACCommand extends Command
{
    public static boolean status = false;

    public ACCommand() {
        super("ac", "Zarzadzanie anticheat", "/ac", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        if (args.length == 0) {
            ACCommand.status = !ACCommand.status;
            return ChatUtil.sendMessage((Player)p, "&7Powiadomienia zostaly &" + (ACCommand.status ? "aWlaczone" : "cWylaczone"));
        }
        return false;
    }
}
