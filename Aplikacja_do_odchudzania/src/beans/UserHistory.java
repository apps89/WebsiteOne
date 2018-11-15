package beans;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UserHistory {
    private String login;
    private String date;
    private String describe;
    private String weight;

    public UserHistory () {

    }

    public UserHistory (String login, String describe, LocalDate localDate, String weight ){
        this.login = login;
        this.date = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.describe = describe;
        this.weight = weight;
    }

    public String getLogin() {
        return login;
    }

    public String getDescribe() {
        return describe;
    }

    public String getDate() {
        return date;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Twoja historia diety" +
                ", data='" + date + '\'' +
                ", opis='" + describe + '\'' +
                ", waga='" + weight + '\'' +
                '}';
    }
}
