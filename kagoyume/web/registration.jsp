<%-- 
    Document   : registration
    Created on : 2016/11/03, 16:11:37
    Author     : Yuu
--%>

<%@page import="javaBeans.UserInfomation"%>
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
          UserInfomation ud = (UserInfomation)hs.getAttribute("ud");
          
        %>
        <h1>新規登録ページ</h1><br>
        <h3>以下を入力してください</h3><br><br>
        <form action="registrationconfirm" method="get">
           
        ユーザー名:<input type="text" name="name" value="<%=ud.getName()%>"><br><br>
        パスワード:<input type="password"  name="password" value="<%=ud.getPassword()%>"><br><br>
        メールアドレス:<input type="text" name="mail" value="<%=ud.getMail()%>"><br><br>
        住所:<input type="text" name="address" value="<%=ud.getAddress()%>"><br><br><br>
        
        
        <input type="submit" value="登録">
        </form>
    </body>
</html>
