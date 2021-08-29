// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.item.Item;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.PlayerCommand;

public class TestCommand extends PlayerCommand
{
    public TestCommand() {
        super("test", "test test test", "/test", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final Item item = Item.get(p.getInventory().getItemInHand().getId());
        item.setCustomName("nazwa");
        item.setLore(new String[] { "test" });
        return true;
    }
}
