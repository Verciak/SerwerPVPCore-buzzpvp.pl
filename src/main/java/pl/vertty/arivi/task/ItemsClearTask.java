package pl.vertty.arivi.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.guilds.utils.ChatUtil;

import java.util.List;

public class ItemsClearTask extends NukkitRunnable {

    public void run() {
        int i = 0;
        for (Player p : Server.getInstance().getOnlinePlayers().values()) {
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 60 sekund!"));
                }
            }, i * 20);
            i += 60;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 5 sekund!"));
                }
            }, i * 20);
            i++;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 4 sekundy!"));
                }
            }, i * 20);
            i++;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 3 sekundy!"));
                }
            }, i * 20);
            i++;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 2 sekundy!"));
                }
            }, i * 20);
            i++;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy zostana wyczyszczone za 1 sekune!"));
                }
            }, i * 20);
            i++;
            Server.getInstance().getScheduler().scheduleDelayedTask((Plugin) Main.getPlugin(), new Runnable() {
                public void run() {
                    for (Level level : Server.getInstance().getLevels().values()) {
                        for (Entity entity : level.getEntities()) {
                            if (entity instanceof cn.nukkit.entity.item.EntityItem)
                                entity.close();
                        }
                    }
                    ChatUtil.sendActionbar(p, ChatUtil.fixColor("&8[&9Czyszczenie&8] &7Itemy z ziemi zostaly wyczyszczone!"));
                }
            }, i * 20);
        }
    }
}

