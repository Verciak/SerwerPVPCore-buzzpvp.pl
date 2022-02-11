package pl.vertty.arivi.drop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class TimeUtils
{
    public static long getTime(final String string) {
        if (string == null || string.isEmpty()) {
            return 0L;
        }
        final Stack type = new Stack();
        final StringBuilder value = new StringBuilder();
        boolean calc = false;
        long time = 0L;
        char[] charArray;
        for (int length = (charArray = string.toCharArray()).length, j = 0; j < length; ++j) {
            final char c = charArray[j];
            switch (c) {
                case 'd':
                case 'h':
                case 'm':
                case 's': {
                    if (!calc) {
                        type.push(c);
                        calc = true;
                    }
                    if (calc) {
                        try {
                            final long i = Integer.parseInt(value.toString());
                            switch ((char)type.pop()) {
                                case 'd': {
                                    time += i * 86400000L;
                                    break;
                                }
                                case 'h': {
                                    time += i * 3600000L;
                                    break;
                                }
                                case 'm': {
                                    time += i * 60000L;
                                    break;
                                }
                                case 's': {
                                    time += i * 1000L;
                                    break;
                                }
                            }
                        }
                        catch (NumberFormatException e) {
                            Util.sendError("Unknown number: " + value);
                            return time;
                        }
                    }
                    type.push(c);
                    calc = true;
                    break;
                }
                default: {
                    value.append(c);
                    break;
                }
            }
        }
        return time;
    }
    
    public static String getDate(final Date date) {
        final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String st = dt.format(date.getTime());
        return st;
    }
    
    public static String getDurationBreakdown(long millis) {
        if (millis == 0L) {
            return "0";
        }
        final long days = TimeUnit.MILLISECONDS.toDays(millis);
        if (days > 0L) {
            millis -= TimeUnit.DAYS.toMillis(days);
        }
        final long hours = TimeUnit.MILLISECONDS.toHours(millis);
        if (hours > 0L) {
            millis -= TimeUnit.HOURS.toMillis(hours);
        }
        final long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        if (minutes > 0L) {
            millis -= TimeUnit.MINUTES.toMillis(minutes);
        }
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        if (seconds > 0L) {
            millis -= TimeUnit.SECONDS.toMillis(seconds);
        }
        final StringBuilder sb = new StringBuilder();
        if (days > 0L) {
            sb.append(days);
            sb.append("d ");
        }
        if (hours > 0L) {
            sb.append(hours);
            sb.append("h ");
        }
        if (minutes > 0L) {
            sb.append(minutes);
            sb.append("m ");
        }
        if (seconds > 0L) {
            sb.append(seconds);
            sb.append("s ");
        }
        return sb.toString();
    }
}
