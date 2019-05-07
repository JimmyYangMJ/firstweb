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
        //������Ӧ���ͺͱ���
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //���ÿͻ��������ͣ����������кϲ�
        //resp.setHeader("Content-Type", "text/html;charset=utf-8");
        //�����ñ������ͣ�Ĭ�ϱ��뷢������ ISO-8859-1��û���й����ֱ��룩����ʱ�ᷢ������

        //����servlet02
        RequestDispatcher rd = req.getRequestDispatcher("/Dispatcher/servlet02");
        rd.forward(req,resp);

        //�����ض���  ��ҳ��ַ��ı�
        resp.sendRedirect(req.getContextPath()+"/Dispatcher/servlet02");


    }
}
