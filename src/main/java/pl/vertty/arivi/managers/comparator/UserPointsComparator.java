package pl.vertty.arivi.managers.comparator;

import pl.vertty.arivi.guilds.data.User;

import java.util.Comparator;

public class UserPointsComparator implements Comparator<User> {
    public int compare(User g0, User g1) {
        Integer p0 = Integer.valueOf(g0.getPoints());
        Integer p2 = Integer.valueOf(g1.getPoints());
        return p2.compareTo(p0);
    }
}

