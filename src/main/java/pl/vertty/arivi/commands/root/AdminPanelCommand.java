package pl.vertty.arivi.commands.root;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.AdminPanelGui;
import pl.vertty.arivi.gui.ItemShopGui;

public class AdminPanelCommand extends PlayerCommand
{
    public AdminPanelCommand() {
        super("adminpanel", "Zarzadzanie serwerem", "adminpanel", GroupType.ADMIN, new String[] { "ap" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        AdminPanelGui.openTopki(p);
        return false;
    }
}
