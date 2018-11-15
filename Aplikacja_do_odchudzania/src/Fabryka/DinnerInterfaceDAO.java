package Fabryka;

import beans.Dinner;

import java.util.List;

public interface DinnerInterfaceDAO {

    public List <Dinner> readAll (int category);
}
