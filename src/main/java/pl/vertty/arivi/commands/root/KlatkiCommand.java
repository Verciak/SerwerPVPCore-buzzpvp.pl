// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.commands.root;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import pl.vertty.arivi.commands.builder.PlayerCommand;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;

public class KlatkiCommand extends PlayerCommand
{
    public KlatkiCommand() {
        super("klatki", "Itemy na klatki", "/klatki", GroupType.ADMIN, new String[] { "" });
    }
    
    @Override
    public boolean onCommand(final Player p, final String[] args) {
        final User u = UserManager.getUser(p);
        final Item buty = Item.get(309, Integer.valueOf(0), 1);
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        buty.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item klata = Item.get(307, Integer.valueOf(0), 1);
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        klata.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item bania = Item.get(306, Integer.valueOf(0), 1);
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        bania.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });
        final Item spodnie = Item.get(308, Integer.valueOf(0), 1);
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(0).setLevel(3) });
        spodnie.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(2) });


        final Item refile = Item.get(322, Integer.valueOf(0), 5);
        final Item miecz33 = Item.get(267, Integer.valueOf(0), 1);
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(9).setLevel(3) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(13).setLevel(2) });
        miecz33.addEnchantment(new Enchantment[] { Enchantment.getEnchantment(17).setLevel(3) });


        p.getInventory().addItem(buty);
        p.getInventory().addItem(klata);
        p.getInventory().addItem(bania);
        p.getInventory().addItem(spodnie);
        p.getInventory().addItem(refile);
        p.getInventory().addItem(miecz33);

        return true;
    }
}
