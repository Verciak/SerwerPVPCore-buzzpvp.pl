
package pl.vertty.arivi.loader;

import pl.vertty.arivi.Main;

import java.io.File;
import java.io.IOException;

public class ConfigLoader
{
    public static void onConfigLoad() {
        File f = new File(Main.getPlugin().getDataFolder(), "config.yml");
        if(!f.exists() && !f.isDirectory()) {
            Main.getPlugin().saveDefaultConfig();
        }
    }
}
