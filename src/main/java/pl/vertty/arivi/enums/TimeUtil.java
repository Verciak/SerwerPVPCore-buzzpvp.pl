// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.enums;

public enum TimeUtil
{
    TICK("TICK", 0, 50, 50), 
    MILLISECOND("MILLISECOND", 1, 1, 1), 
    SECOND("SECOND", 2, 1000, 1000), 
    MINUTE("MINUTE", 3, 60000, 60), 
    HOUR("HOUR", 4, 3600000, 60), 
    DAY("DAY", 5, 86400000, 24), 
    WEEK("WEEK", 6, 604800000, 7);
    
    public static final int MPT = 50;
    private final int time;
    private final int timeMulti;
    
    private TimeUtil(final String s, final int n, final int time, final int timeMulti) {
        this.time = time;
        this.timeMulti = timeMulti;
    }
    
    public int getMulti() {
        return this.timeMulti;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public int getTick() {
        return this.time / 50;
    }
    
    public int getTime(final int multi) {
        return this.time * multi;
    }
    
    public int getTick(final int multi) {
        return this.getTick() * multi;
    }
}
