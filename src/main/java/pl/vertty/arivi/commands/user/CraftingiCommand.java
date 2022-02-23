package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.user.CraftingiGui;

public class CraftingiCommand extends PlayerCommand
{
    public CraftingiCommand() {
        super("craftingi", "Menu craftingow", "craftingi", GroupType.PLAYER, new String[] { "craft" });
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] args) {
        CraftingiGui.openAntyNogi(player);
        return false;
    }
}
