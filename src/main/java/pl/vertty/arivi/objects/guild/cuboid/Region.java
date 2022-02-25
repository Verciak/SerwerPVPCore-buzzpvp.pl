
package pl.vertty.arivi.objects.guild.cuboid;

import cn.nukkit.level.Location;
import pl.vertty.arivi.objects.guild.Guild;

public class Region
{
    private int z;
    private int x;
    private int size;
    private Guild guild;
    
    public void setSize(final int size) {
        this.size = size;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public boolean isInCuboid(final Location location) {
        final int abs = Math.abs(location.getFloorX() - this.x);
        final int abs2 = Math.abs(location.getFloorZ() - this.z);
        return abs <= this.getSize() && abs2 <= this.getSize();
    }
    
    public Location getCenter() {
        return new Location(this.x, 41.0, this.z);
    }
    
    public boolean isInCentrumFarmer(final Location location, final int n, final int n2, final int n3) {
        final Location clone = this.getLocationFarmer(location.getY()).clone();
        return clone.getFloorY() - n2 <= location.getFloorY() && clone.getFloorY() + n >= location.getFloorY() && location.getFloorX() <= clone.getFloorX() + n3 && location.getFloorX() >= clone.getFloorX() - n3 && location.getFloorZ() <= clone.getFloorZ() + n3 && location.getFloorZ() >= clone.getFloorZ() - n3;
    }
    
    public boolean isInCentrum(final Location location, final int n, final int n2, final int n3) {
        final Location clone = this.getLocation().clone();
        return clone.getFloorY() - n2 <= location.getFloorY() && clone.getFloorY() + n >= location.getFloorY() && location.getFloorX() <= clone.getFloorX() + n3 && location.getFloorX() >= clone.getFloorX() - n3 && location.getFloorZ() <= clone.getFloorZ() + n3 && location.getFloorZ() >= clone.getFloorZ() - n3;
    }

    public Location getLocationFarmer(final double n) {
        return new Location(this.getX(), n, this.getZ());
    }
    
    public int getZ() {
        return this.z;
    }
    
    public boolean isInCuboidByLoc(final Location location) {
        final int abs = Math.abs(location.getFloorX() - this.getX());
        final int abs2 = Math.abs(location.getFloorZ() - this.getZ());
        return abs - 1 <= this.getSize() && abs2 - 1 <= this.getSize();
    }
    
    public Region(final int x, final int z, final int size, final Guild guild) {
        this.x = x;
        this.z = z;
        this.size = size;
        this.guild = guild;
    }
    
    public Location getLocation() {
        return new Location(this.getX(), 40.0, this.getZ());
    }
    
    public void setZ(final int z) {
        this.z = z;
    }
    
    public void addSize(final int n) {
        this.size += n;
    }
    
    public int getX() {
        return this.x;
    }
}
