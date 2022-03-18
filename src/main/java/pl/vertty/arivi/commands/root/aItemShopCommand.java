// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.root;

import java.util.Iterator;

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
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class aItemShopCommand extends Command
{
    public aItemShopCommand() {
        super("aitemshop", "Odbierz uslugi premium", "<gracz> <vip/svip/sponsor/skrzydla> <ilosc>", GroupType.ROOT, new String[] { "ais" });
    }
    
    @Override
    public boolean onExecute(final CommandSender p, final String[] args) {
        if (args.length < 3) {
            ChatUtil.sendMessage((CommandSender)p, "/aitemshop <gracz> <vip/svip/sponsor/skrzydla> <ilosc>");
            return false;
        }
        if (!ChatUtil.isInteger(args[2])) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cArgument nie jest liczba!");
            return false;
        }
        final int count = Integer.parseInt(args[2]);
        if (args[1].equalsIgnoreCase("unban")) {
            final Ban b = BanManager.getBan(args[0]);
            if (b == null) {
                return ChatUtil.sendMessage(p, "&4Blad: &cTen gracz nie ma bana!");
            }
            BanManager.unban(b);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9UNBAN", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + args[0] + " otrzymal unbana");
            return false;
        }
        if (args[1].equalsIgnoreCase("vip")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setVip(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range VIP", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + args[0] + " otrzymal range VIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("svip")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setSvip(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range SVIP", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + args[0] + " otrzymal range SVIP");
            return false;
        }
        if (args[1].equalsIgnoreCase("sponsor")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setSponsor(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9Range SPONSOR", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + args[0] + " otrzymal range SPONSOR");
            return false;
        }
        if (args[1].equalsIgnoreCase("skrzydla")) {
            ItemShop is = ItemShopManager.getUser(args[0]);
            if(is == null){
                ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracza nie ma w bazie danych!");
                return false;
            }
            is.setSkrzydla(1);
            for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                ChatUtil.sendTitle(player2, "&9ITEMSHOP", "&7Gracz: &9" + args[0] + " &7kupil &9SKRZYDLA NA 3 EDYCJE", 30, 60, 30);
            }
            ChatUtil.sendMessage((CommandSender)p, "&7Gracz: " + args[0] + " otrzymal SKRZYDLA");
            return false;
        }
        ChatUtil.sendMessage((CommandSender)p, "/aitemshop <gracz> <vip/svip/sponsor/skrzydla> <ilosc>");
        return false;
    }
}
