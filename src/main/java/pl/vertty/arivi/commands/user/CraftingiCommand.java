// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.CraftingiGui;

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
