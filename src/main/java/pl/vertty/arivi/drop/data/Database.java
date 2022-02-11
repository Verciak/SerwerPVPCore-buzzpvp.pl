package pl.vertty.arivi.drop.data;

import cn.nukkit.utils.Config;
import pl.vertty.arivi.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database inst;

    private final String host;

    private final String base;

    private final String user;

    private final String pass;

    private final int port;

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

    public void openConnection() {
        try {
            if (conn != null && !conn.isClosed())
                return;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.base + "?useSSL=false&serverTimezone=Europe/Warsaw&user=" + this.user + "&password=" + this.pass);
        } catch (SQLException|ClassNotFoundException|InstantiationException|IllegalAccessException ex2) {
            ex2.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn == null || conn.isClosed())
                return;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void check() {
        openConnection();
        try {
            conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `DMdrops` (name varchar(50) not null, turbo long not null, turboexp long not null, lvl int not null, blocks int not null, blockstonext int not null, drops text not null, cobble int not null, dirt int not null, primary key(name));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }
}
