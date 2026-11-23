<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set, java.util.HashSet, model.Bank, service.BankServiceImpl, service.BankServiceInterface" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Dashboard</title>
</head>
<body>
    <h2>BANK MANAGEMENT SYSTEM - DASHBOARD</h2>
    <%
        BankServiceInterface service = new BankServiceImpl();
        int totalAccounts = service.totalNoOfAccounts();
        String searchId = request.getParameter("searchId");
        Set<Bank> accounts = new HashSet<>();

        if (searchId != null && !searchId.trim().isEmpty()) {
            Bank found = service.display(Integer.parseInt(searchId.trim()));
            if (found != null) {
                accounts.add(found);
            }
        } else {
            accounts = service.display();
        }
    %>
    <p><strong>Total Accounts:</strong> <%= totalAccounts %></p>

    <p>
        <a href="addaccount.jsp">+ Add New Account</a> |
        <a href="main.jsp">Show All Accounts</a> |
        <a href="login.jsp">Logout</a>
    </p>

    <form action="main.jsp" method="get">
        Search Account Number:
        <input type="number" name="searchId" value="<%= (searchId != null) ? searchId : "" %>">
        <input type="submit" value="Search">
    </form>
    <br>

    <table border="1" cellpadding="6" cellspacing="0">
        <tr>
            <th>Account No</th>
            <th>Holder Name</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Deposit</th>
            <th>Withdraw</th>
            <th>Balance</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <% for (Bank b : accounts) { %>
        <tr>
            <td><%= b.getAccountNumber() %></td>
            <td><%= b.getAccountHolderName() %></td>
            <td><%= b.getContactNumber() %></td>
            <td><%= b.getEmailid() %></td>
            <td><%= b.getDeposit() %></td>
            <td><%= b.getWithdraw() %></td>
            <td><%= b.getBalance() %></td>
            <td><%= b.getStatus() %></td>
            <td>
                <a href="updateaccount.jsp?id=<%= b.getAccountNumber() %>">Update</a> |
                <a href="DeleteAccountServlet?id=<%= b.getAccountNumber() %>" onclick="return confirm('Delete this account?');">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>