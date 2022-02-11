package pl.vertty.arivi.drop.utils;

public class NumberUtils
{
    
    public static boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
