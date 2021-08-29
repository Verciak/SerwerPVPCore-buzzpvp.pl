// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringUtils
{
    public static String replace(final String text, final String searchString, String replacement) {
        if (text == null || text.isEmpty() || searchString.isEmpty()) {
            return text;
        }
        if (replacement == null) {
            replacement = "";
        }
        int start = 0;
        int max = -1;
        int end = text.indexOf(searchString, start);
        if (end == -1) {
            return text;
        }
        final int replLength = searchString.length();
        int increase = replacement.length() - replLength;
        increase = ((increase < 0) ? 0 : increase);
        increase *= ((max > 64) ? 64 : ((max < 0) ? 16 : max));
        final StringBuilder sb = new StringBuilder(text.length() + increase);
        while (end != -1) {
            sb.append(text.substring(start, end)).append(replacement);
            start = end + replLength;
            if (--max == 0) {
                break;
            }
            end = text.indexOf(searchString, start);
        }
        sb.append(text.substring(start));
        return sb.toString();
    }
    
    public static String toString(final Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, Integer> e : map.entrySet()) {
            sb.append(String.valueOf(e.getKey()) + ":" + e.getValue() + ",");
        }
        return sb.toString();
    }
    
    public static Map<String, Integer> fromStringMap(final String s) {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        if (s == null || s.isEmpty()) {
            return map;
        }
        final String[] a = s.split(",");
        String[] array;
        for (int length = (array = a).length, i = 0; i < length; ++i) {
            final String d = array[i];
            final String[] w = d.split(":");
            if (NumberUtils.isInt(w[1])) {
                map.put(w[0], Integer.parseInt(w[1]));
            }
        }
        return map;
    }
}
