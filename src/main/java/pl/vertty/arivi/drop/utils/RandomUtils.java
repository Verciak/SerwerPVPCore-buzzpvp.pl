package pl.vertty.arivi.drop.utils;

import java.util.Random;

public final class RandomUtils
{
    private static final Random rand;
    
    public static int getRandInt(final int min, final int max) throws IllegalArgumentException {
        return RandomUtils.rand.nextInt(max - min + 1) + min;
    }
    
    public static int nextInt(final int i) {
        return RandomUtils.rand.nextInt(i);
    }
    
    public static Double getRandDouble(final double min, final double max) throws IllegalArgumentException {
        return RandomUtils.rand.nextDouble() * (max - min) + min;
    }
    
    public static boolean getChance(final double chance) {
        return chance >= 100.0 || chance >= getRandDouble(0.0, 100.0);
    }
    
    static {
        rand = new Random();
    }
}
