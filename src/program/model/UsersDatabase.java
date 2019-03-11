package program.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsersDatabase {

    private static ArrayList<FoodGetUser> database = new ArrayList<FoodGetUser>() {{
        LocalDateTime dec152018 = LocalDate.of(2018,12,15).atTime(12,1,23);
        LocalDateTime feb11_2019 = LocalDate.of(2019,2,11).atTime(18,21,5);
        LocalDateTime feb24_2019 = LocalDate.of(2019,2,24).atTime(9,58,52);
        LocalDateTime march2_2019 = LocalDate.of(2019,3,2).atTime(17,45,39);
        LocalDateTime march4_2019 = LocalDate.of(2019,3,4).atTime(19,15,57);
        LocalDateTime march5_2019 = LocalDate.of(2019,3,5).atTime(11,53,47);
        LocalDateTime march1_2019 = LocalDate.of(2019,3,1).atTime(22,2,38);
        LocalDateTime march7_2019 = LocalDate.of(2019,3,7).atTime(14,17,32);
        LocalDateTime march8_2019 = LocalDate.of(2019,3,8).atTime(6,11,31);
        List<ProductModel> julieProducts = new ArrayList<ProductModel>() {{
            add(new ProductModel("Sushis",35,dec152018));
            add(new ProductModel("Pain",2,feb11_2019));
            add(new ProductModel("Bananes", 5.84, march2_2019));
            add(new ProductModel("Céréales", 2.79, march4_2019));
            add(new ProductModel("Pâtes", 0.81, march5_2019));
        }};
        List<AlertModel> julieAlerts = new ArrayList<AlertModel>() {{
            add(new AlertModel("Bienvenue sur FoodGet, Julie",dec152018));
        }};
        List<ProductModel> brunoProducts = new ArrayList<ProductModel>() {{
            add(new ProductModel("Lait",3.25,feb24_2019));
            add(new ProductModel("Poulet", 14.82,march1_2019));
            add(new ProductModel("Riz", 1.99,march7_2019));
            add(new ProductModel("Eau", 1.05,march8_2019));
        }};
        List<AlertModel> brunoAlerts = new ArrayList<AlertModel>() {{
            add(new AlertModel("Bienvenue sur FoodGet, Bruno",feb24_2019));
        }};
        FoodGetUser julie = new FoodGetUser("Julie", "juliev@gmail.com", "12", julieProducts,julieAlerts);
        julie.setSpentMoneyThreshold(18.0);
        add(julie);
        FoodGetUser bruno = new FoodGetUser("Bruno", "brunoinshape@gmail.com", "10", brunoProducts,brunoAlerts);
        bruno.setSpentMoneyThreshold(115.0);
        add(bruno);
    }};

    public static ArrayList<FoodGetUser> getDatabase() {
        return database;
    }

}
