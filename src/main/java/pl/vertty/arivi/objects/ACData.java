package pl.vertty.arivi.objects;

import cn.nukkit.Player;

public class ACData {
    public String name;
    private long speedminePerSecondTime;
    public int speedminePerSecond;
    private long packetsPerSecondTime;
    public int packetsPerSecond;
    private long macroPerSecondTime;
    public int macroPerSecond;
    private long entityPerSecondTime;
    public int entityPerSecond;



    public ACData(final Player player) {
        this.name = player.getName();
    }




    public boolean hasMacroLimit() {
        return this.macroPerSecond > 12;
    }
    public boolean entityLimit() {
        if (this.entityPerSecondTime < System.currentTimeMillis()) {
            this.entityPerSecondTime = System.currentTimeMillis() + 1000L;
            this.entityPerSecond = 0;
        }
        return ++this.entityPerSecond >= 60;
    }

    public boolean speedmineLimit(boolean isHalf) {
        if (this.speedminePerSecondTime < System.currentTimeMillis()) {
            this.speedminePerSecondTime = System.currentTimeMillis() + (isHalf ? 500L : 1000L);
            this.speedminePerSecond = 0;
        }
        return ++this.speedminePerSecond >= (isHalf ? 4 : 10);
    }

    public boolean macroLimit() {
        if (this.macroPerSecondTime < System.currentTimeMillis()) {
            this.macroPerSecondTime = System.currentTimeMillis() + 1000L;
            this.macroPerSecond = 0;
        }
        return ++this.macroPerSecond > 12;
    }

    public boolean hasMacroMax() {
        return this.macroPerSecond >= 100;
    }

    public boolean packetLimit() {
        if (this.packetsPerSecondTime < System.currentTimeMillis()) {
            this.packetsPerSecondTime = System.currentTimeMillis() + 1000L;
            this.packetsPerSecond = 0;
        }
        return ++this.packetsPerSecond > 450;
    }



}
