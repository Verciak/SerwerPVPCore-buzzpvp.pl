// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings;

import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class ImageColorTransparent
{
    public static Image makeColorTransparent(final Image im, final Color color) {
        final ImageFilter filter = new RGBImageFilter() {
            public int markerRGB = color.getRGB() | 0xFF000000;
            
            @Override
            public final int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) == this.markerRGB) {
                    return 0xFFFFFF & rgb;
                }
                return rgb;
            }
        };
        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
