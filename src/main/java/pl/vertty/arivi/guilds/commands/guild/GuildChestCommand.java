// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.item.Item;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.guild.Guild;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

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
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(11, ItemData.fromItem(new Item(397, Integer.valueOf(3), 1).setCustomName(ChatUtil.fixColor("&9Glowy")).setLore(new String[] { String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7W Skarbcu: &9")).append(guild.getHead())), ChatUtil.fixColor("&8» &7Kliknij aby przejsc dalej!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                final User user = UserManager.getUser(player);
                User.skarbiec_head = true;
                pl.vertty.arivi.utils.ChatUtil.sendTitle(player, "&9WPLATA GLOW", "&6NAPISZ NA CHAT ILOSC GLOW", 20, 20, 20);
                menu.forceDestroy(player);
            }
        });
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(15, ItemData.fromItem(new Item(388).setCustomName(ChatUtil.fixColor("&9Emeraldy")).setLore(new String[] { String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7W Skarbcu: &9")).append(guild.getSkarbiec())), ChatUtil.fixColor("&8» &7Kliknij aby przejsc dalej!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                final User user = UserManager.getUser(player);
                User.skarbiec_eme = true;
                pl.vertty.arivi.utils.ChatUtil.sendTitle(player, "&9WPLATA EMERALDOW", "&6NAPISZ NA CHAT ILOSC EMERALDOW", 20, 20, 20);
                menu.forceDestroy(player);
            }
        });
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(20, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(21, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(22, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(23, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(24, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        menu.setMainCategory(category);
        menu.addCategory("skarbiecjeMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Skarbiec gildii"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("skarbiecjeMenu", menu);
    }
}
