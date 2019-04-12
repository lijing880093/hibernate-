<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px">
        <tr>
            <td>sId</td>
            <td>sName</td>
            <td>CId</td>
            <td>操作</td>
        </tr>
        <c:forEach var="studentList" items="${all}">
            <tr>
                <td>${studentList.id}</td>
                <td>${studentList.name}</td>
                <td>${studentList.cid}</td>

                <td>
                    <a href="/StudentsServlet?method=delete&id=${studentList.id}">delete</a>
                    <a href="/StudentsServlet?method=queryOne&id=${studentList.id}">update</a>
                </td>
            </tr>
            
        </c:forEach>
    </table>

    <c:forEach var="i" begin="1" step="1" end="${end}">
        <a href="/StudentsServlet?method=query&index=${i}">【${i}】</a>
    </c:forEach><br/>

    <a href="add.jsp">add

</a>

</body>
</html>
