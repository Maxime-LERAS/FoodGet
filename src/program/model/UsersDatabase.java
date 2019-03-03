package program.model;

import java.util.ArrayList;

public class UsersDatabase {

    private static ArrayList<FoodGetUser> database =new ArrayList<FoodGetUser>(){{
        add(new FoodGetUser("Julie","juliev@gmail.com","12",85));
        add(new FoodGetUser("Bruno","brunoinshape@gmail.com","10",150));
    }};

    public static ArrayList<FoodGetUser> getDatabase(){
        return database;
    }

}
