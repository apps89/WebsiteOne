package Fabryka;

import beans.Sport;

import java.util.List;

public interface SportInterfaceDAO {
    public List<Sport> readAll (int category);

}
