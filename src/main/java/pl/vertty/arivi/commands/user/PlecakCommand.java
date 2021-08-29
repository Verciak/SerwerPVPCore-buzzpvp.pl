// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import pl.vertty.arivi.drop.utils.Util;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

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
