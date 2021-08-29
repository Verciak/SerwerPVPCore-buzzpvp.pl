// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.player;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.projectile.EntityArrow;
import cn.nukkit.entity.projectile.EntityProjectile;
import cn.nukkit.event.Event;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityShootBowEvent;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBow;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LevelSoundEventPacket;
import pl.vertty.arivi.Knockback;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.entity.Entity;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.guilds.utils.ChatUtil;

public class GodListener implements Listener
{


    public void knockBack(Entity attacker, double x, double z, double base, Player player)
    {
        double xzKB = base, yKB = base;

        if(attacker instanceof Player)
        {
            xzKB = 0.56;
            yKB = 0.56;
        }

        double f = Math.sqrt(x * x + z * z);
        if (f > 0.0D)
        {
            f = 1.0D / f;
            Vector3 motion = new Vector3(player.motionX, player.motionY, player.motionZ);
            motion.x /= 2.0D;
            motion.y /= 2.0D;
            motion.z /= 2.0D;
            motion.x += x * f * xzKB;
            motion.y += yKB;
            motion.z += z * f * xzKB;

            if (motion.y > yKB)
            {
                motion.y = yKB;
            }

            player.setMotion(motion);
        }
    }

    public void knockBack1(Entity attacker, double x, double z, double base, Player player)
    {
        double xzKB = base, yKB = base;

        if(attacker instanceof Player)
        {
            xzKB = 1.06;
            yKB = 1.06;
        }

        double f = Math.sqrt(x * x + z * z);
        if (f > 0.0D)
        {
            f = 1.0D / f;
            Vector3 motion = new Vector3(player.motionX, player.motionY, player.motionZ);
            motion.x /= 2.0D;
            motion.y /= 2.0D;
            motion.z /= 2.0D;
            motion.x += x * f * xzKB;
            motion.y += yKB;
            motion.z += z * f * xzKB;

            if (motion.y > yKB)
            {
                motion.y = yKB;
            }

            player.setMotion(motion);
        }
    }

    public void knockBack2(Entity attacker, double x, double z, double base, Player player)
    {
        double xzKB = base, yKB = base;

        if(attacker instanceof Player)
        {
            xzKB = 2.06;
            yKB = 2.06;
        }

        double f = Math.sqrt(x * x + z * z);
        if (f > 0.0D)
        {
            f = 1.0D / f;
            Vector3 motion = new Vector3(player.motionX, player.motionY, player.motionZ);
            motion.x /= 2.0D;
            motion.y /= 2.0D;
            motion.z /= 2.0D;
            motion.x += x * f * xzKB;
            motion.y += yKB;
            motion.z += z * f * xzKB;

            if (motion.y > yKB)
            {
                motion.y = yKB;
            }

            player.setMotion(motion);
        }
    }



    @EventHandler
    public void onPuch(DataPacketReceiveEvent e){
        DataPacket packet = e.getPacket();
        if (packet instanceof LevelSoundEventPacket) {
            if (((LevelSoundEventPacket) packet).sound == LevelSoundEventPacket.SOUND_ATTACK_NODAMAGE) {
                e.setCancelled(true);
            }
            else if (((LevelSoundEventPacket) packet).sound == LevelSoundEventPacket.SOUND_ATTACK) {
                e.setCancelled(true);
            }
            else if (((LevelSoundEventPacket) packet).sound == LevelSoundEventPacket.SOUND_ATTACK_STRONG) {
                e.setCancelled(true);
            }
        }
    }


//    @EventHandler
//    private static void a(EntityShootBowEvent e) {
//        System.out.println("1");
//        if (e.getEntity() instanceof Player && e.getProjectile() instanceof cn.nukkit.entity.projectile.EntityArrow) {
//            System.out.println("2");
//            Player p = (Player)e.getEntity();
//            EntityArrow entityArrow = (EntityArrow) e.getProjectile();
//            if (entityArrow.getLocation().getFloorX() <= 65 && entityArrow.getLocation().getFloorX() >= -65 && entityArrow.getLocation().getFloorZ() <= 65 && entityArrow.getLocation().getFloorZ() >= -65) {
//                e.setCancelled(true);
//                return;
//            }
//            System.out.println("3");
//            Knockback.onPostAttack(entityArrow, p, 2000);
//        }
//    }



//    private static void punch(Player player, EntityArrow arrow, float punchKnockback) {
//    if(punchKnockback > 0){
//        punchKnockback += 0.5;
//        if(player.isOnGround()){
//            Vector3 motion = arrow.getMotion();
//            double horizontalSpeed = Math.sqrt((motion.x * 2 + motion.z * 2));
//            if(horizontalSpeed > 0){
//                double multiplier = punchKnockback * 0.8 / horizontalSpeed;
//                player.setMotion(player.getMotion().add(motion.x * multiplier, 0.5, motion.z * multiplier));
//                EntityDamageEvent ev = new EntityDamageEvent(player, EntityDamageEvent.DamageCause.ENTITY_ATTACK, 0);
//                player.attack(ev);
//            }
//        }
//    }
//}




    @EventHandler
    public void onPVP(final EntityDamageEvent e) {
        if (e instanceof EntityDamageByEntityEvent) {
            if (((EntityDamageByEntityEvent)e).getDamager() instanceof Player) {
                final Player pa = (Player)((EntityDamageByEntityEvent)e).getDamager();
                Player paa = (Player) e.getEntity();
                for (final Enchantment e2 : pa.getInventory().getItemInHand().getEnchantments()) {
                    if (e2.getId() == 12) {
                        if (e2.getLevel() == 1) {
                            knockBack1(((EntityDamageByEntityEvent) e).getDamager(), 1.06, 1.06, 9, paa);
                            ((EntityDamageByEntityEvent) e).setKnockBack(0.476f);
                        } else {
                            knockBack(((EntityDamageByEntityEvent) e).getDamager(), 0.56, 0.56, 9, paa);
                            ((EntityDamageByEntityEvent) e).setKnockBack(0.376f);
                        }
                        if (e2.getLevel() == 2) {
                            knockBack2(((EntityDamageByEntityEvent) e).getDamager(), 2.06, 2.06, 9, paa);
                            ((EntityDamageByEntityEvent) e).setKnockBack(0.526f);
                        } else {
                            knockBack(((EntityDamageByEntityEvent) e).getDamager(), 0.56, 0.56, 9, paa);
                            ((EntityDamageByEntityEvent) e).setKnockBack(0.376f);
                        }
                    }
                }
            }
            else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
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

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Location l1 = e.getEntity().getLocation();
            Location l2 = e.getDamager().getLocation();
            if (l1.distance((Vector3)l2) > 4.0D)
                for (Player po : Server.getInstance().getOnlinePlayers().values()) {
                    User u = UserManager.getUser(po);
                    if (u.can(GroupType.HELPER))
                        ChatUtil.sendMessage((CommandSender)po, "&9[AC] &9" + ((Player)e.getDamager()).getName() + " &8-> &7Wykryto REACH!");
                }
        }
    }

}
