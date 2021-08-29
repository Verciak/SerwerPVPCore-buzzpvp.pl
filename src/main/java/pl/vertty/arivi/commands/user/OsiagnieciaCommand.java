// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.gui.osiagniecia.OsiagnieciaInventory;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class OsiagnieciaCommand extends PlayerCommand
{
    public OsiagnieciaCommand() {
        super("osiagniecia", "Odbierz swoje nagrody", "/osiagniecia", GroupType.PLAYER, new String[] { "os" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        OsiagnieciaInventory.guiStone(p);
        return true;
    }
}
