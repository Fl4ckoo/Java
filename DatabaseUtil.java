import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseUtil {

    private static Connection connection;
    private static Statement statement;

    public static void databaseUtil() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url, user, password);

            System.out.println("Connection successful to the database: " + url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;

    }

}










































//    private Connection conn;
//    private Statement statement;
//
//    public Connection openConnection() throws SQLException{
//
//        if(conn == null){
//            String url = "jdbc:mysql://localhost:3306";
//            String dbName = "mysql";
//            String driver = "com.jdbc.mysql.Driver";
//            String userName = "root";
//            String password = "";
//            try{
//                Class.forName(driver);
//                this.conn = DriverManager.getConnection(url+dbName,userName,password);
//
//                System.out.println("Connection Successful!");
//            }
//            catch (ClassNotFoundException | SQLException sqle){
//                System.out.println("Connection Failed");
//            }
//        }
//
//
//        return conn;

