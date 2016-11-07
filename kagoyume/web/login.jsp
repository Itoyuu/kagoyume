<%-- 
    Document   : login
    Created on : 2016/11/03, 14:18:26
    Author     : Yuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ログインページ</h1><br><br><br>
        ユーザー名とパスワードを入力<br><br>
        <form action="rogin" method="get">   
        ユーザー名:<input type="text" name="name"><br>
        パスワード:<input type="password" name ="password"><br><br>
        <input type="submit" value="ログイン"><br><br><br>
        </form>
        <h1>新規の方</h1>
        <form action="registration" method="get"><br><br>
        <input type="submit" value="新規登録ページ">
        </form>    
    </body>
</html>
