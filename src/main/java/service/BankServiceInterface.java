package service;

import java.util.Set;

import model.Bank;

public interface BankServiceInterface 
{
    int add(Bank a);
    int delete(Bank a);
    int update(Bank a);
    Bank display(int id);
    Set<Bank> display();
    int totalNoOfAccounts();
}