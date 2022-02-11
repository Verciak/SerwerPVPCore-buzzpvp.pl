
package pl.vertty.arivi.wings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateImageFileFromGraphicsObject
{
    public static BufferedImage main() throws IOException {
        final int width = 250;
        final int height = 250;
        final BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        final Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.fillOval(0, 0, width, height);
        g2d.setColor(Color.yellow);
        g2d.drawString("Java Code Geeks", 50, 120);
        g2d.dispose();
        return bufferedImage;
    }
}
