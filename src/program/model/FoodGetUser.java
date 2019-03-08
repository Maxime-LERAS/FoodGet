package program.model;

import java.util.ArrayList;
import java.util.List;

public class FoodGetUser {

    private String username;
    private String email;
    private String password;
    private List<ProductModel> history;

    public FoodGetUser(String username, String email, String password,List<ProductModel> history) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
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
}
