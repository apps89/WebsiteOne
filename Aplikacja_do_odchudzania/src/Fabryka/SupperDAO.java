package Fabryka;

import beans.Supper;
import provider.ConnectionProv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupperDAO implements SupperInterfaceDAO {
    private  final static  String READALL = "SELECT * From kolacja WHERE kategoria = ?;";


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
    public List<Supper> readAll(int category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Supper resluts = null;
        List<Supper> supperArrayList= new ArrayList<>();
        try {
            connection = ConnectionProv.getConnection();
            preparedStatement = connection.prepareStatement(READALL);
            preparedStatement.setInt(1, category);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resluts = new Supper();
                resluts.setId(resultSet.getInt("id"));
                resluts.setName(resultSet.getString("nazwa"));
                resluts.setDescriptions(resultSet.getString("opis"));
                resluts.setCost(resultSet.getInt("koszt"));
                resluts.setIngredients(resultSet.getString("skladniki"));
                resluts.setCalory(resultSet.getInt("kalorie"));
                resluts.setCategory(resultSet.getInt("kategoria"));
                supperArrayList.add(resluts);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            release(preparedStatement, resultSet, connection);
        }
        return supperArrayList;
    }
}



