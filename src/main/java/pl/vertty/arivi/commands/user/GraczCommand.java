// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class GraczCommand extends PlayerCommand
{
    public GraczCommand() {
        super("gracz", "Statystki gracza", "/gracz <nick>", GroupType.PLAYER, new String[] { "ranking", "staty", "punkty" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        if (args.length == 0) {
            final User u = UserManager.getUser(player);
            ChatUtil.sendMessage((CommandSender)player, "&8» &7Punkty: &9" + u.getPoints() + "\n &7» &7Zabojstwa: &9" + u.getKills() + "\n &8» &7Zgony: &9" + u.getDeaths() + "\n &8» &7Gildia: &9" + ((u.getGuild() == null) ? "Brak" : u.getGuild().getTag()) + "\n");
            return true;
        }
        if(Server.getInstance().getPlayer(args[0]) == null){
            return ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cGracz nie istnieje badz jest offline!");
        }
        final User u = UserManager.getUser(args[0]);
        final Player p = Server.getInstance().getPlayer(args[0]);
        if (p == null) {
            return ChatUtil.sendMessage((CommandSender)player, "&4Blad: &cGracz nie istnieje badz jest offline!");
        }
        ChatUtil.sendMessage((CommandSender)player, "&8» &7Gracz: &9" + p.getName() + "\n &8» &7Punkty: &9" + u.getPoints() + "\n &8» &7Zabojstwa: &9" + u.getKills() + "\n &8» &7Zgony: &9" + u.getDeaths() + "\n &8» &7Gildia: &9" + ((u.getGuild() == null) ? "Brak" : u.getGuild().getTag()) + "\n");
        return true;
    }
}
