<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StudentsServlet">
    <input type="hidden" name="method" value="update">
    <table >
     <tr>
         <td>id</td>
         <td>
            <input type="text" name="sId"  readonly value="${student.id}">
         </td>
     </tr>
     <tr>
         <td>name</td>
         <td>
             <input type="text" name="sName" value="${student.name}">
         </td>
     </tr>
     <tr>
         <td>city</td>
         <td>
             <input type="text" name="CId" value="${student.cid}">
         </td>
     </tr>

     <tr>
         <td colspan="2">
             <input type="submit" value="save">
             <input type="reset" value="reset">
         </td>
     </tr>
 </table>
</form>

</body>
</html>
