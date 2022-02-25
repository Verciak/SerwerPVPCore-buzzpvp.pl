package pl.vertty.arivi.entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;

public class Snowball extends EntitySnowball {
    public Snowball(FullChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        super(chunk, nbt, shootingEntity);
        setScale(0.5F);
        setPosition((Vector3)getPosition().add(0.0D, 0.23D, 0.0D));
    }

    public float getGravity() {
        return 0.015F;
    }

    public float getDrag() {
        return 0.0045F;
    }
}
