package lv.javaguru.java2.console;

import lv.javaguru.java2.console.database.jdbc.JDBCRepository;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseCleaner extends JDBCRepository {

    public void clean() {
        for(String tableName : getTableNames()) {
            Connection connection = null;
            try {
                connection = getConnection();
                String sql = "delete from " + tableName;
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
            } finally {
                closeConnection(connection);
            }
        }
    }

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("SHOPPING_LIST_ITEMS");
        tableNames.add("SHOPPING_LISTS");
        tableNames.add("PRODUCTS");
        tableNames.add("USERS");
        return tableNames;
    }

}
