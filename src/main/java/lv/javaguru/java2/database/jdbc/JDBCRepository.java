package lv.javaguru.java2.database.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class JDBCRepository {

    private static final String DB_CONFIG_FILE = "database.properties";

    protected String jdbcUrl = null;
    protected String driverClass = null;
    protected String userName = null;
    protected String password = null;


    public JDBCRepository() {
        initDatabaseConnectionProperties();
        registerJDBCDriver();
    }

    private void registerJDBCDriver() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = new Properties();
        try {
            properties.load(JDBCRepository.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));

            jdbcUrl = properties.getProperty("jdbc.url");
            driverClass = properties.getProperty("driverClass");
            userName = properties.getProperty("database.user.name");
            password = properties.getProperty("database.user.password");
        } catch (IOException e){
            System.out.println("Exception while reading JDBC configuration from file = " + DB_CONFIG_FILE);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() {
        try{
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
              }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
