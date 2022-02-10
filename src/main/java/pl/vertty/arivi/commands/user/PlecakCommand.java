// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.enums.GroupType;

public class PlecakCommand extends PlayerCommand
{
    public PlecakCommand() {
        super("plecak", "Wyplac dropy", "/plecak", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        Util.openPlecak(p);
        return true;
    }
}
