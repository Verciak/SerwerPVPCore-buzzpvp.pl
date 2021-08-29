// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers;

import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import java.util.concurrent.ConcurrentHashMap;

public class CombatManager {
    public static Combat getCombat(Player p) {
        return combats.get(p);
    }

    public static void createCombat(Player p) {
        Combat combat = new Combat(p);
        combats.put(p, combat);
    }

    public static void removeCombat(Player p) {
        combats.remove(p);
    }

    public static ConcurrentHashMap<Player, Combat> getCombats() {
        return combats;
    }

    private static final ConcurrentHashMap<Player, Combat> combats = new ConcurrentHashMap<>();
}
