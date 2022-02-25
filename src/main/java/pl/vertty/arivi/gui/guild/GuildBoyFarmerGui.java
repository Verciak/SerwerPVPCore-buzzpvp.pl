
package pl.vertty.arivi.gui.guild;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.objects.User;
import pl.vertty.arivi.objects.guild.Guild;
import pl.vertty.arivi.managers.UserManager;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.task.BoyFarmerTask;
import pl.vertty.arivi.utils.ChatUtil;

public class GuildBoyFarmerGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User user = UserManager.getUser(player);
        Guild g = GuildManager.getGuild(player);

        category.setSmallFarmerServerGui();

        category.addElement(11, new ItemData(Item.WOOL, DyeColor.LIME.getWoolData(), 1, "&7Dodaj kratki", new String[]{"", "&8>> &7Kliknij, aby dodac kratki!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(user.kratki >= g.getRegion().getSize()){
                    ChatUtil.sendMessage(p0, "&cNie mozesz dodac juz kratek");
                    menu.forceDestroy(p0);
                    return;
                }
                user.kratki = user.kratki + 1;
                GuildBoyFarmerGui.openTopki(p0);
            }
        });
        category.addElement(15, new ItemData(Item.WOOL, DyeColor.RED.getWoolData(), 1, "&7Odejmij kratki", new String[]{"", "&8>> &7Kliknij, aby odjac kratki!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(user.kratki <= 5){
                    ChatUtil.sendMessage(p0, "&cNie mozesz odjac juz kratek");
                    menu.forceDestroy(p0);
                    return;
                }
                user.kratki = user.kratki - 1;
                GuildBoyFarmerGui.openTopki(p0);
            }
        });
        category.addElement(22, new ItemData(Item.NETHER_STAR, 0, 1, "&7Rozpocznij tworzenie &fBoyFarmerow", new String[]{"", "&8>> &cPamietaj, ze wysokosc postawienia &4BoyFarmerow, &cjest pobierana od &4wysokosci gracza","","&8>> &7Kliknij, aby rozpoczac!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if (g.getSkarbiec() < (g.getRegion().getSize() * user.kratki / 2)) {
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4" + (g.getRegion().getSize() * user.kratki / 2) + "&cemeraldow w skarbcu");
                    menu.forceDestroy(p0);
                    return;
                }
                g.setSkarbiec(g.getSkarbiec() -(g.getRegion().getSize() * user.kratki / 2));
                new BoyFarmerTask(g, user.kratki).runTaskTimer(Main.getPlugin(), 5, 5);
            }
        });
        category.addElement(4, new ItemData(Item.BOOK, 0, 1, "&7Informacje", new String[]{"", "&8>> &7Twoj rozmiar gildii: &9" + g.getRegion().getSize(), "&8>> &7Aktualna ilosc kratek od srodka: &9" + user.kratki, "", "&8>> &7Koszt stworzenia &fBoyFarmera&7:&9 " +(g.getRegion().getSize() * user.kratki / 2), "&8>> &7Aktualnie emeraldow w skrabcu:&9 " +g.getSkarbiec()}));
        menu.setMainCategory(category);
        menu.addCategory("GuildBoyFarmerGui", category);
        menu.setName(ChatUtil.fixColor("&9Panel BoyFarmerow"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("GuildBoyFarmerGui", menu);
    }
}
