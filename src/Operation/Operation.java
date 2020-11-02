package Operation;

import Connect.Connect;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyWebOracle
 * @description: 执行sql返回结果
 * @author: WangDa
 * @create: 2020-10-30 22:28
 **/
public class Operation implements operate {

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> UserList = new ArrayList<User>();
        String sql = "SELECT * FROM WEBCONNECT.USERS";
        try {
            ResultSet resultSet = runSql.runSql(sql);
            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("USERID")+resultSet.getString("NAME"));
                User user = new User(resultSet.getInt("USERID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("PASSWOrd"),
                        resultSet.getLong("PHONE"),
                        resultSet.getString("REGETIME"),
                        resultSet.getInt("SELLTIMES"),
                        resultSet.getString("NICKNAME"));
                UserList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return UserList;
    }

    @Override
    public boolean AddUser(String NICKNAME, String NAME, String PASSWORD, String PHONE) {

        Statement pstat = null;
        try {
            SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
            String REGIME = tempDate.format(new java.util.Date());
            String sql = "INSERT INTO WEBCONNECT.USERS (NAME, PASSWORD, PHONE, REGETIME, SELLTIMES, NICKNAME) VALUES('"
                    + NAME + "'," + PASSWORD + "," + PHONE + ",'" + REGIME + "'," + "0" + ",'" + NICKNAME + "')";
            System.out.println(sql);
            pstat = Connect.getConnection().createStatement();
            int result = pstat.executeUpdate(sql);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean verifyLogin(String NAME, String PASSWORD) {
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM WEBCONNECT.USERS WHERE NAME = '" + NAME + "' AND PASSWORD ='" + PASSWORD + "'";
            System.out.println(sql);
            resultSet = runSql.runSql(sql);
            if (resultSet.next()) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("登录失败");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int USERID) {
        try {
            String sql = "DELETE FROM WEBCONNECT.USERS WHERE USERID=" + USERID;
            System.out.println(sql);
            int res = Connect.getConnection().createStatement().executeUpdate(sql);//返回值代表受影响的行数
            System.out.println(res);
            return res > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean UpdateUser(User user) {

        try {
            String sql = "update users set NICKNAME='"+user.getNICKNAME()+ "', NAME='"+user.getNAME()+"',PASSWORD='"
                    +user.getPASSWORD()+"',PHONE="+user.getPHONE()+" where USERID="+user.getUSERID();
            System.out.println(sql);
            int result = Connect.getConnection().createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User queryById(int USERID) {
        ResultSet resultSet = null;
        User user= null;
        try {
            String sql = "select * from Users where userid="+USERID;
            resultSet = runSql.runSql(sql);
            while (resultSet.next()) {
                user = new User(resultSet.getInt("USERID"),
                        resultSet.getString("NAME"), resultSet.getString("PASSWORD"),
                        resultSet.getLong("PHONE"), resultSet.getString("REGETIME"),
                        resultSet.getInt("SELLTIMES"), resultSet.getString("NICKNAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
