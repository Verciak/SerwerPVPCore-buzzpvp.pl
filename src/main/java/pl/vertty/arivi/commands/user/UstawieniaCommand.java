//
// Decompiled by Procyon v0.5.36
//

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.EQGui;
import pl.vertty.arivi.gui.UstawieniaGui;

public class UstawieniaCommand extends PlayerCommand
{
    public UstawieniaCommand() {
        super("ustawienia", "Ustawienia na serwerze", "/ustawienia", GroupType.PLAYER, new String[0]);
    }

    @Override
    public boolean onCommand(final Player p, final String[] args) {
        UstawieniaGui.openTopki(p);
        return true;
    }
}
