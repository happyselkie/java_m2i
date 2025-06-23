package org.example.exercice_dao.service;

import org.example.demo_dao.util.DatabaseManager;
import org.example.exercice_dao.dao.AccountDao;
import org.example.exercice_dao.dao.CustomerDao;
import org.example.exercice_dao.dao.TransactionDao;
import org.example.exercice_dao.model.Account;
import org.example.exercice_dao.model.Customer;
import org.example.exercice_dao.model.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankService {

    private CustomerDao customerDao;
    private AccountDao accountDao;
    private TransactionDao transactionDao;
    private Connection connection;


    public BankService() {
        try{
            connection = new DatabaseManager().getConnection();
            customerDao =  new CustomerDao(connection);
            accountDao =  new AccountDao(connection);
            transactionDao =  new TransactionDao(connection);
        } catch (SQLException e){
            System.out.println("Connexion impossible : "+e.getMessage());
        }
    }

    public boolean createCustomer(String firstname, String lastname, String phone){
        Customer customer = new Customer(firstname, lastname, phone);

        try{
            if(customerDao.save(customer)) {
                this.createAccount(customer, 0.0);
                return true;
            }
        } catch (SQLException e){
            System.out.println("Impossible d'enregistrer : "+e.getMessage());
        }
        return false;
    }

    public boolean updateCustomer(Customer customer){
        try{
            if(customerDao.update(customer)) return true;
        } catch (SQLException e){
            System.out.println("Impossible de modifier : "+e.getMessage());
        }
        return false;
    }

    public Customer getCustomer(int id){
        try{
            return customerDao.getById(id);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCustomer(int id){
        Customer customer = null;
        try{
            customer = customerDao.getById(id);
            if(customer != null) {
                accountDao.deleteByCustomer(customer);
                return customerDao.delete(customer);
            }
        } catch (SQLException e){
            System.out.println("Impossible de supprimer : "+e.getMessage());
        }
        return false;
    }


    public List<Customer> getAllCustomer(){
        try {
            return customerDao.getAll();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean createAccount(Customer customer, double balance){
        Account account = new Account(customer, balance);

        try{
            if(accountDao.save(account)) return true;
        } catch (SQLException e){
            System.out.println("Impossible d'enregistrer : "+e.getMessage());
        }
        return false;
    }

    public boolean updateAccount(Account account){
        try{
            if(accountDao.update(account)) return true;
        } catch (SQLException e){
            System.out.println("Impossible de modifier : "+e.getMessage());
        }
        return false;
    }

    public Account getAccount(int id){
        try{
            return accountDao.getById(id);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteAccount(int id){
        Account account = null;
        try{
            account = accountDao.getById(id);
            if(account != null) {
                this.deleteTransactionByAccount(account);
                return accountDao.delete(account);
            }
        } catch (SQLException e){
            System.out.println("Impossible de supprimer : "+e.getMessage());
        }
        return false;
    }

    public boolean deleteAccountByCustomer(Customer customer){
        List<Account> accounts = getAccountsByCustomer(customer);
        try{
            if(accountDao.deleteByCustomer(customer)) {
                for (Account account : accounts){
                    this.deleteTransactionByAccount(account);
                }
                return true;
            }
        } catch (SQLException e){
            System.out.println("Impossible de supprimer : "+e.getMessage());
        }
        return false;
    }

    public List<Account> getAccountsByCustomer(Customer customer){
        try {
            return accountDao.getByCustomer(customer);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Account> getAllAccount(){
        try {
            return accountDao.getAll();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean createTransaction(Account account, double amount, String status){
        Transaction transaction = new Transaction(account, amount, status);

        try{
            if(transactionDao.save(transaction)) return true;
        } catch (SQLException e){
            System.out.println("Impossible d'enregistrer : "+e.getMessage());
        }
        return false;
    }

    public boolean updateTransaction(Transaction transaction){
        try{
            if(transactionDao.update(transaction)) return true;
        } catch (SQLException e){
            System.out.println("Impossible de modifier : "+e.getMessage());
        }
        return false;
    }

    public Transaction getTransaction(int id){
        try{
            return transactionDao.getById(id);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteTransaction(int id){
        Transaction transaction = null;
        try{
            transaction = transactionDao.getById(id);
            if(transaction != null) return transactionDao.delete(transaction);
        } catch (SQLException e){
            System.out.println("Impossible de supprimer : "+e.getMessage());
        }
        return false;
    }

    public boolean deleteTransactionByAccount(Account account){
        try{
            if(transactionDao.deleteByAccount(account)) return true;
        } catch (SQLException e){
            System.out.println("Impossible de modifier : "+e.getMessage());
        }
        return false;
    }

    public List<Transaction> getAllTransaction(){
        try {
            return transactionDao.getAll();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
