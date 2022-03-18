//
// Decompiled by Procyon v0.5.36
//

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.eq.InventoryUtil;
import pl.vertty.arivi.gui.EQGui;
import pl.vertty.arivi.gui.SchowekGui;
import pl.vertty.arivi.guilds.managers.UserManager;

public class EQCommand extends PlayerCommand
{
    public EQCommand() {
        super("zapisz", "Ustaw swoje eq", "/zapisz", GroupType.PLAYER, new String[] { "zapiszeq", "eq" });
    }

    @Override
    public boolean onCommand(final Player p, final String[] args) {
            EQGui.openTopki(p);

        return true;
    }
}
