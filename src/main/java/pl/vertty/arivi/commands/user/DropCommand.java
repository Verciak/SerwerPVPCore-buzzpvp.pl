// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.drop.data.DataManager;
import pl.vertty.arivi.drop.utils.Colors;
import pl.vertty.arivi.drop.utils.TimeUtils;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class DropCommand extends PlayerCommand
{
    public DropCommand() {
        super("drop", "Drop ze stone", "drop", GroupType.PLAYER, new String[] { "stone" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        final User u = UserManager.getUser(player);
        if (args.length == 0 || !u.can(GroupType.ADMIN)) {
            Util.openStone(player);
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            DropUtils.load();
            new DataManager();
            ChatUtil.sendMessage((CommandSender)player, "&aKonfiguracja dropu zostala przeladowana");
            return true;
        }
        if (args.length == 1 || args.length == 2) {
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turbo [drop/exp] [nick] [czas] &8-&7 wlacza turbodrop graczowi");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turbo [drop/exp] [nick] -1 &8-&7 wlacza turbodrop na zawsze");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turbo [drop/exp] [nick] off &8-&7 wylacza turbodrop graczowi");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turbo [drop/exp] [nick] &8-&7 sprawdza czy gracz ma turbodrop");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turboall [drop/exp] [czas] &8-&7 wlacza turbodrop dla wszystkich");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop turboall [drop/exp] off &8-&7 wylacza turbodrop dla wszystkich");
            ChatUtil.sendMessage((CommandSender)player, "&6/drop reload &8-&7 przeladowywuje konfiguracje");
            return false;
        }
        if (args[0].equalsIgnoreCase("turbo") && args.length == 3) {
            final pl.vertty.arivi.drop.base.User user = UserUtils.get(args[2]);
            if (user == null) {
                ChatUtil.sendMessage((CommandSender)player, "&cNie odnaleziono gracza");
                return false;
            }
            if (args[1].equalsIgnoreCase("exp")) {
                final String turbo = user.isTurboExp() ? "&awlaczony" : "&cwylaczony";
                player.sendMessage(Colors.translate("&7" + user.getName() + " ma " + turbo + " &7turboexp." + ((user.getTurboExp() > 0L) ? (" Pozostalo &e" + TimeUtils.getDurationBreakdown(user.getTurboExp() - System.currentTimeMillis())) : "")));
                return true;
            }
            final String turbo = user.isTurbo() ? "&awlaczony" : "&cwylaczony";
            player.sendMessage(Colors.translate("&7" + user.getName() + " ma " + turbo + " &7turbodrop." + ((user.getTurbo() > 0L) ? (" Pozostalo &e" + TimeUtils.getDurationBreakdown(user.getTurbo() - System.currentTimeMillis())) : "")));
            return true;
        }
        else if (args[0].equalsIgnoreCase("turbo") && args.length == 4) {
            final pl.vertty.arivi.drop.base.User user = UserUtils.get(args[2]);
            if (user == null) {
                ChatUtil.sendMessage((CommandSender)player, "&cNie odnaleziono gracza");
                return false;
            }
            if (args[1].equalsIgnoreCase("exp")) {
                if (args[3].equalsIgnoreCase("off")) {
                    user.setTurboExp(0L);
                    Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7zabral turboexp graczowi &6" + user.getName()));
                    return true;
                }
                if (args[3].equalsIgnoreCase("-1")) {
                    user.setTurboExp(-1L);
                    Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7dal turboexp graczowi &6" + user.getName()));
                    return true;
                }
                long l = TimeUtils.getTime(args[3]);
                if (l == 0L) {
                    player.sendMessage("§cBlad: §4Podales zly argument");
                    return false;
                }
                Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7dal turboexp graczowi &6" + user.getName() + " &7na czas &e" + TimeUtils.getDurationBreakdown(l)));
                l += System.currentTimeMillis();
                user.setTurboExp(l);
                return true;
            }
            else {
                if (args[3].equalsIgnoreCase("off")) {
                    user.setTurbo(0L);
                    Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7zabral turbodrop graczowi &6" + user.getName()));
                    return true;
                }
                if (args[3].equalsIgnoreCase("-1")) {
                    user.setTurbo(-1L);
                    Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7dal turbodrop graczowi &6" + user.getName()));
                    return true;
                }
                long l = TimeUtils.getTime(args[3]);
                if (l == 0L) {
                    player.sendMessage("§cBlad: §4Podales zly argument");
                    return false;
                }
                Server.getInstance().broadcastMessage(Colors.translate("&e" + player.getName() + " &7dal turbodrop graczowi &6" + user.getName() + " &7na czas &e" + TimeUtils.getDurationBreakdown(l)));
                l += System.currentTimeMillis();
                user.setTurbo(l);
                return true;
            }
        }
        else {
            if (!args[0].equalsIgnoreCase("turboall") || args.length < 3) {
                return false;
            }
            if (args[1].equalsIgnoreCase("exp")) {
                if (args[2].equalsIgnoreCase("off")) {
                    Util.turbo_exp = 0L;
                    Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wylaczyl turboexp ALL"));
                    return true;
                }
                if (args[2].equalsIgnoreCase("-1")) {
                    Util.turbo_exp = -1L;
                    Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wlaczyl turboexp ALL"));
                    return true;
                }
                Long i = TimeUtils.getTime(args[2]);
                if (i == 0L) {
                    player.sendMessage("§cBlad: §4Podales zly argument");
                    return false;
                }
                Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wlaczyl turboexp ALL na czas &e" + TimeUtils.getDurationBreakdown(i)));
                i += System.currentTimeMillis();
                Util.turbo_exp = i;
                return true;
            }
            else {
                if (args[2].equalsIgnoreCase("off")) {
                    Util.turbo = 0L;
                    Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wylaczyl turbodrop ALL"));
                    return true;
                }
                if (args[2].equalsIgnoreCase("-1")) {
                    Util.turbo = -1L;
                    Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wlaczyl turbodrop ALL"));
                    return true;
                }
                Long i = TimeUtils.getTime(args[2]);
                if (i == 0L) {
                    player.sendMessage("§cBlad: §4Podales zly argument");
                    return false;
                }
                Server.getInstance().broadcastMessage(Colors.translate("&6" + player.getName() + " &7wlaczyl turbodrop ALL na czas &e" + TimeUtils.getDurationBreakdown(i)));
                i += System.currentTimeMillis();
                Util.turbo = i;
                return true;
            }
        }
    }
}
