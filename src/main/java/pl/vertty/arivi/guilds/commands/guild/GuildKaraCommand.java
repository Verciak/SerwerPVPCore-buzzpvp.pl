// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import java.util.ArrayList;
import pl.vertty.arivi.enums.GroupType;
import java.util.Iterator;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.DataUtil;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Guild;
import java.util.List;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildKaraCommand extends PlayerCommand
{
    public static List<Guild> guilds;
    
    public static void openInv(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        for (final Guild guild : GuildManager.getKaraGuilds()) {
            for (int ia = 20; ia < GuildManager.getKaraGuilds().size() + 20; ++ia) {
                final Item itemStack = new Item(397, Integer.valueOf(3), 1);
                itemStack.setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koniec za: &9").append(DataUtil.secondsToString(guild.getTntKaraTime())))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koordynaty: &8(&7X:&9 ").append(guild.getRegion().getX()).append(" &7Z:&9 ").append(guild.getRegion().getZ()).append("&8)"))) });
                itemStack.setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8[&9").append(guild.getTag()).append("&8] &9").append(guild.getName()))));
                category.addElement(ia, ItemData.fromItem(itemStack));
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gkaraMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Kary gildii"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gkaraMenu", menu);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        openInv(player);
        return false;
    }
    
    public GuildKaraCommand() {
        super("kara", "/g kara", GroupType.PLAYER, new String[0]);
    }
    
    static {
        GuildKaraCommand.guilds = new ArrayList<Guild>();
    }
}
