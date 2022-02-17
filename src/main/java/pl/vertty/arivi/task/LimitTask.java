
package pl.vertty.arivi.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;

public class LimitTask extends NukkitRunnable
{
    public static Config c;
    
    public void run() {
        for (final Player p : Server.getInstance().getOnlinePlayers().values()) {
            final User u = UserManager.getUser(p);
            int koxSize = 0;
            int refSize = 0;
            int perSize = 0;
            int sSize = 0;
            int arrSize = 0;
            int tntSize = 0;
            for (final Item pinv : p.getInventory().getContents().values()) {
                if (pinv != null) {
                    if (pinv.getId() == Item.TNT) {
                        if (pinv.getCustomName().contains(ChatUtil.fixColor("&9RZUCANETNT"))) {
                            tntSize += pinv.getCount();
                        }
                    }
                    if (pinv.getId() == Item.ARROW) {
                        if (pinv.hasCustomName()) {
                            return;
                        }
                        arrSize += pinv.getCount();
                    }
                    if (pinv.getId() == Item.SNOWBALL) {
                        if (pinv.hasCustomName()) {
                            return;
                        }
                        sSize += pinv.getCount();
                    }
                    if (pinv.getId() == 368) {
                        if (pinv.hasCustomName()) {
                            return;
                        }
                        perSize += pinv.getCount();
                    }
                    if (pinv.getId() == 466) {
                        if (pinv.hasCustomName()) {
                            return;
                        }
                        koxSize += pinv.getCount();
                    }
                    if (pinv.getId() != 322) {
                        continue;
                    }
                    if (pinv.hasCustomName()) {
                        return;
                    }
                    refSize += pinv.getCount();
                }
            }
            if (tntSize > LimitTask.c.getInt("limit.tnt")) {
                final int toRemove = tntSize - LimitTask.c.getInt("limit.tnt");
                u.addTnt(u.getTnt() + toRemove);
                Item item = new Item(Item.TNT, 0, toRemove);
                item.setCustomName(ChatUtil.fixColor("&9RZUCANETNT"));
                p.getInventory().removeItem(item);
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + tntSize + " &7rzucakow");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.tnt") + " &7rzucakow");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (arrSize > LimitTask.c.getInt("limit.arrow")) {
                final int toRemove = arrSize - LimitTask.c.getInt("limit.arrow");
                u.addArrow(u.getArrow() + toRemove);
                p.getInventory().removeItem(new Item(Item.ARROW, 0, toRemove));
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + arrSize + " &7strzal");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.arrow") + " &7strzal");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (sSize > LimitTask.c.getInt("limit.sniezki")) {
                final int toRemove = sSize - LimitTask.c.getInt("limit.sniezki");
                u.addSniezki(u.getSniezki() + toRemove);
                p.getInventory().removeItem(new Item(Item.SNOWBALL, 0, toRemove));
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + sSize + " &7sniezek");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.sniezki") + " &7sniezek");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (perSize > LimitTask.c.getInt("limit.perly")) {
                final int toRemove = perSize - LimitTask.c.getInt("limit.perly");
                u.addPerly(u.getPerly() + toRemove);
                p.getInventory().removeItem(new Item(368, 0, toRemove));
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + perSize + " &7perel");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.perly") + " &7perel");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (koxSize > LimitTask.c.getInt("limit.kox")) {
                final int toRemove = koxSize - LimitTask.c.getInt("limit.kox");
                u.addKox(u.getKox() + toRemove);
                p.getInventory().removeItem(new Item(466, 0, toRemove));
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + koxSize + " &7koxow");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.kox") + " &7koxow");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (refSize > LimitTask.c.getInt("limit.refy")) {
                final int toRemove = refSize - LimitTask.c.getInt("limit.refy");
                u.addRefy(u.getRefy() + toRemove);
                p.getInventory().removeItem(new Item(322, 0, toRemove));
                ChatUtil.sendMessage(p, "&7Miales przy sobie &e" + refSize + " &7refili");
                ChatUtil.sendMessage(p, "&7Limit to &e" + LimitTask.c.getInt("limit.refy") + " &7refili");
                ChatUtil.sendMessage(p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
        }
    }
    
    static {
        LimitTask.c = Main.getPlugin().getConfig();
    }
}
