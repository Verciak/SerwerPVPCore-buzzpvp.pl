package pl.vertty.arivi.managers.comparator;

import pl.vertty.arivi.objects.User;

import java.util.Comparator;

public class UserPerlyComparator implements Comparator<User> {
    public int compare(User g0, User g1) {
        Integer p0 = Integer.valueOf(g0.getperla());
        Integer p2 = Integer.valueOf(g1.getperla());
        return p2.compareTo(p0);
    }
}

