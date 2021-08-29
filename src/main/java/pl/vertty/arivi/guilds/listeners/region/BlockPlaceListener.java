// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.Coooldown;
import pl.vertty.arivi.guilds.utils.DataUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.managers.CombatManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.EventPriority;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.guilds.utils.region.CuboidUtil;
import cn.nukkit.block.Block;
import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.listeners.premium.CaseListener;

import java.util.concurrent.TimeUnit;

public class BlockPlaceListener implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent blockPlaceEvent) {
        if (blockPlaceEvent.getBlock().getId() == 46 && !Config.ENABLE_TNT) {
            blockPlaceEvent.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_TNT_ERROR2));
            blockPlaceEvent.setCancelled(true);
        }
    }
    
    @EventHandler
    public void slimeblock(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        if (block.getId() == 165 && player.getFloorX() == block.getFloorX() && player.getFloorY() - 1 == block.getFloorY() && player.getFloorZ() == block.getFloorZ()) {
            player.setMotion(new Vector3(0.0, 2.0, 0.0));
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(final BlockPlaceEvent blockPlaceEvent) {
        blockPlaceEvent.setCancelled(CuboidUtil.cancelAction(blockPlaceEvent.getPlayer(), blockPlaceEvent.getBlock().getLocation(), "&cTo nie Twoja gildia!", blockPlaceEvent.getBlock().getId(), "POSTAWIENIE"));
    }
    private static final Coooldown<Player> COOLDOWN = new Coooldown<Player>();


    @EventHandler
    public void onWiadro(PlayerBucketEmptyEvent e) {
        Block i = e.getBlockClicked();
        if (i.getLocation().getFloorX() <= 150 && i.getLocation().getFloorX() >= -150 && i.getLocation().getFloorZ() <= 150 && i.getLocation().getFloorZ() >= -150) {
            if (COOLDOWN.isOnCooldown(e.getPlayer())) {
                e.setCancelled(true);
                return;
            }
            COOLDOWN.putOnCooldown(e.getPlayer(), TimeUnit.SECONDS, 3L);
            e.getPlayer().getInventory().remove(Item.get(ItemID.BUCKET,0,1));
            Server.getInstance().getDefaultLevel().setBlock(new Vector3(i.getX(), i.getY(), i.getZ()), Block.get(BlockID.WATER));
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), (Runnable) new Runnable() {
                @Override
                public void run() {
                    Server.getInstance().getDefaultLevel().setBlock(new Vector3(i.getX(), i.getY(), i.getZ()), Block.get(BlockID.AIR));
                    e.getPlayer().getInventory().addItem(Item.get(ItemID.BUCKET, 8, 1));
                }
            }, 19);
        }
        final Guild g = GuildManager.getGuildByLoc(i.getLocation());
        if (g != null) {
            if (COOLDOWN.isOnCooldown(e.getPlayer())) {
                e.setCancelled(true);
                return;
            }
            COOLDOWN.putOnCooldown(e.getPlayer(), TimeUnit.SECONDS, 3L);
            e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInHand());
            Server.getInstance().getDefaultLevel().setBlock(new Vector3(i.getX(), i.getY(), i.getZ()), Block.get(BlockID.WATER));
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), (Runnable) new Runnable() {
                @Override
                public void run() {
                    Server.getInstance().getDefaultLevel().setBlock(new Vector3(i.getX(), i.getY(), i.getZ()), Block.get(BlockID.AIR));
                    e.getPlayer().getInventory().addItem(Item.get(ItemID.BUCKET, 8, 1));
                }
            }, 19);
        }
    }

    @EventHandler
    public void onPlaceCentrum(final BlockPlaceEvent blockPlaceEvent) {
        final Player player = blockPlaceEvent.getPlayer();
        final Guild guild = GuildManager.getGuild(player.getLocation());
        final Combat combat = CombatManager.getCombat(player);
        Block i = blockPlaceEvent.getBlock();
        if (guild != null && guild.isMember(player) && combat.hasFight() && player.getFloorY() <= 50) {
            blockPlaceEvent.setCancelled(true);
            ChatUtil.sendMessage((CommandSender) player, "&cStawianie blokow ponizej 50 kratki jest zabronione!");
        }
        if (guild != null && guild.isMember(player) && guild.getRegion().isInCentrum(blockPlaceEvent.getBlock().getLocation(), 5, 0, 4)) {
            blockPlaceEvent.setCancelled(true);
            ChatUtil.sendMessage((CommandSender) player, Config.GUILD_BUILD_CENTER);
            return;
        }
        if (!blockPlaceEvent.getPlayer().isOp() && guild != null && guild.isMember(blockPlaceEvent.getPlayer().getName()) && guild.getLastExplodeTime() > System.currentTimeMillis()) {
            blockPlaceEvent.getPlayer().sendMessage(ChatUtil.fixColor(Config.GUILD_TNT_MESSAGE.replace("{X}", DataUtil.secondsToString(guild.getLastExplodeTime()))));
            blockPlaceEvent.setCancelled(true);
        }
    }
}
