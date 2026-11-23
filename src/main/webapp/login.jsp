<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Login</title>
</head>
<body>
    <h2>BANK MANAGEMENT SYSTEM</h2>
    <h3>Login Here</h3>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="LoginServlet" method="post">
        <table>
            <tr>
                <td>Enter username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Enter password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
</body>
</html>