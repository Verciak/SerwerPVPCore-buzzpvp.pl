
package pl.vertty.arivi.task;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.NukkitRunnable;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.utils.SpaceUtil;

public class BoyFarmerTask extends NukkitRunnable {

    private Guild guild;
    private int blocks;
    private int actualY;


    public BoyFarmerTask(Guild guild, int blocks) {
        this.guild = guild;
        this.blocks = blocks;
        this.actualY = 2;
    }

    public void run() {

        if (actualY > 70) {
            this.cancel();
            return;
        }


        Block block = Block.get(BlockID.OBSIDIAN);
        for(int sizee = 0; sizee < (blocks * 2); sizee++) {
            for (Location loc : SpaceUtil.getVector(guild.getRegion().getCenter(), blocks, sizee)) {
                Location xd = new Location(loc.getFloorX(), actualY, loc.getFloorZ(), Server.getInstance().getDefaultLevel());
                Server.getInstance().getDefaultLevel().setBlock(xd, block);
            }
        }

        actualY++;
    }

}
