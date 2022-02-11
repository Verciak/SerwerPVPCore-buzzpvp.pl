
package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.objects.ItemShop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class ItemShopManager
{
    private static final ConcurrentHashMap<String, ItemShop> users;
    
    public static ConcurrentHashMap<String, ItemShop> getUsers() {
        return ItemShopManager.users;
    }

    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_itemshop`");
            while (query.next()) {
                final ItemShop value = new ItemShop(query);
                ItemShopManager.users.put(value.getName(), value);
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(ItemShopManager.users.size()).append(" players from pCGuilds_itemshop")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_itemshop");
            ex.printStackTrace();
        }
    }
    
    public static void createrUser(final Player player) {
        final ItemShop value = new ItemShop(player);
        ItemShopManager.users.put(player.getName(), value);
    }
    
    public static ItemShop getUser(final Player player) {
        for (final ItemShop user : ItemShopManager.users.values()) {
            if (user.getName().equalsIgnoreCase(player.getName())) {
                return user;
            }
        }
        return null;
    }
    
    public static ItemShop getUser(final String anotherString) {
        for (final ItemShop user : ItemShopManager.users.values()) {
            if (user.getName().equalsIgnoreCase(anotherString)) {
                return user;
            }
        }
        return null;
    }
    
    static {
        users = new ConcurrentHashMap<String, ItemShop>();
    }
}
