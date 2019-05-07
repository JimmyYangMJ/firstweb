package JSON_Gson;

import com.google.gson.Gson;

import java.io.*;
import java.sql.*;

import static JDBC.My_JDBC_Connection.JDBC_connect;

public class mkJSON {

    public static File creatfile(){
        File file = new File("soil99.json");
        if(!file.exists())
        {
            try
            {
                System.out.println("已创建新文件");
                file.createNewFile(); //创建soil99.json
            }
            catch(IOException e){ //可能会因为权限不足或磁盘已满报错
                e.printStackTrace();
            }
        }
        return file;
    }
    public static void Mysql(){
        Connection con = null;

        try {
            con = JDBC_connect(); //连接数据库
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //3.ResultSet类，用来存放获取的结果集！！
            // String sql2 = "insert  into soil (id, time, humidity1, humidity2, date) values ('7', '00:06:00', '62', '100', '2019-03-20');";

            //要执行的SQL语句
            String sql = "select * from soil";
            ResultSet rs = statement.executeQuery(sql);

            File file = creatfile(); //创建文件
            Gson gson = new Gson();
            int i = 0;
            while (rs.next()) {
                javaBean j = new javaBean();
                j.setTime(rs.getString("time")) ;
                j.setHumidty1(rs.getString("humidity1")) ;
                j.setDate(rs.getString("Date"));
                String s = gson.toJson(j); //将Java的对象变成json字符串
                System.out.println(s);

                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("soil99.json",true)))) {
                    if(i == 0) {
                        bw.write("[");
                    }
                    bw.write(JsonFormatTool.formatJson(s));
                    bw.write(",");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(JsonFormatTool.formatJson(s));
            }
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("soil99.json",true)))) {
                        bw.write("]");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            rs.close();
            con.close();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            System.out.println("结束");
        }
    }

    public static void main(String[] args) throws SQLException {
        //声明Connection对象
        Mysql();    //连接数据库
                    //将数据封装进javabean
                    // 将Javabean的对象变成json字符串，保存在json文件中
    }
}
