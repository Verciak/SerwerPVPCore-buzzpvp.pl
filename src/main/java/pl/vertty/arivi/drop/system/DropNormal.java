package pl.vertty.arivi.drop.system;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import pl.vertty.arivi.drop.base.User;
import pl.vertty.arivi.drop.base.utils.DropUtils;

public class DropNormal implements DropData
{
    @Override
    public void breakBlock(final Player player, final Item tool, final Block block, final User user) {
        if (DropUtils.isEq(player.getName())) {
            final Item blocka = Item.get(block.getId(), 0, 1);
            player.getInventory().addItem(blocka);
        }
        else {
            final Location loc = block.getLocation();
            final Item blocka2 = Item.get(block.getId(), 0, 1);
            loc.getLevel().dropItem(loc, blocka2);
        }
        final Location c = block.getLocation();
        final Level l = Server.getInstance().getDefaultLevel();
        final double x = c.getFloorX();
        final double y = c.getFloorY();
        final double z = c.getFloorZ();
        l.setBlock(new Vector3(x, y, z), Block.get(0));
    }
}
