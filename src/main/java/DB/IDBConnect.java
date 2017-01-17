package DB;

import java.sql.PreparedStatement;
import java.sql.Statement;


public interface IDBConnect {
    Statement getStatement();
    PreparedStatement getPrepareStatement(String sql);
    void closePreparedStatement(PreparedStatement ps);
}
