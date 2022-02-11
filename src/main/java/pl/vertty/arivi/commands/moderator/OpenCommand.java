package pl.vertty.arivi.commands.moderator;

import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class OpenCommand extends Command
{
    public OpenCommand() {
        super("otworz", "Sprawdzanie eq graczy", "/otworz <inv> <nick>", GroupType.MODERATOR, new String[] { "open" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length != 2) {
            return ChatUtil.sendMessage(p, this.getUsage());
        }
        final Player player = Server.getInstance().getPlayer(args[1]);
        if (player == null) {
            ChatUtil.sendMessage(p, "&cGracz jest offline!");
            return true;
        }
        if (args[0].equalsIgnoreCase("inv") || args[0].equalsIgnoreCase("inventory")) {
            final InventoryMenu menu = new InventoryMenu();
            final InventoryCategory category = new InventoryCategory();
            for (int ia = 0; ia < player.getInventory().getContents().size(); ++ia) {
                category.addElement(ia, ItemData.fromItem(player.getInventory().getContents().get(ia)));
            }
            menu.setDoubleChest();
            menu.setMainCategory(category);
            menu.addCategory("invGuiopen", category);
            menu.setName(ChatUtil.fixColor("&7Ekwipunek gracza &9" + args[1]));
            menu.setOnlyRead(true);
            menu.show(p);
            InventoryMenuHandler.registerNewMenu("invGuiopen", menu);
            return true;
        }
        return true;
    }
}
