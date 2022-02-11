package pl.vertty.arivi.commands.moderator;

import pl.vertty.arivi.objects.Warp;
import pl.vertty.arivi.managers.WarpManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class DelWarpCommand extends Command
{
    public DelWarpCommand() {
        super("delwarp", "Kasowanie warpow", "/delwarp <name>", GroupType.MODERATOR, new String[0]);
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length < 1) {
            return ChatUtil.sendMessage(p, this.getUsage());
        }
        final Warp w = WarpManager.getWarp(args[0]);
        if (w == null) {
            return ChatUtil.sendMessage(p, "&4Blad: &cIstnieje juz warp!");
        }
        WarpManager.deleteWarp(w.getName());
        return ChatUtil.sendMessage(p, "&8>> &7Usuneles warp &6" + w.getName());
    }
}
