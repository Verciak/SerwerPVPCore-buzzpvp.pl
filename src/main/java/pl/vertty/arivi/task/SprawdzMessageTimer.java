package pl.vertty.arivi.task;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.Server;
import pl.vertty.arivi.Main;
import java.util.Iterator;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.objects.Sprawdz;
import pl.vertty.arivi.managers.SprawdzManager;
import cn.nukkit.scheduler.NukkitRunnable;

public class SprawdzMessageTimer extends NukkitRunnable
{
    public void run() {
        for (final Sprawdz s : SprawdzManager.getList().values()) {
            ChatUtil.sendFullTitle(s.getPlayer(), "&9Jestes Sprawdzany!", "&7Zapraszamy na discorda: &9https://discord.gg/KDvaeEswpS");
            if (s.isEffect()) {
                s.getPlayer().addEffect(Effect.getEffect(9).setDuration(600).setAmplifier(1));
                s.getPlayer().addEffect(Effect.getEffect(15).setDuration(600).setAmplifier(1));
            }
            else {
                s.getPlayer().removeEffect(9);
                s.getPlayer().removeEffect(15);
            }
        }
    }
    
    public SprawdzMessageTimer(final Main plugin) {
        Server.getInstance().getScheduler().scheduleDelayedRepeatingTask((Plugin)plugin, (Runnable)this, 40, 20);
    }
}
