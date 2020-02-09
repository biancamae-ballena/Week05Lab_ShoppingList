<%-- 
    Document   : shoppingList
    Created on : Feb 9, 2020, 11:56:34 AM
    Author     : 785284
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><b>Shopping List</b></h1>
        <form method="POST" action="shoppingList">
        Hello, ${username}
        <a href>Logout</a>
        <h2><b>List</b></h2>
        Add Item: <input type="text" name="item"/>
        <button type="submit" name="addItem">Add</button>
        </form>
    </body>
</html>
