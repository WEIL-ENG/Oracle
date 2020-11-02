package Operation;

import javax.xml.crypto.Data;
import java.sql.ResultSet;

/**
 * @program: Oracle
 * @description: 用户实体类，用于临时存放并传递数据库中的用户信息
 * @author: WangDa
 * @create: 2020-10-31 13:13
 **/
public class User {

    public int USERID;
    public String NAME;
    public String PASSWORD;
    public long PHONE;
    public String REGTIME;
    public int SELLITIMES;
    public String NICKNAME;

    public User(int USERID, String NAME, String PASSWORD, long PHONE,
                String REGTIME, int SELLITIMES, String NICKNAME) {
        super();
        this.USERID = USERID;
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
        this.PHONE = PHONE;
        this.REGTIME = REGTIME;
        this.SELLITIMES = SELLITIMES;
        this.NICKNAME = NICKNAME;
    }

    public User(String NAME, String PASSWORD, long PHONE,
                String REGTIME, int SELLITIMES, String NICKNAME) {
        super();
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
        this.PHONE = PHONE;
        this.REGTIME = REGTIME;
        this.SELLITIMES = SELLITIMES;
        this.NICKNAME = NICKNAME;
    }

    public int getUSERID() {
        return USERID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public long getPHONE() {
        return PHONE;
    }

    public String getREGTIME() {
        return REGTIME;
    }

    public int getSELLITIMES() {
        return SELLITIMES;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public String getNAME() {
        return NAME;
    }

}
