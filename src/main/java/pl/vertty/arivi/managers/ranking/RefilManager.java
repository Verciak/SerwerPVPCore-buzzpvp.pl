
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.comparator.UserRefilComparator;

import java.util.LinkedList;
import java.util.List;

public class RefilManager
{
    private static List<User> Refil;

    public static List<User> getRefil() {
        return RefilManager.Refil;
    }
    

    public static void addRefil(final User death) {
        RefilManager.Refil.add(death);
        sortRefil();
    }
    public static void removeRefil(final User kill) {
        RefilManager.Refil.remove(kill);
        sortRefil();
    }
    

    
    public static void sortRefil() {
        RefilManager.Refil.sort(new UserRefilComparator());
    }

    static {
        RefilManager.Refil = new LinkedList<>();
    }

}
