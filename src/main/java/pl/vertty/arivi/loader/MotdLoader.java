// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.Server;

public class MotdLoader
{
    public static void onLoad() {
        Server.getInstance().getNetwork().setName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("wl.motd")));
    }
}
