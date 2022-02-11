package pl.vertty.arivi.enums;

public enum TimeUtil
{
    TICK(50),
    MILLISECOND(1),
    SECOND(1000),
    MINUTE(60000),
    HOUR(3600000),
    DAY(86400000),
    WEEK(604800000);
    
    private final int time;

    TimeUtil(final int time) {
        this.time = time;
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
