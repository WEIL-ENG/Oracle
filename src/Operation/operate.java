package Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface operate {

    public List<User> getAllUsers();

    public boolean AddUser(String NICKNAME, String NAME, String PASSWORD, String PHONE);

    public boolean verifyLogin(String NAME, String PASSWORD);

    public boolean deleteById(int USERID);

    public boolean UpdateUser(User userInfo);

    public User queryById(int UserId);
}
