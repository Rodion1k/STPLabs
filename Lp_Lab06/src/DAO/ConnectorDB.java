package DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB implements IDAO {


    public ConnectorDB() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("BD");
        String url = resource.getString("BD.url");
        String user = resource.getString("BD.user");
        String password = resource.getString("BD.password");
        return DriverManager.getConnection(url,user,password);
    }
}
