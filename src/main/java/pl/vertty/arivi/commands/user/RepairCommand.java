package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.PolishItemNames;
import pl.vertty.arivi.utils.RepairUtil;

public class RepairCommand extends PlayerCommand
{
    public RepairCommand() {
        super("repair", "Naprawianie przedmiotow", "/repair", GroupType.PLAYER, new String[] { "napraw" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        final Item is = p.getInventory().getItemInHand();
        final Item ia = new Item(264, Integer.valueOf(0), 16);
        if (args.length == 1 && args[0].equalsIgnoreCase("all") && u.can(GroupType.SVIP)) {
            RepairUtil.repairAll(p);
            ChatUtil.sendMessage(p, "&8>> &7Itemy zostaly naprawione! Mozliwe ze nie bedzie to widoczne!");
        }
        if (args.length == 1 && args[0].equalsIgnoreCase("all") && !u.can(GroupType.SVIP)) {
            return ChatUtil.sendMessage(p, "&cNie masz dostepu do tej komendy! &7(Wymagana ranga: SVIP)");
        }
        if (is.getId() == 322 || is.getId() == 466) {
            return ChatUtil.sendMessage(p, "&cTego przedmiotu nie mozesz naprawic!");
        }
        if (is.getDamage() == 1) {
            return ChatUtil.sendMessage(p, "&cTen przedmiot jest naprawiony!");
        }
        if (u.can(GroupType.VIP)) {
            RepairUtil.repairAll(p);
            ChatUtil.sendMessage(p, "&8>> &7Naprawiles przedmiot &e" + PolishItemNames.getPolishName(is) + "&7!");
            ChatUtil.sendMessage(p, "&8>> &7Item zostaly naprawiony! Mozliwe ze nie bedzie to widoczne!");
        }
        else if (p.getInventory().contains(ia)) {
            RepairUtil.repairAll(p);
            ChatUtil.sendMessage(p, "&8>> &7Naprawiles przedmiot &e" + PolishItemNames.getPolishName(is) + "&7!");
            ChatUtil.sendMessage(p, "&8>> &7Item zostaly naprawiony! Mozliwe ze nie bedzie to widoczne!");
            p.getInventory().removeItem(new Item[] { ia });
        }
        else {
            ChatUtil.sendMessage(p, "&cNie posiadasz 16 diamentow!");
        }
        return false;
    }
}
