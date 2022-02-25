package pl.vertty.arivi.gui.action;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class SchowekAction
{
    public static Config c;
    
    public SchowekAction() {
    }

    public static void checkTNT(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.tnt");
        assert u != null;
        if (u.getTnt() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if(i.getCustomName().contains(ChatUtil.fixColor("&9RZUCANETNT"))) {
                if (i.getId() == Item.TNT) {
                    koxy += i.getCount();
                }
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getTnt()) {
            j = u.getTnt();
        }
        u.removeTnt(j);
        final Item xd = Item.get(Item.TNT, 0, j);
        xd.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
        xd.setLore(ChatUtil.fixColor(new String[] { "", "&7Kliknij, PPM aby postawic RZUCANETNT" }));

        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7rzucakow".replace("{ITEM}", String.valueOf(j)));
        }
    }

    public static void checkArrow(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.arrow");
        assert u != null;
        if (u.getArrow() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
            }
            return;
        }
        int koxy = 0;
        for (final Item i : p.getInventory().getContents().values()) {
            if (i.getId() == Item.ARROW) {
                koxy += i.getCount();
            }
        }
        if (koxy >= maxKoxy) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getArrow()) {
            j = u.getArrow();
        }
        u.removeSniezki(j);
        final Item xd = Item.get(Item.ARROW, 0, j);
        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7strzal".replace("{ITEM}", String.valueOf(j)));
        }
    }


    public static void checkSniezki(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.sniezki");
        assert u != null;
        if (u.getSniezki() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
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
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getSniezki()) {
            j = u.getSniezki();
        }
        u.removeSniezki(j);
        final Item xd = Item.get(Item.SNOWBALL, 0, j);
        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7sniezek".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkKoxy(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.kox");
        assert u != null;
        if (u.getKox() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
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
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getKox()) {
            j = u.getKox();
        }
        u.removeKox(j);
        final Item xd = Item.get(466, 0, j);
        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7koxow".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkRefile(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.refy");
        assert u != null;
        if (u.getRefy() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
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
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getRefy()) {
            j = u.getRefy();
        }
        u.removeRefy(j);
        final Item xd = Item.get(322, 0, j);
        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7refow".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    public static void checkPerly(final Player p, final boolean msg) {
        final User u = UserManager.getUser(p);
        final int maxKoxy = SchowekAction.c.getInt("limit.perly");
        assert u != null;
        if (u.getPerly() <= 0) {
            if (msg) {
                ChatUtil.sendMessage(p, "&cAktualnie nie masz do wyplacenia tego itemu!");
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
                ChatUtil.sendMessage(p, "&cPosiadasz juz limit tego przedmiotu!");
            }
            return;
        }
        int j = maxKoxy - koxy;
        if (j > u.getPerly()) {
            j = u.getPerly();
        }
        u.removePerly(j);
        final Item xd = Item.get(368, 0, j);
        p.getInventory().addItem(xd);
        if (msg) {
            ChatUtil.sendMessage(p, "&7Zwrocono: &6{ITEM} &7perel".replace("{ITEM}", String.valueOf(j)));
        }
    }
    
    static {
        SchowekAction.c = Main.getPlugin().getConfig();
    }
}
