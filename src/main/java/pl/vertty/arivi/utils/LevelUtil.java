
package pl.vertty.arivi.utils;

import cn.nukkit.Player;
import cn.nukkit.level.Location;

public class LevelUtil {
    private static final int DISTANCE = 60;

    public static boolean isNonPvpArea(final Location loc) {
        final Location l2 = loc.getLocation().getLevel().getSpawnLocation().getLocation();
        final int distancex = Math.abs(loc.getFloorX() - l2.getFloorX());
        final int distancez = Math.abs(loc.getFloorZ() - l2.getFloorZ());
        return distancex <= DISTANCE && distancez <= DISTANCE;
    }

    public static void knockLinePvP(final Player p) {
        final double x = p.getFloorX() - p.getLevel().getSafeSpawn().getFloorX();
        final double z = p.getFloorZ() - p.getLevel().getSafeSpawn().getFloorZ();
        p.knockBack(p, 0.0, x, z, 0.2);
    }
}