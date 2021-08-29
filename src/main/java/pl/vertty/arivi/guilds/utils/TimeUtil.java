// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.utils;

import java.util.Calendar;

public enum TimeUtil
{
    DAY(86400000), 
    SECOND(1000), 
    MINUTE(60000), 
    TICK(50), 
    MILLISECOND(1), 
    WEEK(604800000), 
    HOUR(3600000);
    
    private static final TimeUtil[] $VALUES;
    private final int time;
    
    public static boolean isTnt() {
        final Calendar instance = Calendar.getInstance();
        return instance.get(11) <= 22 && instance.get(11) >= 11;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public int getTick(final int n) {
        return this.getTick() * n;
    }
    
    public int getTick() {
        return this.time / 50;
    }
    
    public int getTime(final int n) {
        return this.time * n;
    }
    
    private TimeUtil(final int time) {
        this.time = time;
    }
    
    static {
        $VALUES = new TimeUtil[] { TimeUtil.TICK, TimeUtil.MILLISECOND, TimeUtil.SECOND, TimeUtil.MINUTE, TimeUtil.HOUR, TimeUtil.DAY, TimeUtil.WEEK };
    }
}
