
package pl.vertty.arivi.listeners.guild;

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
