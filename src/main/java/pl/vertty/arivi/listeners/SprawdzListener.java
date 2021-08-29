// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners;

import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.command.CommandSender;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.objects.Ban;
import pl.vertty.arivi.objects.Sprawdz;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.SprawdzManager;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.utils.DataUtil;

public class SprawdzListener implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            ChatUtil.sendMessage((CommandSender)event.getPlayer(), "&4Blad: &cNie mozesz tego robic! Kontakt z adminem: &7/wyslij [wiadomosc]");
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            final Sprawdz user = SprawdzManager.getByPlayer(event.getPlayer());
            Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracza &9{USER}&7 wylogowal sie podczas sprawdzania!").replace("{USER}", event.getPlayer().getName()));
            SprawdzManager.delete(event.getPlayer());
            final long time = DataUtil.parseDateDiff("3d", true);
            final Ban ban = new Ban(event.getPlayer().getName(), user.getAdmin().getName(), "Logout podczas sprawdzania", time);
            BanManager.addBan(event.getPlayer().getName(), ban);
        }
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            final Sprawdz user = SprawdzManager.getByPlayer(event.getPlayer());
            if (user != null) {
                ChatUtil.sendMessage((CommandSender)user.getAdmin(), "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", event.getMessage()).replace("/wyslij", "").replace("{USER}", user.getPlayer().getName()));
                ChatUtil.sendMessage((CommandSender)event.getPlayer(), "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", event.getMessage()).replace("/wyslij", "").replace("{USER}", user.getPlayer().getName()));
                event.setCancelled(true);
                return;
            }
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (SprawdzManager.getByPlayer(event.getPlayer()) != null) {
            final Sprawdz user = SprawdzManager.getByPlayer(event.getPlayer());
            if (user != null) {
                ChatUtil.sendMessage((CommandSender)user.getAdmin(), "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", event.getMessage()).replace("/wyslij", "").replace("{USER}", user.getPlayer().getName()));
                ChatUtil.sendMessage((CommandSender)event.getPlayer(), "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", event.getMessage()).replace("/wyslij", "").replace("{USER}", user.getPlayer().getName()));
                event.setCancelled(true);
                return;
            }
        }
    }
}
