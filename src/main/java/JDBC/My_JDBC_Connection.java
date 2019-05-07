package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_JDBC_Connection {
    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String user = "root" ;
    final static String password = "981011" ;
    static String url="jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC&useSSL=false";

    public static Connection JDBC_connect() {
        //构建Java和数据库之间的桥梁介质
// 1. 注册驱动
        try{
            Class.forName(driver);
            System.out.println("注册驱动成功!");
        }catch(ClassNotFoundException e1){
            System.out.println("注册驱动失败!");
            e1.printStackTrace();
        }
        Connection conn = null;
        try {
            //构建Java和数据库之间的桥梁：URL，用户名，密码
//2. 创建连接
            conn = DriverManager.getConnection(url, user, password);
            //构建数据库执行者
            if(!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
                return conn;
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Sorry,can`t connect the SQL!");
        }
        return conn;
    }
}
