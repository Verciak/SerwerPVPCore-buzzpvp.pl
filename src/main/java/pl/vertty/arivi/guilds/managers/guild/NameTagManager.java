// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.managers.guild;

import java.util.Collection;
import pl.vertty.arivi.guilds.data.guild.Guild;
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
            final Guild g = GuildManager.getGuild(p);
            final Collection<Player> viewer = p.getViewers().values();
            final SetEntityDataPacket pk = new SetEntityDataPacket();
            for (final Player paa : viewer) {
                pk.eid = p.getId();
                String nick = p.getName();
                if (UserManager.getUser(p).isIncognitoNick() && !UserManager.getUser(paa).can(GroupType.HELPER)) {
                    nick = ChatUtil.fixColor("&8[&cNICK&8] ");
                }
                pk.metadata = new EntityMetadata().putString(4, ChatUtil.fixColor(getValidPrefix(p, paa) + "" + getSuffix(p) + "&7" + nick + "\n&3" + u.getPoints()));
                paa.batchDataPacket((DataPacket)pk);
            }
        }
    }
    
    public static String getValidPrefix(final Player get, final Player send) {
        final User u = UserManager.getUser(get);
        final User userr = UserManager.getUser(get);
        final Guild gGET = GuildManager.getGuild(get);
        final Guild gSEND = GuildManager.getGuild(send);
        if (gGET == null) {
            return "";
        }
        if (u.isIncognitoGuild()) {
            return "&8[&cUKRYTO&8] ";
        }
        if (gSEND == null) {
            return ChatUtil.fixColor("&8[&c" + gGET.getTag() + "&8] ");
        }
        if (gGET.getTag().contains(gSEND.getTag())) {
            return ChatUtil.fixColor("&8[&a" + gGET.getTag() + "&8] ");
        }
        if (gSEND.getAlly().contains(gGET.getTag())) {
            return ChatUtil.fixColor("&8[&6" + gGET.getTag() + "&8] ");
        }
        return ChatUtil.fixColor("&8[&c" + gGET.getTag() + "&8] ");
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
