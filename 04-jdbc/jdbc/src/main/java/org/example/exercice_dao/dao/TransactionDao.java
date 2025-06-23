package org.example.exercice_dao.dao;

import org.example.exercice_dao.model.Account;
import org.example.exercice_dao.model.Customer;
import org.example.exercice_dao.model.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao extends BaseDao<Transaction> {


    public TransactionDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Transaction element) throws SQLException {
        request = "INSERT INTO transactions (bank_account_id, amount, status) VALUES (?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1 , element.getAccount().getId());
        statement.setDouble(2 , element.getAmount());
        statement.setString(2 , element.getStatus());

        int numRows  = statement.executeUpdate();
        result = statement.getGeneratedKeys();

        if (result.next()) element.setId(result.getInt(1));

        return numRows == 1;
    }

    @Override
    public boolean update(Transaction element) throws SQLException {
        request = "UPDATE transactions SET bank_account_id = ?, amount = ?, status = ? WHERE id = ?";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1 , element.getAccount().getId());
        statement.setDouble(2 , element.getAmount());
        statement.setString(3 , element.getStatus());
        statement.setInt(4 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public boolean delete(Transaction element) throws SQLException {
        request = "DELETE FROM transactions WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    public boolean deleteByAccount(Account element) throws SQLException {
        request = "DELETE FROM transactions WHERE bank_account_id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public Transaction getById(int id) throws SQLException {
        Transaction transaction = null;

        request = "SELECT * FROM transactions WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , id);

        result = statement.executeQuery();

        if(result.next()) {

            Account account = new AccountDao(connection).getById(result.getInt("id"));

            transaction = new Transaction(result.getInt("id"),
                    account,
                    result.getDouble("amount"),
                    result.getString("status"));
        }

        return transaction;
    }

    @Override
    public List<Transaction> getAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();

        request = "SELECT * FROM transactions";

        statement = connection.prepareStatement(request);
        result = statement.executeQuery();

        while (result.next()) {
            Account account = new AccountDao(connection).getById(result.getInt("id"));
            Transaction transaction = new Transaction(result.getInt("id"),
                    account,
                    result.getDouble("amount"),
                    result.getString("status")
            );
            transactions.add(transaction);
        }

        return transactions;
    }
}
