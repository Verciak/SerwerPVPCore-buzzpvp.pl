
package pl.vertty.arivi.mysql.modes;

public enum StoreMode
{
    SQLITE("SQLITE", 0, "sqlite"), 
    MYSQL("MYSQL", 1, "mysql");
    
    private String name;
    
    private StoreMode(final String s, final int n, final String name) {
        this.name = name;
    }
    
    public static StoreMode getByName(final String name) {
        StoreMode[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final StoreMode sm = values[i];
            if (sm.getName().equalsIgnoreCase(name)) {
                return sm;
            }
        }
        return null;
    }
    
    public String getName() {
        return this.name;
    }
}
