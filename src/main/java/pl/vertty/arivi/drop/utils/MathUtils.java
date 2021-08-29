// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.utils;

import java.util.Random;

public class MathUtils
{
    public static double round(final double value, final int decimals) {
        final double p = Math.pow(10.0, decimals);
        return Math.round(value * p) / p;
    }
    
    public static boolean chance(final double chance) {
        return chance >= 100.0 || chance >= new Random().nextDouble() * 100.0;
    }
    
    public static double calcTurbo(final double chance) {
        return round(chance * 3.0, 2);
    }
    
    public static double calcFortune(final double chance, final int fortune) {
        switch (fortune) {
            case 1: {
                return chance * 1.1;
            }
            case 2: {
                return chance * 1.3;
            }
            case 3: {
                return chance * 1.5;
            }
            default: {
                return chance;
            }
        }
    }
}
