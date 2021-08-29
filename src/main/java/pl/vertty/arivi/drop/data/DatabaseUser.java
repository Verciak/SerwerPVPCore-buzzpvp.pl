// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.data;

import java.sql.ResultSet;
import pl.vertty.arivi.drop.utils.StringUtils;
import java.sql.SQLException;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.drop.base.User;

public class DatabaseUser
{
    private User user;
    
    public DatabaseUser(final User user) {
        this.user = user;
    }
    
    public void save(final Database db) {
        try {
            db.getConnection().createStatement().executeUpdate(this.getInsert());
        }
        catch (SQLException e) {
            Util.sendError("[MySQL] Blad podczas zapisu gracza " + this.user.getName());
            e.printStackTrace();
        }
    }
    
    public String getInsert() {
        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `DMdrops` VALUES(");
        sb.append("'%name%',");
        sb.append("%turbo%,");
        sb.append("%turbo_exp%,");
        sb.append("%lvl%,");
        sb.append("%blocks%,");
        sb.append("%blockstonext%,");
        sb.append("'%drops%',");
        sb.append("'%plecak%',");
        sb.append("%cobble%,");
        sb.append("%dirt%");
        sb.append(") ON DUPLICATE KEY UPDATE ");
        sb.append("turbo=%turbo%,");
        sb.append("turboexp=%turbo_exp%,");
        sb.append("lvl=%lvl%,");
        sb.append("blocks=%blocks%,");
        sb.append("blockstonext=%blockstonext%,");
        sb.append("drops='%drops%',");
        sb.append("plecak='%plecak%',");
        sb.append("cobble=%cobble%,");
        sb.append("dirt=%dirt%;");
        String m = sb.toString();
        m = StringUtils.replace(m, "%name%", this.user.getName());
        m = StringUtils.replace(m, "%turbo%", Long.toString(this.user.getTurbo()));
        m = StringUtils.replace(m, "%turbo_exp%", Long.toString(this.user.getTurboExp()));
        m = StringUtils.replace(m, "%lvl%", Integer.toString(this.user.getLvl()));
        m = StringUtils.replace(m, "%blocks%", Integer.toString(this.user.getBlocks()));
        m = StringUtils.replace(m, "%blockstonext%", Integer.toString(this.user.getBlockstonext()));
        m = StringUtils.replace(m, "%drops%", StringUtils.toString(this.user.getDrops()));
        m = StringUtils.replace(m, "%plecak%", StringUtils.toString(this.user.getPlecak()));
        m = StringUtils.replace(m, "%cobble%", Integer.toString(this.user.getCobble()));
        m = StringUtils.replace(m, "%dirt%", Integer.toString(this.user.getDirt()));
        return m;
    }
    
    public static User deserialize(final ResultSet rs) {
        try {
            final String name = rs.getString("name");
            final User user = new User(name);
            user.setBlocks(rs.getInt("blocks"));
            user.setBlockstonext(rs.getInt("blockstonext"));
            user.setLvl(rs.getInt("lvl"));
            user.setTurbo(rs.getLong("turbo"));
            user.setTurboExp(rs.getLong("turboexp"));
            user.setDrops(StringUtils.fromStringMap(rs.getString("drops")));
            user.setPlecak(StringUtils.fromStringMap(rs.getString("plecak")));
            user.setCobble(rs.getInt("cobble"));
            user.setDirt(rs.getInt("dirt"));
            user.setChanges(false);
            return user;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
