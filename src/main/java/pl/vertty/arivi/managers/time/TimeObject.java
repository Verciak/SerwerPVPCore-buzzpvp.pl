// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers.time;

import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeObject
{

    public String name;
    private long reward;


    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_reward`(`id`, `name`, `reward`) VALUES (NULL, '").append(this.getName()).append("','").append(this.getReward()).append("')")));
    }


    public String getName() {
        return this.name;
    }

    public TimeObject(final ResultSet set) throws SQLException {
        this.name = set.getString("name");
        this.reward = set.getLong("reward");
    }


    public Player getPlayer() {
        return Server.getInstance().getPlayer(this.getName());
    }


    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_reward` SET `reward` = '").append(this.getReward()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }


    public TimeObject(final Player player) {
        this.name = player.getName();
        this.reward = 0L;
        this.insert();
    }
}
