// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.data.guild;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Arrays;
import java.util.Map;
import pl.vertty.arivi.utils.InventoryUtil;
import java.sql.ResultSet;
import cn.nukkit.inventory.Inventory;
import pl.vertty.arivi.utils.SeralizerUtil;
import pl.vertty.arivi.guilds.managers.guild.RoleManager;
import pl.vertty.arivi.guilds.data.yml.Config;
import java.util.ArrayList;
import java.util.Iterator;
import cn.nukkit.Server;
import java.util.HashSet;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.guild.RelationType;
import pl.vertty.arivi.inventory.SimpleInventoryMenu;
import cn.nukkit.Player;
import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.data.block.BlockRegeneration;
import java.util.List;
import pl.vertty.arivi.guilds.data.guild.cuboid.Region;
import java.util.Set;

public class Guild
{
    private int head;
    private String owner;
    private final String name;
    private int limitSize;
    private final Set<String> ally;
    private Set<Guild> allyInvites;
    private final Region region;
    private long createTime;
    private List<BlockRegeneration> blocks;
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
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `owner` = '").append(this.getOwner()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void removePoints(final int n) {
        this.setPoints(this.getPoints() - n);
    }
    
    public double getKd() {
        if (this.getKills() == 0 && this.getDeaths() == 0) {
            return 0.0;
        }
        if (this.getKills() > 0 && this.getDeaths() == 0) {
            return this.getKills();
        }
        if (this.getDeaths() > 0 && this.getKills() == 0) {
            return -this.getDeaths();
        }
        return ChatUtil.round(this.getKills() / this.getDeaths(), 2);
    }
    
    public void insert() {
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_guilds`(`id`, `tag`, `name`, `owner`, `hp`, `leader`, `cuboidX`, `cuboidZ`, `cuboidSize`, `life`, `lifeLastAttack`, `prolong`, `pvp`, `createTime`, `homeX`, `homeY`, `homeZ`, `ally`, `points`, `kills`, `deaths`, `sojusz`, `pvpAlly`, `limitSize`, `tntKaraTime`, `head`, `limitMembers`, `skarbiec`, `skrzynka1`) VALUES (NULL, '").append(this.getTag()).append("','").append(this.getName()).append("','").append(this.getOwner()).append("','").append(this.getHp()).append("','").append(this.getLeader()).append("','").append(this.getRegion().getX()).append("','").append(this.getRegion().getZ()).append("','").append(this.getRegion().getSize()).append("','").append(this.getLife()).append("','").append(this.getLifeLastAttack()).append("','").append(this.getProlong()).append("','").append(this.isPvp() ? 1 : 0).append("','").append(this.getCreateTime()).append("','").append(this.getHome().getX()).append("','").append(this.getHome().getY()).append("','").append(this.getHome().getZ()).append("','").append(this.ally.toString().replace("[", "").replace("]", "")).append("','").append(this.getPoints()).append("','").append(this.getKills()).append("','").append(this.getDeaths()).append("','").append(this.getSojusz()).append("','").append(this.isPvpAlly() ? 1 : 0).append("', '").append(this.getLimitSize()).append("','").append(this.getTntKaraTime()).append("','").append(this.getHead()).append("','").append(this.getLimitMembers()).append("','").append(this.getSkarbiec()).append("','").append(this.getSkrzynka1()).append("');")));
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String getSkrzynka1() {
        return this.skrzynka1;
    }
    
    public void setSize(final int size) {
        this.getRegion().setSize(size);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE pCGuilds_guilds` SET `cuboidSize` = '").append(this.getRegion().getSize()).append("' WHERE tag = '").append(this.getTag()).append("';")));
    }
    
    public void setRegeneration(final boolean regeneration) {
        this.regeneration = regeneration;
    }
    
    public void setPreDeleted(final boolean preDeleted) {
        this.preDeleted = preDeleted;
    }
    
    public void setTntKaraTime(final long tntKaraTime) {
        this.tntKaraTime = tntKaraTime;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `tntKaraTime` = '").append(this.getTntKaraTime()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public boolean isMember(final String s) {
        return this.getMembers().contains(s);
    }
    
    public void addMember(final Player player) {
        this.members.add(player.getName());
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("INSERT INTO `pCGuilds_members` (`id`,`name`,`tag`) VALUES(NULL, '").append(player.getName()).append("', '").append(this.getTag()).append("');")));
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
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `ally` ='").append(this.getAlly().toString().replace("[", "").replace("]", "")).append("' WHERE `tag` ='").append(this.getTag()).append("'")));
    }
    
    public void setBlocks(final List<BlockRegeneration> blocks) {
        this.blocks = blocks;
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
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `sojusz` = '").append(this.getSojusz()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
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
    
    public void addLimitSize(final int limitSize) {
        this.limitSize = limitSize;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `limitSize` = '").append(this.getLimitSize()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void removeMember(final String str) {
        this.members.remove(str);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_members` WHERE `name` = '").append(str).append("' AND `tag` = '").append(this.getTag()).append("';")));
    }
    
    public void addSize(final int n) {
        this.getRegion().addSize(n);
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `cuboidSize` = '").append(this.getRegion().getSize()).append("' WHERE tag = '").append(this.getTag()).append("';")));
    }
    
    public void setLastExplodeTime(final long lastExplodeTime) {
        this.lastExplodeTime = lastExplodeTime;
    }
    
    public long getProlong() {
        return this.prolong;
    }
    
    public void setHead(final int head) {
        this.head = head;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `head` = '").append(this.getHead()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public Set<Player> getInvites() {
        return this.invites;
    }
    
    public int getSojusz() {
        return this.sojusz;
    }
    
    public void setHp(final int hp) {
        this.hp = hp;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `hp` = '").append(this.getHp()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setLife(final int life) {
        this.life = life;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `life` = '").append(this.getLife()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setLifeLastAttack(final long lifeLastAttack) {
        this.lifeLastAttack = lifeLastAttack;
        Main.getStore().update(String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `lifeLastAttack` = '").append(this.getLifeLastAttack()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setLimitMembers(final int limitMembers) {
        this.limitMembers = limitMembers;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `limitMembers` = '").append(this.getLimitMembers()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setCreateTime(final long createTime) {
        this.createTime = createTime;
    }
    
    public boolean isMember(final Player player) {
        return this.getMembers().contains(player.getName());
    }
    
    public int getLimitSize() {
        return this.limitSize;
    }
    
    public boolean isProtected() {
        return this.getCreateTime() + TimeUtil.HOUR.getTime(24) > System.currentTimeMillis();
    }
    
    public boolean isRegeneration() {
        return this.regeneration;
    }
    
    public boolean isPvp() {
        return this.pvp;
    }
    
    public Set<Player> getOnlineMembers() {
        final Set<Player> online = new HashSet<Player>();
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
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `deaths` = '").append(this.getDeaths()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public boolean isPreDeleted() {
        return this.preDeleted;
    }
    
    public void setPvpAlly(final boolean pvpAlly) {
        this.pvpAlly = pvpAlly;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `pvpAlly` = '").append(this.isPvpAlly() ? 1 : 0).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setLeader(final String leader) {
        this.leader = leader;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `leader` = '").append(this.getLeader()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public boolean isOwner(final String anotherString) {
        return this.getOwner().equalsIgnoreCase(anotherString);
    }
    
    public long getCreateTime() {
        return this.createTime;
    }
    
    public Guild(final String tag, final String name, final Player player, final Location home) {
        this.skrzynka = new SimpleInventoryMenu(true, pl.vertty.arivi.utils.ChatUtil.fixColor("&r&9SKRZYNKA GILDYJNA"));
        this.members = new HashSet<String>();
        this.invites = new HashSet<Player>();
        this.ally = new HashSet<String>();
        this.allyInvites = new HashSet<Guild>();
        this.blocks = new ArrayList<BlockRegeneration>();
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
        RoleManager.addRole(tag, "ROLA 1");
        RoleManager.addRole(tag, "ROLA 2");
        RoleManager.addRole(tag, "ROLA 3");
        RoleManager.addRole(tag, "ROLA 4");
        RoleManager.addRole(tag, "ROLA 5");
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
    
    public void removeDeaths(final int n) {
        this.setDeaths(this.getDeaths() + n);
    }
    
    public boolean isLeader(final Player player) {
        return this.getLeader().equalsIgnoreCase(player.getName());
    }
    
    public void setPoints(final int points) {
        this.points = points;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `points` = '").append(this.getPoints()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setProlong(final long prolong) {
        this.prolong = prolong;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `prolong` = '").append(this.getProlong()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setSkrzynka1(final String skrzynka1) {
        this.skrzynka1 = skrzynka1;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `skrzynka1` = '").append(SeralizerUtil.serializeInventory((Inventory)this.getSkrzynka())).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void addDeaths(final int n) {
        this.setDeaths(this.getDeaths() + n);
    }
    
    public long getLastExplodeTime() {
        return this.lastExplodeTime;
    }
    
    public void setKills(final int kills) {
        this.kills = kills;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `kills` = '").append(this.getKills()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void setSkarbiec(final int skarbiec) {
        this.skarbiec = skarbiec;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `skarbiec` = '").append(this.getSkarbiec()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public boolean isOwner(final Player player) {
        return this.getOwner().equalsIgnoreCase(player.getName());
    }
    
    public Set<String> getAlly() {
        return this.ally;
    }
    
    public void removeMember(final Player player) {
        this.members.remove(player.getName());
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("DELETE FROM `pCGuilds_members` WHERE `name` = '").append(player.getName()).append("' AND `tag` = '").append(this.getTag()).append("';")));
    }
    
    public void removeKills(final int n) {
        this.setKills(this.getKills() - n);
    }
    
    public int getLife() {
        return this.life;
    }
    
    public Guild(final ResultSet set) throws SQLException {
        this.skrzynka = new SimpleInventoryMenu(true, pl.vertty.arivi.utils.ChatUtil.fixColor("&r&9SKRZYNKA GILDYJNA"));
        this.members = new HashSet<String>();
        this.invites = new HashSet<Player>();
        this.ally = new HashSet<String>();
        this.allyInvites = new HashSet<Guild>();
        this.blocks = new ArrayList<BlockRegeneration>();
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
            this.skrzynka.setContents((Map)InventoryUtil.itemArrayToInventoryContents(SeralizerUtil.deserializeItemArray(this.skrzynka1)));
        }
        final ResultSet query = Main.getStore().query(String.valueOf(new StringBuilder().append("SELECT * FROM `pCGuilds_members` WHERE `tag` = '").append(this.tag).append("';")));
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
    
    public void actionbar(final String s) {
        final Iterator<Player> iterator = this.getOnlineMembers().iterator();
        while (iterator.hasNext()) {
            ChatUtil.sendActionbar(iterator.next(), ChatUtil.fixColor(s));
        }
    }
    
    public void addKills(final int n) {
        this.setKills(this.getKills() + n);
    }
    
    public boolean isExits() {
        return this.getProlong() > System.currentTimeMillis();
    }
    
    public int getKills() {
        return this.kills;
    }
    
    public void message(final String s) {
        final Iterator<Player> iterator = this.getOnlineMembers().iterator();
        while (iterator.hasNext()) {
            iterator.next().sendMessage(ChatUtil.fixColor(s));
        }
    }
    
    public void setPvp(final boolean pvp) {
        this.pvp = pvp;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `pvp` = '").append(this.isPvp() ? 1 : 0).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public int getHead() {
        return this.head;
    }
    
    public boolean isLastAtack() {
        return this.getLifeLastAttack() > System.currentTimeMillis();
    }
    
    public void title(final String s, final String s2) {
        for (final Player player : this.getOnlineMembers()) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(s));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(s2));
        }
    }
    
    public void setHome(final Location home) {
        this.home = home;
        Main.getStore().update(false, String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `homeX` = '").append(this.getHome().getX()).append("', `homeY` ='").append(this.getHome().getY()).append("', `homeZ` ='").append(this.getHome().getZ()).append("' WHERE `tag` ='").append(this.getTag()).append("';")));
    }
    
    public void addAlly(final String s) {
        this.ally.add(s);
        Main.getStore().update(String.valueOf(new StringBuilder().append("UPDATE `pCGuilds_guilds` SET `ally` ='").append(this.getAlly().toString().replace("[", "").replace("]", "")).append("' WHERE `tag` ='").append(this.getTag()).append("'")));
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public boolean isPreResetStats() {
        return this.preResetStats;
    }
}
