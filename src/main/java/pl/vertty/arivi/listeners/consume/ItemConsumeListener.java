package pl.vertty.arivi.listeners.consume;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerItemConsumeEvent;
import cn.nukkit.item.Item;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;

public class ItemConsumeListener implements Listener {

    @EventHandler
    public void kox(PlayerItemConsumeEvent e) {
        Item item = e.getItem();
        Player p = e.getPlayer();
        if (item.getId() == 466) {
            if (item.hasCustomName()) {
                p.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
            }
            p.getFoodData().setLevel(p.getFoodData().getLevel() + 4);
            p.getInventory().removeItem(new Item[] { new Item(466, Integer.valueOf(0), 1) });
            e.setCancelled(true);
            User u = UserManager.getUser(p);
            for (Effect pot : p.getEffects().values()) {
                if (pot.getId() == 22)
                    p.removeEffect(22);
                if (pot.getId() == 10)
                    p.removeEffect(10);
                if (pot.getId() == 11)
                    p.removeEffect(11);
                if (pot.getId() == 12)
                    p.removeEffect(12);
            }
            p.addEffect(
                    Effect.getEffect(22)
                            .setAmplifier(0)
                            .setDuration(2400)
                            .setVisible(true));
            p.addEffect(
                    Effect.getEffect(10)
                            .setAmplifier(4)
                            .setDuration(300)
                            .setVisible(true));
            p.addEffect(
                    Effect.getEffect(11)
                            .setAmplifier(0)
                            .setDuration(300)
                            .setVisible(true));
            p.addEffect(
                    Effect.getEffect(12)
                            .setAmplifier(0)
                            .setDuration(6000)
                            .setVisible(true));
        }
        if (item.getId() == 322) {
            if (item.hasCustomName()) {
                p.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
            }
            p.getInventory().removeItem(new Item[] { new Item(322, Integer.valueOf(0), 1) });
            p.getFoodData().setLevel(p.getFoodData().getLevel() + 4);
            e.setCancelled(true);
            User u = UserManager.getUser(p);
            for (Effect pot : p.getEffects().values()) {
                if (pot.getId() == 22)
                    p.removeEffect(22);
                if (pot.getId() == 10)
                    p.removeEffect(10);
                if (pot.getId() == 11)
                    p.removeEffect(11);
                if (pot.getId() == 12)
                    p.removeEffect(12);
            }
            p.addEffect(
                    Effect.getEffect(22)
                            .setAmplifier(2)
                            .setDuration(2400)
                            .setVisible(true));
            p.addEffect(
                    Effect.getEffect(10)
                            .setAmplifier(3)
                            .setDuration(165)
                            .setVisible(true));
            p.addEffect(
                    Effect.getEffect(12)
                            .setAmplifier(0)
                            .setDuration(150)
                            .setVisible(true));
        }
    }

}
