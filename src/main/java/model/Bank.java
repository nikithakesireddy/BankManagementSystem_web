package model;
import java.io.Serializable;
import java.util.Objects;

public class Bank implements Serializable{
	private static final long serialVersionUID = 1L;
    // Encapsulation
    private int accountNumber;
    private String accountHolderName;
    private long contactNumber;
    private String emailid;
    private double deposit;
    private double withdraw;
    private double balance;
    private String status;
    private static int totalnoofaccounts;

    // Overloading : Constructor 1
    public Bank(int accountNumber, String accountHolderName, long contactNumber, String emailid, double deposit, double withdraw) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.contactNumber = contactNumber;
        this.emailid = emailid;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.balance = calcTotalBalance();
        this.status = checkStatus();
    }

    // Overloading : Constructor 2
    public Bank(int accountNumber, String accountHolderName, long contactNumber, String emailid, double deposit, double withdraw, double balance, String status) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.contactNumber = contactNumber;
        this.emailid = emailid;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.balance = balance;
        this.status = status;
    }

    // Uniqueness in HashSet based strictly on accountNumber
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bank other = (Bank) obj;
        return accountNumber == other.accountNumber;
    }

    @Override
    public String toString() {
        return "Bank [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", contactNumber="
                + contactNumber + ", emailid=" + emailid + ", deposit=" + deposit + ", withdraw=" + withdraw
                + ", balance=" + balance + ", status=" + status + "]";
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getTotalnoofaccounts() {
        return totalnoofaccounts;
    }

    public static void setTotalnoofaccounts(int totalnoofaccounts) {
        Bank.totalnoofaccounts = totalnoofaccounts;
    }

    public void display() {
        System.out.println(toString());
    }

    public double calcTotalBalance() {
        balance = deposit - withdraw;
        return balance;
    }

    public String checkStatus() {
        if (balance < 0) {
            status = "Warning: Negative Balance!";
        } else if (balance == 0) {
            status = "Zero Balance!";
        } else {
            status = "Active";
        }
        return status;
    }
}