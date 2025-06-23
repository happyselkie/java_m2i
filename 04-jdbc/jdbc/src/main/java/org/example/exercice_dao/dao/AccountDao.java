package org.example.exercice_dao.dao;

import org.example.exercice_dao.model.Account;
import org.example.exercice_dao.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends BaseDao<Account> {

    public AccountDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Account element) throws SQLException {
        request = "INSERT INTO bank_account (customer_id, balance) VALUES (?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1 , element.getCustomer().getId());
        statement.setDouble(2 , element.getBalance());

        int numRows  = statement.executeUpdate();
        result = statement.getGeneratedKeys();

        if (result.next()) element.setId(result.getInt(1));

        return numRows == 1;
    }

    @Override
    public boolean update(Account element) throws SQLException {
        request = "UPDATE bank_account SET customer_id = ?, balance = ? WHERE id = ?";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1 , element.getCustomer().getId());
        statement.setDouble(2 , element.getBalance());
        statement.setInt(3 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public boolean delete(Account element) throws SQLException {
        request = "DELETE FROM bank_account WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    public boolean deleteByCustomer(Customer element) throws SQLException {
        request = "DELETE FROM bank_account WHERE id_customer = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public Account getById(int id) throws SQLException {
        Account account = null;

        request = "SELECT * FROM bank_account WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , id);

        result = statement.executeQuery();

        if(result.next()) {

            Customer customer = new CustomerDao(connection).getById(result.getInt("id"));

            account = new Account(result.getInt("id"),
                    customer,
                    result.getDouble("balance"));
        }

        return account;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> accounts = new ArrayList<>();

        request = "SELECT * FROM bank_account";

        statement = connection.prepareStatement(request);
        result = statement.executeQuery();

        while(result.next()) {
            Customer customer = new CustomerDao(connection).getById(result.getInt("id"));
            Account account = new Account(result.getInt("id"),
                    customer,
                    result.getDouble("balance"));
            accounts.add(account);
        }

        return accounts;
    }

    public List<Account> getByCustomer(Customer customer) throws SQLException {
        List<Account> accounts = new ArrayList<>();

        request = "SELECT * FROM bank_account WHERE id_customer = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , customer.getId());
        result = statement.executeQuery();

        while(result.next()) {
            Account account = new Account(result.getInt("id"),
                    customer,
                    result.getDouble("balance"));
            accounts.add(account);
        }

        return accounts;
    }
}
