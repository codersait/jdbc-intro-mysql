package com.codersait;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("delete from Persons where PersonID = 2221011");
            statement.executeUpdate();
            System.out.println("Kayit Silindi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Persons");
            List<Person> persons = new ArrayList<>();
            while (resultSet.next()) {
                persons.add(new Person(
                        resultSet.getString("FirstName"),
                        resultSet.getString("Lastname"),
                        resultSet.getInt("PersonID"),
                        resultSet.getString("City"),
                        resultSet.getString("Address")
                ));
            }
            persons.forEach(item -> System.out.println(item.getFirstName()));
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public static void insertDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("INSERT INTO Persons(PersonID,FirstName,Lastname,City,Address) VALUES (?,?,?,?,?)");
            statement.setInt(1,2221095);
            statement.setString(2,"Salih");
            statement.setString(3,"Gulec");
            statement.setString(4,"Ankara");
            statement.setString(5,"macunkoy");
            statement.executeUpdate();
            System.out.println("Kayit Eklendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
    public static void updateDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement("update Persons set Lastname = 'veli',Address='erbil' where PersonID = ?");
            statement.setInt(1,2221034);
            statement.executeUpdate();
            System.out.println("Kayit Guncellendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
