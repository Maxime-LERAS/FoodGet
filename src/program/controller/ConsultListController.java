package program.controller;

import javafx.stage.Stage;
import program.model.FoodGetUser;
import program.model.ShoppingListModel;

public class ConsultListController {

    private Stage stage;
    private FoodGetUser user;

    public ConsultListController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
    }

    public void init(ShoppingListModel shoppingList) {

    }
}
