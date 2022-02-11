package pl.vertty.arivi.commands.root;

import cn.nukkit.Player;
import cn.nukkit.Server;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;

public class ReloadConfigCommand extends PlayerCommand
{
    public ReloadConfigCommand() {
        super("reloadconfig", "Reload configu", "reloadconfig", GroupType.ADMIN, new String[] { "reloadcfg" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        Server.getInstance().getConfig().getAll().clear();
        Server.getInstance().getConfig().reload();
        System.out.printf("XD");
        return false;
    }
}
