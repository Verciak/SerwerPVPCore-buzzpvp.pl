package pl.vertty.arivi.commands.root;

import java.util.Iterator;

import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.drop.utils.TimeUtils;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.managers.ItemShop;
import pl.vertty.arivi.managers.ItemShopManager;
import pl.vertty.arivi.objects.Ban;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;

public class aItemShopCommand extends Command
{
    public aItemShopCommand() {
        super("aitemshop", "Odbierz uslugi premium", "<gracz> <vip/svip/sponsor/pandora> <ilosc>", GroupType.ROOT, new String[] { "ais" });
    }
    
    @Override
    public boolean onExecute(final CommandSender p, final String[] args) {
        if (args.length < 3) {
            ChatUtil.sendMessage(p, "/aitemshop <gracz> <vip/svip/sponsor/pandora> <ilosc>");
            return false;
        }
        if (!ChatUtil.isInteger(args[2])) {
            ChatUtil.sendMessage(p, "&4Blad: &cArgument nie jest liczba!");
            return false;
        }
        final int count = Integer.parseInt(args[2]);
        if (args[1].equalsIgnoreCase("turbodrop30")) {
            final User user = UserManager.getUser(args[0]);
            if (user == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            pl.vertty.arivi.drop.base.User drop = UserUtils.get(args[0]);
            long l = TimeUtils.getTime("30min");
            drop.setTurbo(l);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9TurboDROP na 30min", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal TurboDROP");
            return false;
        }
        if (args[1].equalsIgnoreCase("turbodrop60")) {
            final User user = UserManager.getUser(args[0]);
            if (user == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            pl.vertty.arivi.drop.base.User drop = UserUtils.get(args[0]);
            long l = TimeUtils.getTime("60min");
            drop.setTurbo(l);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9TurboDROP na 60min", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal TurboDROP");
            return false;
        }
        if (args[1].equalsIgnoreCase("pandora")) {
            final User user = UserManager.getUser(args[0]);
            if (user == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            user.addPandora(count);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9" + count + " pandor", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal " + count + " pandor");
            return false;
        }
        if (args[1].equalsIgnoreCase("unban")) {
            final Ban b = BanManager.getBan(args[0]);
            if (b == null) {
                return ChatUtil.sendMessage(p, "&4Blad: &cTen gracz nie ma bana!");
            }
            BanManager.unban(b);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9UNBAN", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal unbana");
            return false;
        }
        if (args[1].equalsIgnoreCase("vip")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setVip(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range VIP", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal range VIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("svip")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setSvip(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range SVIP", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal range SVIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("sponsor")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setSponsor(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range SPONSOR", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal range SPONSOR");
            return false;
        }


        if (args[1].equalsIgnoreCase("turboexp30")) {
            final User user = UserManager.getUser(args[0]);
            if (user == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            pl.vertty.arivi.drop.base.User drop = UserUtils.get(args[0]);
            long l = TimeUtils.getTime("30min");
            drop.setTurboExp(l);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9TurboEXP na 30min", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal TurboDROP");
            return false;
        }
        if (args[1].equalsIgnoreCase("turboexp60")) {
            final User user = UserManager.getUser(args[0]);
            if (user == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            pl.vertty.arivi.drop.base.User drop = UserUtils.get(args[0]);
            long l = TimeUtils.getTime("60min");
            drop.setTurboExp(l);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9TurboEXP na 60min", 30, 60, 30);
            }
            ChatUtil.sendMessage(p, "&7Gracz: " + args[0] + " otrzymal TurboDROP");
            return false;
        }
        ChatUtil.sendMessage(p, "/aitemshop <gracz> <pandora/vip/svip/sponsor> <ilosc>");
        return false;
    }
}
