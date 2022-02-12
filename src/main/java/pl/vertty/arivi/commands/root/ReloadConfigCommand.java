package pl.vertty.arivi.commands.root;

import cn.nukkit.Player;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.ChatUtil;

public class ReloadConfigCommand extends PlayerCommand
{
    Main main = Main.getPlugin();

    public ReloadConfigCommand() {
        super("reloadconfig", "Reload configu", "reloadconfig", GroupType.ADMIN, new String[] { "reloadcfg" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        main.reloadConfig();
        main.saveConfig();
        MainConstants.set();
        p.sendMessage(ChatUtil.fixColor("&aPrzeladowano cfg &2K U R W A"));
        return false;
    }
}
