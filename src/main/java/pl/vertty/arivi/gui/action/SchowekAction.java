// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.gui.action;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class SchowekAction
{
    private final String name;
    public static Config c;
    
    public SchowekAction(final String name) {
        this.name = name;
    }


    public static void checkSniezki(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.sniezki");
        if (u.getSniezki() <= 0) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if (i.getId() == Item.SNOWBALL) {
                koxy += i.getCount();
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getSniezki()) {
            j = u.getSniezki();
        }
        u.removeSniezki(j);
        final Item xd = Item.get(Item.SNOWBALL, Integer.valueOf(0), j);
        p.getInventory().addItem(new Item[] { xd });
        if (msg) {
            ChatUtil.sendMessage((CommandSender)p, "&7Zwrocono: &6{ITEM} &7sniezek".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkKoxy(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.kox");
        if (u.getKox() <= 0) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if (i.getId() == 466) {
                koxy += i.getCount();
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getKox()) {
            j = u.getKox();
        }
        u.removeKox(j);
        final Item xd = Item.get(466, Integer.valueOf(0), j);
        p.getInventory().addItem(new Item[] { xd });
        if (msg) {
            ChatUtil.sendMessage((CommandSender)p, "&7Zwrocono: &6{ITEM} &7koxow".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkRefile(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.refy");
        if (u.getRefy() <= 0) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if (i.getId() == 322) {
                koxy += i.getCount();
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getRefy()) {
            j = u.getRefy();
        }
        u.removeRefy(j);
        final Item xd = Item.get(322, Integer.valueOf(0), j);
        p.getInventory().addItem(new Item[] { xd });
        if (msg) {
            ChatUtil.sendMessage((CommandSender)p, "&7Zwrocono: &6{ITEM} &7refow".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkPerly(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.perly");
        if (u.getPerly() <= 0) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if (i.getId() == 368) {
                koxy += i.getCount();
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage((CommandSender)p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getPerly()) {
            j = u.getPerly();
        }
        u.removePerly(j);
        final Item xd = Item.get(368, Integer.valueOf(0), j);
        p.getInventory().addItem(new Item[] { xd });
        if (msg) {
            ChatUtil.sendMessage((CommandSender)p, "&7Zwrocono: &6{ITEM} &7perel".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    static {
        SchowekAction.c = Main.getPlugin().getConfig();
    }
}
