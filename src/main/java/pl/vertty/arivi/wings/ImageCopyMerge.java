// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageCopyMerge
{
    public static BufferedImage joinBufferedImage(final BufferedImage img1, final BufferedImage img2) {
        final int width = img1.getWidth();
        final int height = img1.getHeight() + img2.getHeight();
        final BufferedImage newImage = new BufferedImage(width, height, 2);
        final Graphics2D g2 = newImage.createGraphics();
        final Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, 0, img1.getHeight());
        g2.dispose();
        return newImage;
    }
}
