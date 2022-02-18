
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.managers.comparator.UserDeathsComparator;
import pl.vertty.arivi.managers.comparator.UserKoxComparator;

import java.util.LinkedList;
import java.util.List;

public class KoxManager
{
    private static List<User> kox;

    public static List<User> getKox() {
        return KoxManager.kox;
    }
    

    public static void addKox(final User death) {
        KoxManager.kox.add(death);
        sortKox();
    }
    public static void removeKox(final User kill) {
        KoxManager.kox.remove(kill);
        sortKox();
    }
    

    
    public static void sortKox() {
        KoxManager.kox.sort(new UserKoxComparator());
    }

    static {
        KoxManager.kox = new LinkedList<>();
    }

}
