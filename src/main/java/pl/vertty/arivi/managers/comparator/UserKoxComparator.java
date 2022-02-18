package pl.vertty.arivi.managers.comparator;

import pl.vertty.arivi.guilds.data.User;

import java.util.Comparator;

public class UserKoxComparator implements Comparator<User> {
    public int compare(User g0, User g1) {
        Integer p0 = Integer.valueOf(g0.getkox());
        Integer p2 = Integer.valueOf(g1.getkox());
        return p2.compareTo(p0);
    }
}

