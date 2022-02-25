package pl.vertty.arivi.objects;

import cn.nukkit.Player;

public class Combat {
    private Player player;

    private long lastAttactTime;

    private Player lastAttactkPlayer;

    private long lastAsystTime;

    private Player lastAsystPlayer;


    public Combat(Player p) {
        this.player = p;
        this.lastAttactTime = 0L;
        this.lastAttactkPlayer = null;
        this.lastAsystPlayer = null;
        this.lastAsystTime = 0L;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getLastAttactTime() {
        return this.lastAttactTime;
    }

    public void setLastAttactTime(long lastAttactTime) {
        this.lastAttactTime = lastAttactTime;
    }

    public Player getLastAttactkPlayer() {
        return this.lastAttactkPlayer;
    }

    public void setLastAttactkPlayer(Player lastAttactkPlayer) {
        this.lastAttactkPlayer = lastAttactkPlayer;
    }

    public long getLastAsystTime() {
        return this.lastAsystTime;
    }

    public void setLastAsystTime(long lastAsystTime) {
        this.lastAsystTime = lastAsystTime;
    }

    public Player getLastAsystPlayer() {
        return this.lastAsystPlayer;
    }

    public void setLastAsystPlayer(Player lastAsystPlayer) {
        this.lastAsystPlayer = lastAsystPlayer;
    }

    public boolean hasFight() {
        return (getLastAttactTime() > System.currentTimeMillis());
    }

    public boolean wasFight() {
        return (getLastAttactkPlayer() != null);
    }
}
