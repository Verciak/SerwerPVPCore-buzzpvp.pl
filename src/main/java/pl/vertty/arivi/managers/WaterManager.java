package pl.vertty.arivi.managers;

import cn.nukkit.level.Level;
import cn.nukkit.level.Position;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WaterManager {

    private static Map<Long, FakeWater> waters = new ConcurrentHashMap<Long, FakeWater>();

    public static void createWater(Position pos) {
        if(!pos.isValid()) {
            return;
        }
        long hash = Level.blockHash(pos.getFloorX(), pos.getFloorY(), pos.getFloorZ());
        if(!waters.containsKey(hash)) {
            waters.put(hash, new FakeWater(pos.getX(), pos.getY(), pos.getZ(),pos.getLevel()));
        }
    }

    public static FakeWater getWater(Position pos) {
        if(!pos.isValid()) {
            return null;
        }
        long hash = Level.blockHash(pos.getFloorX(), pos.getFloorY(), pos.getFloorZ());
        if(waters.containsKey(hash)) {
            return waters.get(hash);
        }
        return null;
    }

    public static void removeWater(Position pos) {
        long hash = Level.blockHash(pos.getFloorX(), pos.getFloorY(), pos.getFloorZ());
        waters.remove(hash);
    }

    public static Map<Long,FakeWater> getWaters(){
        return waters;
    }

}
