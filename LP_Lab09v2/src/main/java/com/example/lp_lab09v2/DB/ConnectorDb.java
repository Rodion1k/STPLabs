package com.example.lp_lab09v2.DB;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDb {

    public ConnectorDb() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection(String dataBase) throws SQLException {
        String url = String.format("jdbc:sqlserver://DESKTOP-61237LK;database=%s;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false",dataBase);
        String user = "sa";
        String password = "1111";
        return DriverManager.getConnection(url, user, password);
    }
}
