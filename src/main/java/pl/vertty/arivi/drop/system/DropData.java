// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.system;

import pl.vertty.arivi.drop.base.User;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.Player;

public interface DropData
{
    void breakBlock(final Player p0, final Item p1, final Block p2, final User p3);
}
