//package text01;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Random;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.chinasoft.dao.impl.ImplTemperatureDao;
//import com.chinasoft.entity.Temperature;
//
//@WebServlet("/AjaxTimeServlet")
//public class AjaxTimeServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public AjaxTimeServlet() {
//        super();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Temperature temperature = new Temperature();
////		生成随机温度
//        Random random = new Random();
//        float a = random.nextFloat()/2+19;
//        BigDecimal b =new BigDecimal(a).setScale(1,BigDecimal.ROUND_HALF_UP);
//        temperature.setTemperature(b+"℃");
//        ImplTemperatureDao implTemperatureDao = new ImplTemperatureDao();
//        try {
//            //插入数据库
//            implTemperatureDao.addTemperature(temperature);
//            //读取数据
//            temperature =implTemperatureDao.findTemperatureById();
//            //转换时间格式
//            SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time = myFmt.format(temperature.getTime());
//            //发送
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write(temperature.getTemperature());
//            response.getWriter().write(time);
//				/*//存储到json中
//				Map<String,String> map = new HashMap<>();
//				map.put("temperature", temperature.getTemperature());
//				map.put("time", time);
//				String result = JSONObject.fromObject(map).toString();
//				//发送到客户端
//				response.setContentType("text/html;charset=utf-8");
//				response.getWriter().write(result);*/
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        doGet(request, response);
//    }
//
//}