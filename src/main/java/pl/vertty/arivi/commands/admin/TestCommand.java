package pl.vertty.arivi.commands.admin;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Config;
import org.apache.commons.lang3.StringUtils;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.ChatUtil;

public class TestCommand extends Command
{

    public TestCommand() {
        super("test", "Ustawianie test test", "/test", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        String msg = StringUtils.join(args, " ");
        Player p = (Player) sender;
        p.getInventory().setItemInHand(p.getInventory().getItemInHand().setCustomName(ChatUtil.fixColor(msg)));
        p.sendMessage(p.getInventory().getItemInHand().getId() + ":" + p.getInventory().getItemInHand().getDamage());
        return false;
    }
    

}
