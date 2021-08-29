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
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}warp` (" + ((DatabaseLoader.store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + "`name` varchar(32) NOT NULL,`location` text NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}mutes` (" + ((DatabaseLoader.store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + "`name` varchar(32) NOT NULL,`time` bigint(22) NOT NULL, `reason` text NOT NULL, `admin` varchar(32) NOT NULL, `start` BIGINT(22) NOT NULL);");
        }
        if (conn) {
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `{P}backups` (`id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,`name` varchar(32) NOT NULL, `killer` varchar(32) NOT NULL, `ping` int NOT NULL, `time` bigint NOT NULL, `inventory` LONGTEXT NOT NULL, `points` int NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_users` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `points` int(100) NOT NULL, `kills` int(100) NOT NULL, `deaths` int(100) NOT NULL, `asysts` int(100) NOT NULL, `upr_lava` int(1) NOT NULL, `upr_water` int(1) NOT NULL, `upr_break_obsidian` int(1) NOT NULL, `upr_break_stone` int(1) NOT NULL, `upr_place_obsidian` int(1) NOT NULL, `upr_place_stone` int(1) NOT NULL, `upr_chest` int(1) NOT NULL, `upr_tnt` int(1) NOT NULL, `upr_boyfarmer` int(1) NOT NULL, `upr_lapis` int(1) NOT NULL, `upr_logblock` int(1) NOT NULL, `upr_furnace` int(1) NOT NULL, `incognitoNick` int(1) NOT NULL, `incognitoSkin` int(1) NOT NULL, `incognitoGuild` int(1) NOT NULL, `role` varchar(32) NOT NULL, `kamien` int(100) NOT NULL, `kox` int(100) NOT NULL, `refil` int(100) NOT NULL, `enderchest1` LONGTEXT NOT NULL, `enderchest2` LONGTEXT NOT NULL, `enderchest3` LONGTEXT NOT NULL, `enderchest4` LONGTEXT NOT NULL, `enderchest5` LONGTEXT NOT NULL, `odblokowane_kamien` int(100) NOT NULL, `odblokowane_zabojstw` int(100) NOT NULL, `odblokowane_zgonow` int(100) NOT NULL, `odblokowane_kox` int(100) NOT NULL, `odblokowane_refil` int(100) NOT NULL, `firstIP` varchar(100) NOT NULL, `lastIP` varchar(100) NOT NULL, `firstJoin` bigint(22) NOT NULL, `schowek_kox` int NOT NULL, `schowek_refy` int NOT NULL, `schowek_perly` int NOT NULL, `prestiz` int NOT NULL, `kit_start` bigint(64) NOT NULL, `kit_yt` bigint(22) NOT NULL, `kit_vip` bigint(22) NOT NULL, `kit_svip` bigint(22) NOT NULL, `kit_tnt` bigint(22) NOT NULL, `turboDrop` bigint(22) NOT NULL, `turboExp` bigint(22) NOT NULL, `ochrona` bigint(22) NOT NULL,`home1` varchar(255) NOT NULL,`home2` varchar(255) NOT NULL,`home3` varchar(255) NOT NULL,`home4` varchar(255) NOT NULL,`home5` varchar(255) NOT NULL, `lastKill` varchar(32) NOT NULL, `lastKillTime` bigint(22) NOT NULL, `god` int(1) NOT NULL, `lvl` int(100) NOT NULL, `exp` int(100) NOT NULL, `group` varchar(32) NOT NULL, `pandora` int NOT NULL, `klucze` int NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_roles` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `tag` varchar(32) NOT NULL, `name` varchar(255) NOT NULL, `upr_lava` int(1) NOT NULL, `upr_water` int(1) NOT NULL, `upr_break_obsidian` int(1) NOT NULL, `upr_break_stone` int(1) NOT NULL, `upr_place_obsidian` int(1) NOT NULL, `upr_place_stone` int(1) NOT NULL, `upr_chest` int(1) NOT NULL, `upr_tnt` int(1) NOT NULL, `upr_boyfarmer` int(1) NOT NULL, `upr_lapis` int(1) NOT NULL, `upr_logblock` int(1) NOT NULL, `upr_furnace` int(1) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_guilds` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `tag` varchar(5) NOT NULL, `name` varchar(32) NOT NULL, `owner` varchar(64) NOT NULL, `leader` varchar(64) NOT NULL, `cuboidX` int(100) NOT NULL, `cuboidZ` int(100) NOT NULL, `cuboidSize` int(100) NOT NULL, `hp` int(100) NOT NULL, `life` int(100) NOT NULL, `lifeLastAttack` bigint(22) NOT NULL, `prolong` bigint(22) NOT NULL, `pvp` int(2) NOT NULL, `createTime` bigint(22) NOT NULL, `homeX` double NOT NULL, `homeY` double NOT NULL, `homeZ` double NOT NULL, `ally` varchar(255) NOT NULL, `points` int(100) NOT NULL, `sojusz` int(100) NOT NULL, `kills` int(100) NOT NULL, `deaths` int(100) NOT NULL,`pvpAlly` int(1) NOT NULL, `limitSize` int(100) NOT NULL, `tntKaraTime` bigint(32) NOT NULL, `head` int(100) NOT NULL, `limitMembers` int(100) NOT NULL, `skarbiec` int(100) NOT NULL, `skrzynka1` LONGTEXT NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_members` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL,`tag` varchar(5) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_wars` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `tag` varchar(32) NOT NULL,`tag2` varchar(32) NOT NULL,`name` varchar(32) NOT NULL,`kills` int(100) NOT NULL,`deaths` int(100) NOT NULL,`time` bigint(32) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_logblock` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `tag` varchar(32) NOT NULL, `location` varchar(255) NOT NULL,`mid` int(100) NOT NULL,`name` varchar(32) NOT NULL,`type` varchar(32) NOT NULL, `time` bigint(32) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_lock` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `tag` varchar(32) NOT NULL, `nick` varchar(255) NOT NULL, `location` varchar(255) NOT NULL);");
            DatabaseLoader.store.update(true, "CREATE TABLE IF NOT EXISTS `pCGuilds_wings` (`id` int(100) NOT NULL PRIMARY KEY AUTO_INCREMENT, `name` varchar(32) NOT NULL, `wings` varchar(255) NOT NULL);");
        }
    }
}
