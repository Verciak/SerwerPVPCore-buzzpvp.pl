package pl.vertty.arivi.objects;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Role
{
    public String name;
    public boolean upr_Tnt;
    public boolean upr_Water;
    public boolean upr_Furnace;
    public boolean upr_Chest;
    public boolean upr_Boyfarmer;
    public boolean upr_Lava;
    public boolean upr_Lapis;
    public boolean upr_perms;
    public boolean upr_Break_Obsidian;
    public boolean upr_Place_Obsidian;
    public boolean upr_Place_Stone;
    public boolean upr_Break_Stone;

    public boolean upr_addMember;
    public boolean upr_removeMember;
    public boolean upr_base_teleport;
    public boolean upr_pvpguild;
    public boolean upr_pvpally;
    public boolean upr_withdrawchest;
    public boolean upr_guildchest;

    private void insert() {
        Main.getStore().asyncUpdate("INSERT INTO `pCGuilds_roles`(`id`, `name`, `upr_lava`, `upr_water`, `upr_break_obsidian`, `upr_break_stone`, `upr_place_obsidian`, `upr_place_stone`, `upr_chest`, `upr_tnt`, `upr_boyfarmer`, `upr_lapis`, `upr_furnace`, `upr_perms`, `upr_addMember`, `upr_removeMember`, `upr_base_teleport`, `upr_pvpguild`, `upr_pvpally`, `upr_withdrawchest`, `upr_guildchest`) VALUES (NULL, '" + this.getName() + "','" + (this.isUpr_Lava() ? 1 : 0) + "','" + (this.isUpr_Water() ? 1 : 0) + "','" + (this.isUpr_Break_Obsidian() ? 1 : 0) + "','" + (this.isUpr_Break_Stone() ? 1 : 0) + "','" + (this.isUpr_Place_Obsidian() ? 1 : 0) + "','" + (this.isUpr_Place_Stone() ? 1 : 0) + "','" + (this.isUpr_Chest() ? 1 : 0) + "','" + (this.isUpr_Tnt() ? 1 : 0) + "','" + (this.isUpr_Boyfarmer() ? 1 : 0) + "','" + (this.isUpr_Lapis() ? 1 : 0) + "','" + (this.isUpr_Furnace() ? 1 : 0) + "','" + (this.isUpr_perms() ? 1 : 0) + "','" + (this.isUpr_addMember() ? 1 : 0) + "','" + (this.isUpr_removeMember() ? 1 : 0) + "','" + (this.isUpr_base_teleport() ? 1 : 0) + "','" + (this.isUpr_pvpguild() ? 1 : 0) + "','" + (this.isUpr_pvpally() ? 1 : 0) + "','" + (this.isUpr_withdrawchest() ? 1 : 0) + "','" + (this.isUpr_guildchest() ? 1 : 0) + "')");
    }

    public boolean isUpr_addMember() {
        return upr_addMember;
    }

    public void setUpr_addMember(boolean upr_addMember) {
        this.upr_addMember = upr_addMember;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_addMember` = '" + (this.isUpr_addMember() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_removeMember() {
        return upr_removeMember;
    }

    public void setUpr_removeMember(boolean upr_removeMember) {
        this.upr_removeMember = upr_removeMember;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_removeMember` = '" + (this.isUpr_removeMember() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_base_teleport() {
        return upr_base_teleport;
    }

    public void setUpr_base_teleport(boolean upr_base_teleport) {
        this.upr_base_teleport = upr_base_teleport;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_base_teleport` = '" + (this.isUpr_base_teleport() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_pvpguild() {
        return upr_pvpguild;
    }

    public void setUpr_pvpguild(boolean upr_pvpguild) {
        this.upr_pvpguild = upr_pvpguild;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_pvpguild` = '" + (this.isUpr_pvpguild() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_pvpally() {
        return upr_pvpally;
    }

    public void setUpr_pvpally(boolean upr_pvpally) {
        this.upr_pvpally = upr_pvpally;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_pvpally` = '" + (this.isUpr_pvpally() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_withdrawchest() {
        return upr_withdrawchest;
    }

    public void setUpr_withdrawchest(boolean upr_withdrawchest) {
        this.upr_withdrawchest = upr_withdrawchest;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_withdrawchest` = '" + (this.isUpr_withdrawchest() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_guildchest() {
        return upr_guildchest;
    }

    public void setUpr_guildchest(boolean upr_guildchest) {
        this.upr_guildchest = upr_guildchest;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_guildchest` = '" + (this.isUpr_guildchest() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public void setUpr_Chest(final boolean upr_Chest) {
        this.upr_Chest = upr_Chest;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_chest` = '" + (this.isUpr_Chest() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_Chest() {
        return this.upr_Chest;
    }

    public boolean isUpr_Lapis() {
        return this.upr_Lapis;
    }

    public void setUpr_Lapis(final boolean upr_Lapis) {
        this.upr_Lapis = upr_Lapis;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_lapis` = '" + (this.isUpr_Lapis() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public String getName() {
        return this.name;
    }

    public Role(final Player name) {
        this.name = name.getName();
        this.upr_Lava = false;
        this.upr_Water = false;
        this.upr_Break_Obsidian = false;
        this.upr_Break_Stone = false;
        this.upr_Place_Obsidian = false;
        this.upr_Place_Stone = false;
        this.upr_Chest = false;
        this.upr_Tnt = false;
        this.upr_Boyfarmer = false;
        this.upr_Lapis = false;
        this.upr_Furnace = false;
        this.upr_perms = false;

        this.upr_addMember = false;
        this.upr_removeMember = false;
        this.upr_base_teleport = false;
        this.upr_pvpguild = false;
        this.upr_pvpally = false;
        this.upr_withdrawchest = false;
        this.upr_guildchest = false;
        this.insert();
    }

    public void setUpr_perms(final boolean upr_perms) {
        this.upr_perms = upr_perms;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_perms` = '" + (this.isUpr_perms() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    public boolean isUpr_perms() {
        return this.upr_perms;
    }



    public void setUpr_Tnt(final boolean upr_Tnt) {
        this.upr_Tnt = upr_Tnt;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_tnt` = '" + (this.isUpr_Tnt() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public void setUpr_Break_Obsidian(final boolean upr_Break_Obsidian) {
        this.upr_Break_Obsidian = upr_Break_Obsidian;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_break_obsidian` = '" + (this.isUpr_Break_Obsidian() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public void setUpr_Place_Obsidian(final boolean upr_Place_Obsidian) {
        this.upr_Place_Obsidian = upr_Place_Obsidian;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_place_obsidian` = '" + (this.isUpr_Place_Obsidian() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_Boyfarmer() {
        return this.upr_Boyfarmer;
    }

    public void setName(final String s) {
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `name` = '" + s + "' WHERE `name` ='" + this.getName() + "';");
        this.name = s;
    }

    public void setUpr_Boyfarmer(final boolean upr_Boyfarmer) {
        this.upr_Boyfarmer = upr_Boyfarmer;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_boyfarmer` = '" + (this.isUpr_Boyfarmer() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_Place_Obsidian() {
        return this.upr_Place_Obsidian;
    }

    public boolean isUpr_Break_Obsidian() {
        return this.upr_Break_Obsidian;
    }

    public void setUpr_Water(final boolean upr_Water) {
        this.upr_Water = upr_Water;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_water` = '" + (this.isUpr_Water() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public void setUpr_Break_Stone(final boolean upr_Break_Stone) {
        this.upr_Break_Stone = upr_Break_Stone;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_break_stone` = '" + (this.isUpr_Break_Stone() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public void setUpr_Place_Stone(final boolean upr_Place_Stone) {
        this.upr_Place_Stone = upr_Place_Stone;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_place_stone` = '" + (this.isUpr_Place_Stone() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_Break_Stone() {
        return this.upr_Break_Stone;
    }

    public Role(final ResultSet set) throws SQLException {
        this.name = set.getString("name");
        this.upr_Lava = (set.getInt("upr_lava") == 1);
        this.upr_Water = (set.getInt("upr_water") == 1);
        this.upr_Break_Obsidian = (set.getInt("upr_break_obsidian") == 1);
        this.upr_Break_Stone = (set.getInt("upr_break_stone") == 1);
        this.upr_Place_Obsidian = (set.getInt("upr_place_obsidian") == 1);
        this.upr_Place_Stone = (set.getInt("upr_place_stone") == 1);
        this.upr_Chest = (set.getInt("upr_chest") == 1);
        this.upr_Tnt = (set.getInt("upr_tnt") == 1);
        this.upr_Boyfarmer = (set.getInt("upr_boyfarmer") == 1);
        this.upr_Lapis = (set.getInt("upr_lapis") == 1);
        this.upr_perms = (set.getInt("upr_perms") == 1);
        this.upr_Furnace = (set.getInt("upr_furnace") == 1);
        this.upr_addMember = (set.getInt("upr_addMember") == 1);
        this.upr_removeMember = (set.getInt("upr_removeMember") == 1);
        this.upr_base_teleport = (set.getInt("upr_base_teleport") == 1);
        this.upr_pvpguild = (set.getInt("upr_pvpguild") == 1);
        this.upr_pvpally = (set.getInt("upr_pvpally") == 1);
        this.upr_withdrawchest = (set.getInt("upr_withdrawchest") == 1);
        this.upr_guildchest = (set.getInt("upr_guildchest") == 1);
    }

    public boolean isUpr_Place_Stone() {
        return this.upr_Place_Stone;
    }

    public void setUpr_Furnace(final boolean upr_Furnace) {
        this.upr_Furnace = upr_Furnace;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_furnace` = '" + (this.isUpr_Furnace() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }

    public boolean isUpr_Furnace() {
        return this.upr_Furnace;
    }

    public boolean isUpr_Tnt() {
        return this.upr_Tnt;
    }

    public boolean isUpr_Water() {
        return this.upr_Water;
    }

    public boolean isUpr_Lava() {
        return this.upr_Lava;
    }

    public void setUpr_Lava(final boolean upr_Lava) {
        this.upr_Lava = upr_Lava;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_roles` SET `upr_lava` = '" + (this.isUpr_Lava() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
}
