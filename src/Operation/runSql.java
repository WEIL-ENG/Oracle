package Operation;

import Connect.Connect;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @program: Oracle
 * @description:
 * @author: WangDa
 * @create: 2020-10-31 11:00
 **/
public class runSql {

        public static ResultSet runSql(String sql){
            ResultSet resultSet = null;
            try {
                Statement ps= Connect.getConnection().createStatement();
                resultSet = ps.executeQuery(sql);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return resultSet;
        }
}
