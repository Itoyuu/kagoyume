<%-- 
    Document   : registrationconfirm
    Created on : 2016/11/03, 19:15:25
    Author     : Yuu
--%>

<%@page import="javaBeans.UserInfomation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs=request.getSession();
    UserInfomation ud = (UserInfomation)hs.getAttribute("ud");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        名前:<%=ud.getName()%><br><br>
        パスワード:<%=ud.getPassword()%><br><br>
        メールアドレス:<%=ud.getMail()%><br><br>
        住所<%=ud.getAddress()%><br><br>
        上記の内容で登録します。よろしいでしょうか？<br><br>
        <form action ="registrationcomplete" method="post">
        <input type="submit" value="はい">
        </form>
        <form action="registration.jsp" method="post">
        <input type="submit" value="いいえ">
        </form>
    </body>
</html>
