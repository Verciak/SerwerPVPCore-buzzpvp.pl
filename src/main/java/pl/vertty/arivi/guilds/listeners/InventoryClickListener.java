// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.listeners;

import cn.nukkit.event.EventHandler;
import pl.vertty.arivi.guilds.data.Combat;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.CombatManager;
import cn.nukkit.event.player.PlayerRespawnEvent;
import java.util.HashMap;
import cn.nukkit.entity.data.Skin;
import java.util.UUID;
import java.util.Map;
import cn.nukkit.event.Listener;

public class InventoryClickListener implements Listener
{
    private final Map<UUID, Skin> originalSkins;
    
    public InventoryClickListener() {
        this.originalSkins = new HashMap<UUID, Skin>();
    }
}
