// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.guilds.commands.guild;

import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.guilds.utils.itemstack.ItemStackUtil;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.task.RegenerationTask;
import pl.vertty.arivi.guilds.utils.TimeUtil;
import pl.vertty.arivi.guilds.utils.DataUtil;
import pl.vertty.arivi.utils.exception.SkinChangeException;
import java.util.Iterator;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.guilds.utils.EffectType;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.Player;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildPanelCommand extends PlayerCommand
{
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Guild guild = GuildManager.getGuild(player);
        if (guild == null) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_GUILD));
            return false;
        }
        if (!guild.isOwner(player.getName())) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_NOT_OWNER));
            return false;
        }
        openInv(player);
        return false;
    }
    
    public static void openInv(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final Guild guild = GuildManager.getGuild(player);
        final Guild guild2 = GuildManager.getGuild(player);
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
        category.addElement(12, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(13, ItemData.fromItem(new Item(373, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Efekty gilidyjne")).setLore(new String[] { ChatUtil.fixColor("&8» &7Koszt: &950 &7glow"), ChatUtil.fixColor("&8» &7Kliknij aby wylosowac efekt dla gildi") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getHead() < 50) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE2.replace("{HEAD}", "50")));
                    return;
                }
                final Effect potionEffect = EffectType.getEffects().get(RandomUtil.getRandInt(0, EffectType.getEffects().size() - 1));
                final Iterator<Player> iterator = guild2.getOnlineMembers().iterator();
                while (iterator.hasNext()) {
                    iterator.next().addEffect(potionEffect);
                }
                guild2.setHead(guild2.getHead() - 50);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE.replace("{EFFECT}", potionEffect.getName())));
            }
        });
        category.addElement(14, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(15, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(16, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(17, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(18, ItemData.fromItem(new Item(323, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Informacje o gildii!")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Tag: &9").append(guild.getTag()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Nazwa: &9").append(guild.getName()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Glowy: &9").append(guild.getHead()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7HP: &9").append(guild.getHp()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Zycia: &9").append(guild.getLife()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Sojuszy: &9").append(guild.getSojusz()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Graczy: &9").append(guild.getLimitMembers()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Rozmiar: &9").append(guild.getRegion().getSize()).append("&7x&9").append(guild.getRegion().getSize()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Wygasa za: &9").append(DataUtil.secondsToString(guild.getProlong())))) })));
        category.addElement(19, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(20, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(21, ItemData.fromItem(new Item(122, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Odnow zycie gildii")).setLore(new String[] { ChatUtil.fixColor("&8» &7Koszt: &930 &7glow"), ChatUtil.fixColor("&8» &7Kliknij aby odnowic zycie jajka") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getHead() < 30) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_LIFE_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE2.replace("{HEAD}", "30")));
                    return;
                }
                if (guild2.getLife() > 2) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_LIFE_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_LIFE_SUBTITLE2));
                    return;
                }
                guild2.setLife(guild2.getLife() + 1);
                guild2.setHead(guild2.getHead() - 30);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_LIFE_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_LIFE_SUBTITLE));
            }
        });
        category.addElement(22, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(23, ItemData.fromItem(new Item(38, Integer.valueOf(0), 1).setCustomName(ChatUtil.fixColor("&9Odnow hp gildii")).setLore(new String[] { ChatUtil.fixColor("&8» &7Koszt: &930 &7glow"), ChatUtil.fixColor("&8» &7Kliknij aby odnowic hp jajka") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getHead() < 30) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_HP_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE2.replace("{HEAD}", "30")));
                    return;
                }
                if (guild2.getHp() > 499) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_HP_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_HP_SUBTITLE2));
                    return;
                }
                guild2.setHp(500);
                guild2.setHead(guild2.getHead() - 30);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_HP_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_HP_SUBTITLE));
            }
        });
        category.addElement(24, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(25, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(26, ItemData.fromItem(new Item(323, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Informacje o gildii!")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Tag: &9").append(guild.getTag()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Nazwa: &9").append(guild.getName()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Glowy: &9").append(guild.getHead()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7HP: &9").append(guild.getHp()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Zycia: &9").append(guild.getLife()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Sojuszy: &9").append(guild.getSojusz()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Graczy: &9").append(guild.getLimitMembers()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Rozmiar: &9").append(guild.getRegion().getSize()).append("&7x&9").append(guild.getRegion().getSize()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Wygasa za: &9").append(DataUtil.secondsToString(guild.getProlong())))) })));
        category.addElement(27, ItemData.fromItem(new Item(323, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Informacje o gildii!")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Tag: &9").append(guild.getTag()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Nazwa: &9").append(guild.getName()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Glowy: &9").append(guild.getHead()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7HP: &9").append(guild.getHp()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Zycia: &9").append(guild.getLife()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Sojuszy: &9").append(guild.getSojusz()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Graczy: &9").append(guild.getLimitMembers()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Rozmiar: &9").append(guild.getRegion().getSize()).append("&7x&9").append(guild.getRegion().getSize()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Wygasa za: &9").append(DataUtil.secondsToString(guild.getProlong())))) })));
        category.addElement(28, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(29, ItemData.fromItem(new Item(283).setCustomName(ChatUtil.fixColor("&9Powieksz limit sojuszy")).setLore(new String[] { ChatUtil.fixColor("&8» &7Koszt: &930 &7glow"), ChatUtil.fixColor("&8» &7Kliknij aby powiekszyc limit sojuszy o &91") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getHead() < 30) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SOJUSZ_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE2.replace("{HEAD}", "30")));
                    return;
                }
                if (guild2.getSojusz() >= 4) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SOJUSZ_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SOJUSZ_SUBTITLE2));
                    return;
                }
                guild2.setSojusz(guild2.getSojusz() + 1);
                guild2.setHead(guild2.getHead() - 30);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SOJUSZ_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_SOJUSZ_SUBTITLE));
            }
        });
        category.addElement(30, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(31, ItemData.fromItem(new Item(46, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Regeneracja terenu")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Do zregenerowania: &9").append(guild.getBlocks().size()).append(" &7blokow"))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koszt regeneracji: &9").append(guild.getBlocks().size() / 2).append(" &7emeraldow"))), ChatUtil.fixColor(" "), ChatUtil.fixColor("&8» &7Regeneracja nie dziala na: "), ChatUtil.fixColor("  &8- &9Tnt"), ChatUtil.fixColor("  &8- &9Dzwignie"), ChatUtil.fixColor("  &8- &9Wagoniki"), ChatUtil.fixColor("  &8- &9Pistony"), ChatUtil.fixColor("  &8- &9Repetery"), ChatUtil.fixColor(" "), ChatUtil.fixColor("&8» &7Kliknij aby zregenerowac!") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (!TimeUtil.isTnt()) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE1));
                    return;
                }
                if (guild2.getBlocks().isEmpty()) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE));
                    return;
                }
                if (guild2.isRegeneration()) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE8));
                    return;
                }
                if (guild2.getSkarbiec() < 1) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE2));
                    return;
                }
                guild2.setRegeneration(true);
                final int koszt = guild2.getBlocks().size() / 2;
                guild2.setSkarbiec(guild2.getSkarbiec() - koszt);
                new RegenerationTask(guild2, guild2.getBlocks()).runTaskTimer((Plugin)Main.getPlugin(), 0, 1);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_COMMAND_REGENERATION_SUBTITLE5));
            }
        });
        category.addElement(32, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(33, ItemData.fromItem(new Item(421, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Powieksz limit czlonkow")).setLore(new String[] { ChatUtil.fixColor("&8» &7Koszt: &930 &7glow"), ChatUtil.fixColor("&8» &7Kliknij aby powiekszyc limit czlonkow o &910") })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getHead() < 30) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_MEMBER_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_EFFECT_SUBTITLE2.replace("{HEAD}", "30")));
                    return;
                }
                if (guild2.getLimitMembers() > 99) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_MEMBER_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_MEMBER_SUBTITLE2));
                    return;
                }
                guild2.setLimitMembers(guild2.getLimitMembers() + 10);
                guild2.setHead(guild2.getHead() - 30);
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_MEMBER_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_MEMBER_SUBTITLE));
            }
        });
        category.addElement(34, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(35, ItemData.fromItem(new Item(323, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Informacje o gildii!")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Tag: &9").append(guild.getTag()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Nazwa: &9").append(guild.getName()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Glowy: &9").append(guild.getHead()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7HP: &9").append(guild.getHp()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Zycia: &9").append(guild.getLife()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Sojuszy: &9").append(guild.getSojusz()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Limit Graczy: &9").append(guild.getLimitMembers()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Rozmiar: &9").append(guild.getRegion().getSize()).append("&7x&9").append(guild.getRegion().getSize()))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Wygasa za: &9").append(DataUtil.secondsToString(guild.getProlong())))) })));
        category.addElement(36, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(37, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(38, ItemData.fromItem(new Item(160, Integer.valueOf(7), 1)));
        category.addElement(39, ItemData.fromItem(new Item(345, Integer.valueOf(1)).setCustomName(ChatUtil.fixColor("&9Powieksz teren gildi")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koszt: &9").append(ItemStackUtil.getItem(Config.COST_ENLARGE_NORMAL, 1)))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Kliknij aby powiekszyc teren o &9").append(Config.CUBOID_SIZE_ADD).append(" &7kratek"))) })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getRegion().getSize() >= Config.CUBOID_SIZE_MAX) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_SUBTITLE2));
                    return;
                }
                final int n = (guild2.getRegion().getSize() - Config.CUBOID_SIZE_START) / 5 + 1;
                final String cost_ENLARGE_NORMAL = Config.COST_ENLARGE_NORMAL;
                if (!ItemStackUtil.checkItems(player, cost_ENLARGE_NORMAL, n)) {
                    ItemStackUtil.getItem(player, cost_ENLARGE_NORMAL, n);
                    return;
                }
                ItemStackUtil.removeItems(player, cost_ENLARGE_NORMAL, n);
                guild2.addSize(Config.CUBOID_SIZE_ADD);
                final int i = guild2.getRegion().getSize() + 1;
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_ENLARGE_SUBTITLE.replace("{SIZE}", Integer.toString(i))));
            }
        });
        category.addElement(40, ItemData.fromItem(new Item(160, Integer.valueOf(11), 1)));
        category.addElement(41, ItemData.fromItem(Item.get(347).setCustomName(ChatUtil.fixColor("&9Oplac gildie")).setLore(new String[] { ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koszt: &9").append(ItemStackUtil.getItem(Config.COST_PROLONG_NORMAL, 1)))), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Kliknij aby oplacic gildie o &9").append(Config.PROLONG_ADD).append(" &7dni"))) })), new ItemClick() {
            @Override
            public void onClick(final Player player, final Item item) throws SkinChangeException {
                if (guild2.getProlong() > System.currentTimeMillis() + TimeUtil.DAY.getTime(Config.PROLONG_MAX)) {
                    ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_TITLE));
                    ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_SUBTITLE2));
                    return;
                }
                final String cost_PROLONG_NORMAL = Config.COST_PROLONG_NORMAL;
                if (!ItemStackUtil.checkItems(player, cost_PROLONG_NORMAL, 1)) {
                    ItemStackUtil.getItem(player, cost_PROLONG_NORMAL, 1);
                    return;
                }
                ItemStackUtil.removeItems(player, cost_PROLONG_NORMAL, 1);
                guild2.setProlong(guild2.getProlong() + TimeUtil.DAY.getTime(Config.PROLONG_ADD));
                ChatUtil.sendTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_TITLE));
                ChatUtil.sendSubTitle(player, ChatUtil.fixColor(Config.GUILD_PANEL_PROLONG_SUBTITLE.replace("{PROLONG}", Integer.toString(Config.PROLONG_ADD))));
            }
        });
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
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gpanel" + player.getName(), category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Panel Gilidyjny"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gpanel" + player.getName(), menu);
    }
    
    public GuildPanelCommand() {
        super("panel", "/g panel", GroupType.PLAYER, new String[0]);
    }
}
