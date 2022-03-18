package pl.vertty.arivi.entity;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityEnderPearl;
import cn.nukkit.entity.projectile.EntityProjectile;
import cn.nukkit.entity.projectile.EntitySnowball;
import cn.nukkit.event.entity.*;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.level.MovingObjectPosition;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Iterator;

public class EnderPearl extends EntityProjectile {



    @Override
    public float getScale() {
        return 0.5F;
    }

    public int getNetworkId() {
        return 87;
    }

    public float getWidth() {
        return 0.25F;
    }

    public float getLength() {
        return 0.25F;
    }

    public float getHeight() {
        return 0.25F;
    }

    protected float getGravity() {
        return 0.02F;
    }

    @Override
    public void setScale(float scale) {
        super.setScale(0.5F);
    }

    protected float getDrag() {
        return 0.006F;
    }

    public EnderPearl(FullChunk chunk, CompoundTag nbt) {
        this(chunk, nbt, (Entity)null);
        setScale(0.5F);
        setPosition((Vector3)getPosition().add(0.0D, 0.23D, 0.0D));
    }

    public EnderPearl(FullChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        super(chunk, nbt, shootingEntity);
        setScale(0.5F);
        setPosition((Vector3)getPosition().add(0.0D, 0.23D, 0.0D));
    }

    public boolean onUpdate(int currentTick) {
        if (this.closed) {
            return false;
        } else {
            this.timing.startTiming();
            boolean hasUpdate = super.onUpdate(currentTick);
            if (this.isCollided && this.shootingEntity instanceof Player) {
                boolean portal = false;
                Iterator var4 = this.getCollisionBlocks().iterator();

                while(var4.hasNext()) {
                    Block collided = (Block)var4.next();
                    if (collided.getId() == 90) {
                        portal = true;
                    }
                }

                if (!portal) {
                    this.teleport();
                }
            }

            if (this.age > 1200 || this.isCollided) {
                this.kill();
                hasUpdate = true;
            }

            this.timing.stopTiming();
            return hasUpdate;
        }
    }

    public void onCollideWithEntity(Entity entity) {
        if (this.shootingEntity instanceof Player) {
            this.teleport();
        }
        this.server.getPluginManager().callEvent(new ProjectileHitEvent(this, MovingObjectPosition.fromEntity(entity)));
        float damage = 0F;
        Object ev;
        if (this.shootingEntity == null) {
            ev = new EntityDamageByEntityEvent(this, entity, EntityDamageEvent.DamageCause.PROJECTILE, damage);
        } else {
            ev = new EntityDamageByChildEntityEvent(this.shootingEntity, this, entity, EntityDamageEvent.DamageCause.PROJECTILE, damage);
        }

        if (entity.attack((EntityDamageEvent)ev)) {
            this.hadCollision = true;
            if (this.fireTicks > 0) {
                EntityCombustByEntityEvent event = new EntityCombustByEntityEvent(this, entity, 5);
                this.server.getPluginManager().callEvent(event);
                if (!event.isCancelled()) {
                    entity.setOnFire(event.getDuration());
                }
            }
        }

        if (this.closeOnCollide) {
            this.close();
        }
    }

    private void teleport() {
        if (this.level.equals(this.shootingEntity.getLevel())) {
            this.level.addLevelEvent(this.shootingEntity.add(0.5D, 0.5D, 0.5D), 1032);
            this.shootingEntity.teleport(new Vector3((double) NukkitMath.floorDouble(this.x) + 0.5D, this.y, (double)NukkitMath.floorDouble(this.z) + 0.5D), PlayerTeleportEvent.TeleportCause.ENDER_PEARL);

            this.level.addLevelEvent(this, 2013);
            this.level.addLevelEvent(this.shootingEntity.add(0.5D, 0.5D, 0.5D), 1032);
        }
    }
}
