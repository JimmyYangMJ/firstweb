package java01_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class context_get_remove extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取一个应用的Servlet上下文（contex）
        ServletContext context = this.getServletContext();
        //System.out.println(context +"获取servlet数据");


        //获取context 数据
        String name = (String)context.getAttribute("name");
        System.out.println(name);
        // context.removeAttribute("name"); 移除context信息
    }
}