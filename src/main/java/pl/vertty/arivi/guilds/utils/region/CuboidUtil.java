// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils.region;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public final class CuboidUtil
{
    public static boolean cancelAction(final Player player, final Location location, final String s, final int n, final String s2) {
        if (player.isOp() && location.getLevel().getBlock(new Vector3((double)location.getFloorX(), (double)location.getFloorY(), (double)location.getFloorZ())) != Block.get(19)) {
            return false;
        }
        final Guild guildByLoc = GuildManager.getGuildByLoc(location);
        if (guildByLoc == null) {
            return false;
        }
        if (!guildByLoc.isMember(player.getName())) {
            ChatUtil.sendMessage((CommandSender)player, s);
            return true;
        }
        if (n == 19) {
            return false;
        }
        if (n == 165) {
            player.setMotion(new Vector3(0.0, 3.0, 0.0));
            return false;
        }
        return false;
    }
    
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
