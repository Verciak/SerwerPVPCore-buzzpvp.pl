package pl.vertty.arivi.managers;

import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import pl.vertty.arivi.enums.TimeUtil;

import java.sql.Time;

public class FakeWater extends Position {

    private long placetime;

    public FakeWater(double x, double y, double z, Level l) {
        super(x, y, z,l);
        this.placetime = System.currentTimeMillis();
    }

    public long getPlaceTime() {
        return this.placetime;
    }

    public boolean canBeRemoved() {
        return this.placetime + TimeUtil.SECOND.getTime(3) <= System.currentTimeMillis();
    }

}
