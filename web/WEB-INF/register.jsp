<%-- 
    Document   : register
    Created on : Feb 9, 2020, 11:56:20 AM
    Author     : 785284
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST">
            <input type="hidden" name="action" value="register" />
            Username: <input type="text" name="fldUsername" />
            <input type="submit" name="btnSubmit" value="Register name" />
        </form>
    </body>
</html>
