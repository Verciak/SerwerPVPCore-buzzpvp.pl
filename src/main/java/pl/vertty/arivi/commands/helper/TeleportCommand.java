package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.User;
import cn.nukkit.level.Location;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Server;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class TeleportCommand extends Command
{
    public TeleportCommand() {
        super("tp", "Teleportacja", "/tp [kto] <do kogo>  lub  [kto] <x> <y> <z>", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        switch (args.length) {
            case 1: {
                final Player o = Server.getInstance().getPlayer(args[0]);
                if (o == null) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
                }
                p.teleport(o.getLocation());
                return ChatUtil.sendMessage(p, "&8>> &cZostales przeteleportowany do gracza &6" + o.getName());
            }
            case 2: {
                if (!u.can(GroupType.MODERATOR)) {
                    return ChatUtil.sendMessage(p, "&cNie masz uprawnien!");
                }
                final Player o = Server.getInstance().getPlayer(args[0]);
                if (o == null) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
                }
                final Player o2 = Server.getInstance().getPlayer(args[1]);
                if (o2 == null) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
                }
                o.teleport(o2.getLocation());
                ChatUtil.sendMessage(p, "&8>> &cPrzeteleportowales gracza &6" + o.getName() + " &cdo gracza &6" + o2.getName());
                return ChatUtil.sendMessage(o, "&8>> &cZostales przeteleportowany do gracza &6" + o2.getName() + " &cprzez &6" + p.getName());
            }
            case 3: {
                if (!u.can(GroupType.MODERATOR)) {
                    return ChatUtil.sendMessage(p, "&8>> &cNie masz uprawnien!");
                }
                final Double x = Double.parseDouble(args[0]);
                final Double y = Double.parseDouble(args[1]);
                final Double z = Double.parseDouble(args[2]);
                if (x.isNaN() && y.isNaN() && z.isNaN()) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cKoordynaty musza byc liczbami!");
                }
                p.teleport(new Location(x, y, z));
                return ChatUtil.sendMessage(p, "&8>> &cZostales przeteleportowany na kordy &8X: &6" + x + " &8Y: &6" + y + " &8Z: &6" + z);
            }
            case 4: {
                if (!u.can(GroupType.MODERATOR)) {
                    return ChatUtil.sendMessage(p, "&8>> &cNie masz uprawnien!");
                }
                final Player o = Server.getInstance().getPlayer(args[0]);
                if (o == null) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
                }
                final Double x2 = Double.parseDouble(args[1]);
                final Double y2 = Double.parseDouble(args[2]);
                final Double z2 = Double.parseDouble(args[3]);
                if (x2.isNaN() && y2.isNaN() && z2.isNaN()) {
                    return ChatUtil.sendMessage(p, "&4Blad: &cKoordynaty musza byc liczbami!");
                }
                o.teleport(new Location(x2, y2, z2));
                ChatUtil.sendMessage(o, "&8>> &cZostales przeteleportowany na kordy &8X: &6" + x2 + " &8Y: &6" + y2 + " &8Z: &6" + z2 + " &cprzez &6" + p.getName());
                return ChatUtil.sendMessage(p, "&8>> &cPrzeteleportowales gracza &6" + o.getName() + " &cna kordy &8X: &6" + x2 + " &8Y: &6" + y2 + " &8Z: &6" + z2);
            }
            default: {
                return ChatUtil.sendMessage(p, this.getUsage());
            }
        }
    }
}
