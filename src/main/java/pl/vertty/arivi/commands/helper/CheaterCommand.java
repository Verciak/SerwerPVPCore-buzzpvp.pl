// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.managers.BanManager;
import pl.vertty.arivi.objects.Ban;
import pl.vertty.arivi.objects.Sprawdz;
import pl.vertty.arivi.managers.SprawdzManager;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.utils.DataUtil;

public class CheaterCommand extends Command
{
    public CheaterCommand() {
        super("cheater", "SprawdzanieCommand", "/cheater [gracz]", GroupType.HELPER, new String[0]);
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length < 1) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cPoprawne Uzycie: &7{USAGE}".replace("{USAGE}", this.getUsage()));
            return false;
        }
        final Player tar = Server.getInstance().getPlayer(args[0]);
        if (tar == null) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cTen gracz jest offline!".replace("{USAGE}", this.getUsage()));
            return false;
        }
        if (SprawdzManager.getByPlayer(tar) == null) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cTen gracz nie jest sprawdzany!");
            return false;
        }
        final Sprawdz s = SprawdzManager.getByPlayer(tar);
        if (s.getAdmin() != p) {
            ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cTo nie ty sprawdzasz tego gracza!");
            return false;
        }
        Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7U gracza &9{USER}&7, zostaly wykryte cheaty przez &9{ADMIN}&7!").replace("{USER}", s.getPlayer().getName()).replace("{ADMIN}", p.getName()));
        tar.teleport(s.getLoc());
        SprawdzManager.delete(s.getPlayer());
        final long time = DataUtil.parseDateDiff("3d", true);
        final Ban ban = new Ban(s.getPlayer().getName(), p.getName(), s.getReason(), time);
        BanManager.addBan(s.getPlayer().getName(), ban);
        return false;
    }
}
