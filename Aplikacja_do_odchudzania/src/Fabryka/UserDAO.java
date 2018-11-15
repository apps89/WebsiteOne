package Fabryka;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import beans.User;
import Fabryka.UserInterfaceDAO;
import beans.UserHistory;
import provider.ConnectionProv;
import change.responsibility.*;


public class UserDAO implements UserInterfaceDAO{
    private final static String CREATE = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?,?, ?, ?);";
    private final static String READ = "SELECT  login,pass, height, weight, age, category FROM user WHERE login = ?;";
    private final static String UPDATE = "UPDATE user SET weight=? WHERE login = ?;";
    private final static String DELETE = "DELETE FROM user WHERE login=?;";


    private void release ( PreparedStatement preparedStatement, ResultSet resultSet, Connection connection ){
        try{
            if(resultSet != null && !resultSet.isClosed()){
                resultSet.close();
            }
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean create (User user) {
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       boolean results = false;
       SelectCategory selectCategory = new SelectCategory();
       int myCategory = selectCategory.chosse(user.getSex(), user.getHeight(),user.getWeight());
       try {
           connection = ConnectionProv.getConnection();
           preparedStatement = connection.prepareStatement(CREATE);
           preparedStatement.setString(1, user.getLogin());
           preparedStatement.setString(2, user.getPass());
           preparedStatement.setString(3, user.getEmail());
           preparedStatement.setString(4, user.getAge());
           preparedStatement.setString(5, user.getHeight());
           preparedStatement.setString(6, user.getWeight());
           preparedStatement.setString(7, user.getSex());
           preparedStatement.setInt(8, myCategory);
           preparedStatement.setInt(9, 1);
           int rows = preparedStatement.executeUpdate();
           FabrykaDAO fabrykaDAO = FabrykaDAO.getFaktoryDAO(FabrykaDAO.anInt);
           UserHistoryDAO userHistoryDAO = fabrykaDAO.getUserHistoryDAO();
           UserHistory userHistory = new UserHistory(user.getLogin(), "Witamy w naszej aplikacji, miejmy nadzieje ze bedziesz zadowolony",
                   LocalDate.now(), user.getWeight());
           userHistoryDAO.create(userHistory);

           if(rows > 0) {
               results = true;
           }
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           release(preparedStatement,null, connection );
       }
       return results;
    }

    @Override
    public User read(String login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User resluts = null;
        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(READ);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                resluts = new User();
                resluts.setLogin(resultSet.getString("login"));
                resluts.setAge(resultSet.getString("age"));
                resluts.setWeight(resultSet.getString("weight"));
                resluts.setPass(resultSet.getString("pass"));
                resluts.setCategory(resultSet.getInt("category"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, resultSet, connection);
        }
        return  resluts;
    }

    @Override
    public boolean update(User user, int weight) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean results = false;
        try{
            connection= ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, weight );
            preparedStatement.setString(2, user.getLogin());
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                results = true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, null, connection);
        }
        return results;
    }

    @Override
    public boolean delete(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean resluts = false;
        try{
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, user.getLogin());
            int rows = preparedStatement.executeUpdate();
            if(rows > 0 ){
                resluts = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, null, connection);
        }
        return resluts;
    }
}
