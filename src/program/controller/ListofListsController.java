package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.views.CreateListView;

import java.io.IOException;

public class ListofListsController {

    @FXML
    private Button Panier_Stats;

    @FXML
    private Button Panier_Liste;

    @FXML
    private Button Panier_Alertes;

    @FXML
    private Button Panier_MonCompte;

    @FXML
    private Button Panier_Accueil;

    private Stage stage;

    private FoodGetUser user;
    private CommonPageCreator cr;

    public ListofListsController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
    }

    public void init() {
        Panier_Accueil.setFocusTraversable(false);
        Panier_Stats.setFocusTraversable(false);
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


    public void addListToLists(String text) {

    }

    public void popupCreateList(){
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        CreateNewListController controller = new CreateNewListController(this, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(CreateListView.XML_FILE));
            //initialize the controller

            Stage popup = new Stage();

            //create the view
            popup.setScene(new Scene(root, CreateListView.WIDTH, CreateListView.HEIGHT));
            controller.init(popup);
            popup.setTitle(CreateListView.LABEL);
            //show the view
            popup.show();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
