// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils;

import java.util.ArrayList;
import cn.nukkit.potion.Effect;
import java.util.List;

public class EffectType
{
    private static List<Effect> effects;
    
    public static void setEffects(final List<Effect> effects) {
        EffectType.effects = effects;
    }
    
    public static List<Effect> getEffects() {
        return EffectType.effects;
    }
    
    static {
        (EffectType.effects = new ArrayList<Effect>()).add(Effect.getEffect(10).setDuration(12000).setAmplifier(1));
        EffectType.effects.add(Effect.getEffect(3).setDuration(12000).setAmplifier(1));
        EffectType.effects.add(Effect.getEffect(12).setDuration(12000).setAmplifier(1));
        EffectType.effects.add(Effect.getEffect(22).setDuration(12000).setAmplifier(1));
        EffectType.effects.add(Effect.getEffect(8).setDuration(12000).setAmplifier(1));
    }
}
