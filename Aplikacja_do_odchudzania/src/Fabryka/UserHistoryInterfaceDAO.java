package Fabryka;

import beans.User;
import beans.UserHistory;

import java.util.List;

public interface UserHistoryInterfaceDAO {
    public boolean create(UserHistory userHistory);
    public UserHistory read(String login);
    public List<UserHistory> readAll (String login);
}
