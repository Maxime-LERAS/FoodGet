package program.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDatabase {

    private static ArrayList<FoodGetUser> database = new ArrayList<FoodGetUser>() {{
        Date march2_2019 = new Date();
        Date march4_2019 = new Date();
        Date march5_2019 = new Date();
        march2_2019.setTime(1551539559);
        march2_2019.setTime(march2_2019.getTime()*1000);
        march4_2019.setTime(1551723357);
        march4_2019.setTime(march4_2019.getTime()*1000);
        march5_2019.setTime(1551783227);
        march5_2019.setTime(march5_2019.getTime()*1000);
        Date march1_2019 = new Date();
        Date march7_2019 = new Date();
        Date march8_2019 = new Date();
        march1_2019.setTime(1551474158);
        march1_2019.setTime(march1_2019.getTime()*1000);
        march7_2019.setTime(1551964652);
        march7_2019.setTime(march7_2019.getTime()*1000);
        march8_2019.setTime(1552021891);
        march8_2019.setTime(march8_2019.getTime()*1000);
        List<ProductModel> julieProducts = new ArrayList<ProductModel>() {{
            add(new ProductModel("Bananes", 5.84, march2_2019));
            add(new ProductModel("Céréales", 2.79, march4_2019));
            add(new ProductModel("Pâtes", 0.81, march5_2019));
        }};
        List<AlertModel> julieAlerts = new ArrayList<AlertModel>() {{
            add(new AlertModel("Seuil de dépense dépassé",march5_2019));
        }};
        List<ProductModel> brunoProducts = new ArrayList<ProductModel>() {{
            add(new ProductModel("Poulet", 14.82,march1_2019));
            add(new ProductModel("Riz", 1.99,march7_2019));
            add(new ProductModel("Eau Minérale", 1.05,march8_2019));
        }};

        add(new FoodGetUser("Julie", "juliev@gmail.com", "12", julieProducts,julieAlerts));
        add(new FoodGetUser("Bruno", "brunoinshape@gmail.com", "10", brunoProducts));
    }};

    public static ArrayList<FoodGetUser> getDatabase() {
        return database;
    }

}
