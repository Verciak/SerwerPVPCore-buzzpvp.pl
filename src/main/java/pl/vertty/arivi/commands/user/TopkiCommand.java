// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.gui.TopkiGui;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class TopkiCommand extends PlayerCommand
{
    public TopkiCommand() {
        super("topki", "Wyswietl topki serwerowe", "/topki", GroupType.PLAYER, new String[] { "gtop", "top" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        TopkiGui.openTopki(p);
        return false;
    }
}
