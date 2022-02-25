
package pl.vertty.arivi.managers.guild;

import cn.nukkit.utils.TextFormat;

public enum RelationType
{
    TEAM("TEAM", 0, TextFormat.getByChar("&a")), 
    ALLY("ALLY", 1, TextFormat.getByChar("&6")), 
    ENEMY("ENEMY", 2, TextFormat.getByChar("&c"));
    
    private final TextFormat color;
    
    private RelationType(final String s, final int n, final TextFormat color) {
        this.color = color;
    }
    
    public TextFormat getColor() {
        return this.color;
    }
}
