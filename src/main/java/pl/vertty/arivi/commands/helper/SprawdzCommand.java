package pl.vertty.arivi.commands.helper;

import cn.nukkit.level.Location;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.managers.SprawdzManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class SprawdzCommand extends Command
{
    public SprawdzCommand() {
        super("sprawdz", "SprawdzCommand", "/sprawdz <nick> [powod]", GroupType.HELPER, new String[] { "spr" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        if (SprawdzManager.getByAdmin(p) != null) {
            ChatUtil.sendMessage(p, "&4Blad: &cSprawdzasz juz kogos!");
            return false;
        }
        if (args.length < 2) {
            ChatUtil.sendMessage(p, "&4Blad: &cPoprawne Uzycie: &7{USAGE}".replace("{USAGE}", this.getUsage()));
            return false;
        }
        final StringBuilder reason = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            reason.append(args[i]).append(" ");
        }
        final Player tar = Server.getInstance().getPlayer(args[0]).getPlayer();
        if (tar == null) {
            ChatUtil.sendMessage(p, "&4Blad: &cTen gracz jest offline!".replace("{USAGE}", this.getUsage()));
            return false;
        }
        if (SprawdzManager.getByPlayer(p) != null) {
            ChatUtil.sendMessage(p, "&4Blad: &cTen gracz jest juz sprawdzany!");
            return false;
        }
        Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz &9{USER}&7 jest sprawdzany przez: &9{ADMIN}!\n&8>> &7Powod: &9{REASON}").replace("{USER}", tar.getName()).replace("{ADMIN}", p.getName()).replace("{REASON}", reason.toString()));
        SprawdzManager.create(tar, p, reason.toString());
        ChatUtil.sendMessage(tar, SprawdzManager.chat);
        tar.teleport(new Location(-41, 66.0, 44.0));
        return false;
    }
}
