package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

public class StatsController {
    @FXML
    private ChoiceBox dateBox;

    @FXML
    private Button stats_Stats;

    @FXML
    private Button stats_Panier;

    @FXML
    private Button stats_Alertes;

    @FXML
    private Button stats_Mon_Compte;


    private Stage stage;
    private ObservableList choices;

    private FoodGetUser user;
    private CommonPageCreator cr;
    private Object theChoice;


    public StatsController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
        choices = FXCollections.observableArrayList("1 Semaine", "1 Mois", "3 Mois", "6 Mois");

    }

    public void init() {

        stats_Stats.setOnAction(event -> openStats());
        stats_Panier.setOnAction(event -> openLists());
        stats_Alertes.setOnAction(event -> openAlertes());
        stats_Mon_Compte.setOnAction(event -> openMonCompte());

        dateBox.setItems(choices);
        dateBox.getSelectionModel().selectFirst();
        theChoice = dateBox.getSelectionModel().getSelectedItem();
        dateBox.setOnAction(event -> theChoice = dateBox.getSelectionModel().getSelectedItem());
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
