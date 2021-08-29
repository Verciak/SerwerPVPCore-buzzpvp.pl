// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi;

import cn.nukkit.Player;
import java.util.HashMap;

public class Cooldown
{
    public static HashMap<Player, Integer> cooldownMap;
    
    public static void setCooldown(final Player player, final int seconds) {
        Cooldown.cooldownMap.put(player, seconds);
    }
    
    public int getSecondsLeft(final Player player) {
        return Cooldown.cooldownMap.get(player);
    }
    
    public static boolean hasCooldown(final Player player) {
        return Cooldown.cooldownMap.containsKey(player);
    }
    
    static {
        Cooldown.cooldownMap = new HashMap<Player, Integer>();
    }
}
