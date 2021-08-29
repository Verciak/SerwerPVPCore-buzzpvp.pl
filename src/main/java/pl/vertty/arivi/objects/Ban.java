// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.objects;

import pl.vertty.arivi.Main;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Ban
{
    private String name;
    private String admin;
    private String reason;
    private long time;
    private long start;
    
    public Ban(final String name, final String admin, final String reason, final long time) {
        this.name = name;
        this.admin = admin;
        this.reason = reason;
        this.time = time;
        this.start = System.currentTimeMillis();
        this.insert();
    }
    
    public Ban(final ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
        this.admin = rs.getString("admin");
        this.reason = rs.getString("reason");
        this.time = rs.getLong("time");
        this.start = rs.getLong("start");
    }
    
    private void insert() {
        Main.getStore().update("INSERT INTO `{P}bans`(`id`, `name`, `admin`, `reason`, `time`, `start`) VALUES (NULL, '" + this.getName() + "','" + this.getAdmin() + "','" + this.getReason() + "','" + this.getTime() + "','" + this.getStart() + "');");
    }
    
    public long getStart() {
        return this.start;
    }
    
    public void setStart(final long start) {
        this.start = start;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public long getTime() {
        return this.time;
    }
    
    public void setTime(final long time) {
        this.time = time;
    }
    
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(final String reason) {
        this.reason = reason;
    }
    
    public String getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(final String admin) {
        this.admin = admin;
    }
}
