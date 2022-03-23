package DAO;

import Data.Customer;
import Data.Product;
import com.main.Main;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class RequestsManager {
    private final Connection connection;

    public RequestsManager(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Product> getGoodsByPrice(float price) throws SQLException {
        ArrayList<Product> result = new ArrayList<>();
        String sql = "select* from Goods \n" +
                "where Goods.Price >=" + price;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            result.add(
                    new Product(
                            resultSet.getString(1),
                            Float.parseFloat(resultSet.getString(2)),
                            resultSet.getString(3),
                            Integer.parseInt(resultSet.getString(4))
                    )
            );
        }
        return result;
    }

    public ArrayList<Customer> getCompaniesInfo() throws SQLException {
        ArrayList<Customer> result = new ArrayList<>();
        String sql = "select distinct Customers.CompanyName,Customers.PhoneNamber,Customers.Address\n" +
                " from Customers inner join Orders on Customers.CompanyName = Orders.Customer";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            result.add(
                    new Customer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return result;
    }

    public void AddRow(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customers (CompanyName, PhoneNamber, Address) Values (?, ?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getPhoneNumber());
        statement.setString(3, customer.getAddress());
        int rows =statement.executeUpdate();
        System.out.println(rows);
    }
}
