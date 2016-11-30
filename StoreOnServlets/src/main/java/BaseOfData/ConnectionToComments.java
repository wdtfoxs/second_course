package BaseOfData;

import BaseOfData.entitys.Comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by nikk on 30.11.2015.
 */
public class ConnectionToComments {

    public static void addComment(String login, int id, String comment){
        Connection connection;
        Statement statement;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "insert into comments (login, id, comment) values('" + login +"'," + id +", '" + comment +"');";
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getComments(int id){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "select * from comments where id=" + id +";";
            resultSet = statement.executeQuery(sql);
            ArrayList<Comment> arrayList = new ArrayList<Comment>();
            while (resultSet.next()){
                String login = resultSet.getString(1);
                String comment = resultSet.getString(3);
                Comment comments = new Comment(login, id, comment);
                arrayList.add(comments);
            }
            return arrayList;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void remove(int id){
        Connection connection;
        Statement statement;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "delete from comments where id = " + id + ";";
            statement.executeUpdate(sql);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
