package Test;

import Connect.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {

    public static void main(String[] args) {

        Connect connWEB = new Connect();

        String sql="select * from WEBCONNECT.USERS";
            ResultSet resultSet = null;
            try {
                Statement ps= Connect.getConnection().createStatement();
                resultSet = ps.executeQuery(sql);
                while(resultSet.next()){
                    System.out.println(resultSet.getString("NAME"));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
}
