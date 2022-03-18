// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.task;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.AntiGrief;
import pl.vertty.arivi.guilds.data.Combat;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.nukkit.level.Level;
import pl.vertty.arivi.managers.FakeWater;
import pl.vertty.arivi.managers.WaterManager;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.NukkitRunnable;

public class CombatTask extends NukkitRunnable
{
    public void run() {
        for (ConcurrentHashMap<String, String> s : (Iterable<ConcurrentHashMap<String, String>>) AntiGrief.getGrief().values()) {
            if (Long.valueOf(s.get("time")).longValue() <= System.currentTimeMillis()) {
                Location loc = new Location(Integer.valueOf(s.get("x")).intValue(), Integer.valueOf(s.get("y")).intValue(), Integer.valueOf(s.get("z")).intValue(), Server.getInstance().getLevelByName(s.get("world")));
                Block v = loc.getLevelBlock();
                if (AntiGrief.removeBlock(v))
                    loc.getLevel().setBlock((Vector3)loc, Block.get(0));
            }
        }
        for(Map.Entry<Long, FakeWater> entry : WaterManager.getWaters().entrySet()) {
            if (!entry.getValue().canBeRemoved()) continue;
            if(entry.getValue().getLevel().getBlock(entry.getValue()).getId() == BlockID.STILL_WATER || entry.getValue().getLevel().getBlock(entry.getValue()).getId() == BlockID.WATER) {
                entry.getValue().getLocation().getLevel().setBlockAt(entry.getValue().getLocation().getFloorX(),
                        entry.getValue().getLocation().getFloorY(), entry.getValue().getLocation().getFloorZ(), BlockID.AIR);
            }
            WaterManager.removeWater(entry.getValue());
        }
        final Level l = Server.getInstance().getDefaultLevel();
        l.setTime(100);
        for (final Player p2 : Server.getInstance().getOnlinePlayers().values()) {
            final Combat u = CombatManager.getCombat(p2);
            final int seconds = (int)((u.getLastAttactTime() - System.currentTimeMillis()) / 1000L);
            if (u == null) {
                continue;
            }
            if (u.hasFight()) {
                ChatUtil.sendActionBar(p2, "&cJestes podczas walki jeszcze przez &6" + (DataUtil.secondsToString(u.getLastAttactTime()).isEmpty() ? "0 &csekund" : (DataUtil.secondsToString(u.getLastAttactTime()) + " &csekund")));
            }
            else {
                if (!u.wasFight()) {
                    continue;
                }
                if (u.hasFight()) {
                    continue;
                }
                ChatUtil.sendActionBar(p2, "&aMozesz sie wylogowac!");
                u.setLastAttactkPlayer(null);
                u.setLastAsystPlayer(null);
            }
        }
    }
}
