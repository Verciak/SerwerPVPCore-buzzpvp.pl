package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.home.HomeInventory;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;

public class HomeCommand extends PlayerCommand
{
    public HomeCommand() {
        super("home", "Teleportacja do domu", "/home", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        if (u == null) {
            return true;
        }
        HomeInventory.openHome(p);
        return true;
    }
}
