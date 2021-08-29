// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class TpdenyCommmand extends PlayerCommand
{
    public TpdenyCommmand() {
        super("tpdeny", "Odrzucenie prosby o teleportacje", "/tpdeny", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        final Player o = u.getTpa().get(0);
        if (o == null) {
            if (u.getTpa().contains(o)) {
                u.getTpa().remove(o);
            }
            return ChatUtil.sendMessage((CommandSender)p, "&cGracz jest offline");
        }
        if (u == null) {
            return true;
        }
        if (!u.getTpa().contains(o)) {
            return ChatUtil.sendMessage((CommandSender)p, "&cNie masz zaproszenia do teleportacji od gracza " + o.getName() + "!");
        }
        u.getTpa().remove(p);
        ChatUtil.sendMessage((CommandSender)p, "&8>> &7Odrzuciles prosbe o teleport od gracza &6" + o.getName() + "&7!");
        return ChatUtil.sendMessage((CommandSender)o, "&8>> &7Gracz &6" + p.getName() + " &7odrzucil twoja prosbe o teleport!");
    }
}
