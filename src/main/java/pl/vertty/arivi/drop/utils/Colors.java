// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.utils;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.utils.TextFormat;

public class Colors
{
    public static String translate(final String m) {
        return TextFormat.colorize('&', m.replace("%>", "»").replace("<%", "«"));
    }
    
    public static List<String> translate(final List<String> s) {
        final List<String> msg = new ArrayList<String>();
        if (s == null || s.isEmpty()) {
            return msg;
        }
        for (final String ss : s) {
            msg.add(translate(ss));
        }
        return msg;
    }
}
