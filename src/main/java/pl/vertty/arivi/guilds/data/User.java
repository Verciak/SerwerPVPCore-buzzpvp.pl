// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.data;

import cn.nukkit.Server;
import cn.nukkit.OfflinePlayer;

import java.sql.SQLException;
import java.util.ArrayList;

import pl.vertty.arivi.eq.InventoryUtil;
import pl.vertty.arivi.eq.SerializerUtil;
import pl.vertty.arivi.utils.ChatUtil;
import java.sql.ResultSet;
import pl.vertty.arivi.Main;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.inventory.SimpleInventoryMenu;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.Player;
import java.util.List;

public class User
{


    public boolean status;
    public boolean sprint;
    public boolean flying;
    private String eq;
    private final SimpleInventoryMenu eq1;
    private List<Player> ignoreTell;
    public int asysts;
    public int coins;
    public String lastkill;
    public int points;
    public String name;
    public boolean incognitoNick;
    public boolean incognitoSkin;
    public int deaths;
    public int kills;
    private long lastChat;
    private String firstIP;
    private String lastIP;
    private long firstJoin;
    private int schowek_kox;
    private int schowek_refy;
    private int schowek_perly;
    private boolean teleport;
    private boolean helpop;
    private long lastHelpop;
    private long lastPearl;
    private String lastKill;
    private long lastKillTime;
    private boolean god;
    private GroupType group;
    private long speedminePerSecondTime;
    public int speedminePerSecond;
    private long packetsPerSecondTime;
    public int packetsPerSecond;
    private long macroPerSecondTime;
    public int macroPerSecond;
    private long entityPerSecondTime;
    public int entityPerSecond;

    public boolean hasMacroLimit() {
        if (this.macroPerSecond > 12) {
            return true;
        }
        return false;
    }
    public boolean entityLimit() {
        if (this.entityPerSecondTime < System.currentTimeMillis()) {
            this.entityPerSecondTime = System.currentTimeMillis() + 1000L;
            this.entityPerSecond = 0;
        }
        if (++this.entityPerSecond >= 60) {
            return true;
        }
        return false;
    }

    public boolean speedmineLimit(boolean isHalf) {
        if (this.speedminePerSecondTime < System.currentTimeMillis()) {
            this.speedminePerSecondTime = System.currentTimeMillis() + (isHalf ? 500L : 1000L);
            this.speedminePerSecond = 0;
        }
        if (++this.speedminePerSecond >= (isHalf ? 4 : 10)) {
            return true;
        }
        return false;
    }

    public boolean macroLimit() {
        if (this.macroPerSecondTime < System.currentTimeMillis()) {
            this.macroPerSecondTime = System.currentTimeMillis() + 1000L;
            this.macroPerSecond = 0;
        }
        if (++this.macroPerSecond > 12) {
            return true;
        }
        return false;
    }

    public boolean hasMacroMax() {
        if (this.macroPerSecond >= 100) {
            return true;
        }
        return false;
    }

    public boolean packetLimit() {
        if (this.packetsPerSecondTime < System.currentTimeMillis()) {
            this.packetsPerSecondTime = System.currentTimeMillis() + 1000L;
            this.packetsPerSecond = 0;
        }
        if (++this.packetsPerSecond > 450) {
            return true;
        }
        return false;
    }
    

