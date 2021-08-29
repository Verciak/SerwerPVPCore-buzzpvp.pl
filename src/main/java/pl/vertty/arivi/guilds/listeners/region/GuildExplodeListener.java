// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners.region;

import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.level.Location;
import java.util.List;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.guilds.data.block.BlockRegeneration;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.SpaceUtil;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.event.entity.EntityExplodeEvent;
import cn.nukkit.event.Listener;

public class GuildExplodeListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void OnExplode(final EntityExplodeEvent entityExplodeEvent) {
        if (Config.ENABLE_TNT) {
            final Guild guildByLoc = GuildManager.getGuildByLoc(entityExplodeEvent.getEntity().getLocation());
            if (guildByLoc != null) {
                if (guildByLoc.getCreateTime() + TimeUtil.HOUR.getTime(24) > System.currentTimeMillis()) {
                    entityExplodeEvent.setCancelled(true);
                    return;
                }
                if (guildByLoc.getTntKaraTime() > System.currentTimeMillis()) {
                    entityExplodeEvent.setCancelled(false);
                    return;
                }
                if (guildByLoc.getRegion().isInCentrum(entityExplodeEvent.getEntity().getLocation(), 5, 0, 4)) {
                    entityExplodeEvent.setCancelled(true);
                    return;
                }
                guildByLoc.setLastExplodeTime(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(2));
                guildByLoc.message(Config.GUILD_TNT_MESSAGE.replace("{X}", "120s"));
            }
            else {
                entityExplodeEvent.getBlockList().clear();
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onExplode(final EntityExplodeEvent entityExplodeEvent) {
        final Guild guildByLoc = GuildManager.getGuildByLoc(entityExplodeEvent.getEntity().getLocation());
        if (guildByLoc != null && guildByLoc.getRegion().isInCentrum(entityExplodeEvent.getEntity().getLocation(), 5, 0, 4)) {
            entityExplodeEvent.setCancelled(true);
            return;
        }
        if (guildByLoc != null && guildByLoc.getTntKaraTime() < System.currentTimeMillis()) {
            final List<Location> sphere = SpaceUtil.sphere(entityExplodeEvent.getEntity().getLocation(), 3, 3, false, true, 0);
            final Guild guild = guildByLoc;
            sphere.forEach(location -> {
                Block block = Server.getInstance().getDefaultLevel().getBlock(location.getFloorX(), location.getFloorY(), location.getFloorZ());
                Block u = Server.getInstance().getDefaultLevel().getBlock(location.getFloorX(), location.getFloorY(), location.getFloorZ());
                Block l = Server.getInstance().getDefaultLevel().getBlock(location.getFloorX(), location.getFloorY(), location.getFloorZ());
                if (block.getId() == 46) {
                    guild.getBlocks().add(new BlockRegeneration(0, block.getLocation()));
                }
                else if (u.getId() == 138) {
                    if (RandomUtil.getChance(5.0)) {
                        l.getLocation().getLevel().dropItem(new Vector3(location.getX(), location.getY(), location.getZ()), new Item(138, Integer.valueOf(0), 1));
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(0, block.getLocation()));
                        }
                    }
                    else {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        guild.getBlocks().add(new BlockRegeneration(0, block.getLocation()));
                    }
                }
                else if (u.getId() == 49) {
                    if (!RandomUtil.getChance(7.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 8) {
                    if (!RandomUtil.getChance(10.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 145) {
                    if (!RandomUtil.getChance(35.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 10) {
                    if (!RandomUtil.getChance(10.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 8) {
                    if (!RandomUtil.getChance(50.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 10) {
                    if (!RandomUtil.getChance(50.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 130) {
                    if (!RandomUtil.getChance(50.0)) {
                        l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                        if (u.getId() != 0) {
                            guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                        }
                    }
                }
                else if (u.getId() == 116 && !RandomUtil.getChance(50.0)) {
                    l.getLocation().getLevel().setBlock(new Vector3(location.getX(), location.getY(), location.getZ()), Block.get(0));
                    if (u.getId() != 0) {
                        guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                    }
                }
                else if (u.getId() != 0) {
                    guild.getBlocks().add(new BlockRegeneration(block.getId(), block.getLocation()));
                }
            });
        }
        else {
            entityExplodeEvent.getBlockList().clear();
        }
    }

    @EventHandler
    public void onTnt(BlockPlaceEvent e){
        Block b = e.getBlock();
        if(b.getId() == Block.TNT){
            if(b.getFloorY() > 45){
                ChatUtil.sendMessage(e.getPlayer(), "&cTNT mozna stawiac ponizej 45 kratki!");
                e.setCancelled(true);
            }
        }
    }
}
