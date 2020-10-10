package com.spring.schoolapplication.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DatabaseConnector {
    private static DatabaseConnector myInstance = null;
    private static String databaseURL;
    private static String databaseUser;
    private static String databasePassword;
    private Connection con;

    public static DatabaseConnector getInstance() {
        if (myInstance == null)
            myInstance = new DatabaseConnector();
        return myInstance;
    }

    public ResultSet executeQuery(String query) throws Exception {
        PreparedStatement preparedStatement = createPreparedStatement(query);
        return executeQuery(preparedStatement);
    }

    public PreparedStatement createPreparedStatement(String query) throws Exception {
        return con.prepareStatement(query);
    }

    public ResultSet executeQuery(PreparedStatement preparedStatement) throws Exception {
        return preparedStatement.executeQuery();
    }

    public int executeUpdate(PreparedStatement preparedStatement) throws Exception {
        return preparedStatement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public void createConnection() throws SQLException, IOException {
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/schoolapplication2?createDatabaseIfNotExist=true", props);
    }

}
