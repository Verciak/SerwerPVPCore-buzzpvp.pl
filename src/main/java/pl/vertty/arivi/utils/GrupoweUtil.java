package pl.vertty.arivi.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.potion.Effect;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.eq.SerializerUtil;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.managers.ShopManager;

import java.util.Objects;

public class GrupoweUtil {

    public static void onItemy(Player p) {
        final User u = UserManager.getUser(p);
        p.setAllowFlight(false);
        p.setAllowFlight(false);
        p.setAllowFlight(false);
        p.setAllowFlight(false);

        Objects.requireNonNull(u).setTeleport(true);

        Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), () -> u.setTeleport(false), 4 * 20);

        for (Effect e : p.getEffects().values()) {
            p.removeEffect(e.getId());
        }
        p.getInventory().clearAll();
        p.setFoodEnabled(false);
        p.setGamemode(0);
        p.setHealth(p.getMaxHealth());
        final Item buty = Item.get(309, 0, 1);
        buty.addEnchantment(Enchantment.getEnchantment(0).setLevel(3));
        buty.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));
        final Item klata = Item.get(307, 0, 1);
        klata.addEnchantment(Enchantment.getEnchantment(0).setLevel(3));
        klata.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));
        final Item bania = Item.get(306, 0, 1);
        bania.addEnchantment(Enchantment.getEnchantment(0).setLevel(3));
        bania.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));
        final Item spodnie = Item.get(308, 0, 1);
        spodnie.addEnchantment(Enchantment.getEnchantment(0).setLevel(3));
        spodnie.addEnchantment(Enchantment.getEnchantment(17).setLevel(2));
        final Item miecz33 = Item.get(267, 0, 1);

        miecz33.addEnchantment(Enchantment.getEnchantment(9).setLevel(3));
        miecz33.addEnchantment(Enchantment.getEnchantment(13).setLevel(1));
        miecz33.addEnchantment(Enchantment.getEnchantment(17).setLevel(3));

        final Item kilof = Item.get(Item.DIAMOND_PICKAXE, 0, 1);

        kilof.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_EFFICIENCY).setLevel(5));
        kilof.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_FORTUNE_DIGGING).setLevel(3));
        kilof.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_DURABILITY).setLevel(3));


        final Item knock = Item.get(267, 0, 1);

        knock.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_DAMAGE_ALL).setLevel(3));
        knock.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_KNOCKBACK).setLevel(2));

        final Item stone = Item.get(BlockID.COBBLESTONE, 0, 64);
        final Item woda = Item.get(Item.BUCKET, 8, 1);


        final Item refile = Item.get(322, 0, 8);

        final Item koxy = Item.get(466, 0, 1);
        final Item perly = Item.get(368, 0, 3);
        final Item sniezki = Item.get(ItemID.SNOWBALL, 0, 8);

        if (u.getEq_1().isEmpty()) {
            Item cobweb = Item.get(Item.COBWEB, 0, 4);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isPajeczyna()){
                p.getInventory().setItem(9,cobweb);
            }
            Item lod = Item.get(Item.ICE, 0, 32);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLod()){
                p.getInventory().setItem(10,lod);
            }
            Item sniezki8 = Item.get(ItemID.SNOWBALL, 0, 8);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isSniezki()){
                p.getInventory().setItem(11,sniezki8);
            }
            Item lava = Item.get(Item.BUCKET, 10, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLava()){
                p.getInventory().setItem(12,lava);
            }
            Item lub = Item.get(ItemID.BOW,0,1);
            Item arrow = Item.get(ItemID.ARROW,0,16);
            lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_POWER).setLevel(2));
            lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_INFINITY).setLevel(1));
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLuk()){
                p.getInventory().setItem(13,lub);
                p.getInventory().setItem(14,arrow);
            }
            Item cobble = Item.get(Item.COBBLESTONE, 0, 64);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isCobblestone()){
                p.getInventory().setItem(15,cobble);
            }
            Item zapalincza = Item.get(Item.FLINT_AND_STEEL, 0, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isZapalniczka()){
                p.getInventory().setItem(16,zapalincza);
            }
            Item obs = Item.get(Item.OBSIDIAN, 0, 16);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isObs()){
                p.getInventory().setItem(17,obs);
            }
            Item slime = Item.get(Item.SLIME_BLOCK, 0, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isSlime()){
                p.getInventory().setItem(18,slime);
            }















            p.getInventory().setItem(0, miecz33);
            p.getInventory().setItem(1, koxy);
            p.getInventory().setItem(2, refile);
            p.getInventory().setItem(3, knock);
            p.getInventory().setItem(4, stone);
            p.getInventory().setItem(5, woda);
            p.getInventory().setItem(6, kilof);
            p.getInventory().setItem(7, sniezki);
            p.getInventory().setItem(8, perly);
            p.getInventory().setArmorItem(3, buty);
            p.getInventory().setArmorItem(1, klata);
            p.getInventory().setArmorItem(0, bania);
            p.getInventory().setArmorItem(2, spodnie);
        } else {
            p.getInventory().setContents(SerializerUtil.deserialize(u.getEq_1()));


            p.getInventory().setArmorItem(3, buty);
            p.getInventory().setArmorItem(1, klata);
            p.getInventory().setArmorItem(0, bania);
            p.getInventory().setArmorItem(2, spodnie);
            Item cobweb = Item.get(Item.COBWEB, 0, 4);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isPajeczyna()){
                p.getInventory().setItem(9,cobweb);
            }
            Item lod = Item.get(Item.ICE, 0, 32);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLod()){
                p.getInventory().setItem(10,lod);
            }
            Item sniezki8 = Item.get(ItemID.SNOWBALL, 0, 8);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isSniezki()){
                p.getInventory().setItem(11,sniezki8);
            }
            Item lava = Item.get(Item.BUCKET, 10, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLava()){
                p.getInventory().setItem(12,lava);
            }
            Item lub = Item.get(ItemID.BOW,0,1);
            Item arrow = Item.get(ItemID.ARROW,0,16);
            lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_POWER).setLevel(2));
            lub.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BOW_INFINITY).setLevel(1));
            if(Objects.requireNonNull(ShopManager.getUser(p)).isLuk()){
                p.getInventory().setItem(13,lub);
                p.getInventory().setItem(14,arrow);
            }
            Item cobble = Item.get(Item.COBBLESTONE, 0, 64);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isCobblestone()){
                p.getInventory().setItem(15,cobble);
            }
            Item zapalincza = Item.get(Item.FLINT_AND_STEEL, 0, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isZapalniczka()){
                p.getInventory().setItem(16,zapalincza);
            }
            Item obs = Item.get(Item.OBSIDIAN, 0, 16);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isObs()){
                p.getInventory().setItem(17,obs);
            }
            Item slime = Item.get(Item.SLIME_BLOCK, 0, 1);
            if(Objects.requireNonNull(ShopManager.getUser(p)).isSlime()){
                p.getInventory().setItem(18,slime);
            }
        }
    }

}
