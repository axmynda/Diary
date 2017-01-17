package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
    private Connection connection;
    private Statement statement;
    public DBConnect() {

        try {
            connection = ConnectionPool.getConnection();
            statement = connection.createStatement();
            statement.execute(SQLRequest.CREATE_TABLE_USERS);
            statement.execute(SQLRequest.CREATE_TABLE_TASKS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public Statement getStatement(){
            return statement;
        }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
    public void closePreparedStatement(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    }

