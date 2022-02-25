
package pl.vertty.arivi.listeners.player;

import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.*;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.objects.User;
import cn.nukkit.entity.Entity;
import pl.vertty.arivi.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;

public class GodListener implements Listener
{




    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityMotion(EntityMotionEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = ((Player) event.getEntity());
            if(player.onGround) {
                event.getMotion().x *= 0.64;
                event.getMotion().y *= 0.87;
                event.getMotion().z *= 0.67;
            }else{
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
            event.setAttackCooldown(8);
            event.setKnockBack(0.39f);
            Item item = ((Player) event.getDamager()).getInventory().getItemInHand();
            if(item.hasEnchantment(Enchantment.ID_KNOCKBACK)){
                if(item.getEnchantment(Enchantment.ID_KNOCKBACK).getLevel() == 1){
                    event.setAttackCooldown(8);
                    event.setKnockBack(0.47f);
                }
                if(item.getEnchantment(Enchantment.ID_KNOCKBACK).getLevel() == 2){
                    event.setAttackCooldown(8);
                    event.setKnockBack(0.84f);
                }
            }{
                event.setAttackCooldown(8);
                event.setKnockBack(0.39f);
            }
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
