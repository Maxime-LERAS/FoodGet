package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

import java.awt.*;

public class MonCompteController {
    @FXML
    private Text spentMoney;

    @FXML
    private Button Mon_Compte_Stats;

    @FXML
    private Button Mon_Compte_Panier;

    @FXML
    private Button Mon_Compte_Alertes;

    @FXML
    private Button Mon_Compte_Mon_Compte;

    @FXML
    private Button Mon_Compte_Accueil;

    @FXML
    private Button deconnect;

    @FXML
    private Hyperlink modifier_email;


    private Stage stage;

    private FoodGetUser user;
    private CommonPageCreator cr;

    public MonCompteController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
    }

    public void init() {
        Mon_Compte_Accueil.setFocusTraversable(false);
        Mon_Compte_Stats.setFocusTraversable(false);
        Mon_Compte_Panier.setFocusTraversable(false);
        Mon_Compte_Alertes.setFocusTraversable(false);

        Mon_Compte_Accueil.setOnAction(event -> openMainMenu());
        Mon_Compte_Stats.setOnAction(event -> openStats());
        Mon_Compte_Panier.setOnAction(event -> openLists());
        Mon_Compte_Alertes.setOnAction(event -> openAlertes());
        Mon_Compte_Mon_Compte.setOnAction(event -> openMonCompte());
        modifier_email.setOnAction(event -> openEmailChange());
        deconnect.setOnAction(event -> openConnection());
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

    public void openEmailChange() {
        cr.openEmailChange();
    }

    public void openConnection() {
        cr.openConnection();
    }



}