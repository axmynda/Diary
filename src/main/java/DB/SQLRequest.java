package DB;


public class SQLRequest {
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/diary";
    public static final String DATABASE_DRIVER= "org.postgresql.Driver";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS USERS (ID INTEGER AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(50), PASSWORD BINARY(1024), ROLE VARCHAR(20) );";
    public static final String CREATE_TABLE_TASKS= "CREATE TABLE IF NOT EXISTS TASKS(ID INTEGER AUTO_INCREMENT PRIMARY KEY, USER_ID INTEGER,FOREIGN KEY(USER_ID) REFERENCES Public.USERS(ID),TASK VARCHAR(300), DATE INTEGER );";

    public static final String INSERT_USER="INSERT INTO USERS (NAME, PASSWORD,ROLE) VALUES (?,?,?);";
    public static final String INSERT_TASK="INSERT INTO USERS (TASK, DATE) VALUES (?,?);";

    public static final String SELECT_USER="SELECT * FROM USERS WHERE ID=?";
    public static final String SELECT_TASK="SELECT * FROM TASKS WHERE ID=?";

    public static final String SELECT_ALL_USERS="SELECT * FROM USERS ";
    public static final String SELECT_ALL_TASKS="SELECT * FROM TASKS ";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE ID=?;";
    public static final String DELETE_TASK = "DELETE FROM TASKS WHERE ID=?;";

    public static final String UPDATE_USER = "UPDATE USERS SET NAME=?, PASSWORD=?, ROLE=? WHERE ID=?";
    public static final String UPDATE_TASK = "UPDATE TASKS SET TASK=?, DATE=?  WHERE ID=?";


}
