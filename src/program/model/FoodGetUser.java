package program.model;

import java.util.ArrayList;
import java.util.List;

public class FoodGetUser {

    private String username;
    private String email;
    private String password;
    private List<ProductModel> history;
    private List<AlertModel> alertHistory;

    public FoodGetUser(String username, String email, String password,List<ProductModel> history) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
    }

    public FoodGetUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = new ArrayList<>();
    }

    public FoodGetUser(String username, String email, String password,List<ProductModel> history, List<AlertModel> alertHistory) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
        this.alertHistory = alertHistory;
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

    public void addProduct(ProductModel p){
        this.history.add(p);
    }

    public List<ProductModel> getHistory(){
        return history;
    }

    public double getMoney() {
        double sum = 0;
        for(ProductModel p :history){
            sum+=p.getProductPrice();
        }
        return sum;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHistory(List<ProductModel> history) {
        this.history = history;
    }

    public List<AlertModel> getAlerts() {
        return alertHistory;
    }
}
