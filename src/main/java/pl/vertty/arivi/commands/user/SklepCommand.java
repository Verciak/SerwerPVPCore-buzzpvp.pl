//
// Decompiled by Procyon v0.5.36
//

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.EQGui;
import pl.vertty.arivi.gui.SklepGui;

public class SklepCommand extends PlayerCommand
{
    public SklepCommand() {
        super("sklep", "Zakup itemy stale", "/sklep", GroupType.PLAYER, new String[0]);
    }

    @Override
    public boolean onCommand(final Player p, final String[] args) {
        SklepGui.openSklep(p);

        return true;
    }
}
