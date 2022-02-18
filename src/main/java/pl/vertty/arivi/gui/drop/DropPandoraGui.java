package pl.vertty.arivi.gui.drop;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class DropPandoraGui {


    public static void openMain(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleCXPandoraServerGui();

        final Item back = new Item(ItemID.NETHER_STAR, 0, 1);
        back.setCustomName(ChatUtil.fixColor("&r&cPOWROT"));

        for(Item item : PierozekManager.drop){
            category.addElementAir(ItemData.fromItem(item));
        }
        category.addElement(49, ItemData.fromItem(back), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> DropMainGui.openMain(player), 13);
            }
        });



        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("MainPandoraGUI", category);
        menu.setName(ChatUtil.fixColor("&9MENU DROPU"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("MainPandoraGUI", menu);
    }

}
