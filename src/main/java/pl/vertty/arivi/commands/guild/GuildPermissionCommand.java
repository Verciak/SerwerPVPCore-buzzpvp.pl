
package pl.vertty.arivi.commands.guild;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.objects.Role;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.objects.yml.Config;
import pl.vertty.arivi.managers.RoleManager;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuildPermissionCommand extends PlayerCommand
{
    public static void openInv(final Player player, final String user) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleGuildRolesGui();
        Role role = RoleManager.getUser(user);


        category.addElement(11, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&9Stawianie Kamienia")).setLore(ChatUtil.fixColor(ChatUtil.fixColor("&8» &7Status: ") + (role.isUpr_Place_Stone() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Place_Stone(!role.isUpr_Place_Stone());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(12, ItemData.fromItem(new Item(1).setCustomName(ChatUtil.fixColor("&9Niszczenie Kamienia")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Break_Stone() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Break_Stone(!role.isUpr_Break_Stone());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(13, ItemData.fromItem(new Item(49).setCustomName(ChatUtil.fixColor("&9Stawianie Obsydianu")).setLore(ChatUtil.fixColor(ChatUtil.fixColor("&8» &7Status: ") + (role.isUpr_Place_Obsidian() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Place_Obsidian(!role.isUpr_Place_Obsidian());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(14, ItemData.fromItem(new Item(49).setCustomName(ChatUtil.fixColor("&9Niszczenie Obsidianu")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Break_Obsidian() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Break_Obsidian(!role.isUpr_Break_Obsidian());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(15, ItemData.fromItem(new Item(54).setCustomName(ChatUtil.fixColor("&9Uzywanie skrzynek")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Chest() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Chest(!role.isUpr_Chest());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(19, ItemData.fromItem(new Item(61).setCustomName(ChatUtil.fixColor("&9Otwieranie piecy")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Furnace() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Furnace(!role.isUpr_Furnace());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(20, ItemData.fromItem(new Item(22).setCustomName(ChatUtil.fixColor("&9Dostep do lapisu")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Lapis() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Lapis(!role.isUpr_Lapis());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(21, ItemData.fromItem(new Item(46).setCustomName(ChatUtil.fixColor("&9Uzywanie tnt")).setLore(ChatUtil.fixColor(ChatUtil.fixColor("&8» &7Status: ") + (role.isUpr_Tnt() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Tnt(!role.isUpr_Tnt());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(22, ItemData.fromItem(new Item(120).setCustomName(ChatUtil.fixColor("&9Uzywanie farmerow")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_Boyfarmer() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Boyfarmer(!role.isUpr_Boyfarmer());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(23, ItemData.fromItem(new Item(8).setCustomName(ChatUtil.fixColor("&9Rozlewanie wody")).setLore(ChatUtil.fixColor(ChatUtil.fixColor("&8» &7Status: ") + (role.isUpr_Water() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Water(!role.isUpr_Water());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(24, ItemData.fromItem(new Item(10).setCustomName(ChatUtil.fixColor("&9Rozlewanie lawy")).setLore(ChatUtil.fixColor(ChatUtil.fixColor("&8» &7Status: ") + (role.isUpr_Lava() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Lava(!role.isUpr_Lava());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(25, ItemData.fromItem(new Item(ItemID.ENDER_EYE).setCustomName(ChatUtil.fixColor("&9Dostep do uprawnien")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_perms() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_perms(!role.isUpr_perms());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(29, ItemData.fromItem(new Item(ItemID.SKULL, 3, 1).setCustomName(ChatUtil.fixColor("&9Dodawanie do gildii")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_addMember() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_addMember(!role.isUpr_addMember());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(30, ItemData.fromItem(new Item(ItemID.SKULL, 0, 1).setCustomName(ChatUtil.fixColor("&9Wyrzucanie z gildii")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_removeMember() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_removeMember(!role.isUpr_removeMember());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(31, ItemData.fromItem(new Item(ItemID.FEATHER, 0, 1).setCustomName(ChatUtil.fixColor("&9Teleportacja na dom gildii")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_base_teleport() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_base_teleport(!role.isUpr_base_teleport());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(32, ItemData.fromItem(new Item(ItemID.MAGMA_CREAM, 0, 1).setCustomName(ChatUtil.fixColor("&9Zmiana pvp w gildii")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_pvpguild() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_pvpguild(!role.isUpr_pvpguild());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(33, ItemData.fromItem(new Item(ItemID.FIRE_CHARGE, 0, 1).setCustomName(ChatUtil.fixColor("&9Zmiana pvp w sojuszu")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_pvpally() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_pvpally(!role.isUpr_pvpally());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(38, ItemData.fromItem(new Item(BlockID.DIAMOND_BLOCK, 0, 1).setCustomName(ChatUtil.fixColor("&9Wyplacanie z skarbca")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_withdrawchest() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_withdrawchest(!role.isUpr_withdrawchest());
                GuildPermissionCommand.openInv(player, user);
            }
        });

        category.addElement(42, ItemData.fromItem(new Item(BlockID.ENDER_CHEST, 0, 1).setCustomName(ChatUtil.fixColor("&9Dostep do skrzynki gildii")).setLore(ChatUtil.fixColor("&8» &7Status: " + (role.isUpr_guildchest() ? "&aTak" : "&cNie")), ChatUtil.fixColor("&8» &7Kliknij aby zmienic"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_guildchest(!role.isUpr_guildchest());
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(48, ItemData.fromItem(new Item(340).setCustomName(ChatUtil.fixColor("&9Wlacz wszystkie")).setLore(ChatUtil.fixColor("&8» &7Kliknij aby wlaczyc uprawnienia!"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Furnace(true);
                role.setUpr_perms(true);
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
                role.setUpr_addMember(true);
                role.setUpr_removeMember(true);
                role.setUpr_base_teleport(true);
                role.setUpr_pvpguild(true);
                role.setUpr_pvpally(true);
                role.setUpr_withdrawchest(true);
                role.setUpr_guildchest(true);
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(50, ItemData.fromItem(new Item(340).setCustomName(ChatUtil.fixColor("&9Wylacz wszystkie")).setLore(ChatUtil.fixColor("&8» &7Kliknij aby wylaczyc uprawnienia!"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                role.setUpr_Furnace(false);
                role.setUpr_perms(false);
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
                role.setUpr_addMember(false);
                role.setUpr_removeMember(false);
                role.setUpr_base_teleport(false);
                role.setUpr_pvpguild(false);
                role.setUpr_pvpally(false);
                role.setUpr_withdrawchest(false);
                role.setUpr_guildchest(false);
                GuildPermissionCommand.openInv(player, user);
            }
        });
        category.addElement(49, ItemData.fromItem(new Item(ItemID.NETHER_STAR).setCustomName(ChatUtil.fixColor("&9Wroc")).setLore(ChatUtil.fixColor("&8» &7Kliknij aby wrocic!"))), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) {
                GuildPermissionCommand.openRoles(player, GuildManager.getGuild(player));
            }
        });
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menu" + role.getName(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Edytowanie uprawnien: &9" + role.getName()));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menu" + role.getName(), menu);
    }
    

    public GuildPermissionCommand() {
        super("uprawnienia", "/g uprawnienia", GroupType.PLAYER);
    }
    
    public static void openRoles(final Player player, final Guild guild) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();

        category.setDoubleGuildItemsGui();

        final Guild g = GuildManager.getGuild(player);
        for (int i = 0; i < Objects.requireNonNull(g).getMembers().size(); ++i) {
            final List<String> list = new ArrayList<>(g.getMembers());
            final User member = UserManager.getUser(list.get(i));
            final Item ib = new Item(397, 3, 1).setCustomName(ChatUtil.fixColor("&9" + member.getName())).setLore(ChatUtil.fixColor("&8» &7Nacisnij aby zarzadzac"));
            category.addElementAir(ItemData.fromItem(ib), new ItemClick() {
                @Override
                public void onClick(final Player player, final Item item) {
                    final Guild guild = GuildManager.getGuild(player);
                    for (int j = 0; j < Objects.requireNonNull(guild).getMembers().size(); ++j) {
                        final List<String> list = new ArrayList<>(guild.getMembers());
                        final User member2 = UserManager.getUser(list.get(j));
                        if (item.getCustomName().equals(ChatUtil.fixColor("&9" + guild.getOwner()))) {
                            ChatUtil.sendSubTitle(player, "&cNie mozesz edytowac permisji lidera!");
                            menu.forceDestroy(player);
                            return;
                        }
                        if (item.getCustomName().equals(ChatUtil.fixColor("&9" + member2.getName()))) {
                                GuildPermissionCommand.openInv(player, member2.getName());
                        }
                    }
                }
            }, 54);
        }


        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("Menur" + guild.getTag(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Zarzadzanie uprawnieniami"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("Menur" + guild.getTag(), menu);
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
