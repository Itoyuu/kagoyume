<%-- 
    Document   : cart
    Created on : 2016/11/03, 17:51:58
    Author     : Yuu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="API.GetAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<GetAPI> cart = (ArrayList) hs.getAttribute("cart");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href ="login.jsp">ログイン</a>
       
        <% for (int i = 0; i < cart.size(); i++) {
                  GetAPI yi = cart.get(i);%>
        <table border="1">
            <tr> 
                <th>写真</th><br>
            <th>名前</th><br>
            <th>値段</th><br>
            <th>説明文</th><br>

            </tr>
            <tr>

                <td><img src="<%=yi.getImage()%>"></td><br>
            <td><%=yi.getName()%></td>
            <td><%=yi.getPrice()%>円</td><br>
            <td><%=yi.getDis()%></td><br>

            <td><form action="delete">
                    <input type="submit" value="削除"></form>>    
                </tr>

                <%}%>
                <%
                    int num = 0;
                    for (int i = 0; i < cart.size(); i++) {
                        GetAPI yi = cart.get(i);
                        num += yi.getPrice();
                    }
                    out.print(num);
                %>
        </table><br><br>
        　<form action="BuyConfirm" method="post">
            <input type="hidden" name="total"  value="<%=num%>">
            <input type="submit" value="購入"><br><br><br><br>
        </form>
        <a href ="top.jsp">トップに戻る</a>
    </body>
</html>
