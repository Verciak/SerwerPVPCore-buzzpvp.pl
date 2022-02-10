// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.objects.Warp;
import pl.vertty.arivi.managers.WarpManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class SetWarpCommand extends Command
{
    public SetWarpCommand() {
        super("setwarp", "Ustawianie warpa", "/setwarp", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length < 1) {
            return ChatUtil.sendMessage((CommandSender)p, this.getUsage());
        }
        final Warp w = WarpManager.getWarp(args[0]);
        if (w != null) {
            return ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cIstnieje juz warp!");
        }
        if (args.length == 1) {
            WarpManager.addWarp(args[0], p.getLocation());
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Ustawiles warp &3" + args[0]);
        }
        return ChatUtil.sendMessage((CommandSender)p, this.getUsage());
    }
}
