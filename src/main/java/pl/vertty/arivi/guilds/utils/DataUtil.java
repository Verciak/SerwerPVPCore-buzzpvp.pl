// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil
{
    private static final LinkedHashMap<Integer, String> values;
    private static final SimpleDateFormat dateFormat;
    private static final SimpleDateFormat timeFormat;
    
    public static String secondsToString(final long n) {
        int n2 = (int)((n - System.currentTimeMillis()) / 1000L);
        final StringBuilder sb = new StringBuilder();
        if (n2 < 1) {
            return String.valueOf(new StringBuilder().append(n2 * 1000).append("ms"));
        }
        for (final Map.Entry<Integer, String> entry : DataUtil.values.entrySet()) {
            final int n3 = n2 / entry.getKey();
            if (n3 >= 1) {
                final int i = (int)Math.floor(n3);
                sb.append(i).append(entry.getValue());
                n2 -= i * entry.getKey();
            }
        }
        if (String.valueOf(sb).equals("")) {
            return "<1s";
        }
        return String.valueOf(sb);
    }
    
    public static String getTime(final long date) {
        return DataUtil.timeFormat.format(new Date(date));
    }
    
    public static long parseDateDiff(final String input, final boolean b) {
        try {
            final Matcher matcher = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2).matcher(input);
            int int1 = 0;
            int int2 = 0;
            int int3 = 0;
            int int4 = 0;
            int int5 = 0;
            int int6 = 0;
            int int7 = 0;
            boolean b2 = false;
            while (matcher.find()) {
                if (matcher.group() != null && !matcher.group().isEmpty()) {
                    for (int i = 0; i < matcher.groupCount(); ++i) {
                        if (matcher.group(i) != null && !matcher.group(i).isEmpty()) {
                            b2 = true;
                            break;
                        }
                        final int n = 5;
                    }
                    if (!b2) {
                        continue;
                    }
                    if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
                        int1 = Integer.parseInt(matcher.group(1));
                    }
                    if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                        int2 = Integer.parseInt(matcher.group(2));
                    }
                    if (matcher.group(3) != null && !matcher.group(3).isEmpty()) {
                        int3 = Integer.parseInt(matcher.group(3));
                    }
                    if (matcher.group(4) != null && !matcher.group(4).isEmpty()) {
                        int4 = Integer.parseInt(matcher.group(4));
                    }
                    if (matcher.group(5) != null && !matcher.group(5).isEmpty()) {
                        int5 = Integer.parseInt(matcher.group(5));
                    }
                    if (matcher.group(6) != null && !matcher.group(6).isEmpty()) {
                        int6 = Integer.parseInt(matcher.group(6));
                    }
                    if (matcher.group(7) == null) {
                        break;
                    }
                    if (matcher.group(7).isEmpty()) {
                        break;
                    }
                    int7 = Integer.parseInt(matcher.group(7));
                    break;
                }
            }
            if (!b2) {
                return -1L;
            }
            final GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (int1 > 0) {
                gregorianCalendar.add(1, int1 * (b ? 1 : -1));
            }
            if (int2 > 0) {
                gregorianCalendar.add(2, int2 * (b ? 1 : -1));
            }
            if (int3 > 0) {
                gregorianCalendar.add(3, int3 * (b ? 1 : -1));
            }
            if (int4 > 0) {
                gregorianCalendar.add(5, int4 * (b ? 1 : -1));
            }
            if (int5 > 0) {
                gregorianCalendar.add(11, int5 * (b ? 1 : -1));
            }
            if (int6 > 0) {
                gregorianCalendar.add(12, int6 * (b ? 1 : -1));
            }
            if (int7 > 0) {
                gregorianCalendar.add(13, int7 * (b ? 1 : -1));
            }
            final GregorianCalendar when = new GregorianCalendar();
            when.add(1, 10);
            if (gregorianCalendar.after(when)) {
                return when.getTimeInMillis();
            }
            return gregorianCalendar.getTimeInMillis();
        }
        catch (Exception ex) {
            return -1L;
        }
    }
    
    public static String getDate(final long date) {
        return DataUtil.dateFormat.format(new Date(date));
    }
    
    static {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        (values = new LinkedHashMap<Integer, String>(6)).put(31104000, "y");
        DataUtil.values.put(2592000, "msc");
        DataUtil.values.put(86400, "d");
        DataUtil.values.put(3600, "h");
        DataUtil.values.put(60, "min");
        DataUtil.values.put(1, "s");
    }
}
