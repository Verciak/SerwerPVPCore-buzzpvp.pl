package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.user.TopkiGui;

public class TopkiCommand extends PlayerCommand
{
    public TopkiCommand() {
        super("topki", "Wyswietl topki serwerowe", "/topki", GroupType.PLAYER, new String[] { "gtop", "top", "topka" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        TopkiGui.openTopki(p);
        return false;
    }
}
