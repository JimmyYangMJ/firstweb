package java01_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
///δ�����Ŀ�������������������������������������������������������������������� 03
@WebServlet("/context_getpath")
public class context_getpath extends HttpServlet {
    /**
     * ͨ���������ַ�����ʵ�·������get����
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /*	  ServletContext��String getRealPath(String path)����;
		?1.������Դ���Ƶõ���Դ�ľ���·��.
		?2.���Եõ���ǰӦ���κ�λ�õ��κ���Դ*/

        //�������
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        /**
         * String path = "src/com/gyf/web/lesson03/info.properties";
         * �����web��Ŀ�������ļ�ʱ��Ҫ����.class·����
         */
        String path = this.getServletContext().getRealPath("WEB-INF/classes/java01_servlet/info.properties");
        System.out.println(path);

        //��Servlet����ȡinfo.properties����
        //1.�������Զ���
        Properties pro = new Properties();

        //2.���������ļ���·��
        pro.load(new FileInputStream(path));

        System.out.println(pro.getProperty("user"));

        //��Ӧ�ͻ���
        resp.getWriter().write(path);
        resp.getWriter().write("-----");
        resp.getWriter().write(pro.getProperty("user"));

    }
}
