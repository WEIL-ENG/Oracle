package servlet;

import Operation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyWebOracle
 * @description:
 * @author: WangDa
 * @create: 2020-10-30 22:37
 **/
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //解决post方式下乱码问题
        String type = request.getParameter("type");  //派发   操作类型type
        if ("users".equals(type)) {
            getAllUsersInfo(request, response);
        } else if ("add".equals(type)) {
            add(request, response);
        } else if ("login".equals(type)) {
            login(request, response);
        } else if ("delete".equals(type)) {
            delete(request, response);
        } else if ("edit".equals(type)) {
            edit(request, response);
        } else if ("querybyid".equals(type)) {
            queryById(request, response);
        }
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从表单接收各个参数
        int USERID = Integer.parseInt(request.getParameter("USERID"));
        String NICKNAME = request.getParameter("NICKNAME");
        String NAME = request.getParameter("NAME");
        String PASSWORD = request.getParameter("PASSWORD");
        long PHONE = Long.parseLong(request.getParameter("PHONE"));
        String REGTIME = request.getParameter("REGTIME");
        int SELLITIMES = Integer.parseInt(request.getParameter("SELLITIMES"));

        User user = new User(USERID, NAME, PASSWORD, PHONE, REGTIME, SELLITIMES, NICKNAME);
        Operation operation = new Operation();
        boolean bool = operation.UpdateUser(user);
        //跳转到user_list.jsp,展示所有用户
        if (bool) {
            request.setAttribute("info", "修改成功！");
            getAllUsersInfo(request, response);
        } else {
            request.setAttribute("info", "修改失败！");
            getAllUsersInfo(request, response);
        }
    }

    private void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Operation operation = new Operation();
        int UserId = Integer.parseInt(request.getParameter("USERID"));
        User user = operation.queryById(UserId);
        request.setAttribute("userinfo", user);
        request.getRequestDispatcher("jsp/edit_user.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Operation operation = new Operation();
        int UserId = Integer.parseInt(request.getParameter("userid"));
        boolean b = operation.deleteById(UserId);
        //跳转到user_list.jsp,展示所有用户
        if (b) {
            request.setAttribute("info", "删除成功！");
            getAllUsersInfo(request, response);
        } else {
            request.setAttribute("info", "删除失败！");
            getAllUsersInfo(request, response);
        }
    }

    private void getAllUsersInfo (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            Operation operation = new Operation();
            ArrayList<User> userList = operation.getAllUsers();
            request.setAttribute("list", userList);
            request.getRequestDispatcher("jsp/user_list.jsp").forward(request, response);
        }

        private void add (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
//        //从表单接收各个参数
            Operation operation = new Operation();
            String NICKNAME = request.getParameter("NICKNAME");
            String NAME = request.getParameter("NAME");
            String PASSWORD = request.getParameter("PASSWORD");
            String PHONE = request.getParameter("PHONE");
            System.out.println("name:" + NAME + ";" + "nickname:" + NICKNAME + ";"
                    + "password:" + PASSWORD + ";" + "phone:" + PHONE);
            //调用dao中的添加方法
            boolean bool = operation.AddUser(NICKNAME, NAME, PASSWORD, PHONE);
            //跳转到user_list.jsp,展示所有用户
            if (bool) {
                request.setAttribute("info", "用户添加成功！");
                getAllUsersInfo(request, response);
            } else {
                request.setAttribute("info", "用户添加失败！");
                getAllUsersInfo(request, response);
            }
        }

        private void login (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            Operation operation = new Operation();
            if (request.getMethod().equals("POST")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                //对用户账号和密码进行验证
                boolean flag = operation.verifyLogin(username, password);
                //根据验证结果跳转页面
                if (flag) {
                    HttpSession session = request.getSession();  //获取session对象
                    session.setAttribute("username", username);  //设置属性值
                    request.setAttribute("info", "你好," + username + "!");
                    //session.setMaxInactiveInterval(60);//设置失效时间
//            request.getRequestDispatcher("jsp/user_list.jsp").forward(request, response);//转发 (页面跳转)
                    getAllUsersInfo(request, response);
                    //绝对路径
           /* String path=request.getContextPath();//获取项目的根路径
            response.sendRedirect(path+"/jsp/succcess.jsp");*/
                } else {
                    // 当用户登录失败时，重新重定向到 login 页面
                    request.setAttribute("info", "用户登录");
                    request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("info", "用户登录");
                request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
            }
        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");  //解决post方式下乱码问题
            String type = request.getParameter("type");  //派发   操作类型type
            if ("delete".equals(type)) {
                doPost(request, response);
            } else if ("querybyid".equals(type)) {
                doPost(request, response);
            } else {
                request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
            }
        }
    }
