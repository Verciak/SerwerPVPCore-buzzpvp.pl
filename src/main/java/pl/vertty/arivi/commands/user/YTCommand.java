// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.utils.ChatUtil;

public class YTCommand extends PlayerCommand
{
    public YTCommand() {
        super("yt", "Komenda yt", "/yt", GroupType.PLAYER, new String[] { "" });
    }

    public static Config c = Main.getPlugin().getConfig();

    @Override
    public boolean onCommand(final Player p, final String[] args) {
        ChatUtil.sendMessage(p, c.getString("yt").replace("{N}","\n"));
        return true;
    }
}
