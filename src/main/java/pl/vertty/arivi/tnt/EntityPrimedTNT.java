// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.tnt;

import cn.nukkit.level.Position;
import cn.nukkit.event.Event;
import cn.nukkit.event.entity.EntityExplosionPrimeEvent;
import cn.nukkit.entity.Entity;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.level.format.FullChunk;

public class EntityPrimedTNT extends cn.nukkit.entity.item.EntityPrimedTNT
{
    public EntityPrimedTNT(final FullChunk chunk, final CompoundTag nbt) {
        this(chunk, nbt, null);
    }
    
    public EntityPrimedTNT(final FullChunk chunk, final CompoundTag nbt, final Entity source) {
        super(chunk, nbt);
        this.source = source;
    }
    
    public void explode() {
        final EntityExplosionPrimeEvent event = new EntityExplosionPrimeEvent((Entity)this, 4.0);
        this.server.getPluginManager().callEvent((Event)event);
        if (!event.isCancelled()) {
            final Explosion explosion = new Explosion((Position)this, event.getForce(), (Entity)this);
            if (event.isBlockBreaking()) {
                explosion.explodeA();
            }
            explosion.explodeB();
        }
    }
}
