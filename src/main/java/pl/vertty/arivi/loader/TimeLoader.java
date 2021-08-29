// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class TimeLoader
{
    public static void onTimeLoader() {
        final SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
