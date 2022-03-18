package pl.vertty.arivi;

import cn.nukkit.block.Block;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pl.vertty.arivi.enums.TimeUtil;

public class AntiGrief {
    private static Map<String, ConcurrentHashMap<String, String>> grief = new ConcurrentHashMap<>();

    public static Map<String, ConcurrentHashMap<String, String>> getGrief() {
        return grief;
    }

    public static boolean removeBlock(Block b) {
        ConcurrentHashMap<String, String> h = grief.get(b.getLocationHash());
        if (h != null)
            grief.remove(b.getLocationHash());
        return !ignored.contains(Integer.valueOf(b.getId()));
    }

    private static List<Integer> ignored = Arrays.asList(new Integer[] { Integer.valueOf(116), Integer.valueOf(130), Integer.valueOf(47), Integer.valueOf(58), Integer.valueOf(54), Integer.valueOf(146) });

    public static boolean AddBlock(Block b) {
        if (!ignored.contains(Integer.valueOf(b.getId())) && !(b instanceof cn.nukkit.block.BlockCactus)) {
            ConcurrentHashMap<String, String> id = new ConcurrentHashMap<>();
            id.put("world", b.getLevel().getName());
            id.put("x", String.valueOf(b.getLocation().getFloorX()));
            id.put("y", String.valueOf(b.getLocation().getFloorY()));
            id.put("z", String.valueOf(b.getLocation().getFloorZ()));
            id.put("time", String.valueOf(System.currentTimeMillis() + TimeUtil.MINUTE.getTime(5)));
            ConcurrentHashMap<String, String> h = grief.get(b.getLocationHash());
            if (h != null) {
                grief.replace(b.getLocationHash(), id);
            } else {
                grief.put(b.getLocationHash(), id);
            }
            return true;
        }
        return false;
    }
}

