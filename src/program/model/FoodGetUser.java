package program.model;

public class FoodGetUser {

    private String username;
    private String email;
    private String password;
    private int money;

    public FoodGetUser(String username, String email, String password, int money) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }
}
