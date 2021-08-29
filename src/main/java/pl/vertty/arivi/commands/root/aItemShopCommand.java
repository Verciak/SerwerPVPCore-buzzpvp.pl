// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.root;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class aItemShopCommand extends PlayerCommand
{
    public aItemShopCommand() {
        super("aitemshop", "Odbierz uslugi premium", "<gracz> <pandora/klucz> <ilosc>", GroupType.ROOT, new String[] { "ais" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 3) {
            ChatUtil.sendMessage((CommandSender)p, "/aitemshop <gracz> <pandora/klucz> <ilosc>");
            return false;
        }
        final Player player = Server.getInstance().getPlayer(args[0]);
        final User user = UserManager.getUser(player);
        if (user == null) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracza nie ma w bazie danych!");
            return false;
        }
        if (!ChatUtil.isInteger(args[2])) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cArgument nie jest liczba!");
            return false;
        }
        final int count = Integer.parseInt(args[2]);
        if (args[1].equalsIgnoreCase("pandora")) {
            user.addPandora(count);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + player.getName() + " &7kupil &9" + count + " pandor", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + player.getName() + " otrzymal " + count + " pandor");
            if (player != null) {
                ChatUtil.sendTitle(player, "&7Odbierz itemy pod:", "&9/is", 30, 60, 30);
            }
            return false;
        }
        if (args[1].equalsIgnoreCase("klucz")) {
            user.addMychest(count);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + player.getName() + " &7kupil &9" + count + " kluczy", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + player.getName() + " otrzymal " + count + " klucze");
            if (player != null) {
                ChatUtil.sendTitle(player, "&7Odbierz itemy pod:", "&9/is", 30, 60, 30);
            }
            return false;
        }
        if (args[1].equalsIgnoreCase("vip")) {
            user.setGroup(GroupType.VIP);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + player.getName() + " &7kupil &9Range VIP", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + player.getName() + " otrzymal range VIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("svip")) {
            user.setGroup(GroupType.SVIP);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + player.getName() + " &7kupil &9Range SVIP", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + player.getName() + " otrzymal range SVIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("sponsor")) {
            user.setGroup(GroupType.SPONSOR);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + player.getName() + " &7kupil &9Range SPONSOR", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + player.getName() + " otrzymal range SPONSOR");
            return false;
        }
        ChatUtil.sendMessage((CommandSender)p, "/aitemshop <gracz> <pandora/klucz/vip/svip/sponsor> <ilosc>");
        return false;
    }
}
