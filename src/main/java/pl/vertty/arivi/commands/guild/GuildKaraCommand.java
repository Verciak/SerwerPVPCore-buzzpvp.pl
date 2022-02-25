
package pl.vertty.arivi.commands.guild;

import java.util.ArrayList;
import pl.vertty.arivi.enums.GroupType;
import pl.vertty.arivi.inventory.InventoryMenuHandler;
import pl.vertty.arivi.utils.guild.ChatUtil;
import pl.vertty.arivi.utils.guild.DataUtil;
import pl.vertty.arivi.managers.guild.GuildManager;
import pl.vertty.arivi.inventory.item.ItemData;
import cn.nukkit.item.Item;
import pl.vertty.arivi.inventory.InventoryCategory;
import pl.vertty.arivi.inventory.InventoryMenu;
import cn.nukkit.Player;
import pl.vertty.arivi.objects.guild.Guild;
import java.util.List;
import pl.vertty.arivi.utils.guild.command.PlayerCommand;

public class GuildKaraCommand extends PlayerCommand
{
    public static List<Guild> guilds;
    
    public static void openInv(final Player player) {
        final InventoryMenu menu = new InventoryMenu();
        final InventoryCategory category = new InventoryCategory();
        category.setDoubleGuildItemsGui();
        for (final Guild guild : GuildManager.getKaraGuilds()) {
                final Item itemStack = new Item(397, 3, 1);
                itemStack.setLore(ChatUtil.fixColor("&8» &7Koniec za: &9" + DataUtil.secondsToString(guild.getTntKaraTime())), ChatUtil.fixColor(String.valueOf(new StringBuilder().append("&8» &7Koordynaty: &8(&7X:&9 ").append(guild.getRegion().getX()).append(" &7Z:&9 ").append(guild.getRegion().getZ()).append("&8)"))));
                itemStack.setCustomName(ChatUtil.fixColor("&8[&9" + guild.getTag() + "&8] &9" + guild.getName()));
                category.addElementAir(ItemData.fromItem(itemStack));
        }
        menu.setDoubleChest();
        menu.setMainCategory(category);
        menu.addCategory("gkaraMenu", category);
        menu.setName(pl.vertty.arivi.utils.ChatUtil.fixColor("&9Kary gildii"));
        menu.setOnlyRead(true);
        menu.show(player);
        InventoryMenuHandler.registerNewMenu("gkaraMenu", menu);
    }
    
    @Override
    public boolean onCommand(final Player player, final String[] array) {
        openInv(player);
        return false;
    }
    
    public GuildKaraCommand() {
        super("kara", "/g kara", GroupType.PLAYER, new String[0]);
    }
    
    static {
        GuildKaraCommand.guilds = new ArrayList<Guild>();
    }
}
