// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.gui.CraftingiGui;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class CraftingiCommand extends PlayerCommand
{
    public CraftingiCommand() {
        super("craftingi", "Menu craftingow", "craftingi", GroupType.PLAYER, new String[] { "craft" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        CraftingiGui.openBoyFarmer(player);
        return false;
    }
}
