<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/15
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StudentsServlet">
    <input type="hidden" name="method" value="add">
    <table>

        <tr>
            <td>name</td>
            <td>
                <input type="text" name="sName" >
            </td>
        </tr>
        <tr>
            <td>city</td>
            <td>
                <input type="text" name="CId" >
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="add">
                <input type="reset" value="reset">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
