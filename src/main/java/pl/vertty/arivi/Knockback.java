package pl.vertty.arivi;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityLiving;
import cn.nukkit.item.enchantment.EnchantmentKnockback;
import cn.nukkit.math.Vector3;

public class Knockback extends EnchantmentKnockback {

    public static void onPostAttack(Entity attacker, Entity victim, int enchantmentLevel)
    {
        if (victim instanceof EntityLiving) {
            System.out.println("test");
            knockBack(victim, victim.getX() - attacker.getX(), victim.getZ() - attacker.getZ(), enchantmentLevel * 0.4);
        }
    }

    public static void knockBack(Entity victim, double x, double z, double base)
    {
        double f = (x * x + z * z);
        if (f <= 0) {
            return;
        }
        f = 1 / f;
        Vector3 motion = victim.getMotion();
        motion.x /= 2;
        motion.z /= 2;
        motion.x += x * f * base;
        motion.z += z * f * base;
        if (victim.onGround) {
            motion.y /= 2;
            motion.y += base;
            if (motion.y > 0.4) {
                motion.y = 0.4;
            }
        }
        victim.setMotion(motion);

    }

}
