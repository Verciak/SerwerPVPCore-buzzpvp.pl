// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.tnt;

import cn.nukkit.blockentity.BlockEntity;
import java.util.Iterator;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.level.particle.Particle;
import cn.nukkit.level.particle.HugeExplodeSeedParticle;
import cn.nukkit.event.block.BlockUpdateEvent;
import cn.nukkit.utils.Hash;
import cn.nukkit.math.BlockFace;
import cn.nukkit.item.Item;
import cn.nukkit.blockentity.BlockEntityShulkerBox;
import cn.nukkit.inventory.InventoryHolder;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.block.BlockTNT;
import cn.nukkit.item.ItemBlock;
import cn.nukkit.entity.item.EntityXPOrb;
import cn.nukkit.entity.item.EntityItem;
import cn.nukkit.event.entity.EntityDamageByBlockEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.math.SimpleAxisAlignedBB;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.event.Event;
import cn.nukkit.event.entity.EntityExplodeEvent;
import it.unimi.dsi.fastutil.longs.LongArraySet;
import java.util.concurrent.ThreadLocalRandom;
import cn.nukkit.math.Vector3;
import java.util.ArrayList;
import cn.nukkit.entity.Entity;
import cn.nukkit.block.Block;
import java.util.List;
import cn.nukkit.level.Position;
import cn.nukkit.level.Level;

public class Explosion
{
    private final int rays = 16;
    private final Level level;
    private final Position source;
    private final double size;
    private List<Block> affectedBlocks;
    private final double stepLen = 0.3;
    private final Object what;
    
    public Explosion(final Position center, final double size, final Entity what) {
        this.affectedBlocks = new ArrayList<Block>();
        this.level = center.getLevel();
        this.source = center;
        this.size = Math.max(size, 0.0);
        this.what = what;
    }
    
    @Deprecated
    public boolean explode() {
        return this.explodeA() && this.explodeB();
    }
    
    public boolean explodeA() {
        if (this.size < 0.1) {
            return false;
        }
        final Vector3 vector = new Vector3(0.0, 0.0, 0.0);
        final Vector3 vBlock = new Vector3(0.0, 0.0, 0.0);
        this.getClass();
        final int mRays = 15;
        int i = 0;
        while (true) {
            final int n = i;
            this.getClass();
            if (n >= 16) {
                break;
            }
            int j = 0;
            while (true) {
                final int n2 = j;
                this.getClass();
                if (n2 >= 16) {
                    break;
                }
                int k = 0;
                while (true) {
                    final int n3 = k;
                    this.getClass();
                    if (n3 >= 16) {
                        break;
                    }
                    if (i == 0 || i == 15 || j == 0 || j == 15 || k == 0 || k == 15) {
                        vector.setComponents(i / 15.0 * 2.0 - 1.0, j / 15.0 * 2.0 - 1.0, k / 15.0 * 2.0 - 1.0);
                        final double len = vector.length();
                        final Vector3 vector2 = vector;
                        final double n4 = vector.x / len;
                        this.getClass();
                        final double n5 = n4 * 0.3;
                        final double n6 = vector.y / len;
                        this.getClass();
                        final double n7 = n6 * 0.3;
                        final double n8 = vector.z / len;
                        this.getClass();
                        vector2.setComponents(n5, n7, n8 * 0.3);
                        double pointerX = this.source.x;
                        double pointerY = this.source.y;
                        double pointerZ = this.source.z;
                        double n11;
                        for (double blastForce = this.size * ThreadLocalRandom.current().nextInt(700, 1301) / 1000.0; blastForce > 0.0; blastForce = n11 - 0.22499999999999998) {
                            final int x = (int)pointerX;
                            final int y = (int)pointerY;
                            final int z = (int)pointerZ;
                            vBlock.x = ((pointerX >= x) ? x : ((double)(x - 1)));
                            vBlock.y = ((pointerY >= y) ? y : ((double)(y - 1)));
                            vBlock.z = ((pointerZ >= z) ? z : ((double)(z - 1)));
                            if (vBlock.y < 0.0) {
                                break;
                            }
                            if (vBlock.y > 255.0) {
                                break;
                            }
                            final Block block = this.level.getBlock(vBlock);
                            if (block.getId() != 0) {
                                final double n9 = blastForce;
                                final double n10 = block.getResistance() / 5.0 + 0.3;
                                this.getClass();
                                blastForce = n9 - n10 * 0.3;
                                if (blastForce > 0.0 && !this.affectedBlocks.contains(block)) {
                                    this.affectedBlocks.add(block);
                                }
                            }
                            pointerX += vector.x;
                            pointerY += vector.y;
                            pointerZ += vector.z;
                            n11 = blastForce;
                            this.getClass();
                        }
                    }
                    ++k;
                }
                ++j;
            }
            ++i;
        }
        return true;
    }
    
