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

public class DeleteAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BankServiceInterface service = new BankServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int accNo = Integer.parseInt(request.getParameter("id"));
        Bank account = new Bank(accNo, "", 0L, "", 0.0, 0.0);
        service.delete(account);

        response.sendRedirect("main.jsp");
    }
}