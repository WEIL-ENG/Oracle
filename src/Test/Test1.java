package Test;

import Connect.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {

    public static void main(String[] args) {

        Connect connWEB = new Connect();

        String sql="select * from WEBCONNECT.USERS";
        try {
            PreparedStatement ps= Connect.getConnection().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                System.out.println("ID:" + rs.getString(1) +
                        "\t姓名:" + rs.getString(2) +
                        "\t密码:" + rs.getString(3));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
