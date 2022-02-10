// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.exception.SkinChangeException;

public class EnchantGUI
{
    public static void openButy(final Player p, final int books) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(46, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(37, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(27, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(36, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(45, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(20, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Powolne opadanie &eIV")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &725 LvL", "&9Ilosc wymaganych biblioteczek: &720" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 20) {
                    if (p.getExperienceLevel() >= 25) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(2).setLevel(4) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 25);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 25 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 20 biblioteczek!");
                }
            }
        });
        category.addElement(29, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Powolne opadanie &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(2).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(38, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Powolne opadanie &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(2).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(47, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Powolne opadanie &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(2).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("butyEnchant", category);
        menu.setName(ChatUtil.fixColor("&9WYBIERANY ENCHANT &8- &3" + books));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("butyEnchant", menu);
    }
    
    public static void openSety(final Player p, final int books) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(46, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(37, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(27, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(36, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(45, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ochrona &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 306 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 309) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("setyEnachnt", category);
        menu.setName(ChatUtil.fixColor("&9WYBIERANY ENCHANT &8- &3" + books));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("setyEnachnt", menu);
    }
    
    public static void openKilof(final Player p, final int books) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(48, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Jedwabny dotyk &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(16).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(29, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Szczescie &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(38, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Szczescie &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(47, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Szczescie &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(18).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(28, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(37, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(46, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(9, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Wydajnosc &eV")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &730 LvL", "&9Ilosc wymaganych biblioteczek: &725" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 25) {
                    if (p.getExperienceLevel() >= 30) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(5) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 30);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 30 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 25 biblioteczek!");
                }
            }
        });
        category.addElement(18, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Wydajnosc &eIV")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &725 LvL", "&9Ilosc wymaganych biblioteczek: &720" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 20) {
                    if (p.getExperienceLevel() >= 25) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(4) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 25);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 25 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 20 biblioteczek!");
                }
            }
        });
        category.addElement(27, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Wydajnosc &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(36, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Wydajnosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(45, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Wydajnosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(15).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("KilofEnchant", category);
        menu.setName(ChatUtil.fixColor("&9WYBIERANY ENCHANT &8- &3" + books));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("KilofEnchant", menu);
    }
    
    public static void openMiecz(final Player p, final int books) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(39, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Odrzut &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(48, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Odrzut &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(12).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(38, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Zaklety ogien &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(47, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Zaklety ogien &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(28, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(37, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(46, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Niezniszczalnosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 277 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 284 && p.getInventory().getItemInHand().getId() != 256 && p.getInventory().getItemInHand().getId() != 273 && p.getInventory().getItemInHand().getId() != 269 && p.getInventory().getItemInHand().getId() != 278 && p.getInventory().getItemInHand().getId() != 285 && p.getInventory().getItemInHand().getId() != 257 && p.getInventory().getItemInHand().getId() != 274 && p.getInventory().getItemInHand().getId() != 270 && p.getInventory().getItemInHand().getId() != 279 && p.getInventory().getItemInHand().getId() != 286 && p.getInventory().getItemInHand().getId() != 258 && p.getInventory().getItemInHand().getId() != 275 && p.getInventory().getItemInHand().getId() != 271 && p.getInventory().getItemInHand().getId() != 309 && p.getInventory().getItemInHand().getId() != 308 && p.getInventory().getItemInHand().getId() != 307 && p.getInventory().getItemInHand().getId() != 306) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        category.addElement(27, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ostrosc &eIII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &720 LvL", "&9Ilosc wymaganych biblioteczek: &715" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 15) {
                    if (p.getExperienceLevel() >= 20) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 20);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 20 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 15 biblioteczek!");
                }
            }
        });
        category.addElement(36, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ostrosc &eII")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &715 LvL", "&9Ilosc wymaganych biblioteczek: &710" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 10) {
                    if (p.getExperienceLevel() >= 15) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(2) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 15);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 15 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 10 biblioteczek!");
                }
            }
        });
        category.addElement(45, ItemData.fromItem(new Item(403, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Ostrosc &eI")).setLore(ChatUtil.fixColor(new String[] { "&9Koszt: &710 LvL", "&9Ilosc wymaganych biblioteczek: &75" }))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (p.getInventory().getItemInHand().getId() == 322 || p.getInventory().getItemInHand().getId() == 466 || p.getInventory().getItemInHand().getId() == 122 || p.getInventory().getItemInHand().getId() == 368) {
                    return;
                }
                if (p.getInventory().getItemInHand().getId() != 276 && p.getInventory().getItemInHand().getId() != 267 && p.getInventory().getItemInHand().getId() != 283 && p.getInventory().getItemInHand().getId() != 272 && p.getInventory().getItemInHand().getId() != 268) {
                    return;
                }
                if (books >= 5) {
                    if (p.getExperienceLevel() >= 10) {
                        final Item i = p.getInventory().getItemInHand();
                        p.getInventory().removeItem(new Item[] { i });
                        i.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(1) });
                        p.getInventory().addItem(new Item[] { i });
                        p.setExperience(0, p.getExperienceLevel() - 10);
                    }
                    else {
                        ChatUtil.sendMessage((CommandSender)p, "&cPotrzebujesz 10 level na pasku!");
                    }
                }
                else {
                    ChatUtil.sendMessage((CommandSender)p, "&cTen enchant wymaga 5 biblioteczek!");
                }
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("MieczEnchant", category);
        menu.setName(ChatUtil.fixColor("&9WYBIERANY ENCHANT &8- &3" + books));
        menu.setOnlyRead(true);
        menu.show(p);
        InventoryMenuHandler.registerNewMenu("MieczEnchant", menu);
    }
}
