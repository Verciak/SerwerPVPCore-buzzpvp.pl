
package pl.vertty.arivi.utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil
{
    private static final SimpleDateFormat dateFormat;
    private static final SimpleDateFormat timeFormat;
    private static final LinkedHashMap<Integer, String> values;
    
    public static String secondsToString(final long l) {
        int seconds = (int)((l - System.currentTimeMillis()) / 1000L);
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<Integer, String> e : DataUtil.values.entrySet()) {
            final int iDiv = seconds / e.getKey();
            if (iDiv >= 1) {
                final int x = (int)Math.floor(iDiv);
                sb.append(x + e.getValue());
                seconds -= x * e.getKey();
            }
        }
        return sb.toString();
    }
    
    public static String parseLong(final long milliseconds, final boolean abbreviate) {
        final List<String> units = new ArrayList<String>();
        long amount = milliseconds / 604800000L;
        units.add(amount + "w");
        amount = milliseconds / 86400000L % 7L;
        units.add(amount + "d");
        amount = milliseconds / 3600000L % 24L;
        units.add(amount + "h");
        amount = milliseconds / 60000L % 60L;
        units.add(amount + "m");
        amount = milliseconds / 1000L % 60L;
        units.add(amount + "s");
        final String[] array = new String[5];
        for (final String s : units) {
            final char end = s.charAt(s.length() - 1);
            switch (end) {
                case 'w': {
                    array[0] = s;
                }
                case 'd': {
                    array[1] = s;
                }
                case 'h': {
                    array[2] = s;
                }
                case 'm': {
                    array[3] = s;
                }
                case 's': {
                    array[4] = s;
                    continue;
                }
                default: {
                    continue;
                }
            }
        }
        units.clear();
        for (final String s2 : array) {
            if (!s2.startsWith("0")) {
                units.add(s2);
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (final String s3 : units) {
            if (!abbreviate) {
                final char c = s3.charAt(s3.length() - 1);
                final String count = s3.substring(0, s3.length() - 1);
                String word = null;
                switch (c) {
                    case 'w': {
                        word = "t";
                        break;
                    }
                    case 'd': {
                        word = "d";
                        break;
                    }
                    case 'h': {
                        word = "g";
                        break;
                    }
                    case 'm': {
                        word = "m";
                        break;
                    }
                    default: {
                        word = "s";
                        break;
                    }
                }
                final String and = s3.equals(units.get(units.size() - 1)) ? "" : (s3.equals(units.get(units.size() - 2)) ? " i " : ", ");
                sb.append(count).append(word).append(and);
            }
            else {
                sb.append(s3);
                if (s3.equals(units.get(units.size() - 1))) {
                    continue;
                }
                sb.append("-");
            }
        }
        return (sb.toString().trim().length() == 0) ? "NULL" : sb.toString().trim();
    }
    
    public static String getDate(final long time) {
        return DataUtil.dateFormat.format(new Date(time));
    }
    
    public static String getTime(final long time) {
        return DataUtil.timeFormat.format(new Date(time));
    }
    
    public static long parseDateDiff(final String time, final boolean future) {
        try {
            final Pattern timePattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
            final Matcher m = timePattern.matcher(time);
            int years = 0;
            int months = 0;
            int weeks = 0;
            int days = 0;
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            boolean found = false;
            while (m.find()) {
                if (m.group() != null && !m.group().isEmpty()) {
                    for (int i = 0; i < m.groupCount(); ++i) {
                        if (m.group(i) != null && !m.group(i).isEmpty()) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        continue;
                    }
                    if (m.group(1) != null && !m.group(1).isEmpty()) {
                        years = Integer.parseInt(m.group(1));
                    }
                    if (m.group(2) != null && !m.group(2).isEmpty()) {
                        months = Integer.parseInt(m.group(2));
                    }
                    if (m.group(3) != null && !m.group(3).isEmpty()) {
                        weeks = Integer.parseInt(m.group(3));
                    }
                    if (m.group(4) != null && !m.group(4).isEmpty()) {
                        days = Integer.parseInt(m.group(4));
                    }
                    if (m.group(5) != null && !m.group(5).isEmpty()) {
                        hours = Integer.parseInt(m.group(5));
                    }
                    if (m.group(6) != null && !m.group(6).isEmpty()) {
                        minutes = Integer.parseInt(m.group(6));
                    }
                    if (m.group(7) == null) {
                        break;
                    }
                    if (m.group(7).isEmpty()) {
                        break;
                    }
                    seconds = Integer.parseInt(m.group(7));
                    break;
                }
            }
            if (!found) {
                return -1L;
            }
            final Calendar c = new GregorianCalendar();
            if (years > 0) {
                c.add(1, years * (future ? 1 : -1));
            }
            if (months > 0) {
                c.add(2, months * (future ? 1 : -1));
            }
            if (weeks > 0) {
                c.add(3, weeks * (future ? 1 : -1));
            }
            if (days > 0) {
                c.add(5, days * (future ? 1 : -1));
            }
            if (hours > 0) {
                c.add(11, hours * (future ? 1 : -1));
            }
            if (minutes > 0) {
                c.add(12, minutes * (future ? 1 : -1));
            }
            if (seconds > 0) {
                c.add(13, seconds * (future ? 1 : -1));
            }
            final Calendar max = new GregorianCalendar();
            max.add(1, 10);
            if (c.after(max)) {
                return max.getTimeInMillis();
            }
            return c.getTimeInMillis();
        }
        catch (Exception e) {
            return -1L;
        }
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
