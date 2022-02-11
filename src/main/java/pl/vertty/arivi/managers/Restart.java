package pl.vertty.arivi.managers;


import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Restart {
    private Integer name;


    public Restart(Integer name) {
        this.name = name;
        insert();
    }

    public Restart(ResultSet rs) throws SQLException {
        this.name = rs.getInt("name");
    }

    private void insert() {
        Main.getStore().update("INSERT INTO `restart`(`id`, `name`) VALUES (NULL, '" + getName() + "');");
    }

    public Integer getName() {
        return this.name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}

