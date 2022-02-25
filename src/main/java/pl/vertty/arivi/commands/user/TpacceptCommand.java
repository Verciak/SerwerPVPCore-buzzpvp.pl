package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.TimerUtil;

public class TpacceptCommand extends PlayerCommand
{
    public TpacceptCommand() {
        super("tpaccept", "Akceptacja teleportacji od gracza", "/tpaccept", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        if (u.getTpa().size() == 0) {
            return ChatUtil.sendMessage(p, "&cNie masz zadnych zaproszenia do teleportacji!");
        }
        final Player o = u.getTpa().get(0);
        if (o == null) {
            if (u.getTpa().contains(o)) {
                u.getTpa().remove(o);
            }
            return ChatUtil.sendMessage(p, "&cGracz offline!");
        }
        if (u == null) {
            return true;
        }
        if (!u.getTpa().contains(o)) {
            return ChatUtil.sendMessage(p, "&cNie masz zaproszenia do teleportacji od gracza " + o.getName() + "!");
        }
        TimerUtil.teleport(o, p.getLocation(), 10);
        u.getTpa().remove(o);
        ChatUtil.sendMessage(p, "&8>> &7Zaakceptowales prosbe o teleport do ciebie od gracza &6" + o.getName() + "&7!");
        ChatUtil.sendMessage(o, "&8>> &7Gracz &6" + p.getName() + " &7zaakceptowal twoja prosbe o teleport do niego!");
        return true;
    }
}
