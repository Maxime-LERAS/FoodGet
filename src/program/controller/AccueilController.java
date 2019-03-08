package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

public class AccueilController {

    @FXML
    private Button main_menu_accueil;

    @FXML
    private Button main_menu_stats;

    @FXML
    private Button main_menu_lists;

    @FXML
    private Button main_menu_alerts;

    @FXML
    private Button main_menu_mon_compte;


    private Stage stage;

    private FoodGetUser user;
    private CommonPageCreator cr;

    public AccueilController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
    }

    public void init() {

        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_stats.setOnAction(event -> openStats());
        main_menu_lists.setOnAction(event -> openLists());
        main_menu_alerts.setOnAction(event -> openAlertes());
        main_menu_mon_compte.setOnAction(event -> openMonCompte());
    }


    private void openAccueil() {
        cr.openAccueil();
    }

    private void openLists() {
        cr.openLists();
    }

    private void openStats() {
        cr.openStats();
    }

    private void openAlertes(){
        cr.openALerts();
    }
    private void openMonCompte(){
        cr.openMonCompte();
    }
}
