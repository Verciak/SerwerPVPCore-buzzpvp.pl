
package pl.vertty.arivi.objects;

import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.InventoryUtil;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.Player;
import java.sql.SQLException;
import java.sql.ResultSet;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.utils.SeralizerUtil;
import cn.nukkit.inventory.PlayerInventory;

public class Backup
{
    String name;
    String killer;
    int ping;
    int points;
    String inventory;
    long time;
    
    public Backup(final String n, final String k, final int p, final PlayerInventory inv, final int points) {
        this.name = n;
        this.killer = k;
        this.ping = p;
        this.inventory = SeralizerUtil.serializeInventory((Inventory)inv);
        this.time = System.currentTimeMillis();
        this.points = points;
        this.insert();
    }
    
    public Backup(final ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
        this.killer = rs.getString("killer");
        this.ping = rs.getInt("ping");
        this.time = rs.getLong("time");
        this.inventory = rs.getString("inventory");
        this.points = rs.getInt("points");
    }
    
    public void restore(final Player p) {
        final User user2 = UserManager.getUser(p);
        user2.setPoints(user2.getPoints() + this.points);
        p.getInventory().setContents(InventoryUtil.itemArrayToInventoryContents(SeralizerUtil.deserializeItemArray(this.inventory)));
    }
    
    public int getPing() {
        return this.ping;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String getKiller() {
        return this.killer;
    }
    
    public long getTime() {
        return this.time;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getInventory() {
        return this.inventory;
    }
    
    private void insert() {
        Main.getStore().update(false, "INSERT INTO `{P}backups`(`id`, `name`, `killer`, `ping`, `time`, `inventory`, `points`) VALUES (NULL, '" + this.name + "','" + this.killer + "','" + this.ping + "','" + this.time + "','" + this.inventory + "','" + this.points + "');");
    }
}
