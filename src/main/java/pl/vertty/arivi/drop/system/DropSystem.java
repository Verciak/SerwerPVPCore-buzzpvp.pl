// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.system;

import cn.nukkit.block.Block;

public class DropSystem
{
    private static final DropData dropcustom;
    
    public static DropData getDropData(final Block mat) {
        final DropData dropdata = new DropNormal();
        if (mat.getId() == 1) {
            return DropSystem.dropcustom;
        }
        return dropdata;
    }
    
    static {
        dropcustom = new DropCustom();
    }
}
