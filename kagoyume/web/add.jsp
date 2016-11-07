<%-- 
    Document   : add
    Created on : 2016/11/03, 16:28:02
    Author     : Yuu
--%>

<%@page import="API.GetAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>カートに追加しました</h1>
       <form action="cart" method="get">
       <input type="submit" value="カートを見る"><br><br><br>
       <a href ="top.jsp">トップに戻る</a>
       </form>
    </body>
</html>
