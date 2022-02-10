// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.user;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.managers.SprawdzManager;
import pl.vertty.arivi.objects.Sprawdz;
import pl.vertty.arivi.utils.ChatUtil;

public class PrzyznajesieCommand extends PlayerCommand
{
    public PrzyznajesieCommand() {
        super("przyznajesie", "Przyznanie sie do cheatow", "/przyznajesie", GroupType.PLAYER, new String[0]);
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        if (SprawdzManager.getByPlayer(p) != null) {
            final Sprawdz s = SprawdzManager.getByPlayer(p);
            Server.getInstance().broadcastMessage(ChatUtil.fixColor("&7Gracz &b{USER}&7 przyznal sie do posiadania cheatow! Sprawdzal go &b{ADMIN}&7!".replace("{USER}", p.getName()).replace("{ADMIN}", s.getAdmin().getName())));
            Server.getInstance().dispatchCommand((CommandSender)Server.getInstance().getConsoleSender(), "ban {USER} 3d PRZYZNANIE".replace("{USER}", p.getName()));
            return false;
        }
        ChatUtil.sendMessage((CommandSender)p, "&4Blad: &cNie jestes sprawdzany!");
        return true;
    }
}
