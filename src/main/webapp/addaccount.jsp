<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
</head>
<body>
    <h2>Open New Bank Account</h2>
    <form action="AddAccountServlet" method="post">
        <table>
            <tr><td>Account Number:</td><td><input type="number" name="accountNumber" required></td></tr>
            <tr><td>Account Holder Name:</td><td><input type="text" name="accountHolderName" required></td></tr>
            <tr><td>Contact Number:</td><td><input type="number" name="contactNumber" required></td></tr>
            <tr><td>Email ID:</td><td><input type="email" name="emailid" required></td></tr>
            <tr><td>Deposit Amount:</td><td><input type="number" step="0.01" name="deposit" value="0" required></td></tr>
            <tr><td>Withdraw Amount:</td><td><input type="number" step="0.01" name="withdraw" value="0" required></td></tr>
            <tr>
                <td><a href="main.jsp">Cancel</a></td>
                <td><input type="submit" value="Create Account"></td>
            </tr>
        </table>
    </form>
</body>
</html>