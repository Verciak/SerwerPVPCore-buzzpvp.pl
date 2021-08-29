// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.user;

import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.guilds.utils.Coooldown;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.listeners.premium.CaseListener;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.utils.SkinUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.guilds.managers.UserManager;
import cn.nukkit.Player;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

import java.util.concurrent.TimeUnit;

public class IncognitoCommand extends PlayerCommand
{
    public IncognitoCommand() {
        super("incognito", "/incognito", GroupType.PLAYER, new String[0]);
    }

    private static final Coooldown<Player> COOLDOWN = new Coooldown<Player>();

    @Override
    public boolean onCommand(final Player player, final String[] array) {
        User u = UserManager.getUser(player);
        if(u.getPresiz() == 0){
            ChatUtil.sendFullTitle(player, "&9INCOGNITO", "&7MUSISZ POSIADAC 1 PRESTIZ!");
            return false;
        }
        if (COOLDOWN.isOnCooldown(player)) {
            ChatUtil.sendFullTitle(player, "&9INCOGNITO", "&7MUSISZ ODCZEKAC 10 MINUT!");
            return false;
        }
        COOLDOWN.putOnCooldown(player, TimeUnit.MINUTES, 10L);
        openInv(player);
        return false;
    }
    
    public static void openInv(final Player player) {
        final User user = UserManager.getUser(player);
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(12, ItemData.fromItem(new Item(397, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9UKRYWANIE SKINA")).setLore(new String[] { String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: &9")).append(user.isIncognitoSkin() ? "ON" : "OFF")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic!") })), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) throws SkinChangeException {
                if (!user.isIncognitoSkin()) {
                    user.setIncognitoSkin(true);
                    ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                    ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE));
                    SkinUtil.changeSkin(p);
                    IncognitoCommand.openInv(p);
                    return;
                }
                user.setIncognitoSkin(false);
                ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE2));
                IncognitoCommand.openInv(p);
                SkinUtil.resetSkin(p);
            }
        });
        category.addElement(13, ItemData.fromItem(new Item(421).setCustomName(ChatUtil.fixColor("&9UKRYWANIE NICKU")).setLore(new String[] { String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: &9")).append(user.isIncognitoNick() ? "ON" : "OFF")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic!") })), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                if (!user.isIncognitoNick()) {
                    user.setIncognitoNick(true);
                    ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                    ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE));
                    IncognitoCommand.openInv(p);
                    return;
                }
                user.setIncognitoNick(false);
                ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE2));
                IncognitoCommand.openInv(p);
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(54, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9UKRYWANIE TAGU GILDII")).setLore(new String[] { String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: &9")).append(user.isIncognitoGuild() ? "ON" : "OFF")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic!") })), new ItemClick() {
            @Override
            public void onClick(final Player p, final Item item) {
                if (!user.isIncognitoGuild()) {
                    user.setIncognitoGuild(true);
                    ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                    ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE));
                    IncognitoCommand.openInv(p);
                    return;
                }
                user.setIncognitoGuild(false);
                ChatUtil.sendTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_TITLE));
                ChatUtil.sendSubTitle(p, ChatUtil.fixColor(Config.GUILD_COMMAND_INCOGNITO_SUBTITLE2));
                IncognitoCommand.openInv(p);
            }
        });
        menu.setMainCategory(category);
        menu.addCategory("IncognitoGUI", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Zarzadzanie Incognito!"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("IncognitoGUI", menu);
    }
}
