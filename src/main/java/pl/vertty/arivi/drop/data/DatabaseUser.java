package pl.vertty.arivi.drop.data;

import pl.vertty.arivi.drop.base.User;
import pl.vertty.arivi.drop.utils.StringUtils;
import pl.vertty.arivi.drop.utils.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUser
{
    private final User user;
    
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
        String m = "INSERT INTO `DMdrops` VALUES(" +
                "'%name%'," +
                "%turbo%," +
                "%turbo_exp%," +
                "%lvl%," +
                "%blocks%," +
                "%blockstonext%," +
                "'%drops%'," +
                "'%plecak%'," +
                "%cobble%," +
                "%dirt%" +
                ") ON DUPLICATE KEY UPDATE " +
                "turbo=%turbo%," +
                "turboexp=%turbo_exp%," +
                "lvl=%lvl%," +
                "blocks=%blocks%," +
                "blockstonext=%blockstonext%," +
                "drops='%drops%'," +
                "cobble=%cobble%," +
                "dirt=%dirt%;";
        m = StringUtils.replace(m, "%name%", this.user.getName());
        m = StringUtils.replace(m, "%turbo%", Long.toString(this.user.getTurbo()));
        m = StringUtils.replace(m, "%turbo_exp%", Long.toString(this.user.getTurboExp()));
        m = StringUtils.replace(m, "%lvl%", Integer.toString(this.user.getLvl()));
        m = StringUtils.replace(m, "%blocks%", Integer.toString(this.user.getBlocks()));
        m = StringUtils.replace(m, "%blockstonext%", Integer.toString(this.user.getBlockstonext()));
        m = StringUtils.replace(m, "%drops%", StringUtils.toString(this.user.getDrops()));
        m = StringUtils.replace(m, "%cobble%", Integer.toString(this.user.getCobble()));
        m = StringUtils.replace(m, "%dirt%", Integer.toString(this.user.getDirt()));
        return m;
    }
    
    public static void deserialize(final ResultSet rs) {
        try {
            final String name = rs.getString("name");
            final User user = new User(name);
            user.setBlocks(rs.getInt("blocks"));
            user.setBlockstonext(rs.getInt("blockstonext"));
            user.setLvl(rs.getInt("lvl"));
            user.setTurbo(rs.getLong("turbo"));
            user.setTurboExp(rs.getLong("turboexp"));
            user.setDrops(StringUtils.fromStringMap(rs.getString("drops")));
            user.setCobble(rs.getInt("cobble"));
            user.setDirt(rs.getInt("dirt"));
            user.setChanges(false);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
