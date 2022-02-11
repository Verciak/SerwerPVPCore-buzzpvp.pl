
package pl.vertty.arivi.loader;

import pl.vertty.arivi.drop.base.utils.UserUtils;
import pl.vertty.arivi.drop.utils.Util;
import pl.vertty.arivi.drop.data.DataManager;
import pl.vertty.arivi.drop.base.utils.DropUtils;

public class DropLoad
{
    public static void onDrop() {
        DropUtils.load();
        DataManager.getData().check();
        DataManager.getData().load();
        Util.loadTurbo();
        UserUtils.sortUsers();
    }
}
