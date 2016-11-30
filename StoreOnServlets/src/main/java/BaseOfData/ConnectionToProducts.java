package BaseOfData;

import BaseOfData.entitys.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nikk on 14.11.2015.
 */
public class ConnectionToProducts {

    public static boolean add(Product pr){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * from products where pet ='" + pr.getPet() +
                    "' and category =  '" + pr.getTypeOfProduct() + "' and nazvanie = '" + pr.getNameOfProduct() +
                    "'and discription = '" + pr.getDescription() + "' and price = '" + pr.getPrice()+ "';";
            resultSet = statement.executeQuery(sql);

            if (!resultSet.next()) {
                Random random = new Random();
                pr.setId(random.nextInt(10000));
                sql = "select id from products where id = " + pr.getId() + ";";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    pr.setId(random.nextInt(10000));
                }
                sql = "insert into products(pet, category, nazvanie, discription, price, id, image) VALUES ('" + pr.getPet() + "', '" +
                        pr.getTypeOfProduct() + "', '" + pr.getNameOfProduct() + "', '" + pr.getDescription() + "', '" +
                        pr.getPrice()+ "'," + pr.getId() + ", '"+ pr.getImage() + "');";
                statement.executeUpdate(sql);
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

    public static void remove(int id){
        Connection connection;
        Statement statement;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "delete from products where id = " + id + ";";
            statement.executeUpdate(sql);
            statement.close();
            ConnectionToComments.remove(id);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Product getProduct(int idProduct){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * from products where id = " + idProduct + ";";
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            String pet = resultSet.getString(1);
            String type = resultSet.getString(2);
            String name = resultSet.getString(3);
            String discription = resultSet.getString(4);
            String price = resultSet.getString(5);
            String image = resultSet.getString(7);
            Product product = new Product(pet, type, name, discription, price, idProduct, image);
            statement.close();
            return product;

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Product> getProducts(){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "select * from products";
            resultSet = statement.executeQuery(sql);
            ArrayList<Product> arrayList = new ArrayList<Product>();
            while (resultSet.next()){
                String pet = resultSet.getString(1);
                String type = resultSet.getString(2);
                String name = resultSet.getString(3);
                String discription = resultSet.getString(4);
                String price = resultSet.getString(5);
                String image = resultSet.getString(7);
                int id = resultSet.getInt(6);
                Product product = new Product(pet, type, name, discription, price, id, image);
                arrayList.add(product);
            }
            return arrayList;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean update(Product pr){
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * from products where pet ='" + pr.getPet() +
                    "' and category =  '" + pr.getTypeOfProduct() + "' and nazvanie = '" + pr.getNameOfProduct() +
                    "'and discription = '" + pr.getDescription() + "' and price = '" + pr.getPrice()+ "';";
            resultSet = statement.executeQuery(sql);

            if (!resultSet.next()) {
                sql = "update products set pet = '" + pr.getPet() + "', category = '" + pr.getTypeOfProduct() + "'," +
                        "nazvanie = '" + pr.getNameOfProduct() + "', discription = '" + pr.getDescription() + "'," +
                        "price = " + pr.getPrice() + "image = " + pr.getImage() + " where id = " + pr.getId() + ";";
                statement.executeUpdate(sql);
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
