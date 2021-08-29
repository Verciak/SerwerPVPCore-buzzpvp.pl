// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.admin;

import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.utils.ChatUtil;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.commands.builder.Command;

public class GroupCommand extends Command
{
    public GroupCommand() {
        super("group", "Nadaj range", "/group", GroupType.ADMIN, new String[] { "nadaj", "setrank" });
    }
    
    @Override
    public boolean onExecute(final CommandSender sender, final String[] args) {
        if (args.length < 3) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final User u = UserManager.getUser(args[0]);
        final String s = args[2];
        if (u == null) {
            return ChatUtil.sendMessage(sender, "&cNie odnaleziono gracza w bazie danych!");
        }
        final String s2;
        switch ((s2 = args[1]).hashCode()) {
            case 113762: {
                if (!s2.equals("set")) {
                    return ChatUtil.sendMessage(sender, "/group");
                }
                break;
            }
            case 111592524: {
                if (!s2.equals("ustaw")) {
                    return ChatUtil.sendMessage(sender, this.getUsage());
                }
                break;
            }
        }
        if (GroupType.valueOf(s.toUpperCase()) == null) {
            return ChatUtil.sendMessage(sender, this.getUsage());
        }
        final GroupType group = GroupType.valueOf(s.toUpperCase());
        if (!u.getGroup().equals(group)) {
            u.setGroup(group);
            ChatUtil.sendMessage(sender, "&8» &7Nadales range &2" + group.getFullName() + "&7, graczowi &2" + u.getName() + "&7!");
            return true;
        }
        ChatUtil.sendMessage(sender, "&cGracz &7" + u.getName() + " &cjest juz w grupie &7" + group.getFullName() + "&c!");
        return true;
    }
}
