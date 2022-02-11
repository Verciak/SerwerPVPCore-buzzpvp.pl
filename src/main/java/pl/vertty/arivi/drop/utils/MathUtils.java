package pl.vertty.arivi.drop.utils;

public class MathUtils
{
    public static double round(final double value, final int decimals) {
        final double p = Math.pow(10.0, decimals);
        return Math.round(value * p) / p;
    }
    
    public static double calcTurbo(final double chance) {
        return round(chance * 3.0, 2);
    }
}
