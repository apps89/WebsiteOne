package Fabryka;

import beans.Sport;
import beans.Supper;
import provider.ConnectionProv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportDAO implements SportInterfaceDAO {
    private static final String READALL = "SELECT * From cwiczenia WHERE kategoria = ?;";


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
    public List<Sport> readAll(int category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Sport resluts = null;
        List<Sport> sportArrayList = new ArrayList<>();
        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(READALL);
            preparedStatement.setInt(1, category);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resluts = new Sport();
                resluts.setDescribe(resultSet.getString("opis"));
                resluts.setCalories(resultSet.getInt("spalone_kalorie"));
               sportArrayList.add(resluts);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, resultSet, connection);
        }
        return sportArrayList;
    }
}
