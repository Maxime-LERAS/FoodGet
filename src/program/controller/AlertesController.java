package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.AlertModel;
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

    @FXML
    private Button Alertes_Accueil;

    @FXML
    private ListView Alertes_List;


    private Stage stage;
    private ObservableList<AlertModel> alerts;
    private FoodGetUser user;
    private CommonPageCreator cr;

    public AlertesController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
        alerts = FXCollections.observableArrayList();
    }

    public void init() {
        alerts.addAll(user.getAlerts());
        Alertes_List.setItems(alerts);
        Alertes_List.setCellFactory(listview -> new ListViewAlertCell());
        Alertes_Accueil.setOnAction(event -> openMainMenu());
        Alertes_Stats.setOnAction(event -> openStats());
        Alertes_Panier.setOnAction(event -> openLists());
        Alertes_Alertes.setOnAction(event -> openAlertes());
        Alertes_Mon_Compte.setOnAction(event -> openMonCompte());
    }

    private void openMainMenu() {
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
