
package pl.vertty.arivi.commands.guild;

import pl.vertty.arivi.MainConstants;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.ItemUtil;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.item.Item;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.objects.guild.Guild;
import cn.nukkit.Player;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildChestCommand extends PlayerCommand
{
    private static void lambda$addSignEmerald$1(final Player player, final Guild guild, final Player player2, final String[] array) {
        final String substring = array[0].substring(1, array[0].length() - 1);
        if (!ChatUtil.isInteger(substring)) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
            return;
        }
        if (substring.contains("-")) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
            return;
        }
        if (!player.getInventory().contains(new Item(388, Integer.valueOf(0), Integer.parseInt(substring)))) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE4));
            return;
        }
        guild.setSkarbiec(guild.getSkarbiec() + Integer.parseInt(substring));
        player.getInventory().removeItem(new Item[] { new Item(388, Integer.valueOf(0), Integer.parseInt(substring)) });
        ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
        ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE3));
    }
    
    private static void lambda$addSignHead$0(final Player player, final Guild guild, final Player player2, final String[] array) {
        final String substring = array[0].substring(1, array[0].length() - 1);
        if (!ChatUtil.isInteger(substring)) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
            return;
        }
        if (substring.contains("-")) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE5));
            return;
        }
        if (!player.getInventory().contains(new Item(397, Integer.valueOf(3), Integer.parseInt(substring)))) {
            ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
            ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE2));
            return;
        }
        guild.setHead(guild.getHead() + Integer.parseInt(substring));
        player.getInventory().removeItem(new Item[] { new Item(397, Integer.valueOf(3), Integer.parseInt(substring)) });
        ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_TITLE));
        ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SKARBIEC_SUBTITLE));
    }
    
    public GuildChestCommand() {
        super("skarbiec", "/g skarbiec", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        openInv(player, guild);
        return false;
    }
    
    public static void openInv(final Player player, final Guild guild) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(1, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(2, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(3, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(4, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(5, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(6, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(7, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(8, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(9, ItemData.fromItem(MainConstants.BLACK_GLASS));
        
        category.addElement(10, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(11, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(12, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(13, ItemData.fromItem(new Item(388).setCustomName(ChatUtil.fixColor("&9Emeraldy")).setLore(ChatUtil.fixColor("&8» &7W Skarbcu: &9") + guild.getSkarbiec(), ChatUtil.fixColor("&8» &7Kliknij aby wplacic emeraldy!"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item){
                final int amount = ItemUtil.getItemAmount(Item.get(Item.EMERALD), player, 0);
                if (amount == 0) {
                    ChatUtil.sendMessage(player, "&cNie posiadasz zadnych &4emeraldow &cw ekwipunku!");
                    menu.forceDestroy(player);
                    return;
                }
                final String it = "388:0-" + amount + ":Szmaragdow;";
                ItemUtil.removeItems(player, it, 1);
                guild.setSkarbiec(guild.getSkarbiec() + amount);
                pl.vertty.arivi.utils.ChatUtil.sendTitle(player, "&9WPLATA EMERALDOW", "&6Wplacono &f" + amount + " &6emeraldow", 20, 20, 20);
                menu.forceDestroy(player);
            }
        });
        category.addElement(14, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(15, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(16, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(17, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(18, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(19, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(20, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(21, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(22, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(23, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(24, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(25, ItemData.fromItem(MainConstants.BLACK_GLASS));
        category.addElement(26, ItemData.fromItem(MainConstants.BLACK_GLASS));
        menu.setMainCategory(category);
        menu.addCategory("skarbiecjeMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Skarbiec gildii"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("skarbiecjeMenu", menu);
    }
}
