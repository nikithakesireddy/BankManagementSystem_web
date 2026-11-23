<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Bank, service.BankServiceImpl, service.BankServiceInterface" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        BankServiceInterface service = new BankServiceImpl();
        Bank b = service.display(id);
    %>
    <h2>Update Account #<%= b.getAccountNumber() %></h2>
    <form action="UpdateAccountServlet" method="post">
        <input type="hidden" name="accountNumber" value="<%= b.getAccountNumber() %>">
        <table>
            <tr><td>Account Holder Name:</td><td><input type="text" name="accountHolderName" value="<%= b.getAccountHolderName() %>" required></td></tr>
            <tr><td>Contact Number:</td><td><input type="number" name="contactNumber" value="<%= b.getContactNumber() %>" required></td></tr>
            <tr><td>Email ID:</td><td><input type="email" name="emailid" value="<%= b.getEmailid() %>" required></td></tr>
            <tr><td>Total Deposit:</td><td><input type="number" step="0.01" name="deposit" value="<%= b.getDeposit() %>" required></td></tr>
            <tr><td>Total Withdraw:</td><td><input type="number" step="0.01" name="withdraw" value="<%= b.getWithdraw() %>" required></td></tr>
            <tr>
                <td><a href="main.jsp">Cancel</a></td>
                <td><input type="submit" value="Save Changes"></td>
            </tr>
        </table>
    </form>
</body>
</html>