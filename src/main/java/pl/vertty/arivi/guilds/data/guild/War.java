
package pl.vertty.arivi.guilds.data.guild;

import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.guild.WarManager;
import pl.vertty.arivi.guilds.utils.TimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class War
{
    private String name;
    private long time;
    private int kills;
    private String tag2;
    private int deaths;
    private String tag;
    
    private void insert() {
        Main.getStore().update(false, "INSERT INTO `pCGuilds_wars`(`id`, `tag`, `tag2`, `name`, `kills`, `deaths`, `time`) VALUES (NULL, '" + this.getTag() + "','" + this.getTag2() + "','" + this.getName() + "','" + this.getKills() + "','" + this.getDeaths() + "','" + this.getTime() + "')");
    }
    
    public War(final String s, final String tag2, final String name) {
        this.tag = s;
        this.tag2 = tag2;
        this.name = name;
        this.kills = 0;
        this.deaths = 0;
        this.time = System.currentTimeMillis() + TimeUtil.HOUR.getTime(24);
        this.insert();
        WarManager.getWars().put(s, this);
    }
    
    public void setName(final String name) {
        this.name = name;
        Main.getStore().update(false, "UPDATE `pCGuilds_wars` SET `name` = '" + this.getName() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public War(final ResultSet set) throws SQLException {
        this.tag = set.getString("tag");
        this.tag2 = set.getString("tag2");
        this.name = set.getString("name");
        this.kills = set.getInt("kills");
        this.deaths = set.getInt("deaths");
        this.time = set.getLong("time");
    }
    
    public String getTag2() {
        return this.tag2;
    }
    
    public void setDeaths(final int deaths) {
        this.deaths = deaths;
        Main.getStore().update(false, "UPDATE `pCGuilds_wars` SET `deaths` = '" + this.getDeaths() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setKills(final int kills) {
        this.kills = kills;
        Main.getStore().update(false, "UPDATE `pCGuilds_wars` SET `kills` = '" + this.getKills() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setTime(final long time) {
        this.time = time;
        Main.getStore().update(false, "UPDATE `pCGuilds_wars` SET `time` = '" + this.getTime() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setTag(final String tag) {
        this.tag = tag;
        Main.getStore().update(false, "UPDATE `pCGuilds_wars` SET `tag` = '" + this.getTag() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public int getKills() {
        return this.kills;
    }
    
    public int getDeaths() {
        return this.deaths;
    }
    
    public long getTime() {
        return this.time;
    }
}
