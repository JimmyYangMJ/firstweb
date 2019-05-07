package java01_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/context_set")  // 可以不用在 xml写 servlet的映射
public class context_set extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取一个应用的Servlet上下文（contex）
        ServletContext context = this.getServletContext();
        //System.out.println(context+"存servlet数据");


        //向context 存数据
        //arg0 arg1 没有关联源码
        context.setAttribute("name","杨明杰");
        //context.removeAttribute("name");
    }
}