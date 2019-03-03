package program.model;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConnectionCheckerModel {

    private String username;
    private String password;


    public ConnectionCheckerModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public FoodGetUser checkCredentials() {
        if (username == null || password == null) {
            return null;
        } else {
            ArrayList<FoodGetUser> database = UsersDatabase.getDatabase();
            ArrayList<FoodGetUser> matching = (ArrayList<FoodGetUser>) database.stream()
                    .filter(foodGetUser -> (username.equalsIgnoreCase(foodGetUser.getUsername()) || username.equalsIgnoreCase(foodGetUser.getEmail()))
                    && password.equals(foodGetUser.getPassword())).collect(Collectors.toList());
            if (matching.isEmpty()) {
                return null;
            } else {
                return matching.get(0);
            }
        }
    }


}
