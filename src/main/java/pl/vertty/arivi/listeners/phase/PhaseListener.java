package pl.vertty.arivi.listeners.phase;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockFence;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.Faceable;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.commands.helper.ACCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class PhaseListener implements Listener {

    private boolean inBlock(final Location loc) {
        Block b1 = getBlock(loc.getLevel(), loc.getFloorX(), loc.getFloorY(), loc.getFloorZ(), false);
        Location lup = loc.getSide(BlockFace.UP).getLocation();
        Block b2 = getBlock(loc.getLevel(), lup.getFloorX(), lup.getFloorY(), lup.getFloorZ(), false);
        return b1.isNormalBlock() && b2.isNormalBlock() && b1.getId() != BlockID.AIR && b2.getId() != BlockID.AIR
                && !(b1 instanceof BlockFence) && !(b2 instanceof BlockFence)
                && !(b1 instanceof Faceable) && !(b2 instanceof Faceable) && !b2.canPassThrough() && !b1.canPassThrough();
    }

    @EventHandler
    public void onPhase(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(!p.isOp()) {
            if (e.getFrom().clone().setComponents(e.getFrom().getX(), 0, e.getFrom().getZ()).distance(e.getTo().clone().setComponents(e.getTo().getX(), 0, e.getTo().getZ())) >= 4) {
                if(UserManager.getUser(p).can(GroupType.HELPER)){
                    return;
                }
                e.getPlayer().teleport(e.getFrom());
                if(!ACCommand.status) {
                    for (Player paa : Server.getInstance().getOnlinePlayers().values()) {
                        User ua = UserManager.getUser(paa);
                        if (ua.can(GroupType.HELPER)) {
                            if (!Cooldown.getInstance().has(paa, "PHASE")) {
                                ChatUtil.sendMessage(paa, "&9AC &8> &7Gracz &3" + p.getName() + " &7probuje &3przejsc przez sciane! &8(&f" + p.getPing() + "ms&8)!");
                                Cooldown.getInstance().add(paa, "PHASE", 5f);
                            }
                        }
                    }
                }
            } else {
                if ((e.getFrom().getFloorX() != e.getTo().getFloorX()) || (e.getFrom().getFloorZ() != e.getTo().getFloorZ()) || (e.getFrom().getFloorY() != e.getTo().getFloorY())) {
                    if (inBlock(e.getFrom()) && inBlock(e.getTo())) {
                        if(UserManager.getUser(p).can(GroupType.HELPER)){
                            return;
                        }
                        e.getPlayer().teleport(e.getFrom());
                        if(!ACCommand.status) {
                            for (Player paa : Server.getInstance().getOnlinePlayers().values()) {
                                User ua = UserManager.getUser(paa);
                                if (ua.can(GroupType.HELPER)) {
                                    if (!Cooldown.getInstance().has(paa, "PHASE2")) {
                                        ChatUtil.sendMessage(paa, "&9AC &8> &7Gracz &3" + p.getName() + " &7probuje &3przejsc przez sciane, bedac w niej! &8(&f" + p.getPing() + "ms&8)!");
                                        Cooldown.getInstance().add(paa, "PHASE2", 5f);
                                    }
                                }
                            }
                        }
                        return;
                    }
                    if (!inBlock(e.getFrom()) && inBlock(e.getTo())) {
                        if (UserManager.getUser(p).can(GroupType.HELPER)) {
                            return;
                        }
                        e.getPlayer().teleport(e.getFrom());
                        if (!ACCommand.status) {
                            for (Player paa : Server.getInstance().getOnlinePlayers().values()) {
                                User ua = UserManager.getUser(paa);
                                if (ua.can(GroupType.HELPER)) {
                                    if (!Cooldown.getInstance().has(paa, "PHASE3")) {
                                        ChatUtil.sendMessage(paa, "&9AC &8> &7Gracz &3" + p.getName() + " &7probuje &3wejsc w sciane! &8(&f" + p.getPing() + "ms&8)!");
                                        Cooldown.getInstance().add(paa, "PHASE3", 5f);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static Block getBlock(Level level, int x, int y, int z, boolean load) {
        int fullState;
        if (y >= 0 && y < 256) {
            int cx = x >> 4;
            int cz = z >> 4;
            BaseFullChunk chunk;
            if (load) {
                chunk = level.getChunk(cx, cz);
            } else {
                chunk = level.getChunkIfLoaded(cx, cz);
            }
            if (chunk != null) {
                fullState = chunk.getFullBlock(x & 15, y, z & 15);
            } else {
                fullState = 0;
            }
        } else {
            fullState = 0;
        }
        Block block = Block.fullList[fullState & 4095].clone();
        block.x = (double)x;
        block.y = (double)y;
        block.z = (double)z;
        block.level = level;
        return block;
    }

}
