
package pl.vertty.arivi.guilds.commands.guild;

import java.util.Iterator;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildItemsCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        this.openInv(player);
        return false;
    }
    
    public GuildItemsCommand() {
        super("itemy", "/g itemy", GroupType.PLAYER, new String[0]);
    }
    
    public void openInv(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleGuildItemsGui();

        final User ua = UserManager.getUser(player);
        String s = Config.COST_CREATE_NORMAL;
        if (ua.can(GroupType.SVIP)) {
            s = Config.COST_CREATE_SVIP;
        }
        if (ua.can(GroupType.VIP)) {
            s = Config.COST_CREATE_VIP;
        }

        category.addElement(10, new ItemData(0,0,1));
        category.addElement(16, new ItemData(0,0,1));

        for(Item itemstack : ItemStackUtil.getItems(s, 1)){
            category.addElementAir(ItemData.fromItem(itemstack
                    .setCustomName(ChatUtil.fixColor("&9" + itemstack.getName()))
                    .setLore(ChatUtil.fixColor("&8» &7Posiadasz: &9" + ItemStackUtil.getItemAmount(itemstack, player) + "&7/&9" + itemstack.getCount()), ChatUtil.fixColor("&8» &7Procent posiadania: &9" + ItemStackUtil.getItemAmount(itemstack, player) / itemstack.getCount() * 100.0 + "&7%"))
            ));
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gItemyMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Itemy na gildie!"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gItemyMenu", menu);
    }
}
