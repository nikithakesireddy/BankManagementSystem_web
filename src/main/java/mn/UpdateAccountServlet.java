package mn;

import java.io.IOException;
import model.Bank;
import service.BankServiceImpl;
import service.BankServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BankServiceInterface service = new BankServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int accNo = Integer.parseInt(request.getParameter("accountNumber"));
        String name = request.getParameter("accountHolderName");
        long contact = Long.parseLong(request.getParameter("contactNumber"));
        String email = request.getParameter("emailid");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double withdraw = Double.parseDouble(request.getParameter("withdraw"));

        Bank account = new Bank(accNo, name, contact, email, deposit, withdraw);
        service.update(account);

        response.sendRedirect("main.jsp");
    }
}