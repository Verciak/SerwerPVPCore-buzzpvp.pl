
package pl.vertty.arivi.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.NukkitRunnable;
import cn.nukkit.utils.BossBarColor;
import cn.nukkit.utils.DummyBossBar;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.objects.BossBar;
import pl.vertty.arivi.utils.ChatUtil;

public class BossBarTask extends NukkitRunnable
{
    public void run() {
        for (Player player : Server.getInstance().getOnlinePlayers().values()) {
            final Guild guild = GuildManager.getGuild(player);
            final Guild guild2 = GuildManager.getGuild(player.getLocation());
            if (guild2 != null) {
                if (guild2 != guild) {
                    if (guild != null && guild.getAlly().contains(guild2.getTag())) {
                        if (BossBar.playerHasBossBar(player)) {
                            Location heart = guild2.getRegion().getCenter();
                            heart.setY(player.getFloorY() - 1);
                            double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                            DummyBossBar bossbar = BossBar.getPlayerBossBar(player);
                            bossbar.setText(ChatUtil.fixColor("&6Jestes na terytorium sojuszniczej gildii &8[&6" + guild2.getTag() + "&8]"));
                            bossbar.setColor(BossBarColor.YELLOW);
                            bossbar.setLength((float) distance);
                        } else {
                            Location heart = guild2.getRegion().getCenter();
                            heart.setY(player.getFloorY() - 1);
                            double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                            DummyBossBar bossBar = new DummyBossBar.Builder(player)
                                    .text(ChatUtil.fixColor("&6Jestes na terytorium sojuszniczej gildii &8[&6" + guild2.getTag() + "&8]"))
                                    .color(BossBarColor.YELLOW)
                                    .build();

                            bossBar.setLength((float) distance);
                            player.createBossBar(bossBar);
                            BossBar.addBossBar(player, bossBar);
                        }
                    } else {
                        if (BossBar.playerHasBossBar(player)) {
                            Location heart = guild2.getRegion().getCenter();
                            heart.setY(player.getFloorY() - 1);
                            double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                            DummyBossBar bossbar = BossBar.getPlayerBossBar(player);
                            bossbar.setText(ChatUtil.fixColor("&cJestes na terytorium wrogiej gildii &8[&c" + guild2.getTag() + "&8]"));
                            bossbar.setColor(BossBarColor.RED);
                            bossbar.setLength((float) distance);
                        } else {
                            Location heart = guild2.getRegion().getCenter();
                            heart.setY(player.getFloorY() - 1);
                            double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                            DummyBossBar bossBar = new DummyBossBar.Builder(player)
                                    .text(ChatUtil.fixColor("&cJestes na terytorium wrogiej gildii &8[&c" + guild2.getTag() + "&8]"))
                                    .color(BossBarColor.RED)
                                    .build();

                            bossBar.setLength((float) distance);
                            player.createBossBar(bossBar);
                            BossBar.addBossBar(player, bossBar);
                        }
                    }
                } else {
                    if (BossBar.playerHasBossBar(player)) {
                        Location heart = guild2.getRegion().getCenter();
                        heart.setY(player.getFloorY() - 1);
                        double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                        DummyBossBar bossbar = BossBar.getPlayerBossBar(player);
                        bossbar.setText(ChatUtil.fixColor("&aJestes na terytorium swojej gildi &8[&a" + guild2.getTag() + "&8]"));
                        bossbar.setColor(BossBarColor.GREEN);
                        bossbar.setLength((float) distance);
                    } else {
                        Location heart = guild2.getRegion().getCenter();
                        heart.setY(player.getFloorY() - 1);
                        double distance = (player.getLocation().distance(heart) * 100) / (guild2.getRegion().getSize());
                        DummyBossBar bossBar = new DummyBossBar.Builder(player)
                                .text(ChatUtil.fixColor("&aJestes na terytorium swojej gildi &8[&a" + guild2.getTag() + "&8]"))
                                .color(BossBarColor.GREEN)
                                .build();

                        bossBar.setLength((float) distance);
                        player.createBossBar(bossBar);
                        BossBar.addBossBar(player, bossBar);
                    }
                }
            }
        }
    }
}
