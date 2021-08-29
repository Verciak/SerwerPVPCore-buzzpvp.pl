// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import pl.vertty.arivi.utils.ChatUtil;
import java.util.Iterator;
import cn.nukkit.Server;
import cn.nukkit.Player;
import java.util.ArrayList;

public class VanishManager implements Runnable
{
    static ArrayList<Player> vanish;
    
    public static void hidePlayersOnJoin(final Player p) {
        if (VanishManager.vanish.size() != 0) {
            for (final Player all : Server.getInstance().getOnlinePlayers().values()) {
                for (final Player vanishAll : VanishManager.vanish) {
                    all.hidePlayer(vanishAll);
                }
            }
        }
    }
    
    public static boolean ifContains(final Player p) {
        return VanishManager.vanish.contains(p);
    }
    
    public static void addToVanish(final Player p) {
        for (final Player all : Server.getInstance().getOnlinePlayers().values()) {
            all.hidePlayer(p);
        }
        VanishManager.vanish.add(p);
    }
    
    public static void removeFromVanish(final Player p) {
        for (final Player all : Server.getInstance().getOnlinePlayers().values()) {
            all.showPlayer(p);
        }
        VanishManager.vanish.remove(p);
    }
    
    @Override
    public void run() {
        Server.getInstance().getOnlinePlayers().values().stream().filter(p -> ifContains(p)).forEach(p -> ChatUtil.sendActionBar(p, "&aJestes na Vanishu!"));
    }
    
    static {
        VanishManager.vanish = new ArrayList<Player>();
    }
}
