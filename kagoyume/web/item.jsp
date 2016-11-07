<%-- 
    Document   : item
    Created on : 2016/11/03, 15:55:09
    Author     : Yuu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="API.GetAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    HttpSession hs = request.getSession();
    GetAPI list = (GetAPI)hs.getAttribute("iteminfo");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href ="login.jsp">ログイン</a>
        <table border="1">
            <tr> 
            <th>写真</th><br>
            <th>名前</th><br>
            <th>値段</th><br>
            <th>説明文</th><br>

            </tr>
            <tr><!--listから情報を持ってくる-->
            <td><img src="<%=list.getImage()%>"></td><br>
            <td><%=list.getName()%></td>
            <td><%=list.getPrice()%>円</td><br>
            <td><%=list.getDis()%></td><br>
            <!--カートに入れるボタンを押すとadd.javaへ-->
            <td><form action="add" method="post">  
            <input type="submit" value="カートに入れる">
            </form></td> 
            
                
            </tr>
           
          
        </table>
       
        
    </body>
</html>
