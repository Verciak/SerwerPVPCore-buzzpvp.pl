// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers.guild;

import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.level.Level;
import cn.nukkit.block.Block;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.guilds.utils.region.CuboidUtil;
import cn.nukkit.Server;
import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.rank.RankingManager;
import java.util.Iterator;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.data.guild.Guild;
import java.util.concurrent.ConcurrentHashMap;

public class GuildManager
{
    private static ConcurrentHashMap<String, Guild> guilds;
    
    public static boolean canCreateGuildByGuild(final Location location) {
        final int n = Config.CUBOID_SIZE_MAX * 2 + Config.CUBOID_SIZE_BETWEEN;
        for (final Guild guild : GuildManager.guilds.values()) {
            if (Math.abs(guild.getRegion().getX() - location.getFloorX()) <= n && Math.abs(guild.getRegion().getZ() - location.getFloorZ()) <= n) {
                return false;
            }
        }
        return true;
    }
    
    public static void deleteGuild(final Guild guild) {
        RankingManager.removeRanking(guild);
        GuildManager.guilds.remove(guild.getTag());
        lambdadeleteGuild1(guild);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_guilds` WHERE `tag` = '").append(guild.getTag()).append("'")));
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_members` WHERE `tag` = '").append(guild.getTag()).append("'")));
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_wars` WHERE `tag` = '").append(guild.getTag()).append("'")));
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_logblock` WHERE `tag` = '").append(guild.getTag()).append("'")));
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_lock` WHERE `tag` = '").append(guild.getTag()).append("'")));
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_roles` WHERE `tag` = '").append(guild.getTag()).append("'")));
        final Iterator<String> iterator = guild.getAlly().iterator();
        while (iterator.hasNext()) {
            final Guild guild2 = getGuild(iterator.next());
            if (guild2 != null) {
                guild2.removeAlly(guild.getTag());
            }
        }
    }
    
    public static Guild getGuild(final Player player) {
        for (final Guild guild : GuildManager.guilds.values()) {
            if (guild.isMember(player)) {
                return guild;
            }
        }
        return null;
    }
    
    private static String checkLife(final Guild guild) {
        if (guild.getLife() == 3) {
            return "&4\u2764\u2764\u2764";
        }
        if (guild.getLife() == 2) {
            return "&4\u2764\u2764&8\u2764";
        }
        if (guild.getLife() == 1) {
            return "&4\u2764&8\u2764\u2764";
        }
        return "&8\u2764\u2764\u2764";
    }
    
    public static Guild createGuild(final String key, final String s, final Player player, final Location location) {
        final Guild value = new Guild(key, s, player, location);
        GuildManager.guilds.put(key, value);
        player.teleport(new Location((double)value.getRegion().getX(), 43.0, (double)value.getRegion().getZ()));
        RankingManager.addRanking(value);
        createRoomGuild(value);
        return value;
    }
    
    public static Guild getGuildByLoc(final Location location) {
        for (final Guild guild : GuildManager.guilds.values()) {
            if (guild.getRegion().isInCuboidByLoc(location)) {
                return guild;
            }
        }
        return null;
    }
    
    public static boolean canCreateGuildBySpawn(final Location location) {
        final int blockX = location.getLevel().getSpawnLocation().getFloorX();
        final int blockZ = location.getLevel().getSpawnLocation().getFloorZ();
        return Math.abs(location.getFloorX() - blockX) >= 150 || Math.abs(location.getFloorZ() - blockZ) >= 150;
    }
    
    private static void createRoomGuild(final Guild guild) {
        final Location c = guild.getRegion().getCenter();
        final Level l = Server.getInstance().getDefaultLevel();
        for (final Location loc : CuboidUtil.getSquare(c, 4, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(0));
        }
        for (final Location loc : CuboidUtil.getSquare(c, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(49));
        }
        for (final Location loc : CuboidUtil.getCorners(c, 4, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(49));
        }
        for (final Location loc : CuboidUtil.getWalls(new Location((double)c.getFloorX(), (double)(c.getFloorY() + 5), (double)c.getFloorZ()), 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(49));
        }
        l.setBlock(new Vector3((double)c.getFloorX(), (double)c.getFloorY(), (double)c.getFloorZ()), Block.get(7));
        l.setBlock(new Vector3((double)c.getFloorX(), (double)(c.getFloorY() + 1), (double)c.getFloorZ()), Block.get(19));
    }
    
