
package pl.vertty.arivi.guilds.utils;

import cn.nukkit.utils.LogLevel;
import pl.vertty.arivi.Main;

public final class Logger
{
    public static void log(final LogLevel level, final String msg) {
        Main.getPlugin().getLogger().log(level, msg);
    }
    
    public static void exception(final Throwable t) {
        t.printStackTrace();
    }
    
    public static void info(final String... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            log(LogLevel.INFO, array[i]);
            final int n = 2;
            final int n2 = -1;
        }
    }
    
    public static void warning(final String... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            log(LogLevel.WARNING, array[i]);
            final int n = 2;
            final int n2 = 2;
        }
    }
}
