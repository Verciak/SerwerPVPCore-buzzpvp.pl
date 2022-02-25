
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.comparator.UserPerlyComparator;

import java.util.LinkedList;
import java.util.List;

public class PerlyManager
{
    private static List<User> Perly;

    public static List<User> getPerly() {
        return PerlyManager.Perly;
    }
    

    public static void addPerly(final User death) {
        PerlyManager.Perly.add(death);
        sortPerly();
    }
    public static void removePerly(final User kill) {
        PerlyManager.Perly.remove(kill);
        sortPerly();
    }
    

    
    public static void sortPerly() {
        PerlyManager.Perly.sort(new UserPerlyComparator());
    }

    static {
        PerlyManager.Perly = new LinkedList<>();
    }

}
