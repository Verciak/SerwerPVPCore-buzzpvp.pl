// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.guilds.data.Combat;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.managers.CombatManager;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class KickCommand extends Command
{
    public KickCommand() {
        super("kick", "Wyrzucanie wszystkich graczy z serwera", "/kick <gracz> [powod]", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 1) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final Player p = Server.getInstance().getPlayer(args[0]);
        final User u = UserManager.getUser(p);
        if (p == null) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cGracz nie jest online!");
        }
        if (u.can(GroupType.HEADADMIN)) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cNie mozesz wyrzucic tego gracza!");
        }
        if (sender.getName().equalsIgnoreCase(p.getName())) {
            return ChatUtil.sendMessage(sender, "&4Blad: &cNie mozesz wyrzucic sam siebie!");
        }
        String reason = "Brak!";
        if (args.length > 1) {
            reason = StringUtils.join((Object[])args, " ", 1, args.length);
        }
        final String kick = "\n&4Zostales wyrzocony z serwera przez &c" + sender.getName() + "\n&4Powod: &c" + reason;
        final Combat combat = CombatManager.getCombat(p);
        combat.setLastAsystTime(0L);
        combat.setPlayer(null);
        combat.setLastAsystPlayer(null);
        p.kick(ChatUtil.fixColor(kick));
        return ChatUtil.sendMessage(Server.getInstance().getOnlinePlayers().values(), "&8>> &cGracz &6" + p.getName() + " &czostal wyrzucony z serwera przez &6" + sender.getName() + " &cpowod: &6" + reason + "&c!");
    }
}
