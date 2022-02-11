package pl.vertty.arivi.commands.helper;

import pl.vertty.arivi.objects.Sprawdz;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.SprawdzManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class CzystyCommand extends Command
{
    public CzystyCommand() {
        super("czysty", "SprawdzanieCommand", "/czysty [gracz]", GroupType.HELPER, new String[0]);
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (args.length < 1) {
            ChatUtil.sendMessage(p, SprawdzManager.messages.get("currect_usage").replace("{USAGE}", this.getUsage()));
            return false;
        }
        final Player tar = Server.getInstance().getPlayer(args[0]);
        if (tar == null) {
            ChatUtil.sendMessage(p, SprawdzManager.messages.get("user_offline").replace("{USAGE}", this.getUsage()));
            return false;
        }
        if (SprawdzManager.getByPlayer(tar) == null) {
            ChatUtil.sendMessage(p, SprawdzManager.messages.get("not_user"));
            return false;
        }
        final Sprawdz s = SprawdzManager.getByPlayer(tar);
        if (s.getAdmin() != p) {
            ChatUtil.sendMessage(p, SprawdzManager.messages.get("not_admin"));
            return false;
        }
        Server.getInstance().broadcastMessage(ChatUtil.fixColor("&9{USER} &7jest czysty! Zostal sprawdzany przez: &9{ADMIN}").replace("{USER}", s.getPlayer().getName()).replace("{ADMIN}", p.getName()));
        tar.teleport(s.getLoc());
        SprawdzManager.delete(s.getPlayer());
        return false;
    }
}
