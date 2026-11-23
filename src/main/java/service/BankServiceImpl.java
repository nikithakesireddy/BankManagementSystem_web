package service;

import java.util.Set;

import dao.BankDAOImplementation;
import dao.BankDAOInterface;
import model.Bank;

public class BankServiceImpl implements BankServiceInterface {

    private final BankDAOInterface bdao = new BankDAOImplementation();

    @Override
    public int add(Bank a) {
        return bdao.add(a);
    }

    @Override
    public int delete(Bank a) {
        return bdao.delete(a);
    }

    @Override
    public int update(Bank a) {
        return bdao.update(a);
    }

    @Override
    public Bank display(int id) {
        return bdao.display(id);
    }

    @Override
    public Set<Bank> display() {
        return bdao.display();
    }

    @Override
    public int totalNoOfAccounts() {
        return bdao.totalNoOfAccounts();
    }
}