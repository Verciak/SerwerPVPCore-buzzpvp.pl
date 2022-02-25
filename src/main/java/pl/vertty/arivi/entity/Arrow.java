package pl.vertty.arivi.entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class Arrow extends EntityArrow {
    public Arrow(FullChunk chunk, CompoundTag nbt) {
        this(chunk, nbt, null);
    }

    public Arrow(FullChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        this(chunk, nbt, shootingEntity, false);
    }

    public Arrow(FullChunk chunk, CompoundTag nbt, Entity shootingEntity, boolean critical) {
        super(chunk, nbt, shootingEntity);
    }

    public float getGravity() {
        return 0.02F;
    }

    public float getDrag() {
        return 0.006F;
    }
}
