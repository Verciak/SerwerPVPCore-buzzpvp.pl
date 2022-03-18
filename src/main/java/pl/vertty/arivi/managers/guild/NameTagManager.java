// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers.guild;

import java.util.Collection;
import pl.vertty.arivi.guilds.data.User;
import java.util.Iterator;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.entity.data.EntityMetadata;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.network.protocol.SetEntityDataPacket;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.Server;

public class NameTagManager
{
    public static void refresh() {
        for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
            final User u = UserManager.getUser(p);
            final Collection<Player> viewer = p.getViewers().values();
            final SetEntityDataPacket pk = new SetEntityDataPacket();
            for (final Player paa : viewer) {
                pk.eid = p.getId();
                String nick = p.getName();
                pk.metadata = new EntityMetadata().putString(4, ChatUtil.fixColor("&c" + p.getPing() + "ms\n" + getSuffix(p) + "&7" + nick + "\n&3" + u.getPoints() + "pkt"));
                paa.batchDataPacket((DataPacket)pk);
            }
        }
    }
    
    private static String getSuffix(final Player p) {
        if (UserManager.getUser(p).isIncognitoNick()) {
            return "";
        }
        final User u = UserManager.getUser(p);
        final String prefix = u.getGroup().getPrefix();
        return prefix + " ";
    }
    
    public static void refreshAllNameTag() {
        refresh();
    }
}
