
package pl.vertty.arivi.guilds.listeners.permission;

import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.block.Block;
import cn.nukkit.event.player.PlayerBucketEmptyEvent;
import cn.nukkit.event.player.PlayerBucketFillEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.managers.RoleManager;
import pl.vertty.arivi.managers.GeneratorManager;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;
import pl.vertty.arivi.managers.WaterManager;

public class PermissionListener implements Listener
{

    @EventHandler
    public void onInteract(final PlayerInteractEvent playerInteractEvent) {
        final Player player = playerInteractEvent.getPlayer();
        final Guild guildByLoc = GuildManager.getGuildByLoc(player.getLocation());
        final User user = UserManager.getUser(player);
        if (guildByLoc != null && (guildByLoc.isMember(player) || player.isOp())) {
            if (playerInteractEvent.getAction() != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK || player.getInventory().getItemInHand().getId() != 270) {
                Item water = Item.get(325, 8, 1);
                if(player.getInventory().getItemInHand().getId() == 325){
                    if (!RoleManager.getUser(player).isUpr_Water()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                }
                if(player.getInventory().getItemInHand().getId() == 325){
                    if (!RoleManager.getUser(player).isUpr_Lava()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                }

                if (playerInteractEvent.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
                    if (playerInteractEvent.getBlock().getId() == 54 && !RoleManager.getUser(player).isUpr_Chest()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                    if (playerInteractEvent.getBlock().getId() == 61 && !RoleManager.getUser(player).isUpr_Furnace()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                    if (playerInteractEvent.getBlock().getId() == 62 && !RoleManager.getUser(player).isUpr_Furnace()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                    if (player.getInventory().getItemInHand().getId() == 46 && !RoleManager.getUser(player).isUpr_Tnt()) {
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                        playerInteractEvent.setCancelled(true);
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent blockPlaceEvent) {
        final Player player = blockPlaceEvent.getPlayer();
        final Guild guildByLoc = GuildManager.getGuildByLoc(player.getLocation());
        final Block b = blockPlaceEvent.getBlock();
        if (Config.ENABLE_STONIARKA) {
            if (!blockPlaceEvent.getPlayer().hasPermission("protect") && b.getLocation().getFloorX() <= 220 && b.getLocation().getFloorX() >= -220 && b.getLocation().getFloorZ() <= 220 && b.getLocation().getFloorZ() >= -220) {
                blockPlaceEvent.setCancelled(true);
                return;
            }
            GeneratorManager.createGenerator(player, blockPlaceEvent);
        }
        if (guildByLoc != null && guildByLoc.isMember(player)) {
            if (blockPlaceEvent.getBlock().getId() == 4 && !RoleManager.getUser(player).isUpr_Place_Stone()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockPlaceEvent.setCancelled(true);
                return;
            }
            if (blockPlaceEvent.getBlock().getId() == 49 && !RoleManager.getUser(player).isUpr_Place_Obsidian()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockPlaceEvent.setCancelled(true);
                return;
            }
            if (blockPlaceEvent.getBlock().getId() == 22 && !RoleManager.getUser(player).isUpr_Lapis()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockPlaceEvent.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent blockBreakEvent) {
        final Player player = blockBreakEvent.getPlayer();
        final Guild guildByLoc = GuildManager.getGuildByLoc(player.getLocation());
        if (Config.ENABLE_STONIARKA) {
            GeneratorManager.repairGenerator(player, blockBreakEvent);
        }
        if (guildByLoc != null && guildByLoc.isMember(player)) {
            final User user = UserManager.getUser(player);
            if (blockBreakEvent.getBlock().getId() == 54 && !RoleManager.getUser(player).isUpr_Chest()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockBreakEvent.setCancelled(true);
            }
            if (blockBreakEvent.getBlock().getId() == 1 && !RoleManager.getUser(player).isUpr_Break_Stone()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockBreakEvent.setCancelled(true);
            }
            if (blockBreakEvent.getBlock().getId() == 49 && !RoleManager.getUser(player).isUpr_Break_Obsidian()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockBreakEvent.setCancelled(true);
            }
            if (blockBreakEvent.getBlock().getId() == 22 && !RoleManager.getUser(player).isUpr_Lapis()) {
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENA_ERROR));
                blockBreakEvent.setCancelled(true);
            }
        }
    }
}
