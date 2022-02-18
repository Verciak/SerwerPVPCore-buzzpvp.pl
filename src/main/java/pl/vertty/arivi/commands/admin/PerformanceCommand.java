package pl.vertty.arivi.commands.admin;

import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.builder.Command;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.DataUtil;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class PerformanceCommand extends Command
{
    public PerformanceCommand() {
        super("gc", "Sprawdzanie danych maszyny", "/gc", GroupType.ADMIN, new String[] { "performance" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        ChatUtil.sendMessage(sender, "&7");
        ChatUtil.sendMessage(sender, "&8>>  &7Online serwer: &3" + DataUtil.parseLong(System.currentTimeMillis() - Main.startUpTime, false));
        ChatUtil.sendMessage(sender, "&7");
        ChatUtil.sendMessage(sender, "&8>>  &7Uzyty RAM: &3" + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "MB");
        ChatUtil.sendMessage(sender, "&8>>  &7Wolny RAM: &3" + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "MB");
        ChatUtil.sendMessage(sender, "&7");
        try {
            ChatUtil.sendMessage(sender, "&8>>  &7Zuzycie procesora: &3" + this.getProcessCpuLoad() + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChatUtil.sendMessage(sender, "&7");
        return true;
    }

    public static double getProcessCpuLoad() throws Exception {

        MBeanServer mbs    = ManagementFactory.getPlatformMBeanServer();
        ObjectName name    = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{ "ProcessCpuLoad" });

        if (list.isEmpty())     return Double.NaN;

        Attribute att = (Attribute)list.get(0);
        Double value  = (Double)att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)      return Double.NaN;
        // returns a percentage value with 1 decimal point precision
        return ((int)(value * 1000) / 10.0);
    }


}
