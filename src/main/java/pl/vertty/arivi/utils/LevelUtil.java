// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import cn.nukkit.entity.Entity;
import cn.nukkit.Player;
import cn.nukkit.level.Location;

public class LevelUtil
{
    public static boolean isNonPvpArea(final Location loc) {
        final Location l2 = loc.getLocation().getLevel().getSpawnLocation().getLocation();
        final int distance = 60;
        final int distancex = Math.abs(loc.getFloorX() - l2.getFloorX());
        final int distancez = Math.abs(loc.getFloorZ() - l2.getFloorZ());
        return distancex <= 60 && distancez <= 60;
    }
    
    public static void knockLinePvP(final Player p) {
        final double x = p.getFloorX() - p.getLevel().getSafeSpawn().getFloorX();
        final double z = p.getFloorZ() - p.getLevel().getSafeSpawn().getFloorZ();
        p.knockBack((Entity)p, 0.0, x, z, 0.2);
    }
}
