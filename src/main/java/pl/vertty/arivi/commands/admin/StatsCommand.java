// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class StatsCommand extends Command
{
    public StatsCommand() {
        super("stats", "Ustawianie graczowi statystyk", "/stats <gracz> <kills/deaths/points/assists> <ilosc> lub <restart> <1>", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length < 2) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final User u = UserManager.getUser(args[0]);
        final User ua = UserManager.getUser(args[0]);
        if (u == null) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cGracz nie istnieje!");
        }
        if (!ChatUtil.isInteger(args[2])) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cTo nie liczba!");
        }
        final int i = Integer.parseInt(args[2]);
        final String s3;
        final String s4;
        final String s2 = s4 = (s3 = args[1]);
        switch (s4) {
            case "restart": {
                ua.setPoints(1000);
                ua.setKills(0);
                ua.setDeaths(0);
                ua.setAsysts(0);
                return ChatUtil.sendMessage(sender, "&8>> &cZresetowales statystyki gracza &6" + u.getName());
            }
            case "points": {
                if (args.length < 3) {
                    return ChatUtil.sendMessage(sender, this.getUsage());
                }
                ua.setPoints(i);
                return ChatUtil.sendMessage(sender, "&8>> &7Ustawiles &6" + args[1] + " &7na &6" + i + " &7gracza &6" + u.getName());
            }
            case "kills": {
                if (args.length < 3) {
                    return ChatUtil.sendMessage(sender, this.getUsage());
                }
                ua.setKills(i);
                return ChatUtil.sendMessage(sender, "&8>> &7Ustawiles &6" + args[1] + " &7na &6" + i + " &7gracza &6" + u.getName());
            }
            case "deaths": {
                if (args.length < 3) {
                    return ChatUtil.sendMessage(sender, this.getUsage());
                }
                ua.setDeaths(i);
                return ChatUtil.sendMessage(sender, "&8>> &7Ustawiles &6" + args[1] + " &7na &6" + i + " &7gracza &6" + u.getName());
            }
            case "assists": {
                if (args.length < 3) {
                    return ChatUtil.sendMessage(sender, this.getUsage());
                }
                ua.setAsysts(i);
                return ChatUtil.sendMessage(sender, "&8>> &7Ustawiles &6" + args[1] + " &7na &6" + i + " &7gracza &6" + u.getName());
            }
            default: {
                return ChatUtil.sendMessage(sender, this.getUsage());
            }
        }
    }
}
