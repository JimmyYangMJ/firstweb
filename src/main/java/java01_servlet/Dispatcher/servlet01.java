package java01_servlet.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Dispatcher/servlet01")
public class servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //设置相应类型和编码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //设置客户编码类型，将上述两行合并
        //resp.setHeader("Content-Type", "text/html;charset=utf-8");
        //不设置编译类型，默认编码发送数据 ISO-8859-1（没有中国二字编码），此时会发生乱码

        //调用servlet02
        RequestDispatcher rd = req.getRequestDispatcher("/Dispatcher/servlet02");
        rd.forward(req,resp);

        //请求重定向  网页地址会改变
        resp.sendRedirect(req.getContextPath()+"/Dispatcher/servlet02");


    }
}
