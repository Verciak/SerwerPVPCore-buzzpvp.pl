package pl.vertty.arivi.managers;



import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.Restart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class RestartManager {

    public static Restart getWhiteListStatus(Integer name) {
        for (Restart w : wl_status.values()) {
            if (name.equals(w.getName()))
                return w;
        }
        return null;
    }

    public static void addWhiteListStatus(Integer name) {
        wl_status.put(name, new Restart(name));
    }

    public static void deleteWhitelistStatus(Integer name) {
        wl_status.remove(name);
        Main.getStore().update("DELETE FROM `restart` WHERE `name` ='" + name + "';");
    }

    public static void loadRestart() {
        try {
            ResultSet rs = Main.getStore().query("SELECT * FROM `restart`");
            while (rs.next()) {
                Restart w = new Restart(rs);
                wl_status.put(w.getName(), w);
            }
            rs.close();
        } catch (SQLException var2) {
            System.out.println("Can not load restart Error " + var2.getMessage());
            var2.printStackTrace();
        }
    }

    public static ConcurrentHashMap<Integer, Restart> wl_status = new ConcurrentHashMap<>();
}



