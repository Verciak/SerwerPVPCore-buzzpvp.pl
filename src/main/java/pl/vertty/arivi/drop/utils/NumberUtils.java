// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.utils;

public class NumberUtils
{
    public static boolean isIntItem(final String s) {
        if (s.contains(":")) {
            final String[] i = s.split(":");
            return isInt(i[0]) && isInt(i[1]);
        }
        return isInt(s);
    }
    
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
