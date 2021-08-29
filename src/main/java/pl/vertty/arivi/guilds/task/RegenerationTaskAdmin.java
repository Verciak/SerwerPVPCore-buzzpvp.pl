// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.task;

import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.block.Block;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.guilds.data.block.BlockRegeneration;
import java.util.List;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.scheduler.NukkitRunnable;

public class RegenerationTaskAdmin extends NukkitRunnable
{
    private Guild g;
    private List<BlockRegeneration> blocks;
    
    public RegenerationTaskAdmin(final Guild g, final List<BlockRegeneration> blocks) {
        this.g = g;
        this.blocks = blocks;
    }
    
    public void run() {
        if (this.blocks.size() > 0) {
            final BlockRegeneration blockRegeneration = this.blocks.get(0);
            if (blockRegeneration != null) {
                final Location location = blockRegeneration.getLocation();
                location.getLevel().setBlock(new Vector3((double)location.getFloorX(), (double)location.getFloorY(), (double)location.getFloorZ()), Block.get(blockRegeneration.getIdBlock()));
            }
            this.blocks.remove(blockRegeneration);
            if (this.blocks.isEmpty()) {
                this.g.title(ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE), ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE4));
                this.g.setRegeneration(false);
                this.cancel();
            }
        }
    }
}
