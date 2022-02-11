package pl.vertty.arivi.drop.utils;

import cn.nukkit.utils.TextFormat;

import java.util.ArrayList;
import java.util.List;

public class Colors
{
    public static String translate(final String m) {
        return TextFormat.colorize('&', m.replace("%>", "»").replace("<%", "«"));
    }

}
