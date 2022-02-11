
package pl.vertty.arivi;

import cn.nukkit.Player;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

final public class Cooldown {

    private static final Cooldown instance = new Cooldown();

    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Long>> cooldowns = new ConcurrentHashMap<>();

    public static Cooldown getInstance() {
        return instance;
    }

    public void add(String username, String identifier, Float time) {

        ConcurrentHashMap<String, Long> map = cooldowns.get(username);
        if (map == null) {
            map = new ConcurrentHashMap<>();
        }

        time = time * 1000;
        map.put(identifier, System.currentTimeMillis() + time.longValue());
        cooldowns.put(username, map);
    }

    public void add(Player player, String name, Float time) {
        add(player.getName(), name, time);
    }

    public void remove(String username, String identifier) {

        ConcurrentHashMap<String, Long> map = cooldowns.get(username);
        if (map == null)
            return;

        map.remove(identifier);
        cooldowns.put(username, map);
    }

    public void remove(Player player, String identifier) {
        remove(player.getName(), identifier);
    }

    public boolean has(String username, String identifier) {

        ConcurrentHashMap<String, Long> map = cooldowns.get(username);
        if (map == null)
            return false;

        Long value = map.get(identifier);
        if (value == null)
            return false;

        return value > System.currentTimeMillis();
    }

    public boolean has(Player player, String identifier) {
        return has(player.getName(), identifier);
    }

    public Long get(String username, String identifier) {

        ConcurrentHashMap<String, Long> map = cooldowns.get(username);
        if (map == null)
            return 0L;

        Long value = map.get(identifier);
        if (value == null)
            return 0L;

        return value;
    }

    public Long get(Player player, String identifier) {
        return get(player.getName(), identifier);
    }

}
