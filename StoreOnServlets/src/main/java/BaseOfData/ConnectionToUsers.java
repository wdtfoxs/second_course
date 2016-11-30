package BaseOfData;

import BaseOfData.entitys.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by nikk on 15.11.2015.
 */
public class ConnectionToUsers {

    public static boolean registrationUser(User user) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "select login from users where login = '" + user.getLogin() + "';";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                statement.close();
                return false;
            }
            sql = "select email from users where email = '" + user.getEmail() + "';";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                statement.close();
                return false;
            }
            sql = "INSERT into users(login, password, email) VALUES ('" + user.getLogin() + "', '" + user.getPassword()
                    + "', '" + user.getEmail() + "');";
            statement.executeUpdate(sql);
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean loginUser(User user){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "select login, password from users where login = '" +  user.getLogin() + "' and password = '"
                    + user.getPassword() + "';";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                statement.close();
                return true;
            }
            else {
                statement.close();
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
}
