package DB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPool {
    private static DataSource dataSource = null;

    static {
        InitialContext initContext = null;
        try {
            initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/diary");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new SQLException("Не удалось получить соединение" + e.getMessage());
        }
        return connection;


} }
