// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.WorkbenchInventoryMenu;
import pl.vertty.arivi.utils.ChatUtil;

public class WorkbenchCommand extends PlayerCommand
{
    public WorkbenchCommand() {
        super("workbench", "workbench", "/workbench", GroupType.VIP, new String[] { "wb" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        final WorkbenchInventoryMenu ec1 = new WorkbenchInventoryMenu(ChatUtil.fixColor("&r&9Przenosny crafting"));
        ec1.show(p);
        return true;
    }
}
