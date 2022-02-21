package pl.vertty.arivi.gui.drop;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.drop.base.Drop;
import pl.vertty.arivi.drop.base.User;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;

public class DropStoneGui {


    public static void openMain(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleStoneServerGui();
        final Config c = Main.getPlugin().getConfig();
        final User userdrop = UserUtils.get(player.getName());
        for (final Drop drop : DropUtils.getDrops()) {
            Item ia = new Item(drop.getItem().getId(), 0, 1);
            ia.setCustomName(ChatUtil.fixColor(drop.getInvName()));
            ia.setLore(ChatUtil.fixColor(c.getString("drop.lore").replace(">>", "»").replace("{CHANCE}", Double.toString(drop.getChance())).replace("{HEIGHT}", (drop.getHeight() == 0) ? "Kazda" : Integer.toString(drop.getHeight())).replace("{LVL}", (drop.getLvl() == 0) ? "Brak" : Integer.toString(drop.getLvl())).replace("{FORTUNE}", drop.isFortune() ? "&awlaczone" : "&cwylaczone").replace("{ENABLE}", drop.getDisabled().contains(player.getName()) ? "&cwylaczony" : "&awlaczony").replace("{WYKOPANE}", String.valueOf(userdrop.getDrop(drop.getName()))).replace("{N}", "\n")));
            category.addElementAir(ItemData.fromItem(ia), new ItemClick() {
                @Override
                public void onClick(final Player player, final Item item) {
                    final Drop drop = Drop.getInv(item.getCustomName());
                    if (drop == null) {
                        return;
                    }
                    if (drop.isDisabled(player.getName())) {
                        drop.enable(player.getName());
                        DropStoneGui.openMain(player);
                    }
                    else {
                        drop.disable(player.getName());
                        DropStoneGui.openMain(player);
                    }
                }
            }, 54);
        }
        final Item on = new Item(351, 10, 1);
        on.setCustomName(ChatUtil.fixColor("&r&aWlacz Wszystkie Dropy"));
        final Item off = new Item(351, 1, 1);
        off.setCustomName(ChatUtil.fixColor("&r&cWylacz Wszystkie Dropy"));
        final Item back = new Item(ItemID.NETHER_STAR, 0, 1);
        back.setCustomName(ChatUtil.fixColor("&r&cPOWROT"));
        final Item exp = new Item(384, Integer.valueOf(0), 1);
        exp.setCustomName(ChatUtil.fixColor("&r&9DOSWIADCZENIE"));
        exp.setLore(ChatUtil.fixColor("&r&8>> &7STONE: &34"), ChatUtil.fixColor("&8>> &7OBSIDIAN: &312"));
        final Item cobble = new Item(4, Integer.valueOf(0), 1);
        cobble.setCustomName(ChatUtil.fixColor("&r&9Cobblestone"));
        cobble.setLore(ChatUtil.fixColor("&r&8>> &7Drop: " + (DropUtils.isCobble(player.getName()) ? "&awlaczony" : "&cwylaczony")));

        category.addElement(46, ItemData.fromItem(on), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                for (final Drop d : DropUtils.getDrops()) {
                    d.enable(player.getName());
                    DropStoneGui.openMain(player);
                }
            }
        });
        category.addElement(47, ItemData.fromItem(off), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                for (final Drop d : DropUtils.getDrops()) {
                    d.disable(player.getName());
                    DropStoneGui.openMain(player);
                }
            }
        });
        category.addElement(49, ItemData.fromItem(back), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                menu.forceDestroy(player);
                Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> DropMainGui.openMain(player), 13);
            }
        });

        category.addElement(51, ItemData.fromItem(exp));
        category.addElement(52, ItemData.fromItem(cobble), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                if (DropUtils.isCobble(player.getName())) {
                    DropUtils.disableCobble(player.getName());
                    DropStoneGui.openMain(player);
                }
                else {
                    DropUtils.enableCobble(player.getName());
                    DropStoneGui.openMain(player);
                }
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
