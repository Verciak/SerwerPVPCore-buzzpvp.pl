// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class TpaCommand extends PlayerCommand
{
    public TpaCommand() {
        super("tpa", "Wysylanie prosby o teleportacje", "/tpa <nick>", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage((CommandSender)p, this.getUsage());
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage((CommandSender)p, "&cGracz jest offline!");
        }
        final User u = UserManager.getUser(o);
        if (u == null) {
            return true;
        }
        if (o == p) {
            return ChatUtil.sendMessage((CommandSender)p, "&cNie mozesz wyslac prosby do samego siebie!");
        }
        if (u.getTpa().contains(p)) {
            return ChatUtil.sendMessage((CommandSender)p, "&cWyslales juz zaproszenie o teleport do gracza " + o.getName() + "!");
        }
        u.getTpa().add(p);
        ChatUtil.sendMessage((CommandSender)p, "&8>> &7Wyslales prosbe o teleport do gracza &6" + o.getName() + "&7!");
        ChatUtil.sendMessage((CommandSender)o, "&8>> &7Gracz &6" + p.getName() + " &7chce sie przeteleportowac do Ciebie!");
        ChatUtil.sendMessage((CommandSender)o, "&8>> &7Wpisz &6/tpaccept &7aby zaakceptowac!");
        return ChatUtil.sendMessage((CommandSender)o, "&8>> &7Wpisz &6/tpdeny &7aby odrzucic!");
    }
}
