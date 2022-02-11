
package pl.vertty.arivi.objects;

import pl.vertty.arivi.Main;
import java.sql.SQLException;
import pl.vertty.arivi.utils.ChatUtil;
import java.sql.ResultSet;
import cn.nukkit.level.Location;

public class Warp
{
    private String name;
    private Location location;
    
    public Warp(final String name, final Location location) {
        this.name = name;
        this.location = location;
        this.insert();
    }
    
    public Warp(final ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
        this.location = ChatUtil.locFromString(rs.getString("location"));
    }
    
    private void insert() {
        Main.getStore().asyncUpdate("INSERT INTO `{P}warp`(`id`, `name`, `location`) VALUES (NULL, '" + this.getName() + "','" + ChatUtil.locToString(this.getLocation()) + "');");
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(final Location location) {
        this.location = location;
    }
}
