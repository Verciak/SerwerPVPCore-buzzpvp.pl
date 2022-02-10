// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.chat;

import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.commands.guild.GuildPermissionCommand;
import cn.nukkit.item.Item;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
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

public class ServerChatListener implements Listener
{
    public static Config c;
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        final User u = UserManager.getUser(player);
        if (!u.can(GroupType.ADMIN)) {
            final String message = event.getMessage();
            final String[] splittedMessage = message.split(" ");
            final String[] pluginCommands = { "/pl", "/plugins", "/?", "/help", "/ver", "/version", "/nukkit", "/nukkit:ver", "/nukkit:version", "/icanhasnukkit", "/nukkit:help", "nukkit:?", "/me", "/nukkit:me", "/minecraft:me", "/about" };
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
            ChatUtil.sendMessage((CommandSender)p, "&cChat jest dostepny od rangi &3VIP");
            e.setCancelled(true);
            return;
        }
        if (!u.can(GroupType.HELPER) && !ChatManager.enable && !ChatManager.vipChat) {
            ChatUtil.sendMessage((CommandSender)p, "&cChat jest aktualnie wylaczony!");
            e.setCancelled(true);
            return;
        }
        if (!u.can(GroupType.HELPER) && !u.isChat()) {
            ChatUtil.sendMessage((CommandSender)p, "&8>> &cNa czacie bedziesz mogl pisac dopiero za &3" + (DataUtil.secondsToString(u.getLastChat()).isEmpty() ? "0s" : DataUtil.secondsToString(u.getLastChat())));
            e.setCancelled(true);
            return;
        }
        u.setLastChat(System.currentTimeMillis() + TimeUtil.SECOND.getTime(ServerChatListener.c.getInt("slowmode")));
        e.setCancelled(true);
        final Guild gGET = u.getGuild();
        final User usa = UserManager.getUser(player);
        final String message = e.getMessage();
        if (User.skarbiec_eme) {
            final Guild guild = GuildManager.getGuild(player);
            if (!pl.vertty.arivi.guilds.utils.ChatUtil.isInteger(message)) {
                pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
                pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
                User.skarbiec_eme = false;
                return;
            }
            if (!player.getInventory().contains(new Item(388, Integer.valueOf(0), Integer.parseInt(message)))) {
                pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
                pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE4));
                User.skarbiec_eme = false;
                return;
            }
            guild.setSkarbiec(guild.getSkarbiec() + Integer.parseInt(message));
            player.getInventory().removeItem(new Item[] { new Item(388, Integer.valueOf(0), Integer.parseInt(message)) });
            pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
            pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE3));
            e.setCancelled(true);
            User.skarbiec_eme = false;
        }
        else if (User.skarbiec_head) {
            final Guild guild = GuildManager.getGuild(player);
            if (!pl.vertty.arivi.guilds.utils.ChatUtil.isInteger(message)) {
                pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
                pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
                User.skarbiec_head = false;
                return;
            }
            if (!player.getInventory().contains(new Item(397, Integer.valueOf(3), Integer.parseInt(message)))) {
                pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
                pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE2));
                User.skarbiec_head = false;
                return;
            }
            guild.setHead(guild.getHead() + Integer.parseInt(message));
            player.getInventory().removeItem(new Item[] { Item.get(397, Integer.valueOf(3), Integer.parseInt(message)) });
            pl.vertty.arivi.guilds.utils.ChatUtil.sendTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_TITLE));
            pl.vertty.arivi.guilds.utils.ChatUtil.sendSubTitle(player, pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_PANEL_SKARBIEC_SUBTITLE));
            e.setCancelled(true);
            User.skarbiec_head = false;
        }
        else {
            if (User.update_name) {
                GuildPermissionCommand.roler.setName(message);
                User.update_name = false;
                pl.vertty.arivi.guilds.utils.ChatUtil.sendMessage((CommandSender)player, "&7Nazwa roli zostala zmieniona na &9" + GuildPermissionCommand.roler.getName());
                e.setCancelled(true);
                return;
            }
            if (message.startsWith("##")) {
                e.setCancelled(true);
                final Guild guild = GuildManager.getGuild(player);
                if (guild == null) {
                    pl.vertty.arivi.guilds.utils.ChatUtil.sendMessage((CommandSender)player, pl.vertty.arivi.guilds.data.yml.Config.GUILD_NOT_GUILD);
                    return;
                }
                final String replace = message.replaceFirst("##", "").replace("&", "");
                guild.message(pl.vertty.arivi.guilds.data.yml.Config.CHAT_ALLY_USAGE.replace("{TAG}", guild.getTag()).replace("{NICK}", player.getName()).replace("{MESSAGE}", replace));
                final Iterator<String> iterator = guild.getAlly().iterator();
                while (iterator.hasNext()) {
                    final Guild guild2 = GuildManager.getGuild(iterator.next());
                    if (guild2 != null) {
                        guild2.message(pl.vertty.arivi.guilds.data.yml.Config.CHAT_ALLY_USAGE.replace("{TAG}", guild.getTag()).replace("{NICK}", player.getName()).replace("{MESSAGE}", replace));
                    }
                }
            }
            else if (message.startsWith("#")) {
                e.setCancelled(true);
                final Guild guild3 = GuildManager.getGuild(player);
                if (guild3 == null) {
                    pl.vertty.arivi.guilds.utils.ChatUtil.sendMessage((CommandSender)player, pl.vertty.arivi.guilds.data.yml.Config.GUILD_NOT_GUILD);
                    return;
                }
                guild3.message(pl.vertty.arivi.guilds.data.yml.Config.CHAT_GUILD_USAGE.replace("{NICK}", player.getName()).replace("{MESSAGE}", message.replaceFirst("#", "").replace("&", "")));
            }
            else {
                if (!message.startsWith("!")) {
                    for (final Player all : Server.getInstance().getOnlinePlayers().values()) {
                        final User ua = UserManager.getUser(p);
                        String tag = "";
                        final Guild gSEND = UserManager.getUser(all).getGuild();
                        if (gGET != null) {
                            if (gSEND == null) {
                                tag = ChatUtil.fixColor("&8[&c" + gGET.getTag() + "&8] &r");
                            }
                            else if (gGET.getTag().equalsIgnoreCase(gSEND.getTag())) {
                                tag = ChatUtil.fixColor("&8[&a" + gGET.getTag() + "&8] &r");
                            }
                            else if (gSEND.getAlly().contains(gGET.getTag())) {
                                tag = ChatUtil.fixColor("&8[&6" + gGET.getTag() + "&8] &r");
                            }
                            else {
                                tag = ChatUtil.fixColor("&8[&c" + gGET.getTag() + "&8] &r");
                            }
                        }
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
                        globalFormat = globalFormat.replace("{LVL}", ChatUtil.fixColor(Integer.toString(u.getLvl())));
                        globalFormat = globalFormat.replace("{MSG}", e.getMessage().replace("&", ""));
                        all.sendMessage(ChatUtil.fixColor(globalFormat));
                    }
                    return;
                }
                e.setCancelled(true);
                final Guild guild = GuildManager.getGuild(player);
                if (guild == null) {
                    player.sendMessage(pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.GUILD_NOT_GUILD));
                    return;
                }
                guild.message(pl.vertty.arivi.guilds.utils.ChatUtil.fixColor(pl.vertty.arivi.guilds.data.yml.Config.CHAT_GUILD_HELP.replace("{NICK}", player.getName()).replace("{X}", Integer.toString(player.getLocation().getFloorX())).replace("{Z}", Integer.toString(player.getLocation().getFloorZ()))));
            }
        }
    }
    
    static {
        ServerChatListener.c = Main.getPlugin().getConfig();
    }
}
