package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.gui.user.ItemShopGui;

public class ItemShopCommand extends PlayerCommand
{
    public ItemShopCommand() {
        super("itemshop", "Odbierz uslugi premium", "itemshop", GroupType.PLAYER, new String[] { "is" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        ItemShopGui.openTopki(p);
        return false;
    }
}
