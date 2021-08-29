// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import pl.vertty.arivi.utils.DataUtil;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class PerformanceCommand extends Command
{
    public PerformanceCommand() {
        super("gc", "Sprawdzanie danych maszyny", "/gc", GroupType.ADMIN, new String[] { "performance" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        final StringBuilder sb = new StringBuilder(ChatUtil.fixColor("&8>> &7TPSy 1m, 5m, 15m: &6"));
        ChatUtil.sendMessage(sender, "");
        ChatUtil.sendMessage(sender, sb.toString());
        ChatUtil.sendMessage(sender, "&8>>  &7Online serwer: &6" + DataUtil.parseLong(System.currentTimeMillis() - Main.startUpTime, false));
        ChatUtil.sendMessage(sender, "&8>>  &7Uzyty RAM: &6" + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "MB");
        ChatUtil.sendMessage(sender, "&8>>  &7Wolny RAM: &6" + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "MB");
        ChatUtil.sendMessage(sender, "&8>>  &7Zuzycie procesora: &6" + this.getCpuUsage() + "%");
        ChatUtil.sendMessage(sender, "");
        return true;
    }
    
    public double getCpuUsage() {
        final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        return operatingSystemMXBean.getSystemLoadAverage() / operatingSystemMXBean.getAvailableProcessors();
    }
}
