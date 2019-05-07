package java01_servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;


public class WordServlet implements Servlet {

    public void WordServlet(){ //构造函数
        System.out.println("执行了WordServlet");
    }
    @Override //初始化工作
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("执行了init");
    }
    @Override  //获取对象配置
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override //处理客户端请求
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter pwt = servletResponse.getWriter();
        System.out.println("执行了service");
        pwt.println("helloYMj"); //向client端发送数据
        pwt.close();
    }
    @Override  //返回Servlet 的信息
    public String getServletInfo() {
        return null;
    }
    @Override //释放资源
    public void destroy() {
        System.out.println("执行了destroy");
    }
}
