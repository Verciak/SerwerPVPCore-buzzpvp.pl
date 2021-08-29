// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.wings;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;
import java.awt.Color;

public class Wings
{
    private String name;
    private String geometryName;
    private String geometryData;
    private String path;
    private Color color;
    
    public Wings(final String name, final String path) {
        this.name = name;
        this.geometryName = "geometry." + name;
        this.path = path;
        final File geo = new File(this.path + "/geometry.json");
        final File skin = new File(this.path + "/skin.png");
        if (!geo.isFile()) {
            System.out.println("nie znaleziono pliku: geometry.json");
        }
        if (!skin.isFile()) {
            System.out.println("nie znaleziono pliku: skin.png");
        }
        try {
            this.geometryData = new String(Files.readAllBytes(geo.toPath()), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getGeometryName() {
        return this.geometryName;
    }
    
    public String getGeometryData() {
        return this.geometryData;
    }
    
    public BufferedImage getImage() throws IOException {
        final BufferedImage image = CreateImageFileFromGraphicsObject.main(this.path + "/skin.png");
        ImageColorTransparent.makeColorTransparent(image, this.color = new Color(0, 0, 0, 127));
        return image;
    }
}
