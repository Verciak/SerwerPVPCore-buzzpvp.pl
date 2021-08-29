// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.level.Location;

public final class SpaceUtil
{
    public static List<Location> getSquare(final Location center, final int radius) {
        final List<Location> locs = new ArrayList<Location>();
        final int cX = center.getFloorX();
        final int cZ = center.getFloorZ();
        final int minX = Math.min(cX + radius, cX - radius);
        final int maxX = Math.max(cX + radius, cX - radius);
        final int minZ = Math.min(cZ + radius, cZ - radius);
        final int maxZ = Math.max(cZ + radius, cZ - radius);
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                locs.add(new Location((double)x, (double)center.getFloorY(), (double)z));
            }
        }
        locs.add(center);
        return locs;
    }
    
    public static List<Location> getCorners(final Location center, final int radius) {
        final List<Location> locs = new ArrayList<Location>();
        final int cX = center.getFloorX();
        final int cZ = center.getFloorZ();
        final int minX = Math.min(cX + radius, cX - radius);
        final int maxX = Math.max(cX + radius, cX - radius);
        final int minZ = Math.min(cZ + radius, cZ - radius);
        final int maxZ = Math.max(cZ + radius, cZ - radius);
        locs.add(new Location((double)minX, (double)center.getFloorY(), (double)minZ));
        locs.add(new Location((double)maxX, (double)center.getFloorY(), (double)minZ));
        locs.add(new Location((double)minX, (double)center.getFloorY(), (double)maxZ));
        locs.add(new Location((double)maxX, (double)center.getFloorY(), (double)maxZ));
        return locs;
    }
    
    public static List<Location> getWalls(final Location center, final int radius) {
        final List<Location> locs = getSquare(center, radius);
        locs.removeAll(getSquare(center, radius - 1));
        return locs;
    }
    
    public static List<Location> getSquare(final Location center, final int radius, final int height) {
        final List<Location> locs = getSquare(center, radius);
        for (int i = 1; i <= height; ++i) {
            locs.addAll(getSquare(new Location((double)center.getFloorX(), (double)(center.getFloorY() + i), (double)center.getFloorZ()), radius));
        }
        return locs;
    }
    
    public static List<Location> getCorners(final Location center, final int radius, final int height) {
        final List<Location> locs = getCorners(center, radius);
        for (int i = 1; i <= height; ++i) {
            locs.addAll(getCorners(new Location((double)center.getFloorX(), (double)(center.getFloorY() + i), (double)center.getFloorZ()), radius));
        }
        return locs;
    }
    
    public static List<Location> getWalls(final Location center, final int radius, final int height) {
        final List<Location> locs = getWalls(center, radius);
        for (int i = 1; i <= height; ++i) {
            locs.addAll(getWalls(new Location((double)center.getFloorX(), (double)(center.getFloorY() + i), (double)center.getFloorZ()), radius));
        }
        return locs;
    }
    
    public static List<Location> sphere(final Location loc, final int radius, final int height, final boolean hollow, final boolean sphere, final int plusY) {
        final List<Location> circleblocks = new ArrayList<Location>();
        final int cx = loc.getFloorX();
        final int cy = loc.getFloorY();
        final int cz = loc.getFloorZ();
        for (int x = cx - radius; x <= cx + radius; ++x) {
            for (int z = cz - radius; z <= cz + radius; ++z) {
                for (int y = sphere ? (cy - radius) : cy; y < (sphere ? (cy + radius) : (cy + height)); ++y) {
                    final double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? ((cy - y) * (cy - y)) : 0);
                    if (dist < radius * radius && (!hollow || dist >= (radius - 1) * (radius - 1))) {
                        final Location l = new Location((double)x, (double)(y + plusY), (double)z);
                        circleblocks.add(l);
                    }
                }
            }
        }
        return circleblocks;
    }
}
