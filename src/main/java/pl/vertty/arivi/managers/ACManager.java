
package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.managers.ranking.*;
import pl.vertty.arivi.objects.ACData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ACManager
{
    private static final Map<String, ACData> users = new ConcurrentHashMap<>();

    public static Map<String, ACData> getUsers() {
        return ACManager.users;
    }
    
    public static void createrUser(final Player player) {
        final ACData value = new ACData(player);
        ACManager.users.put(player.getName(), value);
    }
    
    public static ACData getUser(final Player player) {
        ACData acData = users.get(player.getName());
        if (acData == null) acData = new ACData(player);
        return acData;
    }
    
    public static ACData getUser(final String anotherString) {
        return  users.get(anotherString);
    }

}
