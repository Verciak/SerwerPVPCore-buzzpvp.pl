package pl.vertty.arivi.listeners.rzucak;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.item.EntityPrimedTNT;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.utils.Coooldown;
import pl.vertty.arivi.utils.ChatUtil;

import java.util.concurrent.TimeUnit;

public class RzucakListener implements Listener {

    private static final Coooldown<Player> COOLDOWN = new Coooldown<Player>();



    @EventHandler
    public void Farmery(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Guild guild = GuildManager.getGuild(player.getLocation());
        Item item = player.getInventory().getItemInHand();
        if (guild != null && guild.isMember(player)) {
            if(event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK || event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
                if (item.getCustomName().contains(ChatUtil.fixColor("&9ANTY-NOGI"))) {
                    event.setCancelled(true);
                    if (CombatManager.getCombat(player).hasFight()) {
                        for (Player p1 : Server.getInstance().getOnlinePlayers().values()) {
                            if (p1.getPlayer() != null && p1.getPlayer() != player.getPlayer() && player.getLocation().distance(p1.getLocation()) <= 5.0D) {
                                ChatUtil.sendTitle(player, ChatUtil.fixColor("&9ANTYNOGI"), ChatUtil.fixColor("&7SUKCES!"), 10, 20, 10);
                                player.teleport(p1.getLocation());
                                final Item itemInHand = player.getInventory().getItemInHand();
                                if (itemInHand.getCount() <= 1) {
                                    player.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                                } else {
                                    itemInHand.setCount(itemInHand.getCount() - 1);
                                    player.getInventory().setItemInHand(itemInHand);
                                }
                                return;
                            }
                            ChatUtil.sendTitle(player, ChatUtil.fixColor("&9ANTYNOGI"), ChatUtil.fixColor("&cNie odnaleziono gracza w promieniu 5 kratek!"), 20, 20, 20);
                        }
                    } else {
                        ChatUtil.sendTitle(player, ChatUtil.fixColor("&9ANTYNOGI"), ChatUtil.fixColor("&cNie jestes podczas pvp!"), 20, 20, 20);
                    }
                }
            }
            if(event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
                if (item.getCustomName().contains(ChatUtil.fixColor("&9BOYFARMER"))) {
                    event.setCancelled(true);
                    final Item itemInHand = player.getInventory().getItemInHand();
                    if (itemInHand.getCount() <= 1) {
                        player.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                    } else {
                        itemInHand.setCount(itemInHand.getCount() - 1);
                        player.getInventory().setItemInHand(itemInHand);
                    }
                    if(guild.getRegion().isInCentrum(new Location(event.getBlock().getX(), 42, event.getBlock().getZ()), 5, 0, 4)){
                        for (int i = 1; i < 41; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(49));
                        }
                        for (int i = 47; i < event.getBlock().getLocation().getFloorY() + 1; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(49));
                        }
                    }else{
                        for (int i = 1; i < event.getBlock().getLocation().getFloorY() + 1; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(49));
                        }
                    }
                }
                if (item.getCustomName().contains(ChatUtil.fixColor("&9KOPACZ"))) {
                    event.setCancelled(true);
                    final Item itemInHand = player.getInventory().getItemInHand();
                    if (itemInHand.getCount() <= 1) {
                        player.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                    } else {
                        itemInHand.setCount(itemInHand.getCount() - 1);
                        player.getInventory().setItemInHand(itemInHand);
                    }
                    if(guild.getRegion().isInCentrum(new Location(event.getBlock().getX(), 42, event.getBlock().getZ()), 5, 0, 4)){
                        for (int i = 1; i < 41; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(0));
                        }
                        for (int i = 47; i < event.getBlock().getLocation().getFloorY() + 1; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(0));
                        }
                    }else{
                        for (int i = 1; i < event.getBlock().getLocation().getFloorY() + 1; i++) {
                            Location c = event.getBlock().getLocation();
                            Level l = Server.getInstance().getDefaultLevel();
                            double x = c.getFloorX();
                            double z = c.getFloorZ();
                            l.setBlock(new Vector3(x, i, z), Block.get(0));
                        }
                    }
                }
                if (item.getCustomName().contains(ChatUtil.fixColor("&9RZUCANETNT"))) {
                    if (COOLDOWN.isOnCooldown(player)) {
                        ChatUtil.sendMessage((CommandSender)player, "&cRrzucane TNT mozesz rzucic za 30 sekund!");
                        event.setCancelled(true);
                        return;
                    }
                    COOLDOWN.putOnCooldown(player, TimeUnit.SECONDS, 30L);
                    event.setCancelled(true);
                    final Item itemInHand = player.getInventory().getItemInHand();
                    if (itemInHand.getCount() <= 1) {
                        player.getInventory().setItemInHand(new Item(0, Integer.valueOf(0), 0));
                    } else {
                        itemInHand.setCount(itemInHand.getCount() - 1);
                        player.getInventory().setItemInHand(itemInHand);
                    }
                    Position pos = player.add(0, player.getEyeHeight());
                    Vector3 motion = player.getDirectionVector().multiply(0.6);

                    CompoundTag nbt = new CompoundTag()
                            .putList(new ListTag<DoubleTag>("Pos")
                                    .add(new DoubleTag("", pos.x))
                                    .add(new DoubleTag("", pos.y))
                                    .add(new DoubleTag("", pos.z)))
                            .putList(new ListTag<DoubleTag>("Motion")
                                    .add(new DoubleTag("", motion.x))
                                    .add(new DoubleTag("", motion.y))
                                    .add(new DoubleTag("", motion.z)))
                            .putList(new ListTag<FloatTag>("Rotation")
                                    .add(new FloatTag("", 0))
                                    .add(new FloatTag("", 0)))
                            .putShort("Fuse", 80);
                    Entity tnt = new EntityPrimedTNT(player.getChunk(), nbt);
                    tnt.spawnToAll();
                    event.getBlock().level.addSound(event.getBlock(), Sound.RANDOM_FUSE);
                }
            }
        }
    }

}
