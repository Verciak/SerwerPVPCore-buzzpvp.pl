// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.projectile.EntityEnderPearl;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.entity.*;
import cn.nukkit.event.player.PlayerToggleSwimEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Location;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.*;
import pl.vertty.arivi.AntiGrief;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.entity.Entity;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.guilds.utils.ChatUtil;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GodListener implements Listener
{


    @EventHandler
    public void onSwim(PlayerToggleSwimEvent e){
        e.setCancelled(true);
    }


    private final Map<UUID, Long> times = new ConcurrentHashMap<>();






    @EventHandler
    public void onGrief(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Location l = b.getLocation();
        if (UserManager.getUser(p).can(GroupType.HELPER)) {
            return;
        }
        if (AntiGrief.AddBlock(b)) {
            Long time = this.times.get(p.getUniqueId());
            if (time == null || System.currentTimeMillis() - time.longValue() >= TimeUtil.SECOND.getTime(5)) {
                ChatUtil.sendMessage(p, "&7Postawiles blok ktory zniknie za &e5 minut!");
                this.times.put(p.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
            }

        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityMotion(EntityMotionEvent event) {
//        if(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
//            if(((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager() instanceof Player){
//                Player damager = (Player) ((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager();
//                Item item = damager.getInventory().getItemInHand();
//                if(item == null){
//                    return;
//                }
//                if(!item.hasEnchantment(Enchantment.ID_KNOCKBACK)){
//                    Player player = ((Player) event.getEntity());
//                    if (player.onGround) {
//                        event.getMotion().x *= 0.64;
//                        event.getMotion().y *= 0.87;
//                        event.getMotion().z *= 0.67;
//                    } else {
//                        event.getMotion().x *= 0.67;
//                        event.getMotion().y *= 1.055;
//                        event.getMotion().z *= 0.67;
//                    }
//                }
//
//            }
//        }
                Player player = ((Player) event.getEntity());
                if (player.onGround) {
                    event.getMotion().x *= 0.64;
                    event.getMotion().y *= 0.87;
                    event.getMotion().z *= 0.67;
                } else {
                    event.getMotion().x *= 0.67;
                    event.getMotion().y *= 1.055;
                    event.getMotion().z *= 0.67;
                }
    }



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKnockBack(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        if(event.getDamager() instanceof Player){
            event.setAttackCooldown(7);
            event.setKnockBack(0.346f);
        }
    }

    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        final Entity en = event.getEntity();
        if (en instanceof Player) {
            final Player player = (Player)en;
            final User u = UserManager.getUser(player.getName());
            if (u != null && u.isGod()) {
                event.setCancelled(true);
            }
        }
    }
}
