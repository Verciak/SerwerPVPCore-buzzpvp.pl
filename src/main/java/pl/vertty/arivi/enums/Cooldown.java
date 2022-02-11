package pl.vertty.arivi.enums;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public final class Cooldown<T>
{
    private final Map<T, Long> cooldowns;
    
    public Cooldown() {
        this.cooldowns = new WeakHashMap<>(32);
    }
    
    public boolean isOnCooldown(final T key) {
        final Long cooldown = this.cooldowns.get(key);
        if (cooldown == null) {
            return false;
        }
        if (cooldown > System.currentTimeMillis()) {
            return true;
        }
        this.cooldowns.remove(key);
        return false;
    }
    
    public void putOnCooldown(final T key, final TimeUnit unit, final long duration) {
        this.cooldowns.put(key, System.currentTimeMillis() + unit.toMillis(duration));
    }
    
    public void putOnCooldown(final T key, final long cooldown) {
        this.cooldowns.put(key, System.currentTimeMillis() + cooldown);
    }
    
    public boolean cooldown(final T key, final TimeUnit unit, final long duration) {
        return this.cooldown(key, unit.toMillis(duration));
    }
    
    public boolean cooldown(final T key, final long cooldown) {
        if (this.isOnCooldown(key)) {
            return true;
        }
        this.putOnCooldown(key, cooldown);
        return false;
    }
}
