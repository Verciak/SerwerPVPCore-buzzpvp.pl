// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.managers;

import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemShop
{

    public String name;
    public int vip;
    public int svip;
    public int sponsor;
    public int skrzydla;


    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_itemshop`(`id`, `name`, `vip`, `svip`, `sponsor`,`skrzydla`) VALUES (NULL, '").append(this.getName()).append("','").append(this.getVip()).append("','").append(this.getSvip()).append("','").append(this.getSponsor()).append("','").append(this.getSkrzydla()).append("')")));
    }


    public String getName() {
        return this.name;
    }

    public ItemShop(final ResultSet set) throws SQLException {
        this.name = set.getString("name");
        this.vip = set.getInt("vip");
        this.svip = set.getInt("svip");
        this.sponsor = set.getInt("sponsor");
        this.skrzydla = set.getInt("skrzydla");
    }


    public Player getPlayer() {
        return Server.getInstance().getPlayer(this.getName());
    }


    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_itemshop` SET `vip` = '").append(this.getVip()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }

    public int getSvip() {
        return svip;
    }

    public void setSvip(int svip) {
        this.svip = svip;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_itemshop` SET `svip` = '").append(this.getSvip()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }

    public int getSponsor() {
        return sponsor;
    }

    public void setSponsor(int sponsor) {
        this.sponsor = sponsor;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_itemshop` SET `sponsor` = '").append(this.getSponsor()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }

    public int getSkrzydla() {
        return skrzydla;
    }

    public void setSkrzydla(int skrzydla) {
        this.skrzydla = skrzydla;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_itemshop` SET `skrzydla` = '").append(this.getSkrzydla()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }

    public ItemShop(final Player player) {
        this.name = player.getName();
        this.vip = 0;
        this.svip = 0;
        this.sponsor = 0;
        this.skrzydla = 0;
        this.insert();
    }
}
