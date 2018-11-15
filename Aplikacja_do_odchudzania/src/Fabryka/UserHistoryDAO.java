package Fabryka;

import beans.User;
import beans.UserHistory;
import provider.ConnectionProv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHistoryDAO implements UserHistoryInterfaceDAO {
    private final static String CREATE = "INSERT INTO history VALUES(?, ?, ?, ?);";
    private final static String READ = "SELECT  login, date, opis, weight FROM history WHERE login = ?;";
    private  final static  String READALL = "SELECT login, date, opis, weight  From history WHERE login = ?;";

    private void release(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(UserHistory userHistory) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean results = false;

        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, userHistory.getLogin());
            preparedStatement.setString(2, userHistory.getDate());
            preparedStatement.setString(3, userHistory.getDescribe());
            preparedStatement.setString(4, userHistory.getWeight());
            int rows = preparedStatement.executeUpdate();
            if(rows > 0) {
                results = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(preparedStatement, null, connection);
        }
        return results;
    }

    @Override
    public UserHistory read(String login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserHistory resluts = null;
        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(READ);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                resluts = new UserHistory();
                resluts.setLogin(resultSet.getString("login"));
                resluts.setDate(resultSet.getString("date"));
                resluts.setDescribe(resultSet.getString("opis"));
                resluts.setWeight(resultSet.getString("weight"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, resultSet, connection);
        }
        return  resluts;
    }


    @Override
    public List<UserHistory> readAll (String login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserHistory resluts = null;
        List<UserHistory> userHistoryList = new ArrayList<>();
        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(READALL);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resluts = new UserHistory();
                resluts.setLogin(resultSet.getString("login"));
                resluts.setDate(resultSet.getString("date"));
                resluts.setDescribe(resultSet.getString("opis"));
                resluts.setWeight(resultSet.getString("weight"));
                userHistoryList.add(resluts);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, resultSet, connection);
        }
        return  userHistoryList;
    }
}