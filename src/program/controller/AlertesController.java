package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

public class AlertesController {


    @FXML
    private Text spentMoney;

    @FXML
    private Button Alertes_Stats;

    @FXML
    private Button Alertes_Panier;

    @FXML
    private Button Alertes_Alertes;

    @FXML
    private Button Alertes_Mon_Compte;


    private Stage stage;

    private FoodGetUser user;
    private CommonPageCreator cr;

    public AlertesController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
    }

    public void init() {

        Alertes_Stats.setOnAction(event -> openStats());
        Alertes_Panier.setOnAction(event -> openLists());
        Alertes_Alertes.setOnAction(event -> openAlertes());
        Alertes_Mon_Compte.setOnAction(event -> openMonCompte());
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
