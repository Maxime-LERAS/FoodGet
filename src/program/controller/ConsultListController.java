package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import program.model.*;
import program.views.AddDepenseView;

import java.io.IOException;
import java.text.DecimalFormat;

public class ConsultListController {

    private Stage stage;
    private FoodGetUser user;
    private CommonPageCreator cr;
    private ObservableList<ProductModel> products;

    @FXML
    private Button Panier_Accueil;

    @FXML
    private Button Panier_Stats;

    @FXML
    private Button Panier_Liste;

    @FXML
    private Button Panier_Alertes;

    @FXML
    private Button Panier_MonCompte;

    @FXML
    private Button addDepense;

    @FXML
    private ListView detailListe;


    public ConsultListController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        this.cr = new CommonPageCreator(this.stage, this.user);
        this.products = FXCollections.observableArrayList();
    }

    public void init(ShoppingListModel shoppingList) {
        Panier_Accueil.setOnAction(event -> openMainMenu());
        Panier_Stats.setOnAction(event -> openStats());
        Panier_Liste.setOnAction(event -> openLists());
        Panier_Alertes.setOnAction(event -> openAlertes());
        Panier_MonCompte.setOnAction(event -> openMonCompte());

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
