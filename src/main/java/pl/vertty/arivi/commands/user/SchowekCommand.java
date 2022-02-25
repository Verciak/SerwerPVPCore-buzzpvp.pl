package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.deposit.SchowekGui;

public class SchowekCommand extends PlayerCommand
{
    public SchowekCommand() {
        super("schowek", "Dobierz sie do limitu", "/schowek", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        SchowekGui.openSchowek(p);
        return true;
    }
}
