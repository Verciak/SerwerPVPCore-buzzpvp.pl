
package pl.vertty.arivi.loader;

import cn.nukkit.level.Level;
import cn.nukkit.Server;

public class LevelLoad
{
    public static void onLevel() {
        final Level world = Server.getInstance().getDefaultLevel();
        world.setThundering(false);
        world.setTime(2000);
    }
}
