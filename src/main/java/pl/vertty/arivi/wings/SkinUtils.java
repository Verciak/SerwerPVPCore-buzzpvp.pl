// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings;

import pl.vertty.arivi.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SkinUtils
{
    public static void saveImage(final Main session, final int width, final int height, final byte[] bytes, final String name) {
        final BufferedImage image = new BufferedImage(width, height, 6);
        final ByteArrayInputStream data = new ByteArrayInputStream(bytes);
        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                final Color color = new Color(data.read(), data.read(), data.read(), data.read());
                image.setRGB(x, y, color.getRGB());
            }
        }
        final Path path = Paths.get(Main.getPlugin().getDataFolder() + "/skins/" + name + ".png", new String[0]);
        try (final OutputStream stream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            ImageIO.write(image, "png", stream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
