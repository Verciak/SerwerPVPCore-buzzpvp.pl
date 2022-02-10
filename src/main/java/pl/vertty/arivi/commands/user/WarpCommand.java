// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.managers.WarpManager;
import pl.vertty.arivi.objects.Warp;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.TimerUtil;

public class WarpCommand extends PlayerCommand
{
    public WarpCommand() {
        super("warp", "Teleportacja do danego warpu", "/warp <nazwa>", GroupType.PLAYER, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            if (WarpManager.getWarpByGroup(p).size() == 0) {
                return ChatUtil.sendMessage((CommandSender)p, "&8>> &cBrak warpow!");
            }
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Warpy: &6" + StringUtils.join(WarpManager.getWarpByGroup(p), "&8, &6"));
        }
        else {
            final Warp w = WarpManager.getWarp(args[0]);
            if (w == null) {
                return ChatUtil.sendMessage((CommandSender)p, "&cWarp nie istnieje!");
            }
            TimerUtil.teleport(p, w.getLocation(), 10);
            return true;
        }
    }
}
