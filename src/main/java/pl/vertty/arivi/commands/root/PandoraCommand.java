// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.root;

import pl.vertty.arivi.Main;
import cn.nukkit.Player;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.math.Vector3;
import cn.nukkit.item.Item;
import cn.nukkit.Server;
import pl.vertty.arivi.drop.pierozek.PierozekManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.commands.builder.Command;

public class PandoraCommand extends Command
{
    public static Config c;
    
    public PandoraCommand() {
        super("pandora", "pandora", "/pandora <gracz/all> <ilosc>", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length != 2) {
            ChatUtil.sendMessage(sender, "/pandora <gracz/all> <ilosc>");
            return false;
        }
        if (!ChatUtil.isInteger(args[1])) {
            ChatUtil.sendMessage(sender, "&cArgument nie jest liczba!");
            return false;
        }
        final Item itemStack = PierozekManager.getPandoreItem();
        itemStack.setCount(Integer.parseInt(args[1]));
        if (args[0].equalsIgnoreCase("all")) {
            final Item item = itemStack;
            Server.getInstance().getOnlinePlayers().values().forEach(player -> {
                Item daj = Item.get(item.getId(), Integer.valueOf(item.getDamage()), item.getCount());
                if (item.hasCustomName()) {
                    daj.setCustomName(ChatUtil.fixColor(item.getCustomName()));
                }
                daj.setLore(ChatUtil.fixColor(item.getLore()));
                if (item.hasEnchantments()) {
                    daj.addEnchantment(item.getEnchantments());
                }
                PlayerInventory inventoryAutoAdd = player.getInventory();
                Item[] itemsToAdd = { daj };
                for (int i = 0; i < itemsToAdd.length; i++) {
                    boolean canAddItem = inventoryAutoAdd.canAddItem(itemsToAdd[i]);
                    if (canAddItem) {
                        inventoryAutoAdd.addItem(new Item[] { itemsToAdd[i] });
                    } else {
                        Server.getInstance().getDefaultLevel().dropItem(new Vector3(player.getX(), player.getY(), player.getZ()), daj);
                    }
                }
                ChatUtil.sendTitle(player, "", "&eCaly serwer otrzymal &5&lPandore &7({AMOUNT})".replace("{AMOUNT}", Integer.toString(item.getCount())), 20, 60, 20);
                return;
            });
            return false;
        }
        final Player player2 = Server.getInstance().getPlayer(args[0]);
        if (player2 == null) {
            ChatUtil.sendMessage(sender, "&cGracz jest offline!");
            return false;
        }
        final Item daj2 = Item.get(itemStack.getId(), Integer.valueOf(itemStack.getDamage()), itemStack.getCount());
        if (itemStack.hasCustomName()) {
            daj2.setCustomName(ChatUtil.fixColor(itemStack.getCustomName()));
        }
        daj2.setLore(ChatUtil.fixColor(itemStack.getLore()));
        if (itemStack.hasEnchantments()) {
            daj2.addEnchantment(itemStack.getEnchantments());
        }
        final PlayerInventory inventoryAutoAdd2 = player2.getInventory();
        final Item[] itemsToAdd2 = { daj2 };
        for (int j = 0; j < itemsToAdd2.length; ++j) {
            final boolean canAddItem2 = inventoryAutoAdd2.canAddItem(itemsToAdd2[j]);
            if (canAddItem2) {
                inventoryAutoAdd2.addItem(new Item[] { itemsToAdd2[j] });
            }
            else {
                Server.getInstance().getDefaultLevel().dropItem(new Vector3(player2.getX(), player2.getY(), player2.getZ()), daj2);
            }
        }
        ChatUtil.sendMessage((CommandSender)player2, "&fOtrzymales &5&lPandore &fw ilosci &9{AMOUNT}".replace("{AMOUNT}", Integer.toString(itemStack.getCount())));
        return false;
    }
    
    static {
        PandoraCommand.c = Main.getPlugin().getConfig();
    }
}
