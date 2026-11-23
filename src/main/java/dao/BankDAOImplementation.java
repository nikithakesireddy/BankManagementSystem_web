package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import model.Bank;

public class BankDAOImplementation implements BankDAOInterface {

    private Connection con;
    private Statement st;

    public Statement getMyStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thirdbatchdb?serverTimezone=UTC", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public void closingStatement() {
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add(Bank account) {
        if (account == null) return 0;
        st = getMyStatement();
        int result = 0;

        if (st == null) return 0;

        try {
            String sql = "INSERT INTO account VALUES("
                    + account.getAccountNumber() + ", "
                    + "'" + account.getAccountHolderName() + "', "
                    + account.getContactNumber() + ", "
                    + "'" + account.getEmailid() + "', "
                    + account.getDeposit() + ", "
                    + account.getWithdraw() + ", "
                    + account.getBalance() + ", "
                    + "'" + account.getStatus() + "')";

            result = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closingStatement();
        }

        return result;
    }

    @Override
    public int delete(Bank account) {
        if (account == null) return 0;
        st = getMyStatement();
        int result = 0;

        if (st == null) return 0;

        try {
            String sql = "DELETE FROM account WHERE account_number = " + account.getAccountNumber();
            result = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closingStatement();
        }

        return result;
    }

    @Override
    public int update(Bank account) {
        if (account == null) return 0;
        st = getMyStatement();
        int result = 0;

        if (st == null) return 0;

        try {
            String sql = "UPDATE account SET "
                    + "account_holder_name = '" + account.getAccountHolderName() + "', "
                    + "contact_number = " + account.getContactNumber() + ", "
                    + "emailid = '" + account.getEmailid() + "', "
                    + "deposit = " + account.getDeposit() + ", "
                    + "withdraw = " + account.getWithdraw() + ", "
                    + "balance = " + account.getBalance() + ", "
                    + "status = '" + account.getStatus() + "' "
                    + "WHERE account_number = " + account.getAccountNumber();

            result = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closingStatement();
        }

        return result;
    }

    @Override
    public Bank display(int id) {
        st = getMyStatement();
        Bank account = null;
        ResultSet rs = null;

        if (st == null) return null;

        try {
            rs = st.executeQuery("SELECT * FROM account WHERE account_number = " + id);
            if (rs.next()) {
                account = new Bank(
                    rs.getInt("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getLong("contact_number"),
                    rs.getString("emailid"),
                    rs.getDouble("deposit"),
                    rs.getDouble("withdraw"),
                    rs.getDouble("balance"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closingStatement();
        }

        return account;
    }

    @Override
    public HashSet<Bank> display() {
        HashSet<Bank> accounts = new HashSet<>();
        st = getMyStatement();
        ResultSet rs = null;

        if (st == null) return accounts;

        try {
            rs = st.executeQuery("SELECT * FROM account");
            while (rs.next()) {
                Bank account = new Bank(
                    rs.getInt("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getLong("contact_number"),
                    rs.getString("emailid"),
                    rs.getDouble("deposit"),
                    rs.getDouble("withdraw"),
                    rs.getDouble("balance"),
                    rs.getString("status")
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closingStatement();
        }

        return accounts;
    }

    @Override
    public int totalNoOfAccounts() {
        st = getMyStatement();
        int count = 0;
        ResultSet rs = null;

        if (st == null) return 0;

        try {
            rs = st.executeQuery("SELECT COUNT(*) FROM account");
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closingStatement();
        }

        return count;
    }
}