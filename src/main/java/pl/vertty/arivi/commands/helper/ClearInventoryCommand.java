// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.helper;

import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageByChildEntityEvent;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Cooldown;
import pl.vertty.arivi.guilds.data.User;
import cn.nukkit.Server;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class ClearInventoryCommand extends Command
{

    public ClearInventoryCommand() {
        super("clearinv", "Czyszczenie ekwipunku graczy", "/clearinv [gracz]", GroupType.HELPER, new String[] { "clear", "clearinventory", "ci" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final Player p = (Player)sender;
        final User u = UserManager.getUser(p);
        final Config c = Main.getPlugin().getConfig();
        if (args.length == 0) {
            p.getInventory().setHelmet(new Item(0));
            p.getInventory().setChestplate(new Item(0));
            p.getInventory().setLeggings(new Item(0));
            p.getInventory().setBoots(new Item(0));
            p.getInventory().clearAll();
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Wyczyszczono ekwipunek!");
        }
        if (!u.can(GroupType.MODERATOR)) {
            return ChatUtil.sendMessage((CommandSender)p, "&8>> &cNie masz dostepu!");
        }
        final Player o = Server.getInstance().getPlayer(args[0]);
        if (o == null) {
            return ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cGracz jest offline");
        }
        o.getInventory().clearAll();
        o.getInventory().setHelmet(new Item(0));
        o.getInventory().setChestplate(new Item(0));
        o.getInventory().setLeggings(new Item(0));
        o.getInventory().setBoots(new Item(0));
        ChatUtil.sendMessage((CommandSender)o, "&8>> &7Twoj ekwipunek zostal wyczyszczony przez &6" + p.getName());
        return ChatUtil.sendMessage((CommandSender)p, "&8>> &7Wyczyszczono ekwipunek dla gracza &6" + o.getName());
    }
}
