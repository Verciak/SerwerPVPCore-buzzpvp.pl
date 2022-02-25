
package pl.vertty.arivi.objects.block;

import cn.nukkit.level.Location;

public class BlockRegeneration
{
    private final Location location;
    private final int idBlock;
    
    public BlockRegeneration(final int idBlock, final Location location) {
        this.idBlock = idBlock;
        this.location = location;
    }
    
    public int getIdBlock() {
        return this.idBlock;
    }
    
    public Location getLocation() {
        return this.location;
    }
}
