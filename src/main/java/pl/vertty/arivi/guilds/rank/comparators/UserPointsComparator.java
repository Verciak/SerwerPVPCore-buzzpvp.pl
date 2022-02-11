
package pl.vertty.arivi.guilds.rank.comparators;

import pl.vertty.arivi.guilds.data.User;

import java.util.Comparator;

public class UserPointsComparator implements Comparator<User>
{
    @Override
    public int compare(final User user, final User user2) {
        return Integer.valueOf(user2.getPoints()).compareTo(user.getPoints());
    }
}
