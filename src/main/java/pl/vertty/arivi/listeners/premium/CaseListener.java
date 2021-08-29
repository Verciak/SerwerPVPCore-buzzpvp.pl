// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.listeners.premium;

import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.level.Location;
import java.util.Iterator;
import cn.nukkit.block.Block;
import pl.vertty.arivi.utils.PolishItemNames;
import cn.nukkit.level.particle.Particle;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.Server;
import cn.nukkit.level.particle.FloatingTextParticle;
import java.util.concurrent.TimeUnit;
import cn.nukkit.command.CommandSender;
import org.apache.commons.lang3.RandomUtils;
import pl.vertty.arivi.drop.skrzynka.SkrzynkaManager;
import cn.nukkit.item.Item;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.Coooldown;
import cn.nukkit.event.Listener;

public class CaseListener implements Listener
{
    private static final Coooldown<Player> COOLDOWN;
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getBlock().getId() == 54 && Main.getPlugin().getCrateLocations().containsKey(e.getBlock().getLocation())) {
            e.setCancelled(true);
            if (p.getInventory().getItemInHand().getCustomName().equalsIgnoreCase(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("key.name")))) {
                final Item pandoreItemm = SkrzynkaManager.drop.get(RandomUtils.nextInt(0, SkrzynkaManager.drop.size()));
                if (pandoreItemm.hasCustomName()) {
                    if (CaseListener.COOLDOWN.isOnCooldown(p)) {
                        ChatUtil.sendMessage((CommandSender)p, "&cSkrzynke mozesz otwierac co 2 sekundy!");
                        e.setCancelled(true);
                        return;
                    }
                    CaseListener.COOLDOWN.putOnCooldown(p, TimeUnit.SECONDS, 2L);
                    final Block block = e.getBlock();
                    if (Main.getPlugin().getParticles().size() == 0) {
                        return;
                    }
                    if (Main.getPlugin().getParticles() == null) {
                        return;
                    }
                    if (Main.getPlugin().getParticles().values() == null) {
                        return;
                    }
                    for (final FloatingTextParticle pa : Main.getPlugin().getParticles().values()) {
                        if (pa != null) {
                            if (pandoreItemm.getId() == 138 && !pl.vertty.arivi.drop.utils.RandomUtils.getChance(2.5)) {
                                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz: &f{PLAYER} &7wydropil: &eBEACON &7z &5Magiczej skrzynki!").replace("{PLAYER}", p.getName()).replace("{NAME}", pandoreItemm.getName()));
                            }
                            remove(p, block);
                            final Item itemInHand = e.getPlayer().getInventory().getItemInHand();
                            if (itemInHand.getCount() <= 1) {
                                e.getPlayer().getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                            }
                            else {
                                itemInHand.setCount(itemInHand.getCount() - 1);
                                e.getPlayer().getInventory().setItemInHand(itemInHand);
                            }
                            ItemUtil.giveItem(p, pandoreItemm);
                            final Location location = block.getLocation();
                            final FloatingTextParticle particle = new FloatingTextParticle(location.add(0.5, 2.0, 0.5), ChatUtil.fixColor("&9Magiczna Skrzynka"), ChatUtil.fixColor("&8\u2039-------------------------\u203a\n\n&9Gratulacje wylosowales: &7" + pandoreItemm.getCustomName() + " &fx" + pandoreItemm.getCount()));
                            p.getLocation().getLevel().addParticle((Particle)particle);
                            Main.particles1.put(location, particle);
                            e.getPlayer().getServer().getScheduler().scheduleDelayedTask(() -> remove1(p, block), 35);
                            e.getPlayer().getServer().getScheduler().scheduleDelayedTask(() -> add(block.getLocation()), 35);
                            e.setCancelled(true);
                        }
                    }
                }
                else {
                    if (CaseListener.COOLDOWN.isOnCooldown(p)) {
                        ChatUtil.sendMessage((CommandSender)p, "&cSkrzynke mozesz otwierac co 2 sekundy!");
                        e.setCancelled(true);
                        return;
                    }
                    CaseListener.COOLDOWN.putOnCooldown(p, TimeUnit.SECONDS, 2L);
                    final Block block = e.getBlock();
                    if (Main.getPlugin().getParticles().size() == 0) {
                        return;
                    }
                    if (Main.getPlugin().getParticles() == null) {
                        return;
                    }
                    if (Main.getPlugin().getParticles().values() == null) {
                        return;
                    }
                    for (final FloatingTextParticle pa : Main.getPlugin().getParticles().values()) {
                        if (pa != null) {
                            if (pandoreItemm.getId() == 138 && !pl.vertty.arivi.drop.utils.RandomUtils.getChance(0.5)) {
                                Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz: &f{PLAYER} &7wydropil: &eBEACON &7z &5Magiczej skrzynki!").replace("{PLAYER}", p.getName()).replace("{NAME}", pandoreItemm.getName()));
                            }
                            remove(p, block);
                            final Item itemInHand = e.getPlayer().getInventory().getItemInHand();
                            if (itemInHand.getCount() <= 1) {
                                e.getPlayer().getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                            }
                            else {
                                itemInHand.setCount(itemInHand.getCount() - 1);
                                e.getPlayer().getInventory().setItemInHand(itemInHand);
                            }
                            ItemUtil.giveItem(p, pandoreItemm);
                            final Location location = block.getLocation();
                            final FloatingTextParticle particle = new FloatingTextParticle(location.add(0.5, 2.0, 0.5), ChatUtil.fixColor("&9Magiczna Skrzynka"), ChatUtil.fixColor("&8\u2039-------------------------\u203a\n\n&9Gratulacje wylosowales: &7" + PolishItemNames.getPolishName(pandoreItemm) + " &fx" + pandoreItemm.getCount()));
                            p.getLocation().getLevel().addParticle((Particle)particle);
                            Main.particles1.put(location, particle);
                            e.getPlayer().getServer().getScheduler().scheduleDelayedTask(() -> remove1(p, block), 35);
                            e.getPlayer().getServer().getScheduler().scheduleDelayedTask(() -> add(block.getLocation()), 35);
                            e.setCancelled(true);
                        }
                    }
                }
            }
            else {
                ChatUtil.sendMessage((CommandSender)p, "&cNie posiadasz klucza!");
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onBreakChest(final BlockBreakEvent e) {
        final Block block = e.getBlock();
        if (e.getBlock().getId() == 54 && e.getBlock().getLocation().equals((Object)Main.getPlugin().getCrateLocations())) {
            final FloatingTextParticle particle = Main.getPlugin().getParticles().remove(block.getLocation());
            particle.setInvisible(true);
            particle.setTitle("");
        }
    }
    
    public static void add(final Location location) {
        final FloatingTextParticle particle = new FloatingTextParticle(location.add(0.5, 2.0, 0.5), ChatUtil.fixColor("&9Magiczna Skrzynka"), ChatUtil.fixColor("&8\u2039-------------------------\u203a\n\n&9Kliknij na nia kluczem, aby otworzyc\n&9Klucz zakupisz na stronie BlazePE.pl\n\n&8\u2039-------------------------\u203a\n"));
        location.getLevel().addParticle((Particle)particle);
        Main.particles.put(location, particle);
    }
    
    public static void remove(final Player p, final Block block) {
        if (Main.getPlugin().getParticles().size() == 0) {
            return;
        }
        if (Main.getPlugin().getParticles() == null) {
            return;
        }
        final FloatingTextParticle particle = Main.getPlugin().getParticles().remove(block.getLocation());
        particle.setInvisible(true);
        particle.setTitle("");
        particle.setText("");
    }
    
    public static void remove1(final Player p, final Block block) {
        if (Main.getPlugin().getParticles1().size() == 0) {
            return;
        }
        if (Main.getPlugin().getParticles1() == null) {
            return;
        }
        final FloatingTextParticle particle = Main.getPlugin().getParticles1().remove(block.getLocation());
        particle.setInvisible(true);
        particle.setTitle("");
        particle.setText("");
    }
    
    static {
        COOLDOWN = new Coooldown<Player>();
    }
}
