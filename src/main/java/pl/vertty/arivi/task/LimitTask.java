
package pl.vertty.arivi.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
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
            for (final Item pinv : p.getInventory().getContents().values()) {
                if (pinv != null) {
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
            if (sSize > LimitTask.c.getInt("limit.sniezki")) {
                final int toRemove = sSize - LimitTask.c.getInt("limit.sniezki");
                u.addSniezki(u.getSniezki() + toRemove);
                p.getInventory().removeItem(new Item[] { new Item(Item.SNOWBALL, Integer.valueOf(0), toRemove) });
                ChatUtil.sendMessage((CommandSender)p, "&7Miales przy sobie &e" + sSize + " &7sniezek");
                ChatUtil.sendMessage((CommandSender)p, "&7Limit to &e" + LimitTask.c.getInt("limit.sniezki") + " &7sniezek");
                ChatUtil.sendMessage((CommandSender)p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (perSize > LimitTask.c.getInt("limit.perly")) {
                final int toRemove = perSize - LimitTask.c.getInt("limit.perly");
                u.addPerly(u.getPerly() + toRemove);
                p.getInventory().removeItem(new Item[] { new Item(368, Integer.valueOf(0), toRemove) });
                ChatUtil.sendMessage((CommandSender)p, "&7Miales przy sobie &e" + perSize + " &7perel");
                ChatUtil.sendMessage((CommandSender)p, "&7Limit to &e" + LimitTask.c.getInt("limit.perly") + " &7perel");
                ChatUtil.sendMessage((CommandSender)p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (koxSize > LimitTask.c.getInt("limit.kox")) {
                final int toRemove = koxSize - LimitTask.c.getInt("limit.kox");
                u.addKox(u.getKox() + toRemove);
                p.getInventory().removeItem(new Item[] { new Item(466, Integer.valueOf(0), toRemove) });
                ChatUtil.sendMessage((CommandSender)p, "&7Miales przy sobie &e" + koxSize + " &7koxow");
                ChatUtil.sendMessage((CommandSender)p, "&7Limit to &e" + LimitTask.c.getInt("limit.kox") + " &7koxow");
                ChatUtil.sendMessage((CommandSender)p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
            if (refSize > LimitTask.c.getInt("limit.refy")) {
                final int toRemove = refSize - LimitTask.c.getInt("limit.refy");
                u.addRefy(u.getRefy() + toRemove);
                p.getInventory().removeItem(new Item[] { new Item(322, Integer.valueOf(0), toRemove) });
                ChatUtil.sendMessage((CommandSender)p, "&7Miales przy sobie &e" + refSize + " &7refili");
                ChatUtil.sendMessage((CommandSender)p, "&7Limit to &e" + LimitTask.c.getInt("limit.refy") + " &7refili");
                ChatUtil.sendMessage((CommandSender)p, "&7Przedmioty zostaly przeniesione do schowka &e/schowek&7!");
            }
        }
    }
    
    static {
        LimitTask.c = Main.getPlugin().getConfig();
    }
}
