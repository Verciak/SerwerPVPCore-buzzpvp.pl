
package pl.vertty.arivi.guilds.managers.guild;

import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.Main;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.guild.War;
import java.util.concurrent.ConcurrentHashMap;

public class WarManager
{
    private static final ConcurrentHashMap<String, War> wars;
    
    public static List<War> getWars(final Guild guild) {
        final ArrayList<War> list = new ArrayList<War>();
        for (final War war : WarManager.wars.values()) {
            if (war.getTag().equalsIgnoreCase(guild.getTag()) || war.getTag2().equalsIgnoreCase(guild.getTag())) {
                list.add(war);
            }
        }
        return list;
    }
    
    public static ConcurrentHashMap<String, War> getWars() {
        return WarManager.wars;
    }
    
    public static void deleteWar(final War war) {
        WarManager.wars.remove(war.getTag());
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_wars` WHERE `tag` = '").append(war.getTag()).append("'")));
    }
    
    public static War getWar(final String anotherString) {
        for (final War war : WarManager.wars.values()) {
            if (war.getTag().equalsIgnoreCase(anotherString)) {
                return war;
            }
        }
        return null;
    }
    
    public static void loadWars() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_wars`");
            while (query.next()) {
                final War value = new War(query);
                WarManager.wars.put(value.getTag(), value);
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(WarManager.wars.size()).append(" wars  from pCGuilds_wars")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_wars");
            ex.printStackTrace();
        }
    }
    
    static {
        wars = new ConcurrentHashMap<String, War>();
    }
}
