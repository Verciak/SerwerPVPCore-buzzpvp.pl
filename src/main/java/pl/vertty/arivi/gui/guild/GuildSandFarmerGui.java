
package pl.vertty.arivi.gui.guild;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.DyeColor;
import pl.vertty.arivi.guilds.data.User;
import pl.vertty.arivi.guilds.data.guild.Guild;
import pl.vertty.arivi.guilds.managers.UserManager;
import pl.vertty.arivi.guilds.managers.guild.GuildManager;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.inventory.item.ItemClick;
import pl.vertty.arivi.inventory.item.ItemData;
import pl.vertty.arivi.utils.ChatUtil;
import pl.vertty.arivi.utils.SpaceUtil;

public class GuildSandFarmerGui
{
    public static void openTopki(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        final User user = UserManager.getUser(player);
        Guild g = GuildManager.getGuild(player);
        category.addElement(10, new ItemData(Item.WOOL, DyeColor.LIME.getWoolData(), 1, "&7Dodaj kratki", new String[]{"", "&8>> &7Kliknij, aby dodac kratki!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(user.kratki >= g.getRegion().getSize()){
                    ChatUtil.sendMessage(p0, "&cNie mozesz dodac juz kratek");
                    menu.forceDestroy(p0);
                    return;
                }
                user.kratki = user.kratki + 1;
                GuildSandFarmerGui.openTopki(p0);
            }
        });
        category.addElement(16, new ItemData(Item.WOOL, DyeColor.RED.getWoolData(), 1, "&7Odejmij kratki", new String[]{"", "&8>> &7Kliknij, aby odjac kratki!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(user.kratki <= 0){
                    ChatUtil.sendMessage(p0, "&cNie mozesz odjac juz kratek");
                    menu.forceDestroy(p0);
                    return;
                }
                user.kratki = user.kratki - 1;
                GuildSandFarmerGui.openTopki(p0);
            }
        });
        category.addElement(22, new ItemData(Item.NETHER_STAR, 0, 1, "&7Rozpocznij tworzenie &fSandFarmerow", new String[]{"", "&8>> &cPamietaj, ze wysokosc postawienia &4SandFarmerow, &cjest pobierana od &4wysokosci gracza","","&8>> &7Kliknij, aby rozpoczac!"}), new ItemClick() {
            @Override
            public void onClick(Player p0, Item p1) {
                if(p0.getLocation().getFloorY() >= 80){
                    ChatUtil.sendMessage(p0, "&cMaksymalna kratka jest &480");
                    menu.forceDestroy(p0);
                    return;
                }
                if(g.getSkarbiec() < (g.getRegion().getSize() * user.kratki / 2)){
                    ChatUtil.sendMessage(p0, "&cNie posiadasz &4" + (g.getRegion().getSize() * user.kratki / 2) + "&cemeraldow w skarbcu");
                    menu.forceDestroy(p0);
                    return;
                }
                for(int sizee = 0; sizee < (user.kratki * 2); sizee++) {
                    for(int y = 1; y < p0.getLocation().getFloorY() - 1; y++) {
                        for (Location loc : SpaceUtil.getVector(g.getRegion().getCenter(), user.kratki, sizee)) {
                            Server.getInstance().getDefaultLevel().setBlock(new Vector3(loc.getFloorX(), y, loc.getFloorZ()), cn.nukkit.block.Block.get(BlockID.SAND));
                        }
                    }
                }
            }
        });
        category.addElement(4, new ItemData(Item.BOOK, 0, 1, "&7Informacje", new String[]{"", "&8>> &7Twoj rozmiar gildii: &9" + g.getRegion().getSize(), "&8>> &7Aktualna ilosc kratek od srodka: &9" + user.kratki, "", "&8>> &7Koszt stworzenia &fSandFarmera&7:&9 " +(g.getRegion().getSize() * user.kratki / 2), "&8>> &7Aktualnie emeraldow w skrabcu:&9 " +g.getSkarbiec()}));
        menu.setMainCategory(category);
        menu.addCategory("GuildSandFarmerGui", category);
        menu.setName(ChatUtil.fixColor("&9Panel SandFarmerow"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("GuildSandFarmerGui", menu);
    }
}
