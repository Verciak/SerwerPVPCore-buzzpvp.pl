// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.inventory.item;

import pl.vertty.arivi.utils.exception.SkinChangeException;
import cn.nukkit.item.Item;
import cn.nukkit.Player;

public abstract class ItemClick
{
    private Player player;
    private ItemData item;
    
    public ItemClick() {
        this.player = null;
        this.item = null;
    }
    
    public void init(final Player player, final ItemData item) {
        this.player = player;
        this.item = item;
    }
    
    public abstract void onClick(final Player p0, final Item p1) throws SkinChangeException;
}
