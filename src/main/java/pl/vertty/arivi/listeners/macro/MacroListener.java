package pl.vertty.arivi.listeners.macro;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.inventory.transaction.data.UseItemOnEntityData;
import cn.nukkit.network.protocol.InventoryTransactionPacket;
import cn.nukkit.network.protocol.LevelSoundEventPacket;
import cn.nukkit.scheduler.AsyncTask;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class MacroListener implements Listener {

    private static List<Integer> sounds = Arrays.asList(LevelSoundEventPacket.SOUND_ATTACK, LevelSoundEventPacket.SOUND_ATTACK_NODAMAGE, LevelSoundEventPacket.SOUND_ATTACK_STRONG,
            LevelSoundEventPacket.SOUND_PREPARE_ATTACK, LevelSoundEventPacket.SOUND_CONDUIT_ATTACK, LevelSoundEventPacket.SOUND_BLOCK_TURTLE_EGG_ATTACK);

    @EventHandler
    public void onMacro(DataPacketReceiveEvent e) {
        User u = UserManager.getUser(e.getPlayer());
        if (u != null && u.packetLimit()) {
            e.setCancelled(true);
            e.getPlayer().close(ChatUtil.fixColor("&cPrzekroczyles limit pakietow!"));
            return;
        }
        if (e.getPacket() instanceof LevelSoundEventPacket) {
            if (sounds.contains(((LevelSoundEventPacket) e.getPacket()).sound)) {
                e.setCancelled(true);
                Player p = e.getPlayer();
                if (u != null) {
                    if (u.hasMacroMax()) {
                        e.getPlayer().close(ChatUtil.fixColor("&cPrzekroczyles limit pakietow!"));
                        return;
                    }
                    if (u.macroLimit()) {
                        e.getPlayer().sendTitle(ChatUtil.fixColor("&l&4LIMIT CPS"), ChatUtil.fixColor("&cMaksymalna ilosc CPS: 12"));
                    }
                }
            }
        } else if (e.getPacket() instanceof InventoryTransactionPacket) {
            InventoryTransactionPacket pa = (InventoryTransactionPacket) e.getPacket();
            if (pa.transactionType == InventoryTransactionPacket.TYPE_USE_ITEM_ON_ENTITY) {
                if (u != null && u.entityLimit()) {
                    e.setCancelled(true);
                    e.getPlayer().close(ChatUtil.fixColor("&cPrzekroczyles limit pakietow!"));
                    return;
                }
                UseItemOnEntityData data = (UseItemOnEntityData) pa.transactionData;
                if (data.actionType == InventoryTransactionPacket.USE_ITEM_ON_ENTITY_ACTION_ATTACK) {
                    if (u != null && u.hasMacroLimit()) {
                        e.setCancelled(true);
                        return;
                    }
                }
            }
        }
    }

}
