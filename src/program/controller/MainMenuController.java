package program.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.FoodGetUser;

public class MainMenuController {

    private Stage stage;
    private FoodGetUser user;

    @FXML
    private Text spentMoney;

    public MainMenuController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
    }

    public void init() {
        spentMoney.setText(spentMoney.getText().replace("%username%", user.getUsername())
                .replace("%money%", "" + user.getMoney()));
    }
}
