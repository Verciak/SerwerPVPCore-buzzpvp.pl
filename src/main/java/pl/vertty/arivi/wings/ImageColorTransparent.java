
package pl.vertty.arivi.wings;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class ImageColorTransparent
{
    public static void makeColorTransparent(final Image im, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            public final int markerRGB = color.getRGB() | 0xFF000000;
            
            @Override
            public final int filterRGB(final int x, final int y, final int rgb) {
                return (rgb | 0xFF000000) == this.markerRGB ? 0xFFFFFF & rgb : rgb;
            }
        };
        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        Toolkit.getDefaultToolkit().createImage(ip);
    }
}
