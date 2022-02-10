// 
// Decompiled by Procyon v0.5.36
// 

package pl.vertty.arivi.drop.data;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database inst;

    private String host;

    private String base;

    private String user;

    private String pass;

    private int port;

    private static Connection conn;

    public static Database getInst() {
        if (inst == null)
            new Database();
        return inst;
    }

    public Database() {
        inst = this;
        Config co = Main.getPlugin().getConfig();
        this.host = co.getString("mysql.host");
        this.base = co.getString("mysql.name");
        this.user = co.getString("mysql.user");
        this.pass = co.getString("mysql.pass");
        this.port = co.getInt("mysql.port");
    }

    public Connection getConnection() {
        return conn;
    }

    public Connection openConnection() {
        try {
            if (conn != null && !conn.isClosed())
                return null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return conn = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + Integer.toString(this.port) + "/" + this.base + "?useSSL=false&serverTimezone=Europe/Warsaw&user=" + this.user + "&password=" + this.pass);
        } catch (SQLException|ClassNotFoundException|InstantiationException|IllegalAccessException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (conn == null || (conn != null && conn.isClosed()))
                return;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void check() {
        openConnection();
        try {
            conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `DMdrops` (name varchar(50) not null, turbo long not null, turboexp long not null, lvl int not null, blocks int not null, blockstonext int not null, drops text not null, plecak text not null, cobble int not null, dirt int not null, primary key(name));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }
}
