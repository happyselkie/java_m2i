package org.example.exercice_dao.dao;

import org.example.exercice_dao.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDao<Customer>{

    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        request = "INSERT INTO customer (firstname, lastname, phone) VALUES (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1 , element.getFirstname());
        statement.setString(2 , element.getLastname());
        statement.setString(3 , element.getPhone());

        int numRows  = statement.executeUpdate();
        result = statement.getGeneratedKeys();

        if (result.next()) element.setId(result.getInt(1));

        return numRows == 1;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        request = "UPDATE customer SET firstname = ?, lastname = ?, phone = ? WHERE id = ?";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1 , element.getFirstname());
        statement.setString(2 , element.getLastname());
        statement.setString(3 , element.getPhone());
        statement.setInt(4 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public boolean delete(Customer element) throws SQLException {
        request = "DELETE FROM customer WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public Customer getById(int id) throws SQLException {
        Customer customer = null;

        request = "SELECT * FROM customer WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(1 , id);

        result = statement.executeQuery();

        if(result.next()) {
            customer = new Customer(result.getInt("id"),
                    result.getString("firstname"),
                    result.getString("lastname"),
                    result.getString("phone"));
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        request = "SELECT * FROM customer";

        statement = connection.prepareStatement(request);
        result = statement.executeQuery();

        while(result.next()) {
            Customer customer = new Customer(result.getInt("id"),
                    result.getString("firstname"),
                    result.getString("lastname"),
                    result.getString("phone"));
            customers.add(customer);
        }

        return customers;
    }
}
