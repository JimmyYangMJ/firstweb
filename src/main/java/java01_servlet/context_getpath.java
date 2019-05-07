package java01_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
///未完成项目·································· 03
@WebServlet("/context_getpath")
public class context_getpath extends HttpServlet {
    /**
     * 通过浏览器地址栏访问的路径都是get请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /*	  ServletContext的String getRealPath(String path)方法;
		?1.根据资源名称得到资源的绝对路径.
		?2.可以得到当前应用任何位置的任何资源*/

        //解决乱码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        /**
         * String path = "src/com/gyf/web/lesson03/info.properties";
         * 如果是web项目，查找文件时，要从类.class路径找
         */
        String path = this.getServletContext().getRealPath("WEB-INF/classes/java01_servlet/info.properties");
        System.out.println(path);

        //在Servlet来获取info.properties数据
        //1.创建属性对象
        Properties pro = new Properties();

        //2.关连属性文件的路径
        pro.load(new FileInputStream(path));

        System.out.println(pro.getProperty("user"));

        //响应客户端
        resp.getWriter().write(path);
        resp.getWriter().write("-----");
        resp.getWriter().write(pro.getProperty("user"));

    }
}
