// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.ranking;

import java.util.LinkedList;
import java.util.Comparator;
import pl.vertty.arivi.guilds.data.User;
import java.util.List;

public class AssistManager
{
    private static List<User> assists;

    public static List<User> getAssists() {
        return AssistManager.assists;
    }
    

    public static void addAssist(final User assist) {
        AssistManager.assists.add(assist);
    }

    
    public static void removeAssist(final User assist) {
        AssistManager.assists.remove(assist);
    }

    public static int getPlaceUser(final User user) {
        for (int num = 0; num < AssistManager.assists.size(); ++num) {
            if (AssistManager.assists.get(num).equals(user)) {
                return num + 1;
            }
        }
        return 0;
    }
    
    static {
        AssistManager.assists = new LinkedList<User>();
    }
}
