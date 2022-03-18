// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.chat;

import cn.nukkit.event.player.PlayerJumpEvent;
import pl.vertty.arivi.Main;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import pl.vertty.arivi.enums.TimeUtil;
import pl.vertty.arivi.managers.SprawdzManager;
import pl.vertty.arivi.utils.DataUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.ChatManager;
import cn.nukkit.event.player.PlayerChatEvent;
import java.util.Iterator;
import java.util.List;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.utils.Config;
import cn.nukkit.event.Listener;

public class ServerChatListener implements Listener {
    public static Config c;

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        final User u = UserManager.getUser(player);
        if (!u.can(GroupType.ADMIN)) {
            final String message = event.getMessage();
            final String[] splittedMessage = message.split(" ");
            final String[] pluginCommands = {"/pl", "/plugins", "/?", "/help", "/ver", "/version", "/nukkit", "/nukkit:ver", "/nukkit:version", "/icanhasnukkit", "/nukkit:help", "nukkit:?", "/me", "/nukkit:me", "/minecraft:me", "/about"};
            if (containsIgnoreCase(pluginCommands, splittedMessage[0])) {
                event.setCancelled(true);
            }
        }
    }

    public static boolean containsIgnoreCase(final String[] board, final String string) {
        for (final String otherstring : board) {
            if (otherstring.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(final List<String> board, final String string) {
        for (final String otherstring : board) {
            if (otherstring.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onChat(final PlayerChatEvent e) {
        if (e.isCancelled()) {
            return;
        }
        final Player p = e.getPlayer();
        final Player player = e.getPlayer();
        final User u = UserManager.getUser(p);
        if (u == null) {
            e.setCancelled(true);
            return;
        }
        if (SprawdzManager.getByPlayer(e.getPlayer()) != null) {
            e.setCancelled(true);
            return;
        }
        if (!u.can(GroupType.VIP) && ChatManager.vipChat) {
            ChatUtil.sendMessage((CommandSender) p, "&cChat jest dostepny od rangi &3VIP");
            e.setCancelled(true);
            return;
        }
        if (!u.can(GroupType.HELPER) && !ChatManager.enable && !ChatManager.vipChat) {
            ChatUtil.sendMessage((CommandSender) p, "&cChat jest aktualnie wylaczony!");
            e.setCancelled(true);
            return;
        }
        if (!u.can(GroupType.HELPER) && !u.isChat()) {
            ChatUtil.sendMessage((CommandSender) p, "&8>> &cNa czacie bedziesz mogl pisac dopiero za &3" + (DataUtil.secondsToString(u.getLastChat()).isEmpty() ? "0s" : DataUtil.secondsToString(u.getLastChat())));
            e.setCancelled(true);
            return;
        }
        u.setLastChat(System.currentTimeMillis() + TimeUtil.SECOND.getTime(ServerChatListener.c.getInt("slowmode")));
        e.setCancelled(true);
        final User usa = UserManager.getUser(player);
        final String message = e.getMessage();
        for (final Player all : Server.getInstance().getOnlinePlayers().values()) {
            final User ua = UserManager.getUser(p);
            String tag = "";
            String globalFormat = ServerChatListener.c.getString("format.global");
            if (u.can(GroupType.HELPER)) {
                globalFormat = ServerChatListener.c.getString("format.admin");
            }
            final String prefix = u.getGroup().getPrefix();
            final String ranga = u.getGroup().getFullName();
            final String suffix = u.getGroup().getSuffix();
            globalFormat = globalFormat.replace("{PREFIX}", ChatUtil.fixColor(prefix));
            globalFormat = globalFormat.replace("{RANGA}", ChatUtil.fixColor(ranga));
            globalFormat = globalFormat.replace("{SUFFIX}", ChatUtil.fixColor(suffix));
            globalFormat = globalFormat.replace("{GUILD}", ChatUtil.fixColor(tag));
            globalFormat = globalFormat.replace("{PLAYER}", ChatUtil.fixColor(p.getName()));
            globalFormat = globalFormat.replace("{POINTS}", ChatUtil.fixColor(ua.getPoints() + ""));
            globalFormat = globalFormat.replace("{MSG}", e.getMessage().replace("&", ""));
            all.sendMessage(ChatUtil.fixColor(globalFormat));
        }
        e.setCancelled(true);
    }

    static {
        ServerChatListener.c = Main.getPlugin().getConfig();
    }
}
