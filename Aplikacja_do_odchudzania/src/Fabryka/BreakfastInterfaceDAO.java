package Fabryka;

import beans.Breakfast;
import beans.UserHistory;

import java.util.List;

public interface BreakfastInterfaceDAO{
    public List<Breakfast> readAll (int category);

}
