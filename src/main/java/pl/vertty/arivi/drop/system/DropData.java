// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.system;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import pl.vertty.arivi.drop.base.User;

public interface DropData
{
    void breakBlock(final Player p0, final Item p1, final Block p2, final User p3);
}
