
package pl.vertty.arivi.mysql;

import pl.vertty.arivi.mysql.modes.StoreMode;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Store
{
    Connection getConnection();
    
    boolean connect();
    
    void disconnect();
    
    void reconnect();
    
    boolean isConnected();
    
    ResultSet query(final String p0);
    
    void query(final String p0, final Callback<ResultSet> p1);
    
    void update(final boolean p0, final String p1);
    
    ResultSet update(final String p0);

    void asyncUpdate(String s);

    StoreMode getStoreMode();
}
