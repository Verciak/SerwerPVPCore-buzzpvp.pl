// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.enums;

import pl.vertty.arivi.Main;

public enum GroupType
{
    PLAYER("PLAYER", 0, 1, Main.getPlugin().getConfig().getString("format.chat.player.prefix"), Main.getPlugin().getConfig().getString("format.chat.player.fullname"), Main.getPlugin().getConfig().getString("format.chat.player.suffix")), 
    VIP("VIP", 1, 2, Main.getPlugin().getConfig().getString("format.chat.vip.prefix"), Main.getPlugin().getConfig().getString("format.chat.vip.fullname"), Main.getPlugin().getConfig().getString("format.chat.vip.suffix")), 
    SVIP("SVIP", 2, 3, Main.getPlugin().getConfig().getString("format.chat.svip.prefix"), Main.getPlugin().getConfig().getString("format.chat.svip.fullname"), Main.getPlugin().getConfig().getString("format.chat.svip.suffix")), 
    YOUTUBER("YOUTUBER", 3, 4, Main.getPlugin().getConfig().getString("format.chat.yt.prefix"), Main.getPlugin().getConfig().getString("format.chat.yt.fullname"), Main.getPlugin().getConfig().getString("format.chat.yt.suffix")), 
    SPONSOR("SPONSOR", 4, 5, Main.getPlugin().getConfig().getString("format.chat.sponsor.prefix"), Main.getPlugin().getConfig().getString("format.chat.sponsor.fullname"), Main.getPlugin().getConfig().getString("format.chat.sponsor.suffix")), 
    HELPER("HELPER", 5, 6, Main.getPlugin().getConfig().getString("format.chat.helper.prefix"), Main.getPlugin().getConfig().getString("format.chat.helper.fullname"), Main.getPlugin().getConfig().getString("format.chat.helper.suffix")), 
    MODERATOR("MODERATOR", 6, 7, Main.getPlugin().getConfig().getString("format.chat.moderator.prefix"), Main.getPlugin().getConfig().getString("format.chat.moderator.fullname"), Main.getPlugin().getConfig().getString("format.chat.moderator.suffix")), 
    ADMIN("ADMIN", 7, 8, Main.getPlugin().getConfig().getString("format.chat.admin.prefix"), Main.getPlugin().getConfig().getString("format.chat.admin.fullname"), Main.getPlugin().getConfig().getString("format.chat.admin.suffix")), 
    HEADADMIN("HEADADMIN", 9, 10, Main.getPlugin().getConfig().getString("format.chat.headadmin.prefix"), Main.getPlugin().getConfig().getString("format.chat.headadmin.fullname"), Main.getPlugin().getConfig().getString("format.chat.headadmin.suffix")), 
    ROOT("ROOT", 11, 12, Main.getPlugin().getConfig().getString("format.chat.root.prefix"), Main.getPlugin().getConfig().getString("format.chat.root.fullname"), Main.getPlugin().getConfig().getString("format.chat.root.suffix")), 
    CONSOLE("CONSOLE", 12, 999, "&3", "TECHNIK", "&7");
    
    private int level;
    private String prefix;
    private String fullName;
    private String suffix;
    
    private GroupType(final String s, final int n, final int level, final String prefix, final String fullName, final String suffix) {
        this.level = level;
        this.prefix = prefix;
        this.suffix = suffix;
        this.fullName = fullName;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public boolean can(final GroupType type) {
        return this.level >= type.getLevel();
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
}
