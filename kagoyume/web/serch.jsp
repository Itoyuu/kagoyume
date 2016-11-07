<%-- 
    Document   : serch
    Created on : 2016/11/03, 14:59:27
    Author     : Yuu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="API.GetAPI" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%  
    HttpSession hs = request.getSession();
    ArrayList<GetAPI> list = (ArrayList<GetAPI>) hs.getAttribute("result");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href ="login.jsp">ログイン</a>
        <!--検索結果を表示-->
        
        <%for (int i = 0; i < list.size(); i++) {
            GetAPI yi = list.get(i);%>
        <table border="1">
            <tr> 
            <th>写真</th><br>
            <th>名前</th><br>
            <th>値段</th><br>
            <th>説明文</th><br>

            </tr>
            <tr><!--情報を取り出して表示していく-->
            <td><img src="<%= yi.getImage()%>"></td><br>
            <td><a href="ItemDetail?ID=<%=i%>"><%=yi.getName()%></a></td>
            <td><%= yi.getPrice()%>円</td><br>
            <td><%= yi.getDis()%></td><br>
            
            </tr>
           
            <% }%>
        </table>

    </body>
</html>
