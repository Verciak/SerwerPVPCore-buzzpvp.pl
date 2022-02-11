package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.VanishManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class VanishCommand extends Command
{
    public VanishCommand() {
        super("vanish", "Uruchamianie vanish", "/vanish", GroupType.HELPER, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length != 0) {
            return false;
        }
        if (VanishManager.ifContains(p)) {
            VanishManager.removeFromVanish(p);
            p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb vanish zostal &cwylaczony!"));
            return true;
        }
        VanishManager.addToVanish(p);
        p.sendMessage(ChatUtil.fixColor("&8>> &7Tryb vanish zostal &awlaczony!"));
        return true;
    }
}
