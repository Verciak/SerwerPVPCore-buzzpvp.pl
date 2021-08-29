// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.data.guild.cuboid;

import java.sql.SQLException;
import java.sql.ResultSet;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.level.Location;

public class Lock
{
    private final String nick;
    private final Location location;
    private final String tag;
    
    public Location getLocation() {
        return this.location;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_lock`(`id`, `tag`, `nick`, `location`) VALUES (NULL, '").append(this.getTag()).append("','").append(this.getNick()).append("','").append(ChatUtil.locToString2(this.getLocation())).append("');")));
    }
    
    public String getNick() {
        return this.nick;
    }
    
    public Lock(final String tag, final String nick, final Location location) {
        this.tag = tag;
        this.nick = nick;
        this.location = location;
        this.insert();
    }
    
    public Lock(final ResultSet set) throws SQLException {
        this.tag = set.getString("tag");
        this.nick = set.getString("nick");
        this.location = ChatUtil.locFromString2(set.getString("location"));
    }
}
