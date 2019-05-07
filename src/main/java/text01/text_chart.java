package text01;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class text_chart {
    static class MyTask extends TimerTask {
        public void run() {
            System.out.println("运行了1！时间为：" + new Date());
            writeLine("d:/IDEA-workspace/firstweb/web/photo/line.jpg");// 折线图
        }
    }
    static class MyTask2 extends TimerTask {
        public void run() {
            System.out.println("运行了2！时间为：" + new Date());
            writeLine("d:/IDEA-workspace/firstweb/web/photo/line.jpg");// 折线图
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
            MyTask task = new MyTask();
        Timer timer = new Timer();

        // writeBar("c:/Users/dell/Desktop/java项目/bar.jpg"); // 柱状图
       // writePie("c:/Users/dell/Desktop/java项目/pie.jpg"); // 饼图

        System.out.println("当前时间："+new Date().toLocaleString());
        //当前时间1秒后，每2秒执行一次
        timer.schedule(task, 1000, 1000);

        Thread.sleep(1000000);
        task.cancel();  //取消当前的任务
        Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND,now.get(Calendar.SECOND)+3);
        Date runDate = now.getTime();
        MyTask2 task2 = new MyTask2();
        timer.scheduleAtFixedRate(task2,runDate,3000); //固定速率

        Thread.sleep(20000);
        timer.cancel();  //取消定时器
    }

    public static StandardChartTheme getChineseTheme()
    {
        StandardChartTheme chineseTheme = new StandardChartTheme("CN");
        chineseTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        chineseTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
        chineseTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
        return chineseTheme;
    }
    //柱状图
    public static void writeBar(String fileName) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(11, "", "第一季度");
        dataset.addValue(41, "", "第二季度");
        dataset.addValue(51, "", "第三季度");
        dataset.addValue(4, "", "第四季度");

        // PlotOrientation.HORIZONTAL横向 PlotOrientation.VERTICAL 竖向
        // 引入中文主题样式
        ChartFactory.setChartTheme(getChineseTheme());
        JFreeChart chart = ChartFactory.createBarChart3D("柱状图", "2018年", "产品总量", dataset, PlotOrientation.VERTICAL,
                false, false, false);

        try {
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //饼状图
    public static void writePie(String fileName) {
        DefaultPieDataset pds = new DefaultPieDataset();
        pds.setValue("C人数", 300);
        pds.setValue("C++人数", 200);
        pds.setValue("Java人数", 100);
        try {
            ChartFactory.setChartTheme(getChineseTheme());
            JFreeChart chart = ChartFactory.createPieChart("饼图", pds);

            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //折线图
    public static void writeLine(String fileName) {
        DefaultCategoryDataset lines = new DefaultCategoryDataset();
        //第一条线
        Random rd = new Random();
        lines.addValue(rd.nextInt(100), "正常", "1月");
        lines.addValue(rd.nextInt(100), "正常", "2月");
        lines.addValue(rd.nextInt(100), "正常", "3月");
        lines.addValue(rd.nextInt(100), "正常", "4月");

        //第二条线
        lines.addValue(10, "测量值", "1月");
        lines.addValue(30, "测量值", "2月");
        lines.addValue(60, "测量值", "3月");
        lines.addValue(80, "测量值", "4月");
        try {
            ChartFactory.setChartTheme(getChineseTheme());
            JFreeChart chart = ChartFactory.createLineChart("土壤水势-折线图", "时间", "湿度", lines);
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
