
package pl.vertty.arivi.guilds.commands.guild;

import java.util.HashMap;
import pl.vertty.arivi.enums.GroupType;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import cn.nukkit.level.Location;
import pl.vertty.arivi.guilds.utils.RandomUtil;
import pl.vertty.arivi.Main;
import cn.nukkit.Server;
import pl.vertty.arivi.guilds.utils.ChatUtil;
import pl.vertty.arivi.guilds.data.yml.Config;
import cn.nukkit.Player;
import java.util.Map;
import java.util.Random;
import pl.vertty.arivi.guilds.utils.command.PlayerCommand;

public class GuildFreeSpaceCommand extends PlayerCommand
{
    private Random rand;
    public static Map<Player, Long> gt;
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        final Long n = GuildFreeSpaceCommand.gt.get(player);
        if (n != null && System.currentTimeMillis() - n < 38000L) {
            player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_ERROR));
            return false;
        }
        GuildFreeSpaceCommand.gt.put(player, System.currentTimeMillis());
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 10);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 20);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 30);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 40);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 50);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 60);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 70);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 80);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 90);
        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final int randInt = RandomUtil.getRandInt(-800, 800);
                final int randInt2 = RandomUtil.getRandInt(-800, 800);
                if (!GuildManager.canCreateGuildByGuild(new Location((double)randInt, (double)(player.getLevel().getHighestBlockAt(randInt, randInt2) + 1.5f), (double)randInt2))) {
                    return;
                }
                final double kratki = player.getLocation().distance(new Vector3((double)randInt, 60.0, (double)randInt2));
                final int IntValue = (int)kratki;
                player.sendMessage(ChatUtil.fixColor(Config.GUILD_COMMAND_FREESPACE_SUCCESS.replace("{KRATKI}", Double.toString(IntValue)).replace("{X}", Integer.toString(randInt)).replace("{Z}", Integer.toString(randInt2))));
            }
        }, 100);
        return false;
    }
    
    public GuildFreeSpaceCommand() {
        super("wolnemiejsce", "/g wolnemiejsce", GroupType.PLAYER, new String[0]);
    }
    
    static {
        GuildFreeSpaceCommand.gt = new HashMap<Player, Long>();
    }
}
