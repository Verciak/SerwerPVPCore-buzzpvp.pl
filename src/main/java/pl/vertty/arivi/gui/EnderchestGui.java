// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;

public class EnderchestGui
{
    public static void openSchowek(final Player player) {
        final User u = UserManager.getUser(player);
        final Config c = Main.getPlugin().getConfig();
    }
}
