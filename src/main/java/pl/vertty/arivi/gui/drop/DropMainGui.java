package pl.vertty.arivi.gui.drop;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class DropMainGui{


    public static void openMain(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoublCHUJGui();

        category.addElement(21, new ItemData(Item.LEAVES, 0, 1, "&r&9DROP Z LISCI", new String[]{ChatUtil.fixColor("&r&8>> &7Kliknij, aby otworzyc &3drop z lisci")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                DropLeavesGui.openMain(player);
            }
        });
        category.addElement(19, new ItemData(Item.OBSIDIAN, 0, 1, "&r&9DROP Z OBSYDIANU", new String[]{ChatUtil.fixColor("&r&8>> &7Kliknij, aby otworzyc &3drop z obsydianu")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                DropObsidianGui.openMain(player);
            }
        });
        category.addElement(23, new ItemData(Item.STONE, 0, 1, "&r&9DROP Z STONE", new String[]{ChatUtil.fixColor("&r&8>> &7Kliknij, aby otworzyc &3drop z stone")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                DropStoneGui.openMain(player);
            }
        });
        category.addElement(25, new ItemData(Block.MONSTER_SPAWNER, 0, 1, "&r&9DROP Z COBBLEX", new String[]{ChatUtil.fixColor("&r&8>> &7Kliknij, aby otworzyc &3drop z cobblex")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                DropCobblexGui.openMain(player);
            }
        });
        category.addElement(31, new ItemData(Block.DRAGON_EGG, 0, 1, "&r&9DROP Z PANDOR", new String[]{ChatUtil.fixColor("&r&8>> &7Kliknij, aby otworzyc &3drop z pandor")}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1){
                DropPandoraGui.openMain(player);
            }
        });


        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("MainDropGUI", category);
        menu.setName(ChatUtil.fixColor("&9MENU DROPU"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("MainDropGUI", menu);
    }

}
