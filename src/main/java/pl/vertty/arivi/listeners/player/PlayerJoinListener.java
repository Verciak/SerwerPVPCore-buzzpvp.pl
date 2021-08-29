// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.utils.Config;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.drop.utils.RandomUtils;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.network.protocol.DataPacket;
import java.util.Iterator;
import cn.nukkit.level.particle.FloatingTextParticle;
import pl.vertty.arivi.Main;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.utils.SkinUtil;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.drop.base.User;
import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.wings.WingsManager;
import pl.vertty.arivi.wings.mysql.UserWings;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.event.Listener;

public class PlayerJoinListener implements Listener
{
    @EventHandler
    public void onCreate(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final pl.vertty.arivi.guilds.data.User u = UserManager.getUser(p);
        p.setGamemode(0);
        if (UserWings.getUser(p) != null && UserWings.getUser(p).getWings() != null) {
            WingsManager.setRatWings(p, WingsManager.getWings(UserWings.getUser(p).getWings()));
        }
        if (!UserUtils.playedBefore(p.getName())) {
            new User(p.getName());
        }
        if (u == null) {
            UserManager.createrUser(p);
        }
        final Combat combat = CombatManager.getCombat(p);
        if (combat == null) {
            CombatManager.createCombat(p);
        }
        if(u != null){
            if(!u.can(GroupType.HELPER)) {
                p.setOp(false);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onLogin(final PlayerLoginEvent event) throws SkinChangeException {
        final Player p = event.getPlayer();
        p.setGamemode(0);
        final pl.vertty.arivi.guilds.data.User u = UserManager.getUser(p);
        SkinUtil.originalSkins.put(event.getPlayer().getUniqueId(), event.getPlayer().getSkin());
        if(u != null){
            if(!u.can(GroupType.HELPER)) {
                p.setOp(false);
            }
        }
        if (u != null && u.isIncognitoSkin()) {
            SkinUtil.changeSkin(p);
        }
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Combat c = CombatManager.getCombat(e.getPlayer());
        Iterator<Player> iterator = Server.getInstance().getOnlinePlayers().values().iterator();
        if (iterator.hasNext()) {
            Player p = iterator.next();
            Combat ca = CombatManager.getCombat(e.getPlayer());
            if (ca == null) {
                CombatManager.createCombat(p);
            }
            return;
        }
        if (c == null) {
            CombatManager.createCombat(e.getPlayer());
        }
        for (final FloatingTextParticle particle : Main.getPlugin().getParticles().values()) {
            particle.setInvisible(false);
            for (final DataPacket pk : particle.encode()) {
                e.getPlayer().dataPacket(pk);
            }
        }
        e.setJoinMessage("");
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        e.setQuitMessage("");
    }
    
    @EventHandler
    public void onDataPacket(final DataPacketReceiveEvent e) {
        final DataPacket data = e.getPacket();
        final Player p = e.getPlayer();
        final Config c = Main.getPlugin().getConfig();
        Combat ca = CombatManager.getCombat(e.getPlayer());
        if (ca == null) {
            CombatManager.createCombat(p);
        }
        if (data instanceof SetLocalPlayerAsInitializedPacket && !p.hasPlayedBefore()) {
            p.getInventory().addItem(new Item[] { Item.get(274, Integer.valueOf(0), 1) });
            p.getInventory().addItem(new Item[] { Item.get(320, Integer.valueOf(0), 64) });
            p.getInventory().addItem(new Item[] { Item.get(130, Integer.valueOf(0), 1) });
            final int x = RandomUtils.getRandInt(-c.getInt("border"), c.getInt("border"));
            final int z = RandomUtils.getRandInt(-c.getInt("border"), c.getInt("border"));
            final Location location = p.getLocation();
            final Block tele = p.getLocation().getLevel().getBlock(new Vector3(location.getX(), location.getY(), location.getZ()));
            final Location telep = tele.getLocation();
            final Location loc = new Location((double)x, (double)telep.getLevel().getHighestBlockAt(x, z), (double)z);
            p.teleport(loc, PlayerTeleportEvent.TeleportCause.PLUGIN);
        }
    }
}
