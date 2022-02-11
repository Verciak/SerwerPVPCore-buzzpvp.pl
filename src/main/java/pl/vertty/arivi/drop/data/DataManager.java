package pl.vertty.arivi.drop.data;

public class DataManager
{
    private static DataExecutor data;
    
    public static DataExecutor getData() {
        if (DataManager.data == null) {
            new DataManager();
        }
        return DataManager.data;
    }
    
    public DataManager() {
        DataManager.data = new DatabaseExe();
    }
}
