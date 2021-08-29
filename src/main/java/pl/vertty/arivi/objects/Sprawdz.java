package pl.vertty.arivi.objects;

import cn.nukkit.level.Location;
import cn.nukkit.Player;

public class Sprawdz
{
    private Player player;
    private Player admin;
    private Long start;
    private String reason;
    private Location loc;
    private boolean effect;
    private String kanal;
    
    public Sprawdz(final Player player, final Player admin, final Long start, final String reason, final Location loc, final boolean effect, final String kanal) {
        this.player = player;
        this.admin = admin;
        this.start = start;
        this.reason = reason;
        this.loc = loc;
        this.effect = effect;
        this.kanal = kanal;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(final Player player) {
        this.player = player;
    }
    
    public Player getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(final Player admin) {
        this.admin = admin;
    }
    
    public Long getStart() {
        return this.start;
    }
    
    public void setStart(final Long start) {
        this.start = start;
    }
    
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(final String reason) {
        this.reason = reason;
    }
    
    public Location getLoc() {
        return this.loc;
    }
    
    public void setLoc(final Location loc) {
        this.loc = loc;
    }
    
    public boolean isEffect() {
        return this.effect;
    }
    
    public void setEffect(final boolean effect) {
        this.effect = effect;
    }
    
    public String getKanal() {
        return this.kanal;
    }
    
    public void setKanal(final String kanal) {
        this.kanal = kanal;
    }
}
