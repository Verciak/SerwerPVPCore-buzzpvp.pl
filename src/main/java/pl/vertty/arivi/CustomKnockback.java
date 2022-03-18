package pl.vertty.arivi;

import cn.nukkit.entity.Entity;
import cn.nukkit.item.enchantment.EnchantmentKnockback;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;

public class CustomKnockback extends EnchantmentKnockback {
    public void doPostAttack(Entity attacker, Entity victim) {
        Vector3 vector3 = new Vector3();
        Position position = victim.getPosition().subtract((Vector3)attacker.getPosition());
        if (attacker.getPosition().floor().equals(victim.getPosition().floor()))
            vector3 = attacker.getDirectionVector();
        knockBack(victim, vector3.getX(), vector3.getZ(), getLevel() * 0.8D);
    }

    private void knockBack(Entity victim, double x, double z, double base) {
        double f = Math.sqrt(x * x + z * z);
        if (f <= 0.0D)
            return;
        f = 1.0D / f;
        Vector3 motion = victim.getMotion();
        motion.x /= 2.0D;
        motion.z /= 2.0D;
        motion.x += x * f * base;
        motion.z += z * f * base;
        if (victim.isOnGround()) {
            motion.y /= 2.0D;
            motion.y += base;
            if (motion.y > 0.4D)
                motion.y = 0.4D;
        }
        victim.setMotion(motion);
    }
}