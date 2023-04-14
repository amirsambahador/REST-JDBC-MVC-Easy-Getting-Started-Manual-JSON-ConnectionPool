package org.j2os.project.repository;

import org.j2os.project.common.exception.RecordNotExistException;
import org.j2os.project.common.jdbc.ConnectionProvider;
import org.j2os.project.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.j2os.project.common.jdbc.ConnectionProvider.ORACLE_XE;

public class PersonRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonRepository() throws Exception {
        connection = ConnectionProvider.getConnection(ORACLE_XE);
        connection.setAutoCommit(false);
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select person_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("id"));
        preparedStatement = connection.prepareStatement("insert into person (id,name,family,salary) values (?,?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setLong(4, person.getSalary());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set name=?, family=?, salary=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getSalary());
        preparedStatement.setLong(4, person.getId());
        preparedStatement.executeUpdate();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("family"), resultSet.getLong("salary"));
            personList.add(person);
        }
        return personList;
    }

    public Person selectOne(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select * from person where id=?");
        preparedStatement.setLong(1, person.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return new Person(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("family"), resultSet.getLong("salary"));
        throw new RecordNotExistException();
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
