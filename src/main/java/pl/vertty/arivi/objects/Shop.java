package pl.vertty.arivi.objects;

import cn.nukkit.OfflinePlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Shop {

    public String name;
    public boolean pajeczyna;
    public boolean lod;
    public boolean sniezki;
    public boolean lava;
    public boolean luk;
    public boolean cobblestone;
    public boolean zapalniczka;
    public boolean slime;
    public boolean obs;
    public boolean fly;


    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_shop`(`id`, `name`, `pajeczyna`, `lod`, `sniezki`, `lava`, `luk`, `cobblestone`, `zapalniczka`, `slime`, `obs`, `fly`) VALUES (NULL, '").append(this.getName()).append("','").append(this.isPajeczyna()).append("','").append(this.isLod()).append("','").append(this.isSniezki()).append("','").append(this.isLava()).append("','").append(this.isLuk()).append("','").append(this.isCobblestone()).append("','").append(this.isZapalniczka()).append("','").append(this.isSlime()).append("','").append(this.isObs()).append("','").append(this.isFly()).append("')")));
    }

    public Shop(final ResultSet set) throws SQLException {
        this.name = set.getString("name");
        this.pajeczyna = set.getBoolean("pajeczyna");
        this.lod = set.getBoolean("lod");
        this.sniezki = set.getBoolean("sniezki");
        this.lava = set.getBoolean("lava");
        this.luk = set.getBoolean("luk");
        this.cobblestone = set.getBoolean("cobblestone");
        this.zapalniczka = set.getBoolean("zapalniczka");
        this.slime = set.getBoolean("slime");
        this.obs = set.getBoolean("obs");
        this.fly = set.getBoolean("fly");
    }

    public Shop(final Player player) {
        this.name = player.getName();
        this.pajeczyna = false;
        this.lod = false;
        this.sniezki = false;
        this.lava = false;
        this.luk = false;
        this.cobblestone = false;
        this.zapalniczka = false;
        this.slime = false;
        this.obs = false;
        this.fly = false;
        this.insert();
    }

    public String getName() {
        return this.name;
    }

    public Player getPlayer() {
        return Server.getInstance().getPlayer(this.getName());
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isPajeczyna() {
        return pajeczyna;
    }

    public void setPajeczyna(boolean pajeczyna) {
        this.pajeczyna = pajeczyna;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `pajeczyna` ='" + this.isPajeczyna() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isLod() {
        return lod;
    }

    public void setLod(boolean lod) {
        this.lod = lod;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `lod` ='" + this.isLod() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isSniezki() {
        return sniezki;
    }

    public void setSniezki(boolean sniezki) {
        this.sniezki = sniezki;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `sniezki` ='" + this.isSniezki() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isLava() {
        return lava;
    }

    public void setLava(boolean lava) {
        this.lava = lava;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `lava` ='" + this.isLava() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isLuk() {
        return luk;
    }

    public void setLuk(boolean luk) {
        this.luk = luk;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `luk` ='" + this.isLuk() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isCobblestone() {
        return cobblestone;
    }

    public void setCobblestone(boolean cobblestone) {
        this.cobblestone = cobblestone;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `cobblestone` ='" + this.isCobblestone() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isZapalniczka() {
        return zapalniczka;
    }

    public void setZapalniczka(boolean zapalniczka) {
        this.zapalniczka = zapalniczka;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `zapalniczka` ='" + this.isZapalniczka() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isSlime() {
        return slime;
    }

    public void setSlime(boolean slime) {
        this.slime = slime;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `slime` ='" + this.isSlime() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isObs() {
        return obs;
    }

    public void setObs(boolean obs) {
        this.obs = obs;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `obs` ='" + this.isObs() + "' WHERE `name` ='" + this.getName() + "'");

    }

    public boolean isFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
        Main.getStore().update("UPDATE `pCGuilds_shop` SET `fly` ='" + this.isFly() + "' WHERE `name` ='" + this.getName() + "'");

    }
}