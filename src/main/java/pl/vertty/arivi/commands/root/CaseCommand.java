// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.root;

import pl.vertty.arivi.drop.skrzynka.SkrzynkaManager;
import pl.vertty.arivi.utils.ItemUtil;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.commands.builder.Command;

public class CaseCommand extends Command
{
    public static Config c;
    
    public CaseCommand() {
        super("case", "magiczne skrzynki", "/case <case/key> <gracz/all/create> <ilosc>", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 3) {
            sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("casecmd.usage")));
            return true;
        }
        if (!ChatUtil.isInteger(args[2])) {
            sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("casecmd.notint")));
            return true;
        }
        final int size = Integer.parseInt(args[2]);
        if (args[0].equalsIgnoreCase("case")) {
            final Item i = Item.get(54);
            i.setCustomName(ChatUtil.fixColor("&4Skrzyneczka"));
            ItemUtil.giveItem((Player)sender, i);
            return false;
        }
        if (args[0].equalsIgnoreCase("key")) {
            final Item i = SkrzynkaManager.key;
            i.setCustomName(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("key.name")));
            ItemUtil.giveItem((Player)sender, i);
            return false;
        }
        sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("casecmd.usage")));
        return true;
    }
    
    static {
        CaseCommand.c = Main.getPlugin().getConfig();
    }
}
