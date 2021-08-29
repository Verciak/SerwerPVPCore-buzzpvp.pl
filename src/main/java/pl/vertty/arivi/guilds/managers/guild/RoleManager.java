// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers.guild;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import pl.vertty.arivi.guilds.utils.Logger;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import java.util.Iterator;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.guild.Role;
import java.util.List;

public class RoleManager
{
    private static final List<Role> roles;
    
    public static void addRole(final String s, final String s2) {
        RoleManager.roles.add(new Role(s, s2));
    }
    
    public static void refreshRoleAll() {
        for (final Guild guild : GuildManager.getGuilds().values()) {
            final Iterator<String> iterator2 = guild.getMembers().iterator();
            while (iterator2.hasNext()) {
                final User user = UserManager.getUser(iterator2.next());
                for (final Role role : getRolesGuild(guild.getTag())) {
                    if (user.getRole().contains(role.getName())) {
                        user.setUpr_Furnace(role.isUpr_Furnace());
                        user.setUpr_Logblock(role.isUpr_Logblock());
                        user.setUpr_Lava(role.isUpr_Lava());
                        user.setUpr_Boyfarmer(role.isUpr_Boyfarmer());
                        user.setUpr_Chest(role.isUpr_Chest());
                        user.setUpr_Tnt(role.isUpr_Tnt());
                        user.setUpr_Place_Obsidian(role.isUpr_Place_Obsidian());
                        user.setUpr_Place_Stone(role.isUpr_Place_Stone());
                        user.setUpr_Break_Obsidian(role.isUpr_Break_Obsidian());
                        user.setUpr_Lapis(role.isUpr_Lapis());
                        user.setUpr_Break_Stone(role.isUpr_Break_Stone());
                        user.setUpr_Water(role.isUpr_Water());
                    }
                }
            }
        }
    }
    
    public static void deleteRoleAll(final String s) {
        for (final Role role : RoleManager.roles) {
            if (role.getTag().equalsIgnoreCase(s)) {
                RoleManager.roles.remove(role);
                Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_roles` WHERE `tag` = '").append(s).append("'")));
            }
        }
    }
    
    public static void loadRoles() {
        try {
            final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_roles`");
            while (query.next()) {
                RoleManager.roles.add(new Role(query));
            }
            query.close();
            Logger.info(String.valueOf(new StringBuilder().append("Loaded ").append(RoleManager.roles.size()).append(" roles from pCGuilds_roles")));
        }
        catch (SQLException ex) {
            Logger.info("Nie mozna zaladowac tabeli pCGuilds_roles");
            ex.printStackTrace();
        }
    }
    
    public static List<Role> getRolesGuild(final String anotherString) {
        final ArrayList<Role> list = new ArrayList<Role>();
        for (final Role role : RoleManager.roles) {
            if (role.getTag().equalsIgnoreCase(anotherString)) {
                list.add(role);
            }
        }
        return list;
    }
    
    public static Role getRole(final String anotherString, final String anotherString2) {
        for (final Role role : RoleManager.roles) {
            if (role.getTag().equals(anotherString) && role.getName().equals(anotherString2)) {
                return role;
            }
        }
        return null;
    }
    
    public static List<Role> getRoles() {
        return RoleManager.roles;
    }
    
    static {
        roles = new ArrayList<Role>();
    }
}
