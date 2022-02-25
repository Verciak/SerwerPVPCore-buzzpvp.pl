
package pl.vertty.arivi.managers.ranking;

import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.comparator.UserKamienComparator;

import java.util.LinkedList;
import java.util.List;

public class KamienManager
{
    private static List<User> Kamien;

    public static List<User> getKamien() {
        return KamienManager.Kamien;
    }
    

    public static void addKamien(final User death) {
        KamienManager.Kamien.add(death);
        sortKamien();
    }
    public static void removeKamien(final User kill) {
        KamienManager.Kamien.remove(kill);
        sortKamien();
    }
    

    
    public static void sortKamien() {
        KamienManager.Kamien.sort(new UserKamienComparator());
    }

    static {
        KamienManager.Kamien = new LinkedList<>();
    }

}
