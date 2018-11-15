package Fabryka;

import beans.Supper;

import java.util.List;

public interface SupperInterfaceDAO {
    public List<Supper> readAll (int category);
}
