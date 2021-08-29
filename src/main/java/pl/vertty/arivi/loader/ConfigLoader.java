// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.Main;

public class ConfigLoader
{
    public static void onConfigLoad() {
        Main.getPlugin().saveDefaultConfig();
    }
}
