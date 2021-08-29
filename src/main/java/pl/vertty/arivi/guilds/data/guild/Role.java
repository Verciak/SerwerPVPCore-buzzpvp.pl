// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.data.guild;

import java.sql.SQLException;
import java.sql.ResultSet;
import pl.vertty.arivi.Main;

public class Role
{
    public boolean upr_Tnt;
    public boolean upr_Water;
    public boolean upr_Break_Obsidian;
    public String name;
    public boolean upr_Furnace;
    public boolean upr_Chest;
    public boolean upr_Boyfarmer;
    public boolean upr_Lava;
    public String tag;
    public boolean upr_Logblock;
    public boolean upr_Place_Obsidian;
    public boolean upr_Lapis;
    public boolean upr_Place_Stone;
    public boolean upr_Break_Stone;
    
    public void setUpr_Chest(final boolean upr_Chest) {
        this.upr_Chest = upr_Chest;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_chest` = '").append(this.isUpr_Chest() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isUpr_Chest() {
        return this.upr_Chest;
    }
    
    public boolean isUpr_Lapis() {
        return this.upr_Lapis;
    }
    
    public void setUpr_Lapis(final boolean upr_Lapis) {
        this.upr_Lapis = upr_Lapis;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_lapis` = '").append(this.isUpr_Lapis() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public String getName() {
        return this.name;
    }
    
    public Role(final String tag, final String name) {
        this.tag = tag;
        this.name = name;
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
        this.upr_Logblock = false;
        this.upr_Furnace = false;
        this.insert();
    }
    
    public void setUpr_Tnt(final boolean upr_Tnt) {
        this.upr_Tnt = upr_Tnt;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_tnt` = '").append(this.isUpr_Tnt() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setUpr_Break_Obsidian(final boolean upr_Break_Obsidian) {
        this.upr_Break_Obsidian = upr_Break_Obsidian;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_break_obsidian` = '").append(this.isUpr_Break_Obsidian() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setUpr_Place_Obsidian(final boolean upr_Place_Obsidian) {
        this.upr_Place_Obsidian = upr_Place_Obsidian;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_place_obsidian` = '").append(this.isUpr_Place_Obsidian() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isUpr_Boyfarmer() {
        return this.upr_Boyfarmer;
    }
    
    public void setName(final String s) {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `name` = '").append(s).append("' WHERE `name` ='").append(this.getName()).append("';")));
        this.name = s;
    }
    
    public void setUpr_Boyfarmer(final boolean upr_Boyfarmer) {
        this.upr_Boyfarmer = upr_Boyfarmer;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_boyfarmer` = '").append(this.isUpr_Boyfarmer() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isUpr_Place_Obsidian() {
        return this.upr_Place_Obsidian;
    }
    
    public boolean isUpr_Break_Obsidian() {
        return this.upr_Break_Obsidian;
    }
    
    public void setUpr_Water(final boolean upr_Water) {
        this.upr_Water = upr_Water;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_water` = '").append(this.isUpr_Water() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setUpr_Break_Stone(final boolean upr_Break_Stone) {
        this.upr_Break_Stone = upr_Break_Stone;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_break_stone` = '").append(this.isUpr_Break_Stone() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setUpr_Place_Stone(final boolean upr_Place_Stone) {
        this.upr_Place_Stone = upr_Place_Stone;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_place_stone` = '").append(this.isUpr_Place_Stone() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isUpr_Break_Stone() {
        return this.upr_Break_Stone;
    }
    
    public Role(final ResultSet set) throws SQLException {
        this.tag = set.getString("tag");
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
        this.upr_Logblock = (set.getInt("upr_logblock") == 1);
        this.upr_Furnace = (set.getInt("upr_furnace") == 1);
    }
    
    public boolean isUpr_Place_Stone() {
        return this.upr_Place_Stone;
    }
    
    public void setTag(final String tag) {
        this.tag = tag;
    }
    
    public void setUpr_Logblock(final boolean upr_Logblock) {
        this.upr_Logblock = upr_Logblock;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_logblock` = '").append(this.isUpr_Logblock() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isUpr_Logblock() {
        return this.upr_Logblock;
    }
    
    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_roles`(`id`, `tag`, `name`, `upr_lava`, `upr_water`, `upr_break_obsidian`, `upr_break_stone`, `upr_place_obsidian`, `upr_place_stone`, `upr_chest`, `upr_tnt`, `upr_boyfarmer`, `upr_lapis`, `upr_logblock`, `upr_furnace`) VALUES (NULL, '").append(this.getTag()).append("','").append(this.getName()).append("','").append(this.isUpr_Lava() ? 1 : 0).append("','").append(this.isUpr_Water() ? 1 : 0).append("','").append(this.isUpr_Break_Obsidian() ? 1 : 0).append("','").append(this.isUpr_Break_Stone() ? 1 : 0).append("','").append(this.isUpr_Place_Obsidian() ? 1 : 0).append("','").append(this.isUpr_Place_Stone() ? 1 : 0).append("','").append(this.isUpr_Chest() ? 1 : 0).append("','").append(this.isUpr_Tnt() ? 1 : 0).append("','").append(this.isUpr_Boyfarmer() ? 1 : 0).append("','").append(this.isUpr_Lapis() ? 1 : 0).append("','").append(this.isUpr_Logblock() ? 1 : 0).append("','").append(this.isUpr_Furnace() ? 1 : 0).append("')")));
    }
    
    public void setUpr_Furnace(final boolean upr_Furnace) {
        this.upr_Furnace = upr_Furnace;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_furnace` = '").append(this.isUpr_Furnace() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
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
    
    public String getTag() {
        return this.tag;
    }
    
    public boolean isUpr_Lava() {
        return this.upr_Lava;
    }
    
    public void setUpr_Lava(final boolean upr_Lava) {
        this.upr_Lava = upr_Lava;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_roles` SET `upr_lava` = '").append(this.isUpr_Lava() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
}