    public static int addPoints(final Player player, final Player player2) {
        final Guild guild = getGuild(player);
        if (guild == null) {
            return 0;
        }
        final Guild guild2 = getGuild(player2);
        if (guild2 == null) {
            return 10;
        }
        if (guild.isMember(player2)) {
            return 0;
        }
        if (guild.getAlly().contains(guild2.getTag())) {
            return -20;
        }
        return 50;
    }
    
    public static ConcurrentHashMap<String, Guild> getGuilds() {
        return GuildManager.guilds;
    }
    
    private static void deleteRoom(final Guild guild) {
        final Location c = guild.getRegion().getCenter();
        final Level l = Server.getInstance().getDefaultLevel();
        for (final Location loc : CuboidUtil.getSquare(c, 4, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(0));
        }
        for (final Location loc : CuboidUtil.getSquare(c, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(0));
        }
        for (final Location loc : CuboidUtil.getCorners(c, 4, 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(0));
        }
        for (final Location loc : CuboidUtil.getWalls(new Location((double)c.getFloorX(), (double)(c.getFloorY() + 5), (double)c.getFloorZ()), 4)) {
            l.setBlock(new Vector3(loc.getX(), loc.getY(), loc.getZ()), Block.get(0));
        }
        l.setBlock(new Vector3((double)c.getFloorX(), (double)c.getFloorY(), (double)c.getFloorZ()), Block.get(0));
        l.setBlock(new Vector3((double)c.getFloorX(), (double)(c.getFloorY() + 1), (double)c.getFloorZ()), Block.get(0));
    }
    
    public static List<Guild> getKaraGuilds() {
        final ArrayList<Guild> list = new ArrayList<Guild>();
        for (final Guild guild : GuildManager.guilds.values()) {
            if (guild.getTntKaraTime() > System.currentTimeMillis()) {
                list.add(guild);
            }
        }
        return list;
    }
    
    public static void lambdadeleteGuild1(final Guild guild) {
        deleteRoom(guild);
    }
    
    public static int removePoints(final Player player, final Player player2) {
        final Guild guild = getGuild(player);
        if (guild == null) {
            return 0;
        }
        final Guild guild2 = getGuild(player2);
        if (guild2 == null) {
            return 50;
        }
        if (guild.isMember(player2)) {
            return 20;
        }
        if (guild.getAlly().contains(guild2.getTag())) {
            return 20;
        }
        return 50;
    }
    
    public static Guild getGuild(final String s) {
        for (final Guild guild : GuildManager.guilds.values()) {
            if (guild.getName().equalsIgnoreCase(s) || guild.getTag().equalsIgnoreCase(s)) {
                return guild;
            }
        }
        return null;
    }
    
    public static Guild getGuild(final Location location) {
        for (final Guild guild : GuildManager.guilds.values()) {
            if (guild.getRegion().isInCuboid(location)) {
                return guild;
            }
        }
        return null;
    }
    
    public static void loadGuilds() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_guilds`");
            while (query.next()) {
                final Guild value = new Guild(query);
                GuildManager.guilds.put(value.getTag(), value);
                RankingManager.addRanking(value);
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(GuildManager.guilds.size()).append(" guilds from pCGuilds_guilds")));
        }
        catch (SQLException ex) {
            Logger.warning("Nie mozna zaladowac tabeli pCGuilds_guilds");
            ex.printStackTrace();
        }
    }
    
    static {
        GuildManager.guilds = new ConcurrentHashMap<String, Guild>();
    }
}
