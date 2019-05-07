package text01;

import JSON_02.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC {

    public static void tester() {
        Gson gson = new Gson();

        /* —————————————————— 准备测试数据 —————————————————— */

        Person person1 = new Person();
        person1.setName("我没有三颗心脏1");
        person1.setAge(21);

        Person person2 = new Person();
        person2.setName("我没有三颗心脏2");
        person2.setAge(21);

        Person person3 = new Person();
        person3.setName("我没有三颗心脏3");
        person3.setAge(21);

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);

        /* —————————————————— 简单的Bean转为JSON —————————————————— */
        String jsonString = gson.toJson(person1);
        System.out.println("简单的Bean转为JSON：" + jsonString);

        /* —————————————————— JSON转为简单Bean —————————————————— */
        Person personFromJson = gson.fromJson(jsonString, Person.class);
        System.out.println("JSON转为简单Bean：" + personFromJson.toString());

        /* —————————————————— 带泛型的List转JSON —————————————————— */
        String jsonStringFromList = gson.toJson(list);
        System.out.println("带泛型的List转JSON：" + jsonStringFromList);

        /* —————————————————— JSONz转为带泛型的List —————————————————— */
        List<Person> retList = gson.fromJson(jsonStringFromList, new TypeToken<List<Person>>() {
        }.getType());
        for (Person tempPerson : retList) {
            System.out.println(tempPerson.toString());
        }

    }
    public static void f() { //从网页读取文字
        System.out.println("每日一句：");
//		String URLString= new String("https://sslapi.hitokoto.cn/?c=f&encode=text");
        String URLString= new String("http://open.iciba.com/ds_open.php?id=62176&name=%E7%99%BE%E5%BA%A6&auth=220CE1B1B2DF14F5E4E685D2CF998E81");
        try {
            URL url = new URL(URLString);
            int count = 1;
            Scanner input = new Scanner(url.openStream());
            int i = 0;
            while(input.hasNext()) {
                String line = input.nextLine();

                int start = line.indexOf("title=\"")+7; 		 //网页源码文本
                int end = line.indexOf("\" target=\"_blank\"") ; //网页源码文本

                //String newName=new String(line.getBytes(),"UTF-8");	//更改字符串编码
                if(i == 14) {
                    System.out.println( line.substring(start, end)  );
                    break;
                }
                else i++;
                count+= line.length();
            }
//			System.out.println( input.nextLine() );
            System.out.println("is " + count + " C");
        }catch(Exception e) {
            System.out.println("no no");
            e.printStackTrace();
        }
    }
    public static void Mysql(){
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root" ;
        String password = "981011" ;
        //       String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC&useSSL=false&user=root&password=981011";
        String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC&useSSL=false";
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            // con = DriverManager.getConnection(url);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //3.ResultSet类，用来存放获取的结果集！！

            String sql2 = "insert  into soil (id, time, humidity1, humidity2, date) values ('7', '00:06:00', '62', '100', '2019-03-20');";
            //String sql2 = "select id from soil";
            PreparedStatement rs2 = con.prepareStatement(sql2);
            int r = rs2.executeUpdate();

            //要执行的SQL语句

            String sql = "select * from soil";
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("  湿度  " + "\t" + " 时间 ");
            System.out.println("-----------------");

            String time = null;
            String humidity1 = null;
            while (rs.next()) {
                //获取stuname这列数据
                time = rs.getString("time");
                //获取stuid这列数据
                humidity1 = rs.getString("humidity1");

                //输出结果
                System.out.println(humidity1 + "\t" + time);
            }
            System.out.println("-----------------");
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            //e.printStackTrace();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("结束");
        }
    }

    public static void main(String[] args) throws SQLException {
        //声明Connection对象
        Mysql();
        f();
        tester();
    }
}
