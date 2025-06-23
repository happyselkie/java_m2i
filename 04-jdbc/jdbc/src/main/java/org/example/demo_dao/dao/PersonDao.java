package org.example.demo_dao.dao;

import org.example.demo_dao.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends BaseDao<Person> {


    public PersonDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Person element) throws SQLException {
        request = "INSERT INTO users (firstname, lastname) VALUES (?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1 , element.getFirstname());
        statement.setString(2 , element.getLastname());

        int numRows  = statement.executeUpdate();
        result = statement.getGeneratedKeys();

        if (result.next()) element.setId(result.getInt(1));

        return numRows == 1;
    }

    @Override
    public boolean update(Person element) throws SQLException {
        request = "UPDATE users SET firstname = ?, lastname = ? WHERE id = ?";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1 , element.getFirstname());
        statement.setString(2 , element.getLastname());
        statement.setInt(3 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public boolean delete(Person element) throws SQLException {
        request = "DELETE FROM users WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(3 , element.getId());

        int numRows  = statement.executeUpdate();

        return numRows == 1;
    }

    @Override
    public Person get(int id) throws SQLException {
        Person person = null;

        request = "SELECT * FROM users WHERE id = ?";

        statement = connection.prepareStatement(request);
        statement.setInt(3 , id);

        result = statement.executeQuery();

        if(result.next()) {
            person = new Person(result.getInt("id"),
                    result.getString("firstname"),
                    result.getString("lastname"));
        }

        return person;
    }

    @Override
    public List<Person> get() throws SQLException {
        List<Person> persons = new ArrayList<>();

        request = "SELECT * FROM users";

        statement = connection.prepareStatement(request);
        result = statement.executeQuery();

        while(result.next()) {
            Person person = new Person(result.getInt("id"),
                    result.getString("firstname"),
                    result.getString("lastname"));
            persons.add(person);
        }

        return persons;
    }
}
