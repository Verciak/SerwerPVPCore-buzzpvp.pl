// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.loader;

import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.drop.data.DataManager;

public class DropsLoader
{
    public static void onDropsLoad() {
        DropLoad.onDrop();
    }
    
    public static void onDataSaved() {
        DataManager.getData().check();
        DataManager.getData().save();
        Util.saveTurbo();
    }
}
