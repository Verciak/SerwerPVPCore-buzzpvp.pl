// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.base.utils;

import pl.vertty.arivi.drop.base.User;

import java.util.*;

public class UserUtils
{
    private static Map<String, User> users = new HashMap<String, User>();
    private static List<User> top = new ArrayList<User>();
    
    public static void add(final User user) {
        UserUtils.users.put(user.getName().toLowerCase(), user);
        UserUtils.top.add(user);
        Collections.sort(UserUtils.top);
    }
    
    public static void remove(final User user) {
        UserUtils.users.remove(user.getName().toLowerCase());
        UserUtils.top.remove(user);
        Collections.sort(UserUtils.top);
    }
    
    public static User get(final String name) {
        return UserUtils.users.get(name.toLowerCase());
    }
    
    public static List<String> getNames() {
        return new ArrayList<String>(UserUtils.users.keySet());
    }
    
    public static List<User> getUsers() {
        return new ArrayList<User>(UserUtils.users.values());
    }
    
    public static void clearUsers() {
        UserUtils.users.clear();
    }
    
    public static boolean playedBefore(final String name) {
        return UserUtils.users.containsKey(name.toLowerCase());
    }
    
    public static void sortUsers() {
        Collections.sort(UserUtils.top);
    }
    
    public static int getPosition(final User user) {
        int i = 1;
        for (final User u : UserUtils.top) {
            if (u.getName().equalsIgnoreCase(user.getName())) {
                return i;
            }
            ++i;
        }
        return 0;
    }
    
    public static User getUser(final int i) {
        if (UserUtils.top.size() < i) {
            return null;
        }
        return UserUtils.top.get(i - 1);
    }
    
    public static List<User> getTops() {
        return new ArrayList<User>(UserUtils.top);
    }

}
