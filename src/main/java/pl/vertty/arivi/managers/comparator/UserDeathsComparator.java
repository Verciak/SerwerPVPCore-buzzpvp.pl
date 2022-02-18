package pl.vertty.arivi.managers.comparator;

import pl.vertty.arivi.guilds.data.User;

import java.util.Comparator;

public class UserDeathsComparator implements Comparator<User> {
    public int compare(User g0, User g1) {
        Integer p0 = Integer.valueOf(g0.getDeaths());
        Integer p2 = Integer.valueOf(g1.getDeaths());
        return p2.compareTo(p0);
    }
}