    public boolean explodeB() {
        final LongArraySet updateBlocks = new LongArraySet();
        final List<Vector3> send = new ArrayList<Vector3>();
        final Vector3 source = new Vector3(this.source.x, this.source.y, this.source.z).floor();
        double yield = 1.0 / this.size * 100.0;
        if (this.what instanceof Entity) {
            final EntityExplodeEvent ev = new EntityExplodeEvent((Entity)this.what, this.source, (List)this.affectedBlocks, yield);
            this.level.getServer().getPluginManager().callEvent((Event)ev);
            if (ev.isCancelled()) {
                return false;
            }
            yield = ev.getYield();
            this.affectedBlocks = (List<Block>)ev.getBlockList();
        }
        final double explosionSize = this.size * 2.0;
        final double minX = NukkitMath.floorDouble(this.source.x - explosionSize - 1.0);
        final double maxX = NukkitMath.ceilDouble(this.source.x + explosionSize + 1.0);
        final double minY = NukkitMath.floorDouble(this.source.y - explosionSize - 1.0);
        final double maxY = NukkitMath.ceilDouble(this.source.y + explosionSize + 1.0);
        final double minZ = NukkitMath.floorDouble(this.source.z - explosionSize - 1.0);
        final double maxZ = NukkitMath.ceilDouble(this.source.z + explosionSize + 1.0);
        final AxisAlignedBB explosionBB = (AxisAlignedBB)new SimpleAxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
        final Entity[] list;
        final Entity[] nearbyEntities;
        final Entity[] array3;
        final Entity[] array4;
        final Entity[] array2 = array4 = (array3 = (nearbyEntities = (list = this.level.getNearbyEntities(explosionBB, (this.what instanceof Entity) ? ((Entity)this.what) : null))));
        for (final Entity entity : array4) {
            final double distance = entity.distance((Vector3)this.source) / explosionSize;
            if (distance <= 1.0) {
                final Vector3 motion = entity.subtract((Vector3)this.source).normalize();
                final int exposure = 1;
                final double impact = (1.0 - distance) * 1.0;
                final int damage = (int)((impact * impact + impact) / 2.0 * 8.0 * explosionSize + 1.0);
                if (this.what instanceof Entity) {
                    entity.attack((EntityDamageEvent)new EntityDamageByEntityEvent((Entity)this.what, entity, EntityDamageEvent.DamageCause.ENTITY_EXPLOSION, (float)damage));
                }
                else if (this.what instanceof Block) {
                    entity.attack((EntityDamageEvent)new EntityDamageByBlockEvent((Block)this.what, entity, EntityDamageEvent.DamageCause.BLOCK_EXPLOSION, (float)damage));
                }
                else {
                    entity.attack(new EntityDamageEvent(entity, EntityDamageEvent.DamageCause.BLOCK_EXPLOSION, (float)damage));
                }
                if (!(entity instanceof EntityItem) && !(entity instanceof EntityXPOrb)) {
                    entity.setMotion(motion.multiply(impact * 5.0));
                }
            }
        }
        final ItemBlock air = new ItemBlock(Block.get(0));
        for (final Block block : this.affectedBlocks) {
            if (block.getId() == 46) {
                ((BlockTNT)block).prime(new NukkitRandom().nextRange(10, 30), (this.what instanceof Entity) ? ((Entity)this.what) : null);
            }
            else {
                final BlockEntity container;
                if ((container = block.getLevel().getBlockEntity((Vector3)block)) instanceof InventoryHolder) {
                    if (container instanceof BlockEntityShulkerBox) {
                        this.level.dropItem((Vector3)block.add(0.5, 0.5, 0.5), block.toItem());
                        ((InventoryHolder)container).getInventory().clearAll();
                    }
                    else {
                        for (final Item drop : ((InventoryHolder)container).getInventory().getContents().values()) {
                            this.level.dropItem((Vector3)block.add(0.5, 0.5, 0.5), drop);
                        }
                        ((InventoryHolder)container).getInventory().clearAll();
                    }
                }
                else if (Math.random() * 100.0 < yield) {
                    for (final Item drop2 : block.getDrops((Item)air)) {
                        this.level.dropItem((Vector3)block.add(0.5, 0.5, 0.5), drop2);
                    }
                }
            }
            this.level.setBlockAt((int)block.x, (int)block.y, (int)block.z, 0);
            final Vector3 pos = new Vector3(block.x, block.y, block.z);
            for (final BlockFace side : BlockFace.values()) {
                final Vector3 sideBlock = pos.getSide(side);
                final long index = Hash.hashBlock((int)sideBlock.x, (int)sideBlock.y, (int)sideBlock.z);
                if (!this.affectedBlocks.contains(sideBlock) && !updateBlocks.contains(index)) {
                    final BlockUpdateEvent ev2 = new BlockUpdateEvent(this.level.getBlock(sideBlock));
                    this.level.getServer().getPluginManager().callEvent((Event)ev2);
                    if (!ev2.isCancelled()) {
                        ev2.getBlock().onUpdate(1);
                    }
                    updateBlocks.add(index);
                }
            }
            send.add(new Vector3(block.x - source.x, block.y - source.y, block.z - source.z));
        }
        this.level.addParticle((Particle)new HugeExplodeSeedParticle((Vector3)this.source));
        this.level.addLevelSoundEvent(source, 48);
        return true;
    }
}
