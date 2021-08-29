// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.Main;
import cn.nukkit.entity.Entity;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.commands.builder.Command;

public class EntityClearCommand extends Command
{
    public static Config c;
    
    public EntityClearCommand() {
        super("entity", "Usuwanie entity serwera", "/entity", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        int amount = 0;
        final Player player = (Player)sender;
        for (final Entity entity : player.getLevel().getEntities()) {
            if (!(entity instanceof Player)) {
                entity.getLevel().removeEntity(entity);
                ++amount;
            }
        }
        player.sendMessage(TextFormat.DARK_GREEN + "Wypierdalam tych smieci..." + TextFormat.RED + " " + amount);
        return false;
    }
    
    static {
        EntityClearCommand.c = Main.getPlugin().getConfig();
    }
}
