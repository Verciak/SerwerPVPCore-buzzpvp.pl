// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.moderator;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.item.EntityItem;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class ClearItemsCommand extends Command
{
    public ClearItemsCommand() {
        super("clearitems", "Czyszczenie itemow z ziemi", "clearitems", GroupType.MODERATOR, new String[] { "ic" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        for (final Entity entity : Server.getInstance().getDefaultLevel().getEntities()) {
            if (entity instanceof EntityItem) {
                entity.close();
            }
        }
        return false;
    }
}
