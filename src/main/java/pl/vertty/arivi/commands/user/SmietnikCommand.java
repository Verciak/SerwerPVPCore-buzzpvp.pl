package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.SmietnikGui;

public class SmietnikCommand extends PlayerCommand
{
    public SmietnikCommand() {
        super("smietnik", "Wyrzuc niepotrzebne przedmioty", "/smietnik", GroupType.PLAYER, new String[] { "kosz" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        SmietnikGui.openSmietnik(p);
        return false;
    }
}
