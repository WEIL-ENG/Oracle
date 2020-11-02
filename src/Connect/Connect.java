package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接Oracle数据库WEB，产生一个数据库连接connection
 */
public class Connect {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:WEB";
    private static final String username = "WEBCONNECT";
    private static final String password = "Orcl1234";

    public static Connection connection = null;

    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,username,password);
//            System.out.println("成功连接到Oracle数据库");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
