
package pl.vertty.arivi.guilds.data.guild;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Location;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.block.BlockRegeneration;
import pl.vertty.arivi.guilds.data.guild.cuboid.Region;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.RelationType;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.inventory.SimpleInventoryMenu;
import pl.vertty.arivi.utils.InventoryUtil;
import pl.vertty.arivi.utils.SeralizerUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Guild
{
    private int head;
    private String owner;
    private final String name;
    private final int limitSize;
    private final Set<String> ally;
    private final Set<Guild> allyInvites;
    private final Region region;
    private final long createTime;
    private final List<BlockRegeneration> blocks;
    private boolean pvp;
    private long prolong;
    private long lastExplodeTime;
    private long lifeLastAttack;
    private int limitMembers;
    private boolean pvpAlly;
    private int points;
    private Location home;
    private final String tag;
    private boolean preResetStats;
    private int life;
    private int skarbiec;
    private final Set<Player> invites;
    private boolean regeneration;
    private final Set<String> members;
    private boolean preDeleted;
    private int kills;
    private int deaths;
    private long tntKaraTime;
    private int sojusz;
    private String leader;
    private String skrzynka1;
    private int hp;
    private final SimpleInventoryMenu skrzynka;
    
    public RelationType getRelationGuild(final Guild g) {
        if (g.equals(this)) {
            return RelationType.TEAM;
        }
        if (this.ally.contains(g)) {
            return RelationType.ALLY;
        }
        return RelationType.ENEMY;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public void addPoints(final int n) {
        this.setPoints(this.getPoints() + n);
    }
    
    public void setOwner(final String owner) {
        this.owner = owner;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `owner` = '" + this.getOwner() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void removePoints(final int n) {
        this.setPoints(this.getPoints() - n);
    }
    
    public void insert() {
        Main.getStore().update(false, "INSERT INTO `pCGuilds_guilds`(`id`, `tag`, `name`, `owner`, `hp`, `leader`, `cuboidX`, `cuboidZ`, `cuboidSize`, `life`, `lifeLastAttack`, `prolong`, `pvp`, `createTime`, `homeX`, `homeY`, `homeZ`, `ally`, `points`, `kills`, `deaths`, `sojusz`, `pvpAlly`, `limitSize`, `tntKaraTime`, `head`, `limitMembers`, `skarbiec`, `skrzynka1`) VALUES (NULL, '" + this.getTag() + "','" + this.getName() + "','" + this.getOwner() + "','" + this.getHp() + "','" + this.getLeader() + "','" + this.getRegion().getX() + "','" + this.getRegion().getZ() + "','" + this.getRegion().getSize() + "','" + this.getLife() + "','" + this.getLifeLastAttack() + "','" + this.getProlong() + "','" + (this.isPvp() ? 1 : 0) + "','" + this.getCreateTime() + "','" + this.getHome().getX() + "','" + this.getHome().getY() + "','" + this.getHome().getZ() + "','" + this.ally.toString().replace("[", "").replace("]", "") + "','" + this.getPoints() + "','" + this.getKills() + "','" + this.getDeaths() + "','" + this.getSojusz() + "','" + (this.isPvpAlly() ? 1 : 0) + "', '" + this.getLimitSize() + "','" + this.getTntKaraTime() + "','" + this.getHead() + "','" + this.getLimitMembers() + "','" + this.getSkarbiec() + "','" + this.getSkrzynka1() + "');");
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String getSkrzynka1() {
        return this.skrzynka1;
    }
    
    public void setSize(final int size) {
        this.getRegion().setSize(size);
        Main.getStore().update(false, "UPDATE pCGuilds_guilds` SET `cuboidSize` = '" + this.getRegion().getSize() + "' WHERE tag = '" + this.getTag() + "';");
    }
    
    public void setRegeneration(final boolean regeneration) {
        this.regeneration = regeneration;
    }
    
    public void setPreDeleted(final boolean preDeleted) {
        this.preDeleted = preDeleted;
    }
    
    public void setTntKaraTime(final long tntKaraTime) {
        this.tntKaraTime = tntKaraTime;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `tntKaraTime` = '" + this.getTntKaraTime() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public boolean isMember(final String s) {
        return this.getMembers().contains(s);
    }
    
    public void addMember(final Player player) {
        this.members.add(player.getName());
        Main.getStore().update(false, "INSERT INTO `pCGuilds_members` (`id`,`name`,`tag`) VALUES(NULL, '" + player.getName() + "', '" + this.getTag() + "');");
    }
    
    public List<BlockRegeneration> getBlocks() {
        return this.blocks;
    }
    
    public String getLeader() {
        return this.leader;
    }
    
    public Set<Guild> getAllyinvites() {
        return this.allyInvites;
    }
    
    public int getSkarbiec() {
        return this.skarbiec;
    }
    
    public void removeAlly(final String s) {
        this.ally.remove(s);
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `ally` ='" + this.getAlly().toString().replace("[", "").replace("]", "") + "' WHERE `tag` ='" + this.getTag() + "'");
    }

    public Region getRegion() {
        return this.region;
    }
    
    public long getLifeLastAttack() {
        return this.lifeLastAttack;
    }
    
    public int getLimitMembers() {
        return this.limitMembers;
    }
    
    public void setSojusz(final int sojusz) {
        this.sojusz = sojusz;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `sojusz` = '" + this.getSojusz() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPreResetStats(final boolean preResetStats) {
        this.preResetStats = preResetStats;
    }
    
    public Set<String> getMembers() {
        return this.members;
    }
    
    public int getDeaths() {
        return this.deaths;
    }

    
    public void removeMember(final String str) {
        this.members.remove(str);
        Main.getStore().update(false, "DELETE FROM `pCGuilds_members` WHERE `name` = '" + str + "' AND `tag` = '" + this.getTag() + "';");
    }
    
    public void addSize(final int n) {
        this.getRegion().addSize(n);
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `cuboidSize` = '" + this.getRegion().getSize() + "' WHERE tag = '" + this.getTag() + "';");
    }
    
    public void setLastExplodeTime(final long lastExplodeTime) {
        this.lastExplodeTime = lastExplodeTime;
    }
    
    public long getProlong() {
        return this.prolong;
    }
    
    public void setHead(final int head) {
        this.head = head;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `head` = '" + this.getHead() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public Set<Player> getInvites() {
        return this.invites;
    }
    
    public int getSojusz() {
        return this.sojusz;
    }
    
    public void setHp(final int hp) {
        this.hp = hp;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `hp` = '" + this.getHp() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setLife(final int life) {
        this.life = life;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `life` = '" + this.getLife() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setLifeLastAttack(final long lifeLastAttack) {
        this.lifeLastAttack = lifeLastAttack;
        Main.getStore().update("UPDATE `pCGuilds_guilds` SET `lifeLastAttack` = '" + this.getLifeLastAttack() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setLimitMembers(final int limitMembers) {
        this.limitMembers = limitMembers;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `limitMembers` = '" + this.getLimitMembers() + "' WHERE `tag` ='" + this.getTag() + "';");
    }

    public boolean isMember(final Player player) {
        return this.getMembers().contains(player.getName());
    }
    
    public int getLimitSize() {
        return this.limitSize;
    }
    
    public boolean isRegeneration() {
        return this.regeneration;
    }
    
    public boolean isPvp() {
        return this.pvp;
    }
    
    public Set<Player> getOnlineMembers() {
        final Set<Player> online = new HashSet<>();
        for (final String u : this.members) {
            final Player op = Server.getInstance().getPlayer(u);
            if (op != null && op.isOnline()) {
                online.add(op.getPlayer());
            }
        }
        return online;
    }
    
    public void setDeaths(final int deaths) {
        this.deaths = deaths;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `deaths` = '" + this.getDeaths() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public boolean isPreDeleted() {
        return this.preDeleted;
    }
    
    public void setPvpAlly(final boolean pvpAlly) {
        this.pvpAlly = pvpAlly;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `pvpAlly` = '" + (this.isPvpAlly() ? 1 : 0) + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setLeader(final String leader) {
        this.leader = leader;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `leader` = '" + this.getLeader() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public boolean isOwner(final String anotherString) {
        return this.getOwner().equalsIgnoreCase(anotherString);
    }
    
    public long getCreateTime() {
        return this.createTime;
    }
    
    public Guild(final String tag, final String name, final Player player, final Location home) {
        this.skrzynka = new SimpleInventoryMenu(true, pl.vertty.arivi.utils.ChatUtil.fixColor("&r&9SKRZYNKA GILDYJNA"));
        this.members = new HashSet<>();
        this.invites = new HashSet<>();
        this.ally = new HashSet<>();
        this.allyInvites = new HashSet<>();
        this.blocks = new ArrayList<>();
        this.lastExplodeTime = 0L;
        this.tag = tag;
        this.name = name;
        this.owner = player.getName();
        this.leader = "Brak";
        this.region = new Region(player.getLocation().getFloorX(), player.getLocation().getFloorZ(), Config.CUBOID_SIZE_START, this);
        this.life = 3;
        this.lifeLastAttack = System.currentTimeMillis() + TimeUtil.HOUR.getTime(24);
        this.prolong = System.currentTimeMillis() + TimeUtil.DAY.getTime(Config.PROLONG_START);
        this.hp = 500;
        this.home = home;
        this.createTime = System.currentTimeMillis();
        this.pvp = false;
        this.addMember(player);
        this.points = 1000;
        this.kills = 0;
        this.deaths = 0;
        this.sojusz = 2;
        this.pvpAlly = false;
        this.limitSize = Config.CUBOID_SIZE_MAX;
        this.tntKaraTime = 0L;
        this.head = 0;
        this.limitMembers = 30;
        this.preDeleted = false;
        this.preResetStats = false;
        this.regeneration = false;
        this.skarbiec = 0;
        this.skrzynka1 = "0;0;0;0;not";
        this.insert();
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public long getTntKaraTime() {
        return this.tntKaraTime;
    }
    
    public boolean isPvpAlly() {
        return this.pvpAlly;
    }
    
    public boolean isLeader(final String s) {
        return this.getOwner().equals(s) || this.getLeader().equals(s);
    }
    
    public Location getHome() {
        return this.home;
    }

    public void setPoints(final int points) {
        this.points = points;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `points` = '" + this.getPoints() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setProlong(final long prolong) {
        this.prolong = prolong;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `prolong` = '" + this.getProlong() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setSkrzynka1(final String skrzynka1) {
        this.skrzynka1 = skrzynka1;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `skrzynka1` = '" + SeralizerUtil.serializeInventory(this.getSkrzynka()) + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void addDeaths(final int n) {
        this.setDeaths(this.getDeaths() + n);
    }
    
    public long getLastExplodeTime() {
        return this.lastExplodeTime;
    }
    
    public void setKills(final int kills) {
        this.kills = kills;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `kills` = '" + this.getKills() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void setSkarbiec(final int skarbiec) {
        this.skarbiec = skarbiec;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `skarbiec` = '" + this.getSkarbiec() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public boolean isOwner(final Player player) {
        return this.getOwner().equalsIgnoreCase(player.getName());
    }
    
    public Set<String> getAlly() {
        return this.ally;
    }
    
    public void removeMember(final Player player) {
        this.members.remove(player.getName());
        Main.getStore().update(false, "DELETE FROM `pCGuilds_members` WHERE `name` = '" + player.getName() + "' AND `tag` = '" + this.getTag() + "';");
    }

    public int getLife() {
        return this.life;
    }
    
    public Guild(final ResultSet set) throws SQLException {
        this.skrzynka = new SimpleInventoryMenu(true, pl.vertty.arivi.utils.ChatUtil.fixColor("&r&9SKRZYNKA GILDYJNA"));
        this.members = new HashSet<>();
        this.invites = new HashSet<>();
        this.ally = new HashSet<>();
        this.allyInvites = new HashSet<>();
        this.blocks = new ArrayList<>();
        this.lastExplodeTime = 0L;
        this.tag = set.getString("tag");
        this.name = set.getString("name");
        this.owner = set.getString("owner");
        this.leader = set.getString("leader");
        this.region = new Region(set.getInt("cuboidX"), set.getInt("cuboidZ"), set.getInt("cuboidSize"), this);
        this.life = set.getInt("life");
        this.hp = set.getInt("hp");
        this.lifeLastAttack = set.getLong("lifeLastAttack");
        this.prolong = set.getLong("prolong");
        this.home = new Location(set.getDouble("homeX"), set.getDouble("homeY"), set.getDouble("homeZ"));
        this.createTime = set.getLong("createTime");
        this.pvp = (set.getInt("pvp") == 1);
        this.points = set.getInt("points");
        this.kills = set.getInt("kills");
        this.deaths = set.getInt("deaths");
        this.sojusz = set.getInt("sojusz");
        this.pvpAlly = (set.getInt("pvpAlly") == 1);
        this.limitSize = set.getInt("limitSize");
        this.tntKaraTime = set.getLong("tntKaraTime");
        this.head = set.getInt("head");
        this.limitMembers = set.getInt("limitMembers");
        this.preDeleted = false;
        this.preResetStats = false;
        this.regeneration = false;
        this.skarbiec = set.getInt("skarbiec");
        this.skrzynka1 = set.getString("skrzynka1");
        if (!this.skrzynka1.isEmpty()) {
            this.skrzynka.setContents(InventoryUtil.itemArrayToInventoryContents(SeralizerUtil.deserializeItemArray(this.skrzynka1)));
        }
        final ResultSet query = Main.getStore().query("SELECT * FROM `pCGuilds_members` WHERE `tag` = '" + this.tag + "';");
        while (query.next()) {
            this.members.add(query.getString("name"));
        }
        query.close();
        if (set.getString("ally").equals("")) {
            return;
        }
        this.ally.addAll(Arrays.asList(set.getString("ally").split(", ")));
    }
    
    public SimpleInventoryMenu getSkrzynka() {
        return this.skrzynka;
    }
    
    public void addKills(final int n) {
        this.setKills(this.getKills() + n);
    }

    public int getKills() {
        return this.kills;
    }
    
    public void message(final String s) {
        for (Player player : this.getOnlineMembers()) {
            player.sendMessage(ChatUtil.fixColor(s));
        }
    }
    
    public void setPvp(final boolean pvp) {
        this.pvp = pvp;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `pvp` = '" + (this.isPvp() ? 1 : 0) + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public int getHead() {
        return this.head;
    }

    public void title(final String s, final String s2) {
        for (final Player player : this.getOnlineMembers()) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(s));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(s2));
        }
    }
    
    public void setHome(final Location home) {
        this.home = home;
        Main.getStore().update(false, "UPDATE `pCGuilds_guilds` SET `homeX` = '" + this.getHome().getX() + "', `homeY` ='" + this.getHome().getY() + "', `homeZ` ='" + this.getHome().getZ() + "' WHERE `tag` ='" + this.getTag() + "';");
    }
    
    public void addAlly(final String s) {
        this.ally.add(s);
        Main.getStore().update("UPDATE `pCGuilds_guilds` SET `ally` ='" + this.getAlly().toString().replace("[", "").replace("]", "") + "' WHERE `tag` ='" + this.getTag() + "'");
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public boolean isPreResetStats() {
        return this.preResetStats;
    }
}
