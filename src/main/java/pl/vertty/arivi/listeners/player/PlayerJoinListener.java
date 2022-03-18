// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import cn.nukkit.level.particle.FloatingTextParticle;
import pl.vertty.arivi.Main;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.managers.ItemShop;
import pl.vertty.arivi.managers.ItemShopManager;
import pl.vertty.arivi.managers.ShopManager;
import pl.vertty.arivi.managers.time.TimeObject;
import pl.vertty.arivi.managers.time.TimeObjectManager;
import pl.vertty.arivi.objects.Shop;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.utils.SkinUtil;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.wings.SkinUtils;
import pl.vertty.arivi.wings.WingsManager;
import pl.vertty.arivi.wings.mysql.UserWings;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.event.Listener;

import javax.imageio.ImageIO;

public class PlayerJoinListener implements Listener
{
    @EventHandler
    public void onCreate(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final pl.vertty.arivi.guilds.data.User u = UserManager.getUser(p);
//        final Skin playerSkin = p.getSkin();
//        SkinUtils.saveImage(Main.getPlugin(), 64, 64, playerSkin.getSkinData().data, p.getName());
//        final Path skinPath = Paths.get(Main.getPlugin().getDataFolder() + "/skins/" + p.getName() + ".png", new String[0]);
//        final Path skinGeometryPath = Paths.get(Main.getPlugin().getDataFolder() + "/defaultGeometry.json", new String[0]);
//        String geometry = null;
//        BufferedImage skinData = null;
//        try {
//            geometry = new String(Files.readAllBytes(skinGeometryPath), StandardCharsets.UTF_8);
//            skinData = ImageIO.read(skinPath.toFile());
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        final Skin skin = new Skin();
//        skin.setGeometryData(geometry);
//        skin.setGeometryName("geometry.defaultGeometry");
//        skin.setSkinData(skinData);
//        skin.setSkinId("defaultGeometry");
//        skin.setPremium(true);
//        skin.setTrusted(true);
//        p.setSkin(skin);


        Shop shop = ShopManager.getUser(p);
        ItemShop is = ItemShopManager.getUser(p);
        TimeObject timer = TimeObjectManager.getUser(p);

        p.setGamemode(0);
        if (UserWings.getUser(p) != null && UserWings.getUser(p).getWings() != null) {
            WingsManager.setRatWings(p, WingsManager.getWings(UserWings.getUser(p).getWings()));
        }
        if(timer == null){
            TimeObjectManager.createrUser(p);
        }
        if(shop == null){
            ShopManager.createrUser(p);
        }
        if (u == null) {
            UserManager.createrUser(p);
        }
        if (is == null) {
            ItemShopManager.createrUser(p);
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

    private static boolean isActive(final long czas) {
        return czas >= System.currentTimeMillis();
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
        if (data instanceof SetLocalPlayerAsInitializedPacket){
            final pl.vertty.arivi.guilds.data.User u = UserManager.getUser(p);
            TimeObject timer = TimeObjectManager.getUser(p);
            if(u.can(GroupType.ROOT)){

            }
            else if(u.can(GroupType.HEADADMIN)){

            }
            else if(u.can(GroupType.ADMIN)){

            }
            else if(u.can(GroupType.MODERATOR)){

            }
            else if(u.can(GroupType.HELPER)){

            }
            else if(u.can(GroupType.SPONSOR)){
                if(UserWings.getUser(p) == null) {
                    WingsManager.setRatWings(p, WingsManager.getWings("walizaczapa"));
                }
                if(isActive(timer.getReward())){
                    ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Musisz poczekac jeszcze &3" + DataUtil.parseLong(timer.getReward() - System.currentTimeMillis(), false));
                    return;
                }
                timer.setReward(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                u.addCoins(125);
                ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Otrzymales &3125 monet");
                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&8* &7Na serwer dolaczyl &3SPONSOR &f" + p.getName()));
            }else if(u.can(GroupType.YOUTUBER)){
                if(UserWings.getUser(p) == null) {
                    WingsManager.setRatWings(p, WingsManager.getWings("yt3"));
                }
                if(isActive(timer.getReward())){
                    ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Musisz poczekac jeszcze &3" + DataUtil.parseLong(timer.getReward() - System.currentTimeMillis(), false));
                    return;
                }
                timer.setReward(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                u.addCoins(75);
                ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Otrzymales &375 monet");
                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&8* &7Na serwer dolaczyl &5YOUTUBER &f" + p.getName()));
            } else if(u.can(GroupType.SVIP)){
                if(UserWings.getUser(p) == null) {
                    WingsManager.setRatWings(p, WingsManager.getWings("banknot"));
                }
                if(isActive(timer.getReward())){
                    ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Musisz poczekac jeszcze &3" + DataUtil.parseLong(timer.getReward() - System.currentTimeMillis(), false));
                    return;
                }
                timer.setReward(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                u.addCoins(100);
                ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Otrzymales &3100 monet");
                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&8* &7Na serwer dolaczyl &eSVIP &f" + p.getName()));
            } else if(u.can(GroupType.VIP)){
                if(UserWings.getUser(p) == null) {
                    WingsManager.setRatWings(p, WingsManager.getWings("moneta"));
                }
                if(isActive(timer.getReward())){
                    ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Musisz poczekac jeszcze &3" + DataUtil.parseLong(timer.getReward() - System.currentTimeMillis(), false));
                    return;
                }
                timer.setReward(System.currentTimeMillis() + TimeUtil.HOUR.getTime(24));
                u.addCoins(75);
                ChatUtil.sendFullTitle(p, "&9DZIENNA NAGRODA", "&7Otrzymales &375 monet");
                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&8* &7Na serwer dolaczyl &6VIP &f" + p.getName()));
            }
        }
        if (ca == null) {
            CombatManager.createCombat(p);
        }
    }
}
