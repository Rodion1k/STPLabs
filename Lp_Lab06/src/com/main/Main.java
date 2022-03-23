package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.ConnectorDB;
import DAO.RequestsManager;
import Data.Customer;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ConnectorDB connectorDB = new ConnectorDB();
        try {
            LOG.info("starting program");
            var connection = connectorDB.getConnection();
            LOG.info("connection with BD");
            RequestsManager manager = new RequestsManager(connection);
            System.out.println();
            LOG.info("goods: \n");
            var goods = manager.getGoodsByPrice(200);
            for (var i : goods) {
                System.out.println(i);
                LOG.info(i);
            }
            System.out.println();
            LOG.info("Customers :\n");
            var info = manager.getCompaniesInfo();
            for (var i : info) {
                System.out.println(i);
                LOG.info(i);
            }
            manager.AddRow(new Customer("LOL","2288","Kiev"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            LOG.info("END");
        }


    }
}
