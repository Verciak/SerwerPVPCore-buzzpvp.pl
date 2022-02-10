// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.entity;

import cn.nukkit.entity.EntityHuman;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class EntityHead extends EntityHuman
{
    public EntityHead(final FullChunk chunk, final CompoundTag nbt) {
        super(chunk, nbt);
    }
    
    public boolean isNameTagVisible() {
        return false;
    }
    
    public boolean isSneaking() {
        return false;
    }
    
    public boolean isOnFire() {
        return false;
    }
}
