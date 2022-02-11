package pl.vertty.arivi.commands.admin;

import java.util.List;
import pl.vertty.arivi.wings.mysql.UserWings;
import pl.vertty.arivi.utils.SkinUtil;
import pl.vertty.arivi.wings.WingsManager;
import cn.nukkit.Server;
import java.util.ArrayList;
import java.io.File;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.builder.Command;

public class SkrzydlaCommand extends Command
{
    public static Main plugin;
    public static Config c;
    
    public SkrzydlaCommand() {
        super("skrzydla", "", "/skrzydla nadaj/usun <gracz> <nazwa>", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender commandSender, final String[] args) {
        final Player p = (Player)commandSender;
        if (args.length < 2) {
            ChatUtil.sendMessage(commandSender, "&7/skrzydla nadaj <gracz> <nazwa>");
            ChatUtil.sendMessage(commandSender, "&7/skrzydla usun <gracz>");
            ChatUtil.sendMessage(commandSender, "");
            ChatUtil.sendMessage(commandSender, "&7Dostepne skrzydla:");
            final String path = SkrzydlaCommand.plugin.getDataFolder() + "/wings";
            final File actual = new File(path);
            final List<String> fileNames = new ArrayList<String>();
            for (final File file : actual.listFiles()) {
                fileNames.add(file.getName());
            }
            for (final String wingName : fileNames) {
                ChatUtil.sendMessage(commandSender, "&8>> &9" + wingName);
            }
            return false;
        }
        if (args[0].equalsIgnoreCase("nadaj")) {
            final Player o = Server.getInstance().getPlayer(args[1]);
            if (o == null) {
                ChatUtil.sendMessage(p, "&4Blad: &cGracz jest offline!");
                return false;
            }
            WingsManager.setRatWings(o, WingsManager.getWings(args[2]));
            ChatUtil.sendMessage(p, "&6Nadano skrzydla o nazwe: &c" + args[2]);
        }
        else {
            if (!args[0].equalsIgnoreCase("usun")) {
                ChatUtil.sendMessage(commandSender, "/skrzydla nadaj <gracz> <nazwa>");
                ChatUtil.sendMessage(commandSender, "/skrzydla usun <gracz>");
                return false;
            }
            final Player o = Server.getInstance().getPlayer(args[1]);
            if (o.isOnline()) {
                SkinUtil.resetSkin(o);
                UserWings.deleteUser(o);
            }
            else {
                UserWings.deleteUser(args[1]);
            }
            ChatUtil.sendMessage(p, "&6Usunieto skrzydla");
        }
        return false;
    }
    
    static {
        SkrzydlaCommand.plugin = Main.getPlugin();
        SkrzydlaCommand.c = Main.getPlugin().getConfig();
    }
}
