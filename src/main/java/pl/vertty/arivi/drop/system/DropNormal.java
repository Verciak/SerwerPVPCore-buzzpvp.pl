// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.system;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;
import java.util.ArrayList;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import java.util.List;
import cn.nukkit.Server;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.drop.base.utils.DropUtils;
import pl.vertty.arivi.drop.base.User;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.Player;

public class DropNormal implements DropData
{
    @Override
    public void breakBlock(final Player player, final Item tool, final Block block, final User user) {
        final List<Item> drops = this.getDrops(player, block, tool, user);
        if (DropUtils.isEq(player.getName())) {
            final Item blocka = Item.get(block.getId(), Integer.valueOf(0), 1);
            player.getInventory().addItem(new Item[] { blocka });
        }
        else {
            final Location loc = block.getLocation();
            final Item blocka2 = Item.get(block.getId(), Integer.valueOf(0), 1);
            loc.getLevel().dropItem((Vector3)loc, blocka2);
        }
        final Location c = block.getLocation();
        final Level l = Server.getInstance().getDefaultLevel();
        final double x = c.getFloorX();
        final double y = c.getFloorY();
        final double z = c.getFloorZ();
        l.setBlock(new Vector3(x, y, z), Block.get(0));
    }
    
    public List<Item> getDrops(final Player player, final Block block, final Item item, final User user) {
        final List<Item> items = new ArrayList<Item>();
        final Config c = Main.getPlugin().getConfig();
        if (block.getId() == 49) {
            player.addExperience(user.isTurboExp() ? (c.getInt("exp.obsidian") + 15) : c.getInt("exp.obsidian"));
        }
        final int amount = 1;
        if (block.getId() == 1 && !DropUtils.isCobble(player.getName())) {
            return items;
        }
        return items;
    }
}
