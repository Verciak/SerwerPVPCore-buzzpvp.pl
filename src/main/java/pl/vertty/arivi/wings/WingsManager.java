
package pl.vertty.arivi.wings;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.PlayerSkinPacket;
import cn.nukkit.plugin.Plugin;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.SkinUtil;
import pl.vertty.arivi.wings.mysql.UserWings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WingsManager
{
    public static Map<String, Wings> wingsNames = new ConcurrentHashMap<>();
    public static Main plugin = Main.getPlugin();
    
    public static void init(final Main plugin) throws SQLException {
        load(plugin);
    }
    
    public static void load(final Main plugin) {
        final String path = plugin.getDataFolder() + "/wings";
        System.out.println();
        System.out.println("Lokalizacja skrzydel:");
        System.out.println();
        System.out.println(path);
        final File actual = new File(path);
        System.out.println();
        System.out.println("Wczytano skrzydla o nazwe:");
        System.out.println();
        final List<String> fileNames = new ArrayList<String>();
        for (final File file : actual.listFiles()) {
            fileNames.add(file.getName());
        }
        System.out.println();
        System.out.println("Nazwy skrzydel w liscie:");
        System.out.println();
        System.out.println(fileNames);
        System.out.println();
        System.out.println("Zaladowane Skrzydla:");
        System.out.println();
        for (final String wingName : fileNames) {
            final String pathName = plugin.getDataFolder() + "/wings/" + wingName;
            WingsManager.wingsNames.put(wingName, new Wings(wingName, pathName));
            System.out.println("- " + wingName);
        }
    }
    
    public static Wings getWings(final String name) {
        return WingsManager.wingsNames.get(name);
    }
    
    public static Collection<Wings> getCollectionWings() {
        return getHashMapWings().values();
    }
    
    public static Map<String, Wings> getHashMapWings() {
        return WingsManager.wingsNames;
    }

    public static void setRatWings(final Player player, final Wings wings) {
        if (UserWings.getUser(player) != null) {
            UserWings.deleteUser(player);
            SkinUtil.resetSkin(player);
        }
        UserWings.createrUser(player);
        UserWings.getUser(player).setWings(wings.getName());
        final Skin playerSkin = player.getSkin();
        SkinUtils.saveImage(playerSkin.getSkinData().width, playerSkin.getSkinData().height, playerSkin.getSkinData().data, player.getName());
        Server.getInstance().getScheduler().scheduleDelayedTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                final Path skinPath = Paths.get(Main.getPlugin().getDataFolder() + "/skins/" + player.getName() + ".png");
                BufferedImage skinData = null;
                try {
                    skinData = ImageIO.read(skinPath.toFile());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                final Skin skin = new Skin();
                skin.setSkinId(playerSkin.getSkinId());
                skin.setGeometryName(wings.getGeometryName());
                skin.setGeometryData(wings.getGeometryData());
                BufferedImage bufferedImage = null;
                try {
                    bufferedImage = ImageIO.read(new File(Main.getPlugin().getDataFolder() + "/wings/" + wings.getName() + "/skin.png"));
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                final BufferedImage bff = new BufferedImage(128, 128, 2);
                final Graphics2D graphics2D = bff.createGraphics();
                graphics2D.drawImage(skinData, 0, 0, null);
                graphics2D.dispose();
                final Graphics2D graphics2De = bff.createGraphics();
                graphics2De.drawImage(bufferedImage, 0, 0, null);
                graphics2De.dispose();
                skin.setSkinData(bff);
                skin.setTrusted(true);
                player.setSkin(skin);
                final PlayerSkinPacket packet = new PlayerSkinPacket();
                packet.skin = skin;
                packet.newSkinName = player.getName();
                packet.oldSkinName = playerSkin.getSkinId();
                packet.uuid = player.getUniqueId();
                Server.broadcastPacket(Server.getInstance().getOnlinePlayers().values(), packet);
                final Collection<Player> viewer = player.getViewers().values();
                for (final Player paa : viewer) {
                    paa.batchDataPacket(packet);
                }
            }
        }, 200);
    }

}
