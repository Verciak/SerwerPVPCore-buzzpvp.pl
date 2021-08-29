// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.utils;

import pl.vertty.arivi.guilds.data.User;

public class RankingTopUtil
{
    public static int pointsprestiz(final User u) {
        if (u == null) {
            return 0;
        }
        return u.getPresiz() * 1000;
    }
}
