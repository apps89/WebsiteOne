package Fabryka;
import beans.User;

public interface UserInterfaceDAO {
    public boolean create(User user);
    public User read(String login);
  //  public boolean daily_update (User user);
    public boolean update( User user, int weight);
    public boolean delete(User user);
}