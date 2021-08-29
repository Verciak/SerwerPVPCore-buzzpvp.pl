// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import cn.nukkit.level.Location;
import java.util.Iterator;
import pl.vertty.arivi.objects.Warp;
import java.util.concurrent.ConcurrentHashMap;

public class WarpManager
{
    public static ConcurrentHashMap<String, Warp> warps;
    
    public static Warp getWarp(final String name) {
        for (final Warp w : WarpManager.warps.values()) {
            if (name.equalsIgnoreCase(w.getName())) {
                return w;
            }
        }
        return null;
    }
    
    public static void addWarp(final String name, final Location location) {
        WarpManager.warps.put(name, new Warp(name, location));
    }
    
    public static void deleteWarp(final String name) {
        WarpManager.warps.remove(name);
        Main.getStore().update("DELETE FROM `{P}warp` WHERE `name` ='" + name + "';");
    }
    
    public static List<String> getWarpByGroup(final Player p) {
        final List<String> warp = new ArrayList<String>();
        for (final Warp w : WarpManager.warps.values()) {
            warp.add(w.getName());
        }
        return warp;
    }
    
    public static void loadWarp() {
        try {
            final ResultSet rs = Main.getStore().query("SELECT * FROM `{P}warp`");
            while (rs.next()) {
                final Warp w = new Warp(rs);
                WarpManager.warps.put(w.getName(), w);
            }
            rs.close();
            System.out.println("Loaded " + WarpManager.warps.size() + " warps");
        }
        catch (SQLException e) {
            System.out.println("Can not load warps Error " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ConcurrentHashMap<String, Warp> getWarps() {
        return WarpManager.warps;
    }
    
    static {
        WarpManager.warps = new ConcurrentHashMap<String, Warp>();
    }
}
