package program.model;

import java.util.ArrayList;
import java.util.List;

public class FoodGetUser {

    private String username;
    private String email;
    private String password;
    private List<ProductModel> history;

    public FoodGetUser(String username, String email, String password, int money) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = new ArrayList<>();
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

    public double getMoney() {
        double sum = 0;
        for(ProductModel p :history){
            sum+=p.getProductPrice();
        }
        return sum;
    }
}