    private void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_users`(`id`, `name`, `points`, `kills`, `deaths`, `asysts`, `incognitoNick`, `incognitoSkin`, `firstIP`, `lastIP`, `firstJoin`, `schowek_kox`, `schowek_refy`, `schowek_perly`, `lastKill`, `lastKillTime`, `god`, `group`, `eq1`, `coins`) VALUES (NULL, '").append(this.getName()).append("','").append(this.getPoints()).append("','").append(this.getKills()).append("','").append(this.getDeaths()).append("','").append(this.getAsysts()).append("','").append(this.isIncognitoNick() ? 1 : 0).append("','").append(this.isIncognitoSkin() ? 1 : 0).append("','").append(this.getFirstIP()).append("','").append(this.getLastIP()).append("','").append(this.getFirstJoin()).append("','").append(this.getKox()).append("','").append(this.getRefy()).append("','").append(this.getPerly()).append("','").append(this.getLastKill()).append("','").append(this.getLastKillTime()).append("','").append(this.isGod() ? 1 : 0).append("','").append(this.getGroup()).append("','").append(this.getEq_1()).append("','").append(this.getCoins()).append("')")));
    }
    

    public void setKills(final int kills) {
        this.kills = kills;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `kills` = '").append(this.getKills()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isIncognitoSkin() {
        return this.incognitoSkin;
    }

    public int getKills() {
        return this.kills;
    }
    
    public void setLastkill(final String lastkill) {
        this.lastkill = lastkill;
    }

    
    public int getAsysts() {
        return this.asysts;
    }
    
    public void setAsysts(final int asysts) {
        this.asysts = asysts;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `asysts` = '").append(this.getAsysts()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public String getLastkill() {
        return this.lastkill;
    }
    

    public User(final ResultSet set) throws SQLException {
        this.eq1 = new SimpleInventoryMenu(true, ChatUtil.fixColor("&r&7ZAPISZ EQ"));
        this.eq = set.getString("eq1");
        this.name = set.getString("name");
        this.points = set.getInt("points");
        this.coins = set.getInt("coins");
        this.kills = set.getInt("kills");
        this.deaths = set.getInt("deaths");
        this.asysts = set.getInt("asysts");
        this.incognitoNick = (set.getInt("incognitoNick") == 1);
        this.incognitoSkin = (set.getInt("incognitoSkin") == 1);
        this.lastkill = "";
        this.status = false;
        this.sprint = false;
        this.flying = false;
        this.firstIP = set.getString("firstIP");
        this.lastIP = set.getString("lastIP");
        this.firstJoin = set.getLong("firstJoin");
        this.schowek_kox = set.getInt("schowek_kox");
        this.schowek_perly = set.getInt("schowek_perly");
        this.schowek_refy = set.getInt("schowek_refy");
        this.lastKill = set.getString("lastKill");
        this.lastKillTime = set.getLong("lastKillTime");
        this.lastChat = 0L;
        this.god = (set.getInt("god") == 1);
        this.teleport = false;
        this.ignoreTell = new ArrayList<>();
        this.helpop = true;
        this.lastHelpop = 0L;
        this.lastPearl = 0L;
        this.group = GroupType.valueOf(set.getString("group"));
    }

    public int getCoins() {
        return this.coins;
    }

    public void addCoins(final int l) {
        this.coins += l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `coins` ='" + this.getCoins() + "' WHERE `name` ='" + this.getName() + "'");
    }

    public void removeCoins(final int l) {
        this.coins -= l;
        Main.getStore().update("UPDATE `pCGuilds_users` SET `coins` ='" + this.getCoins() + "' WHERE `name` ='" + this.getName() + "'");
    }


    public SimpleInventoryMenu getEq1() {
        return this.eq1;
    }

    public String getEq_1() {
        return this.eq;
    }

    public void setEq_1(final String enderchest_1) {
        this.eq = enderchest_1;
        Main.getStore().update(false, "UPDATE `pCGuilds_users` SET `eq1` ='" + this.getEq_1() + "' WHERE `name` ='" + this.getName() + "'");
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
    
    public boolean isLastHelpop() {
        return this.getLastHelpop() > System.currentTimeMillis();
    }
    
    public boolean isLastPearl() {
        return this.getLastPearl() > System.currentTimeMillis();
    }
    
    public long getLastHelpop() {
        return this.lastHelpop;
    }
    
    public void setLastHelpop(final long lastHelpop) {
        this.lastHelpop = lastHelpop;
    }
    
    public long getLastPearl() {
        return this.lastPearl;
    }
    
    public GroupType getGroup() {
        return this.group;
    }
    
    public void setLastPearl(final long lastPearl) {
        this.lastPearl = lastPearl;
    }
    
    public boolean isHelpop() {
        return this.helpop;
    }
    
    public void setHelpop(final boolean helpop) {
        this.helpop = helpop;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFirstIP() {
        return this.firstIP;
    }
    
    public void setFirstIP(final String firstIP) {
        this.firstIP = firstIP;
    }
    
    public String getLastIP() {
        return this.lastIP;
    }
    
    public void setLastIP(final String lastIP) {
        this.lastIP = lastIP;
    }
    
    public long getFirstJoin() {
        return this.firstJoin;
    }
    
    public void setFirstJoin(final long firstJoin) {
        this.firstJoin = firstJoin;
    }
    
    public OfflinePlayer getOfflinePlayer() {
        return (OfflinePlayer)Server.getInstance().getOfflinePlayer(this.getName());
    }
    
    public void setGroup(final GroupType group) {
        this.group = group;
        Main.getStore().update(false, "UPDATE `pCGuilds_users` SET `group`='" + this.getGroup().toString() + "' WHERE `name`='" + this.getName() + "'");
    }
    
    public Player getPlayer() {
        return Server.getInstance().getPlayer(this.getName());
    }
    
    public boolean isOnline() {
        return this.getPlayer() != null;
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
    
    public void setDeaths(final int deaths) {
        this.deaths = deaths;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `deaths` = '").append(this.getDeaths()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public int getDeaths() {
        return this.deaths;
    }
    
    public void setIncognitoSkin(final boolean incognitoSkin) {
        this.incognitoSkin = incognitoSkin;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `incognitoSkin` = '").append(this.isIncognitoSkin() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setPoints(final int points) {
        this.points = points;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `points` = '").append(this.getPoints()).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setIncognitoNick(final boolean incognitoNick) {
        this.incognitoNick = incognitoNick;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_users` SET `incognitoNick` = '").append(this.isIncognitoNick() ? 1 : 0).append("' WHERE `name` ='").append(this.getName()).append("';")));
    }
    
    public boolean isIncognitoNick() {
        return this.incognitoNick;
    }
    
    public User(final Player player) {
        this.status = false;
        this.sprint = false;
        this.flying = false;
        this.eq1 = new SimpleInventoryMenu(true, ChatUtil.fixColor("&r&7ZAPISZ EQ"));
        this.name = player.getName();
        this.points = 1000;
        this.kills = 0;
        this.coins = 0;
        this.deaths = 0;
        this.asysts = 0;
        this.incognitoNick = false;
        this.incognitoSkin = false;
        this.lastkill = "";
        this.eq = "";
        this.ignoreTell = new ArrayList<>();
        this.firstIP = player.getAddress();
        this.lastIP = player.getAddress();
        this.firstJoin = System.currentTimeMillis();
        this.schowek_kox = 0;
        this.schowek_refy = 0;
        this.schowek_perly = 0;
        this.lastKill = "-";
        this.lastKillTime = 0L;
        this.lastChat = 0L;
        this.god = false;
        this.teleport = false;
        this.helpop = true;
        this.lastHelpop = 0L;
        this.lastPearl = 0L;
        this.group = GroupType.PLAYER;
        this.insert();
    }
    
    public int getPoints() {
        return this.points;
    }

    public List<Player> getIgnoreTell() {
        return this.ignoreTell;
    }

    public boolean isIgnoreTell(Player p) {
        return this.ignoreTell.contains(p);
    }

    public void setIgnoreTell(List<Player> ignoreTell) {
        this.ignoreTell = ignoreTell;
    }

    public void addIgnoreTell(Player p) {
        this.ignoreTell.add(p);
    }

    public void removeIgnoreTell(Player p) {
        this.ignoreTell.remove(p);
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setSprint(final boolean sprint) {
        this.sprint = sprint;
    }

    public boolean isSprint() {
        return this.sprint;
    }

    public void setFlying(final boolean flying) {
        this.flying = flying;
    }

    public boolean isFlying() {
        return this.flying;
    }

}
