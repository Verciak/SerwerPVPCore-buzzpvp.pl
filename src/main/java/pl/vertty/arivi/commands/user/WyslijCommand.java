// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.managers.SprawdzManager;
import pl.vertty.arivi.objects.Sprawdz;
import pl.vertty.arivi.utils.ChatUtil;

public class WyslijCommand extends PlayerCommand
{
    public WyslijCommand() {
        super("wyslij", "Wysylanie wiad podczas sprawdzania", "/wyslij <tekst>", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (args.length < 1) {
            ChatUtil.sendMessage(p, "/wyslij <tekst>");
            return false;
        }
        final StringBuilder reason = new StringBuilder();
        for (int i = 0; i < args.length; ++i) {
            reason.append(args[i]).append(" ");
        }
        final Sprawdz user = SprawdzManager.getByPlayer(p);
        final Sprawdz admin = SprawdzManager.getByAdmin(p);
        if (user != null) {
            ChatUtil.sendMessage(user.getAdmin(), "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", reason.toString()).replace("{USER}", user.getPlayer().getName()));
            ChatUtil.sendMessage(p, "&8[&9SPRWADZANY&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", reason.toString()).replace("{USER}", user.getPlayer().getName()));
            return true;
        }
        if (admin != null) {
            ChatUtil.sendMessage(admin.getPlayer(), "&8[&9ADMINISTRATOR&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", reason.toString()).replace("{USER}", admin.getAdmin().getName()));
            ChatUtil.sendMessage(p, "&8[&9ADMINISTRATOR&8] &7{USER} &8>> &7{MESSAGE}".replace("{MESSAGE}", reason.toString()).replace("{USER}", admin.getAdmin().getName()));
            return true;
        }
        ChatUtil.sendMessage(p, "&4Blad: &cNie jestes sprawdzany!");
        return false;
    }
}
