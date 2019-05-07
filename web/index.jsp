<%@ page import="java.sql.*" %>
<%@ page import="text01.text_chart" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>soil</title>
  <link href="css/soil.css" type="text/css" rel="stylesheet"/>
  <script src="scripts/soil.js" type="text/javascript"></script>
</head>

<body >
土壤水势项目 -------
<table >
  <tr>
    <td >土壤水势项目数据!</td>
  </tr>
</table>
<%
  //声明Connection对象
  Connection con = null;
  String driver = "com.mysql.cj.jdbc.Driver";
  String user = "root" ;
  String password = "981011" ;
  //       String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC&useSSL=false&user=root&password=981011";
  String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC&useSSL=false";
  try {
    //加载驱动程序
    Class.forName(driver);
    //1.getConnection()方法，连接MySQL数据库！！
    con = DriverManager.getConnection(url, user, password);
    // con = DriverManager.getConnection(url);
    if (!con.isClosed())
      System.out.println("Succeeded connecting to the Database!");
    //2.创建statement类对象，用来执行SQL语句！！
    Statement statement = con.createStatement();
    //要执行的SQL语句
    String sql = "select * from soil";
    //3.ResultSet类，用来存放获取的结果集！！
    ResultSet rs = statement.executeQuery(sql);
%>
<table >
  <tr>
    <td bgcolor="#a9a9a9">....日期....</td> <td bgcolor="#a9a9a9">湿度</td> <td bgcolor="#a9a9a9">....时间....</td>
  </tr>
</table>
<%
  String time = null;
  String humidity1 = null;
  String date = null;
  while (rs.next()) {
    //获取stuname这列数据
    time = rs.getString("time");
    //获取stuid这列数据
    humidity1 = rs.getString("humidity1");
    date = rs.getString("date");
    //输出结果
%>
<table >
  <tr>
    <td > <%=time%> </td> <td > <%=humidity1%> </td> <td > <%=date%> </td>
  </tr>
</table>
<%
    }
    rs.close();
    con.close();
  } catch (ClassNotFoundException e) {
    //数据库驱动类异常处理
    System.out.println("Sorry,can`t find the Driver!");
    //e.printStackTrace();
  } catch (SQLException e) {
    // TODO: handle exception
    e.printStackTrace();
  } finally {
    System.out.println("结束");
  }
%>
<%-- 小游戏
      <div><img id="hangmanpic" src="photo/hangman6.gif" alt="soil"/></div>
      <div id="clue">按“新游戏”按钮开始!!</div>
      <div>
        <input id="guess" type="text" size="10" maxlength="1"/>
        <button onclick="guessLetter();">猜</button>
      </div>
      <div id="newgamearea">
        <button onclick="newGame();">新游戏</button>
      </div>
      <div id="guesses"></div>
 --%>
</body>
<%--  音乐播放
<table border="1" width="50%" cellspacing="0" cellpadding="10">
  <tr>
    <td>
      <p align="center">音乐欣赏</td>
  </tr>
  <tr>
    <td>
      <audio src="mp3/1.mp3" controls="controls">您的浏览器不支持audio标签。</audio>
    </td>
  </tr>
</table>
--%>

<body>
<h2>土壤水势！！！</h2>
<img border="0" src="photo/line.jpg" alt="Pulpit rock" width="500" height="500">
</body>

<body>
    <form action="loginServlet" method="post">
         user:<input type="text" name="username"/>
         password:<input type="password" name="password"/>
        
         <input type="submit" value="Submit"/>
      </form>
  </body>
</html>
