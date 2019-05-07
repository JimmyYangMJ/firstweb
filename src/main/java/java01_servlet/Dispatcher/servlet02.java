package java01_servlet.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/Dispatcher/servlet02")
public class servlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //resp.setContentType("text/json"); 给客户端返回的数据类型
        // 显示信息
        //resp.getWriter().write("由servlet01调用!!!");  (与传输字节不能同时使用)
        //也可以给客户端返回html /json / xml文件 /图片数据

        //设置状态响应码
        resp.setStatus(200); //200	请求已成功，请求所希望的响应头或数据体将随此响应返回。

        //或者传输字节
        byte[] bs = {97,98,99,100};
        resp.getOutputStream().write(bs);

//        getParameterMap方法  //做框架用，非常实用
//        把所有请求参数存在一个map中
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()){
            System.out.println("参数的名字：" );
            System.out.println(entry.getKey());

            System.out.println("参数的值：" );
            for (String value:entry.getValue()){
                System.out.println(value);
            }
        }
        // http://localhost:8080/firstweb_war_exploded/Dispatcher/servlet01?Name=qq&Name=aa&sex=01&number=123
    }
}
