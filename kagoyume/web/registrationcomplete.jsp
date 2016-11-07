<%-- 
    Document   : registrationcomplete
    Created on : 2016/11/03, 20:50:22
    Author     : Yuu
--%>

<%@page import="DB.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        HttpSession hs = request.getSession();
        UserDataDTO udd=(UserDataDTO)hs.getAttribute("udd");
        %>
        
        <h2>登録確認</h2>
        名前：<%= udd.getName() %><br>
        パスワード:<%=udd.getPassword()%><br>
        メールアドレス:<%=udd.getmMail()%><br>
        住所:<%=udd.getAddress()%><br>
        <%=udd.getNewDate()%><br><br><br>
        <h1>以上の内容で登録しました。</h1>
        <h1><a href ="top.jsp">トップに戻る</a></h1>
    </body>
</html>
