package dao;

import java.util.HashSet;

import model.Bank;

public interface BankDAOInterface 
{
    int add(Bank account);
    int delete(Bank account);
    int update(Bank account);
    Bank display(int accountNumber);
    HashSet<Bank> display();
    int totalNoOfAccounts();
}