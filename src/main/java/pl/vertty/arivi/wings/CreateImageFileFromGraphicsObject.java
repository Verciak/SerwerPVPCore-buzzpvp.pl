// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.awt.image.BufferedImage;

public class CreateImageFileFromGraphicsObject
{
    public static BufferedImage main(final String args) throws IOException {
        final File file = new File(args);
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
