package pl.vertty.arivi.guilds.data;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.utils.ChatUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User
{
    public int kratki;
    private final List<Player> ignoreTell;
    public static boolean skarbiec_eme;
    public static boolean skarbiec_head;
    public static boolean update_name;
    public static boolean war_create;
    public static boolean war_stop;
    public static boolean upr_Logblock;
    public static boolean upr_Break_Stone;
    public int asysts;
    public boolean upr_Chest;
    public String lastkill;
    public boolean upr_Boyfarmer;
    public int points;
    public boolean upr_Break_Obsidian;
    public String name;
    public boolean upr_Water;
    public boolean incognitoNick;
    public boolean incognitoSkin;
    public boolean incognitoGuild;
    public int deaths;
    public String role;
    public boolean upr_Furnace;
    public boolean upr_Lapis;
    public int kills;
    public boolean upr_Place_Obsidian;
    public boolean upr_Lava;
    public boolean upr_Place_Stone;
    public boolean upr_Tnt;
    private long lastChat;
    private final String firstIP;
    private final String lastIP;
    private final long firstJoin;
    private int schowek_kox;
    private int schowek_refy;
    private int schowek_perly;
    private int schowek_sniezki;
    private int schowek_arrow;
    private int schowek_tnt;
    private long kit_mieso;
    private long kit_start;
    private long kit_yt;
    private long kit_vip;
    private long kit_svip;
    private long kit_tnt;
    private final long turboDrop;
    private final long turboExp;
    private long ochrona;
    private boolean teleport;

    private final List<Player> tpa;
    private String home1;
    private String home2;
    private String home3;
    private String home4;
    private String home5;
    private long lastHelpop;
    private final long lastPearl;
    private String lastKill;
    private long lastKillTime;
    private boolean god;
    private int lvl;
    private int exp;
    private GroupType group;
    private int kamien;
    private int kox;
    private int refil;
    private int perla;
    private int pandora;
    private long speedminePerSecondTime;
    public int speedminePerSecond;
    private long packetsPerSecondTime;
    public int packetsPerSecond;
    private long macroPerSecondTime;
    public int macroPerSecond;
    private long entityPerSecondTime;
    public int entityPerSecond;

    public boolean hasMacroLimit() {
        return this.macroPerSecond > 12;
    }
    public boolean entityLimit() {
        if (this.entityPerSecondTime < System.currentTimeMillis()) {
            this.entityPerSecondTime = System.currentTimeMillis() + 1000L;
            this.entityPerSecond = 0;
        }
        return ++this.entityPerSecond >= 60;
    }

    public boolean speedmineLimit(boolean isHalf) {
        if (this.speedminePerSecondTime < System.currentTimeMillis()) {
            this.speedminePerSecondTime = System.currentTimeMillis() + (isHalf ? 500L : 1000L);
            this.speedminePerSecond = 0;
        }
        return ++this.speedminePerSecond >= (isHalf ? 4 : 10);
    }

    public boolean macroLimit() {
        if (this.macroPerSecondTime < System.currentTimeMillis()) {
            this.macroPerSecondTime = System.currentTimeMillis() + 1000L;
            this.macroPerSecond = 0;
        }
        return ++this.macroPerSecond > 12;
    }

    public boolean hasMacroMax() {
        return this.macroPerSecond >= 100;
    }

    public boolean packetLimit() {
        if (this.packetsPerSecondTime < System.currentTimeMillis()) {
            this.packetsPerSecondTime = System.currentTimeMillis() + 1000L;
            this.packetsPerSecond = 0;
        }
        return ++this.packetsPerSecond > 450;
    }
    
    public boolean isUpr_Logblock() {
        return User.upr_Logblock;
    }
    
    private void insert() {
        Main.getStore().asyncUpdate("INSERT INTO `pCGuilds_users`(`id`, `name`, `points`, `kills`, `deaths`, `asysts`, `upr_lava`, `upr_water`, `upr_break_obsidian`, `upr_break_stone`, `upr_place_obsidian`, `upr_place_stone`, `upr_chest`, `upr_tnt`, `upr_boyfarmer`, `upr_lapis`, `upr_logblock`, `upr_furnace`, `incognitoNick`, `incognitoSkin`, `incognitoGuild`, `role`, `kamien`,`kox`,`refil`, `perla`,`firstIP`, `lastIP`, `firstJoin`, `schowek_kox`, `schowek_refy`, `schowek_perly`, `schowek_sniezki`, `schowek_arrow`, `schowek_tnt`, `kit_start`, `kit_yt`, `kit_vip`, `kit_svip`, `kit_tnt`, `turboDrop`, `turboExp`, `ochrona`, `home1`,`home2`,`home3`,`home4`,`home5`, `lastKill`, `lastKillTime`, `god`, `lvl`, `exp`, `group`, `pandora`) VALUES (NULL, '" + this.getName() + "','" + this.getPoints() + "','" + this.getKills() + "','" + this.getDeaths() + "','" + this.getAsysts() + "','" + (this.isUpr_Lava() ? 1 : 0) + "','" + (this.isUpr_Water() ? 1 : 0) + "','" + (this.isUpr_Break_Obsidian() ? 1 : 0) + "','" + (this.isUpr_Break_Stone() ? 1 : 0) + "','" + (this.isUpr_Place_Obsidian() ? 1 : 0) + "','" + (this.isUpr_Place_Stone() ? 1 : 0) + "','" + (this.isUpr_Chest() ? 1 : 0) + "','" + (this.isUpr_Tnt() ? 1 : 0) + "','" + (this.isUpr_Boyfarmer() ? 1 : 0) + "','" + (this.isUpr_Lapis() ? 1 : 0) + "','" + (this.isUpr_Logblock() ? 1 : 0) + "','" + (this.isUpr_Furnace() ? 1 : 0) + "','" + (this.isIncognitoNick() ? 1 : 0) + "','" + (this.isIncognitoSkin() ? 1 : 0) + "','" + (this.isIncognitoGuild() ? 1 : 0) + "','" + this.getRole() + "','" + this.getkamien() + "','" + this.getkox() + "','" + this.getrefil() + "','" + this.getperla() + "','" + this.getFirstIP() + "','" + this.getLastIP() + "','" + this.getFirstJoin() + "','" + this.getKox() + "','" + this.getRefy() + "','" + this.getPerly() + "','" + this.getSniezki() + "','" + this.getArrow() + "','" + this.getTnt() + "','" + this.getKit_start() + "','" + this.getKit_yt() + "','" + this.getKit_vip() + "','" + this.getKit_svip() + "','" + this.getKit_tnt() + "','" + this.getTurboDrop() + "','" + this.getTurboExp() + "','" + this.getOchrona() + "','" + this.getHome1() + "','" + this.getHome2() + "','" + this.getHome3() + "','" + this.getHome4() + "','" + this.getHome5() + "','" + this.getLastKill() + "','" + this.getLastKillTime() + "','" + (this.isGod() ? 1 : 0) + "','" + this.getLvl() + "','" + this.getExp() + "','" + this.getGroup() + "','" + this.getPandora() + "')");
    }
    
    public boolean isUpr_Boyfarmer() {
        return this.upr_Boyfarmer;
    }

    public void setKills(final int kills) {
        this.kills = kills;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kills` = '" + this.getKills() + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isIncognitoSkin() {
        return this.incognitoSkin;
    }
    
    public boolean isIncognitoGuild() {
        return this.incognitoGuild;
    }
    
    public int getKills() {
        return this.kills;
    }
    
    public void setUpr_Break_Stone(final boolean upr_Break_Stone) {
        User.upr_Break_Stone = upr_Break_Stone;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_break_stone` = '" + (this.isUpr_Break_Stone() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isUpr_Furnace() {
        return this.upr_Furnace;
    }
    
    public boolean isUpr_Place_Stone() {
        return this.upr_Place_Stone;
    }
    
    public boolean isUpr_Lava() {
        return this.upr_Lava;
    }
    
    public int getAsysts() {
        return this.asysts;
    }
    
    public void setUpr_Place_Stone(final boolean upr_Place_Stone) {
        this.upr_Place_Stone = upr_Place_Stone;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_place_stone` = '" + (this.isUpr_Place_Stone() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setAsysts(final int asysts) {
        this.asysts = asysts;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `asysts` = '" + this.getAsysts() + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isUpr_Water() {
        return this.upr_Water;
    }
    
    public User(final ResultSet set) throws SQLException {
        this.name = set.getString("name");
        this.points = set.getInt("points");
        this.kills = set.getInt("kills");
        this.deaths = set.getInt("deaths");
        this.pandora = set.getInt("pandora");
        this.asysts = set.getInt("asysts");
        this.upr_Lava = (set.getInt("upr_lava") == 1);
        this.upr_Water = (set.getInt("upr_water") == 1);
        this.upr_Break_Obsidian = (set.getInt("upr_break_obsidian") == 1);
        upr_Break_Stone = (set.getInt("upr_break_stone") == 1);
        this.upr_Place_Obsidian = (set.getInt("upr_place_obsidian") == 1);
        this.upr_Place_Stone = (set.getInt("upr_place_stone") == 1);
        this.upr_Chest = (set.getInt("upr_chest") == 1);
        this.upr_Tnt = (set.getInt("upr_tnt") == 1);
        this.upr_Boyfarmer = (set.getInt("upr_boyfarmer") == 1);
        this.upr_Lapis = (set.getInt("upr_lapis") == 1);
        upr_Logblock = (set.getInt("upr_logblock") == 1);
        this.upr_Furnace = (set.getInt("upr_furnace") == 1);
        this.incognitoNick = (set.getInt("incognitoNick") == 1);
        this.incognitoSkin = (set.getInt("incognitoSkin") == 1);
        this.incognitoGuild = (set.getInt("incognitoGuild") == 1);
        this.lastkill = "";
        this.role = set.getString("role");
        skarbiec_eme = false;
        skarbiec_head = false;
        update_name = false;
        war_create = false;
        war_stop = false;
        this.kamien = set.getInt("kamien");
        this.kox = set.getInt("kox");
        this.refil = set.getInt("refil");
        this.perla = set.getInt("perla");
        this.firstIP = set.getString("firstIP");
        this.lastIP = set.getString("lastIP");
        this.firstJoin = set.getLong("firstJoin");
        this.schowek_kox = set.getInt("schowek_kox");
        this.schowek_perly = set.getInt("schowek_perly");
        this.schowek_refy = set.getInt("schowek_refy");
        this.schowek_sniezki = set.getInt("schowek_sniezki");
        this.schowek_arrow = set.getInt("schowek_arrow");
        this.schowek_tnt = set.getInt("schowek_tnt");
        this.kit_mieso = 0L;
        this.kit_start = set.getLong("kit_start");
        this.kit_yt = set.getLong("kit_yt");
        this.kit_vip = set.getLong("kit_vip");
        this.kit_svip = set.getLong("kit_svip");
        this.kit_tnt = set.getLong("kit_tnt");
        this.turboDrop = set.getLong("turboDrop");
        this.turboExp = set.getLong("turboExp");
        this.home1 = set.getString("home1");
        this.home2 = set.getString("home2");
        this.home3 = set.getString("home3");
        this.home4 = set.getString("home4");
        this.home5 = set.getString("home5");
        this.lastKill = set.getString("lastKill");
        this.lastKillTime = set.getLong("lastKillTime");
        this.lastChat = 0L;
        this.kratki = 0;
        this.god = (set.getInt("god") == 1);
        this.lvl = set.getInt("lvl");
        this.exp = set.getInt("exp");
        this.ochrona = set.getLong("ochrona");
        this.teleport = false;
        this.ignoreTell = new ArrayList<>();
        this.tpa = new ArrayList<>();
        this.lastHelpop = 0L;
        this.lastPearl = 0L;
        this.group = GroupType.valueOf(set.getString("group"));
    }

    
    public int getPandora() {
        return this.pandora;
    }
    
    public void setPandora(final int toSet) {
        this.pandora = toSet;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `pandora` ='" + this.getPandora() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void addPandora(final int toAdd) {
        this.pandora += toAdd;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `pandora` ='" + this.getPandora() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public Location getHome1Location() {
        return ChatUtil.locFromString(this.getHome1());
    }
    
    public Location getHome2Location() {
        return ChatUtil.locFromString(this.getHome2());
    }
    
    public Location getHome3Location() {
        return ChatUtil.locFromString(this.getHome3());
    }
    
    public Location getHome4Location() {
        return ChatUtil.locFromString(this.getHome4());
    }
    
    public Location getHome5Location() {
        return ChatUtil.locFromString(this.getHome5());
    }
    
    public String getHome1() {
        return this.home1;
    }
    
    public void setHome1(final Location home1) {
        this.home1 = ChatUtil.locToString(home1);
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `home1` ='" + this.getHome1() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public String getHome2() {
        return this.home2;
    }
    
    public void setHome2(final Location home2) {
        this.home2 = ChatUtil.locToString(home2);
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `home2` ='" + this.getHome2() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public String getHome3() {
        return this.home3;
    }
    
    public void setHome3(final Location home3) {
        this.home3 = ChatUtil.locToString(home3);
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `home3` ='" + this.getHome3() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public String getHome4() {
        return this.home4;
    }
    
    public void setHome4(final Location home4) {
        this.home4 = ChatUtil.locToString(home4);
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `home4` ='" + this.getHome4() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public String getHome5() {
        return this.home5;
    }
    
    public void setHome5(final Location home5) {
        this.home5 = ChatUtil.locToString(home5);
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `home5` ='" + this.getHome5() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public int getkamien() {
        return this.kamien;
    }
    
    public void setkamien(final int l) {
        this.kamien = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `kamien` ='" + this.getkamien() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public int getkox() {
        return this.kox;
    }
    
    public void setkox(final int l) {
        this.kox = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `kox` ='" + this.getkox() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public int getperla() {
        return this.perla;
    }

    public void serperla(final int l) {
        this.perla = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `perla` ='" + this.getperla() + "' WHERE `name` ='" + this.getName() + "'");
    }


    public int getrefil() {
        return this.refil;
    }
    
    public void setrefil(final int l) {
        this.refil = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `refil` ='" + this.getrefil() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public int getKox() {
        return this.schowek_kox;
    }
    
    public void addKox(final int l) {
        this.schowek_kox = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_kox` ='" + this.getKox() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public int getRefy() {
        return this.schowek_refy;
    }
    
    public void addRefy(final int l) {
        this.schowek_refy = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_refy` ='" + this.getRefy() + "' WHERE `name` ='" + this.getName() + "'");
    }


    public int getArrow() {
        return this.schowek_arrow;
    }

    public void addArrow(final int l) {
        this.schowek_arrow = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_arrow` ='" + this.getArrow() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public void removeArrow(final int l) {
        this.schowek_arrow -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_arrow` ='" + this.getArrow() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public int getTnt() {
        return this.schowek_tnt;
    }

    public void addTnt(final int l) {
        this.schowek_tnt = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_tnt` ='" + this.getTnt() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public void removeTnt(final int l) {
        this.schowek_tnt -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_tnt` ='" + this.getTnt() + "' WHERE `name` ='" + this.getName() + "'");
    }


    public int getSniezki() {
        return this.schowek_sniezki;
    }

    public void addSniezki(final int l) {
        this.schowek_sniezki = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_sniezki` ='" + this.getSniezki() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public void removeSniezki(final int l) {
        this.schowek_sniezki -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_sniezki` ='" + this.getSniezki() + "' WHERE `name` ='" + this.getName() + "'");
    }




    
    public int getPerly() {
        return this.schowek_perly;
    }
    
    public void addPerly(final int l) {
        this.schowek_perly = l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_perly` ='" + this.getPerly() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void removeKox(final int l) {
        this.schowek_kox -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_kox` ='" + this.getKox() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void removeRefy(final int l) {
        this.schowek_refy -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_refy` ='" + this.getRefy() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void removePerly(final int l) {
        this.schowek_perly -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `schowek_perly` ='" + this.getPerly() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void setTeleport(final boolean teleport) {
        this.teleport = teleport;
    }
    
    public boolean isTeleport() {
        return this.teleport;
    }
    
    public long getOchrona() {
        return this.ochrona;
    }
    
    public void setOchrona(final long l) {
        this.ochrona = l;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `ochrona` ='" + this.getOchrona() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public boolean isLastHelpop() {
        return this.getLastHelpop() > System.currentTimeMillis();
    }
    
    public long getLastHelpop() {
        return this.lastHelpop;
    }
    
    public void setLastHelpop(final long lastHelpop) {
        this.lastHelpop = lastHelpop;
    }

    public GroupType getGroup() {
        return this.group;
    }
    
    public List<Player> getTpa() {
        return this.tpa;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFirstIP() {
        return this.firstIP;
    }
    
    public String getLastIP() {
        return this.lastIP;
    }
    
    public long getFirstJoin() {
        return this.firstJoin;
    }
    
    public long getKit_mieso() {
        return this.kit_mieso;
    }
    
    public void setKit_mieso(final long kit_mieso) {
        this.kit_mieso = kit_mieso;
    }
    
    public long getKit_start() {
        return this.kit_start;
    }
    
    public void setKit_start(final long kit_start) {
        this.kit_start = kit_start;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kit_start`='" + this.getKit_start() + "' WHERE `name`='" + this.getName() + "'");
    }
    
    public void setGroup(final GroupType group) {
        this.group = group;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `group`='" + this.getGroup().toString() + "' WHERE `name`='" + this.getName() + "'");
    }
    
    public long getKit_yt() {
        return this.kit_yt;
    }
    
    public void setKit_yt(final long kit_yt) {
        this.kit_yt = kit_yt;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kit_yt` ='" + this.getKit_yt() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public void setKit_tnt(final long kit_tnt) {
        this.kit_tnt = kit_tnt;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kit_tnt` ='" + this.getKit_tnt() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public long getKit_vip() {
        return this.kit_vip;
    }
    
    public long getKit_tnt() {
        return this.kit_tnt;
    }
    
    public void setKit_vip(final long kit_vip) {
        this.kit_vip = kit_vip;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kit_vip`='" + this.getKit_vip() + "' WHERE `name`='" + this.getName() + "'");
    }
    
    public long getKit_svip() {
        return this.kit_svip;
    }
    
    public void setKit_svip(final long kit_svip) {
        this.kit_svip = kit_svip;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `kit_svip`='" + this.getKit_svip() + "' WHERE `name`='" + this.getName() + "'");
    }
    
    public Player getPlayer() {
        return Server.getInstance().getPlayer(this.getName());
    }
    
    public boolean can(final GroupType gt) {
        return this.group.can(gt);
    }
    
    public String getLastKill() {
        return this.lastKill;
    }
    
    public void setLastKill(final String lastKill) {
        this.lastKill = lastKill;
    }
    
    public long getLastKillTime() {
        return this.lastKillTime;
    }
    
    public void setLastKillTime(final long lastKillTime) {
        this.lastKillTime = lastKillTime;
    }
    
    public boolean isChat() {
        return System.currentTimeMillis() > this.lastChat;
    }
    
    public void setLastChat(final long lastChat) {
        this.lastChat = lastChat;
    }
    
    public long getLastChat() {
        return this.lastChat;
    }
    
    public boolean isGod() {
        return this.god;
    }
    
    public void setGod(final boolean god) {
        this.god = god;
    }
    
    public int getLvl() {
        return this.lvl;
    }
    
    public void setLvl(final int lvl) {
        this.lvl = lvl;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `lvl` ='" + this.getLvl() + "', `exp` ='" + this.getExp() + "' WHERE `name` ='" + this.getName() + "'");
    }
    
    public int getExp() {
        return this.exp;
    }
    
    public long getTurboDrop() {
        return this.turboDrop;
    }
    
    public long getTurboExp() {
        return this.turboExp;
    }
    
    public void setExp(final int exp) {
        this.exp = exp;
    }
    
    public Guild getGuild() {
        return GuildManager.getGuild(this.getPlayer());
    }
    
    public boolean isUpr_Tnt() {
        return this.upr_Tnt;
    }
    
    public void setDeaths(final int deaths) {
        this.deaths = deaths;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `deaths` = '" + this.getDeaths() + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public int getDeaths() {
        return this.deaths;
    }
    
    public void setIncognitoSkin(final boolean incognitoSkin) {
        this.incognitoSkin = incognitoSkin;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `incognitoSkin` = '" + (this.isIncognitoSkin() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setIncognitoGuild(final boolean incognitoGuild) {
        this.incognitoGuild = incognitoGuild;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `incognitoGuild` = '" + (this.isIncognitoGuild() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Logblock(final boolean upr_Logblock) {
        User.upr_Logblock = upr_Logblock;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_logblock` = '" + (this.isUpr_Logblock() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setPoints(final int points) {
        this.points = points;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `points` = '" + this.getPoints() + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isUpr_Place_Obsidian() {
        return this.upr_Place_Obsidian;
    }
    
    public void setUpr_Tnt(final boolean upr_Tnt) {
        this.upr_Tnt = upr_Tnt;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_tnt` = '" + (this.isUpr_Tnt() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Place_Obsidian(final boolean upr_Place_Obsidian) {
        this.upr_Place_Obsidian = upr_Place_Obsidian;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_place_obsidian` = '" + (this.isUpr_Place_Obsidian() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isUpr_Break_Stone() {
        return User.upr_Break_Stone;
    }
    
    public void setUpr_Lapis(final boolean upr_Lapis) {
        this.upr_Lapis = upr_Lapis;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_lapis` = '" + (this.isUpr_Lapis() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setIncognitoNick(final boolean incognitoNick) {
        this.incognitoNick = incognitoNick;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `incognitoNick` = '" + (this.isIncognitoNick() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isUpr_Break_Obsidian() {
        return this.upr_Break_Obsidian;
    }
    
    public void setUpr_Break_Obsidian(final boolean upr_Break_Obsidian) {
        this.upr_Break_Obsidian = upr_Break_Obsidian;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_break_obsidian` = '" + (this.isUpr_Break_Obsidian() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Lava(final boolean upr_Lava) {
        this.upr_Lava = upr_Lava;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_lava` = '" + (this.isUpr_Lava() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Furnace(final boolean upr_Furnace) {
        this.upr_Furnace = upr_Furnace;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_furnace` = '" + (this.isUpr_Furnace() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public String getRole() {
        return this.role;
    }
    
    public void setRole(final String role) {
        this.role = role;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `role` = '" + this.getRole() + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public boolean isIncognitoNick() {
        return this.incognitoNick;
    }
    
    public boolean isUpr_Lapis() {
        return this.upr_Lapis;
    }
    
    public void setUpr_Chest(final boolean upr_Chest) {
        this.upr_Chest = upr_Chest;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_chest` = '" + (this.isUpr_Chest() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Boyfarmer(final boolean upr_Boyfarmer) {
        this.upr_Boyfarmer = upr_Boyfarmer;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_boyfarmer` = '" + (this.isUpr_Boyfarmer() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public void setUpr_Water(final boolean upr_Water) {
        this.upr_Water = upr_Water;
        Main.getStore().asyncUpdate("UPDATE `pCGuilds_users` SET `upr_water` = '" + (this.isUpr_Water() ? 1 : 0) + "' WHERE `name` ='" + this.getName() + "';");
    }
    
    public User(final Player player) {
        this.name = player.getName();
        this.kratki = 0;
        this.points = 1000;
        this.kills = 0;
        this.deaths = 0;
        this.asysts = 0;
        this.upr_Lava = true;
        this.upr_Water = true;
        this.upr_Break_Obsidian = true;
        upr_Break_Stone = true;
        this.upr_Place_Obsidian = true;
        this.upr_Place_Stone = true;
        this.upr_Chest = true;
        this.upr_Tnt = true;
        this.upr_Boyfarmer = true;
        this.upr_Lapis = true;
        upr_Logblock = true;
        this.upr_Furnace = true;
        this.incognitoNick = false;
        this.incognitoSkin = false;
        this.lastkill = "";
        this.role = "";
        this.ignoreTell = new ArrayList<>();
        skarbiec_eme = false;
        skarbiec_head = false;
        update_name = false;
        war_create = false;
        war_stop = false;
        this.kamien = 0;
        this.kox = 0;
        this.refil = 0;
        this.perla = 0;
        this.pandora = 0;
        this.firstIP = player.getAddress();
        this.lastIP = player.getAddress();
        this.firstJoin = System.currentTimeMillis();
        this.schowek_kox = 0;
        this.schowek_refy = 0;
        this.schowek_perly = 0;
        this.schowek_sniezki = 0;
        this.schowek_arrow = 0;
        this.schowek_tnt = 0;
        this.kit_mieso = 0L;
        this.kit_start = 0L;
        this.kit_yt = 0L;
        this.kit_vip = 0L;
        this.kit_svip = 0L;
        this.kit_tnt = 0L;
        this.home1 = ChatUtil.locToString(0.0, 0.0, 0.0);
        this.home2 = ChatUtil.locToString(0.0, 0.0, 0.0);
        this.home3 = ChatUtil.locToString(0.0, 0.0, 0.0);
        this.home4 = ChatUtil.locToString(0.0, 0.0, 0.0);
        this.home5 = ChatUtil.locToString(0.0, 0.0, 0.0);
        this.lastKill = "-";
        this.lastKillTime = 0L;
        this.lastChat = 0L;
        this.god = false;
        this.lvl = 1;
        this.exp = 0;
        this.turboDrop = 0L;
        this.turboExp = 0L;
        this.ochrona = System.currentTimeMillis() + TimeUtil.MINUTE.getTime(3);
        this.teleport = false;
        this.tpa = new ArrayList<>();
        this.lastHelpop = 0L;
        this.lastPearl = 0L;
        this.group = GroupType.PLAYER;
        this.insert();
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public boolean isUpr_Chest() {
        return this.upr_Chest;
    }

    public boolean isIgnoreTell(Player p) {
        return this.ignoreTell.contains(p);
    }

    public void addIgnoreTell(Player p) {
        this.ignoreTell.add(p);
    }

    public void removeIgnoreTell(Player p) {
        this.ignoreTell.remove(p);
    }
}
