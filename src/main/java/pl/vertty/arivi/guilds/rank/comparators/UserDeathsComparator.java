// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.rank.comparators;

import pl.vertty.arivi.guilds.data.User;

import java.util.Comparator;

public class UserDeathsComparator implements Comparator<User>
{
    @Override
    public int compare(final User user, final User user2) {
        return Integer.valueOf(user2.getDeaths()).compareTo(user.getDeaths());
    }
}
