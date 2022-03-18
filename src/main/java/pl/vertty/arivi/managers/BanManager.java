// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import cn.nukkit.Server;
import cn.nukkit.Player;
import java.util.Iterator;
import pl.vertty.arivi.objects.Ban;
import java.util.concurrent.ConcurrentHashMap;

public class BanManager
{
    private static ConcurrentHashMap<String, Ban> bans;
    
    public static Ban getBan(final String name) {
        for (final Ban ban : BanManager.bans.values()) {
            if (ban.getName().equalsIgnoreCase(name)) {
                return ban;
            }
        }
        return null;
    }
    
    public static Ban getBan(final Player player) {
        for (final Ban ban : BanManager.bans.values()) {
            if (ban.getName().equalsIgnoreCase(player.getName())) {
                return ban;
            }
        }
        return null;
    }
    
    public static void addBan(final String name, final Ban ban) {
        getBans().put(name, ban);
        final Player p = Server.getInstance().getPlayer(name);
        p.close(ChatUtil.fixColor(ban.getReason()));
    }
    
    public static void unban(final Ban ban) {
        getBans().remove(ban.getName());
        Main.getStore().update("DELETE FROM `{P}bans` WHERE `name` ='" + ban.getName() + "'");
    }
    
    public static void unbanAll() {
        for (final Ban ban : getBans().values()) {
            unban(ban);
        }
    }
    
    public static void loadBans() {
        try {
            final ResultSet rs = Main.getStore().query("SELECT * FROM `{P}bans`");
            while (rs.next()) {
                final Ban b = new Ban(rs);
                if (b.getTime() != 0L && b.getTime() < System.currentTimeMillis()) {
                    Main.getStore().update("DELETE FROM `{P}bans` WHERE `name` ='" + b.getName() + "'");
                }
                else {
                    BanManager.bans.put(b.getName(), b);
                }
            }
            rs.close();
            System.out.println("Loaded " + BanManager.bans.size() + " bans");
        }
        catch (SQLException e) {
            System.out.println("Can not load players Error " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ConcurrentHashMap<String, Ban> getBans() {
        return BanManager.bans;
    }
    
    static {
        BanManager.bans = new ConcurrentHashMap<String, Ban>();
    }
}
