// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class IgnoreCommand extends PlayerCommand
{

    public IgnoreCommand() {
        super("ignore", "Ignoruje prywatne wiadomosci od danego gracza", "/ignore [nick]", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage(p, "/ignore [nick]");
        }
        User u = UserManager.getUser(p);
        Player arg = Server.getInstance().getPlayer(args[0]);
        if (u.isIgnoreTell(arg)) {
            u.removeIgnoreTell(arg);
            return ChatUtil.sendMessage(p, "&7Przestales ignorowac prywatne wiadomosci od gracza &9" + args[0] + "&7!");
        }
        u.addIgnoreTell(arg);
        return ChatUtil.sendMessage(p, "&7Od teraz ignorujesz prywatne wiadomosci od gracza &9" + args[0] + "&7!");
    }
}
