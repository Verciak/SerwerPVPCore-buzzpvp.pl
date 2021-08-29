// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.inventory;

import lombok.NonNull;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import java.util.HashMap;

public class InventoryCategory
{
    public InventoryMenu menu;
    public String[] inventoryGui;
    private HashMap<Integer, ItemData> itemData;
    private HashMap<Integer, ItemClick> itemClick;
    
    public InventoryCategory() {
        this.menu = null;
        this.itemData = new HashMap<Integer, ItemData>();
        this.itemClick = new HashMap<Integer, ItemClick>();
    }
    
    public HashMap<Integer, ItemData> itemDataMap() {
        return this.itemData;
    }
    
    public InventoryMenu getMenu() {
        return this.menu;
    }
    
    public void setStringElements(final String[] elements, final HashMap<Character, ItemData> itemDatas) {
        this.setStringElements(elements, itemDatas, null);
    }
    
    private int convertLineToSlot(final int line, final int rowSlot) {
        return 9 * line + rowSlot;
    }
    
    public void setStringElements(final String[] elements, final HashMap<Character, ItemData> itemDatas, final HashMap<Character, ItemClick> itemClicks) {
        if (elements.length == 3 || elements.length == 6) {
            this.inventoryGui = elements;
            for (int line = 0; line < elements.length; ++line) {
                final String row = elements[line];
                for (int rowSize = 0; rowSize < row.length(); ++rowSize) {
                    final char c = row.charAt(rowSize);
                    if (c != ' ' && !itemDatas.containsKey(c)) {
                        throw new RuntimeException("Element with symbol " + c + " not registered");
                    }
                    final int slot = this.convertLineToSlot(line, rowSize);
                    if (c != ' ') {
                        if (itemClicks != null) {
                            if (itemClicks.containsKey(c)) {
                                this.addElement(slot, itemDatas.get(c), itemClicks.get(c));
                            }
                            else {
                                this.addElement(slot, itemDatas.get(c));
                            }
                        }
                        else {
                            this.addElement(slot, itemDatas.get(c));
                        }
                    }
                }
            }
        }
    }
    
    public void addElement(final int position, @NonNull final ItemData item) {
        if (item == null) {
            throw new NullPointerException("item is marked non-null but is null");
        }
        this.addElement(position, item, null);
    }
    
    public void addElement(final int position, @NonNull final ItemData item, final ItemClick click) {
        if (item == null) {
            throw new NullPointerException("item is marked non-null but is null");
        }
        if (!this.itemData.containsKey(position)) {
            this.itemData.put(position, item);
            if (click != null) {
                this.itemClick.put(position, click);
            }
        }
    }
    
    public ItemData getItemData(final int position) {
        if (this.itemData.containsKey(position)) {
            return this.itemData.get(position);
        }
        return null;
    }
    
    public ItemClick getItemClick(final int position) {
        if (this.itemClick.containsKey(position)) {
            return this.itemClick.get(position);
        }
        return null;
    }
}
