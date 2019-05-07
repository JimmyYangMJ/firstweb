package java01_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("GBK");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>Servlet实例</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    Servlet实例： ");
        out.print(this.getClass());
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
