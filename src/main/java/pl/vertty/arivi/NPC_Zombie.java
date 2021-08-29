// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.AddPlayerPacket;
import cn.nukkit.Player;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.entity.EntityHuman;

public class NPC_Zombie extends EntityHuman
{
    public NPC_Zombie(final FullChunk chunk, final CompoundTag nbt) {
        super(chunk, nbt);
        this.setScale(this.namedTag.getFloat("scale"));
        if (this.namedTag.contains("ScoreTag")) {
            this.setScoreTag(this.namedTag.getString("ScoreTag"));
        }
    }
    
    public void spawnTo(final Player player) {
        if (!this.hasSpawned.containsKey(player.getLoaderId())) {
            this.hasSpawned.put(player.getLoaderId(), player);
            final AddPlayerPacket pk = new AddPlayerPacket();
            pk.uuid = this.getUniqueId();
            pk.username = this.getName();
            pk.entityUniqueId = this.getId();
            pk.entityRuntimeId = this.getId();
            pk.x = (float)this.x;
            pk.y = (float)this.y;
            pk.z = (float)this.z;
            pk.speedX = (float)this.motionX;
            pk.speedY = (float)this.motionY;
            pk.speedZ = (float)this.motionZ;
            pk.yaw = (float)this.yaw;
            pk.pitch = (float)this.pitch;
            pk.item = this.getInventory().getItemInHand();
            pk.metadata = this.dataProperties;
            player.dataPacket((DataPacket)pk);
            this.server.removePlayerListData(this.getUniqueId(), new Player[] { player });
            super.spawnTo(player);
        }
    }
}
