package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.views.StatsView;

import java.io.IOException;

@SuppressWarnings("Duplicates")
public class MainMenuController {

    private Stage stage;
    private FoodGetUser user;
    private CommonPageCreator cr;

    @FXML
    private Text spentMoney;

    @FXML
    private Button main_menu_stats;

    @FXML
    private Button main_menu_lists;

    @FXML
    private Button main_menu_alerts;

    @FXML
    private Button main_menu_mon_compte;

    public MainMenuController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
    }

    public void init() {
        spentMoney.setText(spentMoney.getText().replace("%username%", user.getUsername())
                .replace("%money%", "" + user.getMoney()));
        main_menu_stats.setOnAction(event -> openStats());
        main_menu_lists.setOnAction(event -> openLists());
    }

    private void openLists() {
        cr.openLists();
    }

    private void openStats() {
        cr.openStats();
    }
}
