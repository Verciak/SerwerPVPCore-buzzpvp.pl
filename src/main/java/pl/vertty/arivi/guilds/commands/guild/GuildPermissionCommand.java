// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import java.util.List;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Server;
import java.util.Collection;
import java.util.ArrayList;
import pl.vertty.arivi.enums.GroupType;
import java.util.Iterator;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.managers.guild.RoleManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.data.guild.Role;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildPermissionCommand extends PlayerCommand
{
    public static Role roler;
    
    public static void openRoleesSearch(final Player player, final String str) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        final Iterator<Role> iterator = RoleManager.getRolesGuild(GuildManager.getGuild(player).getTag()).iterator();
        for (int i = 20; i < RoleManager.getRolesGuild(GuildManager.getGuild(player).getTag()).size() + 20; ++i) {
            category.addElement(i, ItemData.fromItem(new Item(323, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9&l").append(iterator.next().getName())))).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby ustawic role!") })), new ItemClick() {
                @Override
                public void onClick(final Player player, final Item item) throws SkinChangeException {
                    final Guild guild = GuildManager.getGuild(player);
                    menu.forceDestroy(player);
                    final Role role2 = RoleManager.getRole(guild.getTag(), item.getCustomName().substring(4));
                    final String substring = str;
                    final User user = UserManager.getUser(substring);
                    user.setUpr_Furnace(role2.isUpr_Furnace());
                    user.setUpr_Logblock(role2.isUpr_Logblock());
                    user.setUpr_Lava(role2.isUpr_Lava());
                    user.setUpr_Boyfarmer(role2.isUpr_Boyfarmer());
                    user.setUpr_Chest(role2.isUpr_Chest());
                    user.setUpr_Tnt(role2.isUpr_Tnt());
                    user.setUpr_Place_Obsidian(role2.isUpr_Place_Obsidian());
                    user.setUpr_Place_Stone(role2.isUpr_Place_Stone());
                    user.setUpr_Break_Obsidian(role2.isUpr_Break_Obsidian());
                    user.setUpr_Lapis(role2.isUpr_Lapis());
                    user.setUpr_Break_Stone(role2.isUpr_Break_Stone());
                    user.setUpr_Water(role2.isUpr_Water());
                    user.setRole(role2.getName());
                    player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENIA_SUCCESS.replace("{ROLE}", role2.getName()).replace("{NICK}", substring)));
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menu" + str, category);
        menu.setName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9Wybierz role dla ").append(str))));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menu" + str, menu);
    }
    
    public static void openInv(final Player player, final Role role) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(8).setCustomName(ChatUtil.fixColor("&9Uzywanie wody")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: ")).append(role.isUpr_Water() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Water(!role.isUpr_Water());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(12, ItemData.fromItem(new Item(10).setCustomName(ChatUtil.fixColor("&9Uzywanie lawy")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: ")).append(role.isUpr_Lava() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Lava(!role.isUpr_Lava());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(13, ItemData.fromItem(new Item(49).setCustomName(ChatUtil.fixColor("&9Stawianie Obsydianu")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: ")).append(role.isUpr_Place_Obsidian() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Place_Obsidian(!role.isUpr_Place_Obsidian());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&9Stawianie Kamienia")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: ")).append(role.isUpr_Place_Stone() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Place_Stone(!role.isUpr_Place_Stone());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(15, ItemData.fromItem(new Item(46).setCustomName(ChatUtil.fixColor("&9Uzywanie tnt")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append(ChatUtil.fixColor("&8» &7Status: ")).append(role.isUpr_Tnt() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Tnt(!role.isUpr_Tnt());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(49).setCustomName(ChatUtil.fixColor("&9Niszczenie Obsidianu")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Break_Obsidian() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Break_Obsidian(!role.isUpr_Break_Obsidian());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(20, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&9Niszczenie Kamienia")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Break_Stone() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Break_Stone(!role.isUpr_Break_Stone());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(21, ItemData.fromItem(new Item(54).setCustomName(ChatUtil.fixColor("&9Uzywanie skrzynek")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Chest() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Chest(!role.isUpr_Chest());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(22, ItemData.fromItem(new Item(120).setCustomName(ChatUtil.fixColor("&9Uzywanie boyfarmera")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Boyfarmer() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Boyfarmer(!role.isUpr_Boyfarmer());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(23, ItemData.fromItem(new Item(22).setCustomName(ChatUtil.fixColor("&9Dostep do lapisu")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Lapis() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Lapis(!role.isUpr_Lapis());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(24, ItemData.fromItem(new Item(270).setCustomName(ChatUtil.fixColor("&9Dostep do Logblocka")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Logblock() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Logblock(!role.isUpr_Logblock());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(25, ItemData.fromItem(new Item(61).setCustomName(ChatUtil.fixColor("&9Otwieranie piecy")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Status: ").append(role.isUpr_Furnace() ? "&aTak" : "&cNie"))), ChatUtil.fixColor("&8» &7Kliknij aby zmienic") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Furnace(!role.isUpr_Furnace());
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(29, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(30, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(31, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(32, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(33, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(340).setCustomName(ChatUtil.fixColor("&9Wlacz wszystkie")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby wlaczyc uprawnienia!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Furnace(true);
                role.setUpr_Logblock(true);
                role.setUpr_Lava(true);
                role.setUpr_Boyfarmer(true);
                role.setUpr_Chest(true);
                role.setUpr_Tnt(true);
                role.setUpr_Place_Obsidian(true);
                role.setUpr_Place_Stone(true);
                role.setUpr_Break_Obsidian(true);
                role.setUpr_Break_Stone(true);
                role.setUpr_Lapis(true);
                role.setUpr_Water(true);
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(40, ItemData.fromItem(new Item(339).setCustomName(ChatUtil.fixColor("&9Zmien nazwe")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby zmienic nazwe!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                menu.forceDestroy(player);
                GuildPermissionCommand.roler = role;
                final User user = UserManager.getUser(player);
                User.update_name = true;
                pl.vertty.arivi.utils.ChatUtil.sendTitle(player, "&9ZMIANA NAZWY", "&6NAPISZ NA CHAT NAZWE ROLI", 20, 20, 20);
            }
        });
        category.addElement(41, ItemData.fromItem(new Item(340).setCustomName(ChatUtil.fixColor("&9Wylacz wszystkie")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby wylaczyc uprawnienia!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                role.setUpr_Furnace(false);
                role.setUpr_Logblock(false);
                role.setUpr_Lava(false);
                role.setUpr_Boyfarmer(false);
                role.setUpr_Chest(false);
                role.setUpr_Tnt(false);
                role.setUpr_Place_Obsidian(false);
                role.setUpr_Place_Stone(false);
                role.setUpr_Break_Obsidian(false);
                role.setUpr_Lapis(false);
                role.setUpr_Break_Stone(false);
                role.setUpr_Water(false);
                GuildPermissionCommand.openInv(player, role);
            }
        });
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(331).setCustomName(ChatUtil.fixColor("&9Wroc")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby wrocic!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                GuildPermissionCommand.openRoles(player, GuildManager.getGuild(player));
            }
        });
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menu" + role.getTag(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9Edytowanie roli: &9").append(role.getName()))));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menu" + role.getTag(), menu);
    }
    
    public static void openRolesSearch(final Player player, final String str) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        final Iterator<Role> iterator = RoleManager.getRolesGuild(GuildManager.getGuild(player).getTag()).iterator();
        while (iterator.hasNext()) {
            for (int ia = 20; ia < RoleManager.getRolesGuild(GuildManager.getGuild(player).getTag()).size() + 20; ++ia) {
                category.addElement(ia, ItemData.fromItem(new Item(323).setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9&l").append(iterator.next().getName())))).setLore(new String[] { "&8» &7Kliknij aby zmodyfikowac role!" })), new ItemClick() {
                    @Override
                    public void onClick(final Player player, final Item item) throws SkinChangeException {
                        menu.forceDestroy(player);
                        final Role role2 = RoleManager.getRole(GuildManager.getGuild(player).getTag(), item.getCustomName().substring(4));
                        final User user = UserManager.getUser(str);
                        user.setUpr_Furnace(role2.isUpr_Furnace());
                        user.setUpr_Logblock(role2.isUpr_Logblock());
                        user.setUpr_Lava(role2.isUpr_Lava());
                        user.setUpr_Boyfarmer(role2.isUpr_Boyfarmer());
                        user.setUpr_Chest(role2.isUpr_Chest());
                        user.setUpr_Tnt(role2.isUpr_Tnt());
                        user.setUpr_Place_Obsidian(role2.isUpr_Place_Obsidian());
                        user.setUpr_Place_Stone(role2.isUpr_Place_Stone());
                        user.setUpr_Break_Obsidian(role2.isUpr_Break_Obsidian());
                        user.setUpr_Lapis(role2.isUpr_Lapis());
                        user.setUpr_Break_Stone(role2.isUpr_Break_Stone());
                        user.setUpr_Water(role2.isUpr_Water());
                        user.setRole(role2.getName());
                        player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENIA_SUCCESS.replace("{ROLE}", role2.getName()).replace("{NICK}", str)));
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menu" + str, category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9Wybierz role dla ").append(str))));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menu" + str, menu);
    }
    
    private static void dSignSearchName1(final Player player, final Player player2, final String[] array) {
        final String substring = array[0].substring(1, array[0].length() - 1);
        final Guild guild = GuildManager.getGuild(player);
        final User user = UserManager.getUser(substring);
        if (user == null) {
            player.sendMessage(ChatUtil.fixColor(Config.USER_NULL));
            return;
        }
        if (!guild.isMember(user.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_MYGUILD));
            return;
        }
        if (guild.isOwner(user.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_UPRAWNIENIA_ERROR2));
            return;
        }
        openRolesSearch(player, substring);
    }
    
    public GuildPermissionCommand() {
        super("uprawnienia", "/g uprawnienia", GroupType.PLAYER, new String[0]);
    }
    
    public static void openMembers(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        final Guild g = GuildManager.getGuild(player);
        for (int i = 0; i < g.getMembers().size(); ++i) {
            final List<String> list = new ArrayList<String>(g.getMembers());
            final User member = UserManager.getUser(list.get(i));
            final Item ib = new Item(397, Integer.valueOf(3), 1).setCustomName(ChatUtil.fixColor("&9" + member.getName())).setLore(new String[] { ChatUtil.fixColor("&8» &7Obecna rola: &9" + member.getRole()), ChatUtil.fixColor("&8» &7Nacisnij aby zarzadzac") });
            category.addElement(i + 19, ItemData.fromItem(ib), new ItemClick() {
                @Override
                public void onClick(final Player player, final Item item) throws SkinChangeException {
                    final Guild guild = GuildManager.getGuild(player);
                    for (int j = 0; j < guild.getMembers().size(); ++j) {
                        final List<String> list = new ArrayList<String>(guild.getMembers());
                        final User member2 = UserManager.getUser(list.get(j));
                        if (item.getCustomName().equals(ChatUtil.fixColor("&9" + member2.getName()))) {
                            final Player onlinee = Server.getInstance().getPlayer(member2.getName());
                            if (onlinee == null) {
                                ChatUtil.sendMessage((CommandSender)player, "&cGracz jest offline!");
                                menu.forceDestroy(player);
                            }
                            else {
                                GuildPermissionCommand.openRoleesSearch(player, member2.getName());
                            }
                        }
                    }
                }
            });
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("membersMenu" + player.getName(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Czlonkowie gildii"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("membersMenu" + player.getName(), menu);
    }
    
    public static void openRoles(final Player player, final Guild guild) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.addElement(0, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(1, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(2, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(3, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(4, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(5, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(6, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(7, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(8, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(9, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(10, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(11, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(13, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(27, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(29, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(30, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(31, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(32, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(33, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(340, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Zarzadzanie czlonkow")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby przejsc dalej!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                GuildPermissionCommand.openMembers(player);
            }
        });
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(41, ItemData.fromItem(new Item(386, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Odswiez permissje")).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby odswiezyc!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                RoleManager.refreshRoleAll();
            }
        });
        category.addElement(42, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(43, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(44, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(45, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(46, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(47, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(48, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(49, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(50, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(51, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(52, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(53, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(54, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        final Iterator<Role> iterator = RoleManager.getRolesGuild(guild.getTag()).iterator();
        while (iterator.hasNext()) {
            for (int ia = 20; ia < RoleManager.getRolesGuild(guild.getTag()).size() + 20; ++ia) {
                category.addElement(ia, ItemData.fromItem(new Item(323).setCustomName(ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&9&l").append(iterator.next().getName())))).setLore(new String[] { ChatUtil.fixColor("&8» &7Kliknij aby zmodyfikowac role!") })), new ItemClick() {
                    @Override
                    public void onClick(final Player player, final Item item) throws SkinChangeException {
                        GuildPermissionCommand.openInv(player, RoleManager.getRole(guild.getTag(), item.getCustomName().substring(4)));
                    }
                });
            }
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menur" + guild.getTag(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Zarzadzanie Rolami"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menur" + guild.getTag(), menu);
    }
    
    private static void addSignEditName(final Role role, final Player player, final Player player2, final String[] array) {
        role.setName(array[0].substring(1, array[0].length() - 1));
        openInv(player, role);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.getOwner().equalsIgnoreCase(player.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        openRoles(player, guild);
        return false;
    }
}
