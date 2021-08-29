// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi;

import java.util.HashMap;
import cn.nukkit.entity.data.EntityData;
import cn.nukkit.entity.data.FloatEntityData;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.level.format.FullChunk;
import java.util.Map;
import cn.nukkit.entity.Entity;

public abstract class NPC_Entity extends Entity
{
    static Map<Integer, Float> map;
    
    public NPC_Entity(final FullChunk chunk, final CompoundTag nbt) {
        super(chunk, nbt);
        this.setDataProperty((EntityData)new FloatEntityData(54, (float)NPC_Entity.map.getOrDefault(this.getNetworkId(), 1.0f)), true);
        this.setDataProperty((EntityData)new FloatEntityData(38, this.namedTag.getFloat("scale")));
    }
    
    static {
        (NPC_Entity.map = new HashMap<Integer, Float>()).put(10, 0.4f);
        NPC_Entity.map.put(11, 1.0f);
        NPC_Entity.map.put(12, 0.6f);
        NPC_Entity.map.put(13, 0.8f);
        NPC_Entity.map.put(14, 0.4f);
        NPC_Entity.map.put(15, 1.4f);
        NPC_Entity.map.put(16, 0.8f);
        NPC_Entity.map.put(17, 0.6f);
        NPC_Entity.map.put(18, 0.4f);
        NPC_Entity.map.put(19, 0.4f);
        NPC_Entity.map.put(20, 2.4f);
        NPC_Entity.map.put(21, 1.2f);
        NPC_Entity.map.put(22, 0.4f);
        NPC_Entity.map.put(23, 1.2f);
        NPC_Entity.map.put(24, 0.9f);
        NPC_Entity.map.put(25, 1.2f);
        NPC_Entity.map.put(26, 1.2f);
        NPC_Entity.map.put(27, 1.2f);
        NPC_Entity.map.put(114, 1.95f);
        NPC_Entity.map.put(118, 1.95f);
        NPC_Entity.map.put(32, 1.4f);
        NPC_Entity.map.put(33, 1.2f);
        NPC_Entity.map.put(34, 1.4f);
        NPC_Entity.map.put(35, 0.5f);
        NPC_Entity.map.put(36, 1.4f);
        NPC_Entity.map.put(37, 1.0f);
        NPC_Entity.map.put(38, 2.4f);
        NPC_Entity.map.put(39, 0.4f);
        NPC_Entity.map.put(40, 0.2f);
        NPC_Entity.map.put(41, 4.5f);
        NPC_Entity.map.put(42, 1.0f);
        NPC_Entity.map.put(43, 1.4f);
        NPC_Entity.map.put(44, 1.4f);
        NPC_Entity.map.put(45, 1.6f);
        NPC_Entity.map.put(46, 1.4f);
        NPC_Entity.map.put(47, 1.4f);
        NPC_Entity.map.put(48, 2.1f);
        NPC_Entity.map.put(65, 1.0f);
        NPC_Entity.map.put(66, 0.5f);
        NPC_Entity.map.put(84, 0.7f);
        NPC_Entity.map.put(90, 0.6f);
        NPC_Entity.map.put(104, 1.6f);
        NPC_Entity.map.put(57, 1.6f);
        NPC_Entity.map.put(105, 0.4f);
    }
}
