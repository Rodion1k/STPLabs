package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO {

    Connection getConnection() throws SQLException;
}
