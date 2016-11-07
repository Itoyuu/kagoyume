<%-- 
    Document   : buycomplete
    Created on : 2016/11/03, 19:04:44
    Author     : Yuu
--%>

<%@page import="DB.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="API.GetAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   HttpSession hs = request.getSession();
   UserDataDTO udd =(UserDataDTO) hs.getAttribute("udd");
   ArrayList<GetAPI>buy = (ArrayList<GetAPI>)hs.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href ="login.jsp">ログイン</a>
        <h1>購入が完了しました</h1>
        <h1><a href ="top.jsp">トップに戻る</a></h1>
        <%
        
        %>
        
    </body>
</html>
