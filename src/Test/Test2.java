package Test;

import Operation.Operation;
import Operation.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: Oracle
 * @description:
 * @author: WangDa
 * @create: 2020-10-31 20:01
 **/
public class Test2 {

    public static void main(String[] args) {
        Operation operation = new Operation();
        System.out.println(operation.verifyLogin("管理员","123456"));
    }
}
