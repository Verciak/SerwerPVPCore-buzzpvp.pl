
package pl.vertty.arivi.inventory;

import lombok.NonNull;
import pl.vertty.arivi.MainConstants;
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

    public void setDoubleGuildRolesGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44,46,51,47,52};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setDoublePanelServerGUI() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7, 9,10,11, 15,16,17, 18,19,20,22, 24,25,26, 27,28,30, 32, 34,35, 36,37,38,39,41,42,43,44,46,47, 48, 50,51,52};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setDoubleGuildItemsGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44,46,49,51,47,52,48,50};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }


    public void setDoubleCXPandoraServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44,46,51,47,52,48,50};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setDoubleLeavesServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44,46,52,48,50};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setDoubleStoneServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44,48,50};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setSmallMainDropGUI() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7, 9, 17, 19,
                20, 21, 22, 23, 24, 25 };
        int[] blue = { 0, 8, 18, 26,10,16 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }


    public void setDoubleCraftingiServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,9,18,27,36,17,26,35,44, 47,51};
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setDoubleKitServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7,47,48,49,50,51 };
        int[] blue = { 0, 8, 45, 53 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }

    public void setSmallSchowekServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7, 9, 17, 19,
                20, 21, 23, 24, 25 };
        int[] blue = { 0, 8, 18, 26 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
    }


    public void setSmallServerGui() {
        int[] black = {
                1, 2, 3,4, 5, 6, 7, 9, 17, 19,
                20, 21,22, 23, 24, 25 };
        int[] blue = { 0, 8, 18, 26 };
        for (int b : black)
            addElement(b, ItemData.fromItem(MainConstants.BLACK_GLASS));
        for (int b : blue)
            addElement(b, ItemData.fromItem(MainConstants.BLUE_GLASS));
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

    public void addElementAir(@NonNull final ItemData item) {
        if (item == null) {
            throw new NullPointerException("item is marked non-null but is null");
        }
        this.addElementAir(item, null, 54);
    }

    public void addElementAir(@NonNull final ItemData item, final ItemClick click, int inventorySize) {
        if (item == null) {
            throw new NullPointerException("item is marked non-null but is null");
        }
        for(int i = 0; i < inventorySize; i++) {
            if (!this.itemData.containsKey(i)) {
                if (click != null) {
                    itemClick.put(i, click);
                }
                itemData.put(i, item);
                break;
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
