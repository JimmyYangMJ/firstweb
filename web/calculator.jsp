<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/22
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简易Servlet计算器</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        function calc(form){
            with(form){
                if(firstNum.value == "" || secendNum.value == ""){
                    alert("请输入数字！");
                    return false;
                }
                if(isNaN(firstNum.value) || isNaN(secendNum.value)){
                    alert("数字格式错误！");
                    return false;
                }
                if(operator.value == "-1"){
                    alert("请选择运算符！");
                    return false;
                }
            }
        }
    </script>
</head>

<body>
<form action="CalculateServlet" method="post" onsubmit="return calc(this);">
    <table align="center" border="0">
        <tr>
            <th>简易Servlet计算器</th>
        </tr>
        <tr>
            <td>
                <input type="text" name="firstNum">
                <select name="operator">
                    <option value="-1">运算符</option>
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
                <input type="text" name="secendNum">
                <input type="submit" value="计算">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

