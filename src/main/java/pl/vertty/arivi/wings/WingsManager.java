
package pl.vertty.arivi.wings;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.PlayerSkinPacket;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.SerializedImage;
import pl.vertty.arivi.Main;
import pl.vertty.arivi.utils.SkinUtil;
import pl.vertty.arivi.wings.mysql.UserWings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
    public static Map<String, Wings> wingsNames;
    public static Main plugin;

    public static void init(final Main plugin) throws SQLException {
        load(plugin);
    }

    public static void load(final Main plugin) {
        final String path = plugin.getDataFolder() + "/wings";
        System.out.println("");
        System.out.println("Lokalizacja skrzydel:");
        System.out.println("");
        System.out.println(path);
        final File actual = new File(path);
        System.out.println("");
        System.out.println("Wczytano skrzydla o nazwe:");
        System.out.println("");
        final List<String> fileNames = new ArrayList<String>();
        for (final File file : actual.listFiles()) {
            fileNames.add(file.getName());
        }
        System.out.println("");
        System.out.println("Nazwy skrzydel w liscie:");
        System.out.println("");
        System.out.println(fileNames);
        System.out.println("");
        System.out.println("Zaladowane Skrzydla:");
        System.out.println("");
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

    public static List<String> getWingsNames() {
        return getCollectionWings().stream().map(Wings::getName).collect(Collectors.toList());
    }

    public static void setRatWings(final Player player, final Wings wings) throws IOException {
        if (UserWings.getUser(player) != null) {
            UserWings.deleteUser(player);
            SkinUtil.resetSkin(player);
        }
        UserWings.createrUser(player);
        UserWings.getUser(player).setWings(wings.getName());
        Skin skin = player.getSkin();
        SerializedImage skinData = skin.getSkinData();

        BufferedImage bufferedImage = new BufferedImage(skinData.width, skinData.height, 6);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(skinData.data);

        for (int y = 0; y < bufferedImage.getHeight(); ++y) {
            for (int x = 0; x < bufferedImage.getWidth(); ++x) {
                Color color = new Color(byteArrayInputStream.read(), byteArrayInputStream.read(), byteArrayInputStream.read(), byteArrayInputStream.read());
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }

        Skin producedSkin = new Skin();

        producedSkin.setSkinId(skin.getSkinId());
        producedSkin.setSkinData(skin.getSkinData());
        producedSkin.setCapeData(skin.getCapeData());

        BufferedImage customizeBufferedImage = new BufferedImage(128, 128, 2);

        Graphics2D outputGraphics2D = customizeBufferedImage.createGraphics();
        outputGraphics2D.drawImage(bufferedImage, 0, 0, null);
        outputGraphics2D.dispose();

        Graphics wingsGraphics = customizeBufferedImage.getGraphics();
        wingsGraphics.drawImage(ImageIO.read(new File(Main.getPlugin().getDataFolder() + "/wings/" + wings.getName() + "/" + wings.getName() + ".png")), 0, 0, null);
        wingsGraphics.dispose();

        producedSkin.setSkinData(customizeBufferedImage);
        producedSkin.setGeometryName(wings.getGeometryName());
        producedSkin.setGeometryData(wings.getGeometryData());
        producedSkin.setTrusted(true);
        player.setSkin(producedSkin);
        final PlayerSkinPacket packet = new PlayerSkinPacket();
        packet.skin = producedSkin;
        packet.newSkinName = player.getName();
        packet.oldSkinName = skin.getSkinId();
        packet.uuid = player.getUniqueId();
        Server.broadcastPacket(Server.getInstance().getOnlinePlayers().values(), packet);
        final Collection<Player> viewer = player.getViewers().values();
        for (final Player paa : viewer) {
            paa.batchDataPacket(packet);
        }


//        final Skin playerSkin = player.getSkin();
//        SkinUtils.saveImage(Main.getPlugin(), playerSkin.getSkinData().width, playerSkin.getSkinData().height, playerSkin.getSkinData().data, player.getName());
//        Server.getInstance().getScheduler().scheduleDelayedTask((Plugin)Main.getPlugin(), (Runnable)new Runnable() {
//            @Override
//            public void run() {
//                final Path skinPath = Paths.get(Main.getPlugin().getDataFolder() + "/skins/" + player.getName() + ".png", new String[0]);
//                BufferedImage skinData = null;
//                try {
//                    skinData = ImageIO.read(skinPath.toFile());
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//                final Skin skin = new Skin();
//                skin.setSkinId(playerSkin.getSkinId());
//                skin.setGeometryName(wings.getGeometryName());
//                skin.setGeometryData(wings.getGeometryData());
//                BufferedImage bufferedImage = null;
//                try {
//                    bufferedImage = ImageIO.read(new File(Main.getPlugin().getDataFolder() + "/wings/" + wings.getName() + "/"+wings.getName()+".png"));
//                }
//                catch (IOException e2) {
//                    e2.printStackTrace();
//                }
//                final BufferedImage bff = new BufferedImage(128, 128, 2);
//                final Graphics2D graphics2D = bff.createGraphics();
//                graphics2D.drawImage(skinData, 0, 0, null);
//                graphics2D.dispose();
//                final Graphics2D graphics2De = bff.createGraphics();
//                graphics2De.drawImage(bufferedImage, 0, 0, null);
//                graphics2De.dispose();
//                skin.setSkinData(bff);
//                skin.setTrusted(true);
//                player.setSkin(skin);
//                final PlayerSkinPacket packet = new PlayerSkinPacket();
//                packet.skin = skin;
//                packet.newSkinName = player.getName();
//                packet.oldSkinName = playerSkin.getSkinId();
//                packet.uuid = player.getUniqueId();
//                Server.broadcastPacket((Collection)Server.getInstance().getOnlinePlayers().values(), (DataPacket)packet);
//                final Collection<Player> viewer = player.getViewers().values();
//                for (final Player paa : viewer) {
//                    paa.batchDataPacket((DataPacket)packet);
//                }
//            }
//        }, 200);
    }

    static {
        WingsManager.wingsNames = new ConcurrentHashMap<String, Wings>();
        WingsManager.plugin = Main.getPlugin();
    }
}
