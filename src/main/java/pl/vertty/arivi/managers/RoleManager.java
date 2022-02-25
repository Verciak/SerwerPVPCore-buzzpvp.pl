
package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.Role;
import pl.vertty.arivi.utils.guild.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class RoleManager
{
    private static final ConcurrentHashMap<String, Role> users = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, Role> getUsers() {
        return RoleManager.users;
    }


    public static void permsOwner(Role role) {
        role.setUpr_Furnace(true);
        role.setUpr_perms(true);
        role.setUpr_Lava(true);
        role.setUpr_Boyfarmer(true);
        role.setUpr_Chest(true);
        role.setUpr_Tnt(true);
        role.setUpr_Place_Obsidian(true);
        role.setUpr_Place_Stone(true);
        role.setUpr_Break_Obsidian(true);
        role.setUpr_Break_Stone(true);
        role.setUpr_Lapis(true);
        role.setUpr_Water(true);
        role.setUpr_addMember(true);
        role.setUpr_removeMember(true);
        role.setUpr_base_teleport(true);
        role.setUpr_pvpguild(true);
        role.setUpr_pvpally(true);
        role.setUpr_withdrawchest(true);
        role.setUpr_guildchest(true);
    }

    public static void permsOwnerOff(Role role) {
        role.setUpr_Furnace(false);
        role.setUpr_perms(false);
        role.setUpr_Lava(false);
        role.setUpr_Boyfarmer(false);
        role.setUpr_Chest(false);
        role.setUpr_Tnt(false);
        role.setUpr_Place_Obsidian(false);
        role.setUpr_Place_Stone(false);
        role.setUpr_Break_Obsidian(false);
        role.setUpr_Break_Stone(false);
        role.setUpr_Lapis(false);
        role.setUpr_Water(false);
        role.setUpr_addMember(false);
        role.setUpr_removeMember(false);
        role.setUpr_base_teleport(false);
        role.setUpr_pvpguild(false);
        role.setUpr_pvpally(false);
        role.setUpr_withdrawchest(false);
        role.setUpr_guildchest(false);
    }

    public static void loadUsers() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_roles`");
            while (query.next()) {
                final Role value = new Role(query);
                RoleManager.users.put(value.getName(), value);
            }
            query.close();
            Logger.info("Loaded " + users.size() + " players from 'pCGuilds_roles'");
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_roles");
            ex.printStackTrace();
        }
    }
    
    public static void deleteUser(final Role user) {
        RoleManager.users.remove(user.getName());
        Main.getStore().asyncUpdate("DELETE FROM `pCGuilds_roles` WHERE `name` = '" + user.getName() + "'");
    }
    
    public static void createrUser(final Player player) {
        final Role value = new Role(player);
        RoleManager.users.put(player.getName(), value);
    }
    
    public static Role getUser(final Player player) {
        return users.get(player.getName());
    }
    
    public static Role getUser(final String anotherString) {
        return  users.get(anotherString);
    }

}
