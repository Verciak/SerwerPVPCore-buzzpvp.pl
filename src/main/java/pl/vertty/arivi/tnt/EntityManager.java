
package pl.vertty.arivi.tnt;

import cn.nukkit.entity.Entity;

public class EntityManager
{
    public static void init() {
        Entity.registerEntity("PrimedTnt", (Class)EntityPrimedTNT.class, true);
    }
}
