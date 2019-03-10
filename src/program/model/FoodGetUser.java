package program.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodGetUser {

    private String username;
    private String email;
    private String password;
    private double spentMoneyThreshold;
    private List<ProductModel> history;
    private List<AlertModel> alertHistory;
    private List<ShoppingListModel> shoppingLists;

    public FoodGetUser(String username, String email, String password, List<ProductModel> history) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
        this.alertHistory = new ArrayList<>();
        this.shoppingLists = new ArrayList<>();
    }

    public FoodGetUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = new ArrayList<>();
        this.alertHistory = new ArrayList<>();
        this.shoppingLists = new ArrayList<>();
    }

    public FoodGetUser(String username, String email, String password, List<ProductModel> history, List<AlertModel> alertHistory) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
        this.alertHistory = alertHistory;
        this.shoppingLists = new ArrayList<>();
    }

    public FoodGetUser(String username, String email, String password, List<ProductModel> history, List<AlertModel> alertHistory, List<ShoppingListModel> shoppingLists) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.history = history;
        this.alertHistory = alertHistory;
        this.shoppingLists = shoppingLists;
    }

    public void setSpentMoneyThreshold(double spentMoneyThreshold) {
        this.spentMoneyThreshold = spentMoneyThreshold;
    }

    public double getSpentMoneyThreshold() {
        return spentMoneyThreshold;
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

    public List<ShoppingListModel> getShoppingLists() {
        return shoppingLists;
    }

    public void addProduct(ProductModel p) {
        this.history.add(p);
    }

    public List<ProductModel> getHistory() {
        return history;
    }

    public double getMoney() {
        double sum = 0;
        for (ProductModel p : history) {
            sum += p.getProductPrice();
        }
        return sum;
    }

    public double getMoneyLastMonth() {
        double sum = 0;
        List<ProductModel> lastMonthProducts = history.stream()
                .filter(productModel -> productModel.getAddDate().isAfter(LocalDateTime.now().minusMonths(1))).collect(Collectors.toList());
        for (ProductModel p : lastMonthProducts) {
            sum += p.getProductPrice();
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

    public void addAlert(AlertModel alert) {
        this.alertHistory.add(alert);
    }

    public void addList(ShoppingListModel shoppingList) {
        this.shoppingLists.add(shoppingList);
    }
}
