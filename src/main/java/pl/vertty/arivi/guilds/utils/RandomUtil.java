// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils;

import java.util.Random;

public class RandomUtil
{
    private static final Random rand;
    
    public static int getRandInt(final int n, final int n2) throws IllegalArgumentException {
        return RandomUtil.rand.nextInt(n2 - n + 1) + n;
    }
    
    public static Double getRandDouble(final double n, final double n2) throws IllegalArgumentException {
        return RandomUtil.rand.nextDouble() * (n2 - n) + n;
    }
    
    public static boolean getChance(final double n) {
        return n >= 100.0 || n >= getRandDouble(0.0, 100.0);
    }
    
    static {
        rand = new Random();
    }
}
