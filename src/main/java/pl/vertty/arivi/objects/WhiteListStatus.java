package pl.vertty.arivi.objects;


import pl.vertty.arivi.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WhiteListStatus {
    private Integer name;


    public WhiteListStatus(Integer name) {
        this.name = name;
        insert();
    }

    public WhiteListStatus(ResultSet rs) throws SQLException {
        this.name = rs.getInt("name");
    }

    private void insert() {
        Main.getStore().update("INSERT INTO `whitelist-status`(`id`, `name`) VALUES (NULL, '" + getName() + "');");
    }

    public Integer getName() {
        return this.name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}

