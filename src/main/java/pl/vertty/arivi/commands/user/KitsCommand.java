// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.gui.KitsGui;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class KitsCommand extends PlayerCommand
{
    public KitsCommand() {
        super("kit", "Odbierz swoj zestaw", "/kit", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        KitsGui.openKits(p);
        return true;
    }
}
