// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.mysql.modes.StoreMode;
import pl.vertty.arivi.mysql.modes.StoreMySQL;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.mysql.Store;

public class DatabaseLoader
{
    public static Store store;
    
    public static void onDatabaseLoad() {
        final Config co = Main.getPlugin().getConfig();
        DatabaseLoader.store = new StoreMySQL(co.getString("mysql.host"), co.getInt("mysql.port"), co.getString("mysql.user"), co.getString("mysql.pass"), co.getString("mysql.name"), co.getString("mysql.prefix"));
        final boolean conn = DatabaseLoader.store.connect();
        if (conn) {
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}bans` (" + ((DatabaseLoader.store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + "`name` varchar(32) NOT NULL,`time` bigint(22) NOT NULL, `reason` text NOT NULL, `admin` varchar(32) NOT NULL, `start` BIGINT(22) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}bansip` (" + ((DatabaseLoader.store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + "`ip` varchar(32) NOT NULL,`time` bigint(22) NOT NULL, `reason` text NOT NULL, `admin` varchar(32) NOT NULL, `start` BIGINT(22) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}mutes` (" + ((DatabaseLoader.store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + "`name` varchar(32) NOT NULL,`time` bigint(22) NOT NULL, `reason` text NOT NULL, `admin` varchar(32) NOT NULL, `start` BIGINT(22) NOT NULL);");
        }
        if (conn) {
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_shop` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `pajeczyna` varchar(100) NOT NULL, `lod` varchar(100) NOT NULL, `sniezki` varchar(100) NOT NULL, `lava` varchar(100) NOT NULL, `luk` varchar(100) NOT NULL, `cobblestone` varchar(100) NOT NULL, `zapalniczka` varchar(100) NOT NULL, `slime` varchar(100) NOT NULL, `obs` varchar(100) NOT NULL, `fly` varchar(100) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_users` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `points` int(100) NOT NULL, `kills` int(100) NOT NULL, `deaths` int(100) NOT NULL, `asysts` int(100) NOT NULL, `incognitoNick` int(1) NOT NULL, `incognitoSkin` int(1) NOT NULL, `firstIP` varchar(100) NOT NULL, `lastIP` varchar(100) NOT NULL, `firstJoin` bigint(22) NOT NULL, `schowek_kox` int NOT NULL, `schowek_refy` int NOT NULL, `schowek_perly` int NOT NULL, `lastKill` varchar(32) NOT NULL, `lastKillTime` bigint(22) NOT NULL, `god` int(1) NOT NULL, `group` varchar(32) NOT NULL, `eq1` LONGTEXT NOT NULL, `coins` int NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_wings` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `wings` varchar(255) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_itemshop` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `vip` int(100) NOT NULL, `svip` int(100) NOT NULL, `sponsor` int(100) NOT NULL, `skrzydla` int(100) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_reward` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `reward` varchar(32) NOT NULL);");


        }
    }
}
