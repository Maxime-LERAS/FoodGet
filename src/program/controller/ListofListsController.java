package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import program.model.AlertModel;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.ShoppingListModel;
import program.views.ConsultListView;
import program.views.CreateListView;

import java.io.IOException;

public class ListofListsController {

    private ObservableList<ShoppingListModel> shoppingLists;

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

    @FXML
    private ListView ListOfLists;

    @FXML
    private Label sharedListLabel;

    @FXML
    private Button createListPopup;

    private Stage stage;

    private FoodGetUser user;
    private CommonPageCreator cr;

    public ListofListsController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage, user);
        shoppingLists = FXCollections.observableArrayList();
    }

    public void init() {
        sharedListLabel.setText("");
        shoppingLists.addAll(user.getShoppingLists());
        ListOfLists.setItems(shoppingLists);
        ListOfLists.setCellFactory(listview -> new ListViewListCell(this));
        Panier_Accueil.setFocusTraversable(false);
        Panier_Stats.setFocusTraversable(false);
        Panier_Accueil.setOnAction(event -> openMainMenu());
        Panier_Stats.setOnAction(event -> openStats());
        Panier_Liste.setOnAction(event -> openLists());
        Panier_Alertes.setOnAction(event -> openAlertes());
        Panier_MonCompte.setOnAction(event -> openMonCompte());
        createListPopup.setOnAction(event -> popupCreateList());
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

    private void openAlertes() {
        cr.openALerts();
    }

    private void openMonCompte() {
        cr.openMonCompte();
    }


    public void addListToLists(String text) {
        ShoppingListModel shoppingList = new ShoppingListModel(text);
        shoppingLists.add(shoppingList);
        user.addList(shoppingList);
        user.addAlert(new AlertModel("Vous avez créé la liste \"" + shoppingList.getName() + "\" "));
    }

    public void popupCreateList() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        CreateNewListController controller = new CreateNewListController(this, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(CreateListView.XML_FILE));
            //initialize the controller
            root.getStylesheets().add(CreateListView.getCssFile());
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

    public void deleteList(ShoppingListModel shoppingList) {
        this.shoppingLists.remove(shoppingList);
        user.getShoppingLists().remove(shoppingList);
        user.addAlert(new AlertModel("Vous avez supprimé la liste \"" + shoppingList.getName() + "\" ."));
    }

    public void shareList(ShoppingListModel shoppingList) {
        sharedListLabel.setText("Vous venez de partager la liste \"" + shoppingList.getName() + "\" avec vos amis");
        user.addAlert(new AlertModel("Vous avez partagé la liste \"" + shoppingList.getName() + "\" !"));
    }

    public void openContainedList(ShoppingListModel shoppingList) {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ConsultListController controller = new ConsultListController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(ConsultListView.XML_FILE));
            //initialize the controller
            root.getStylesheets().add(ConsultListView.getCssFile());

            //create the view
            this.stage.setScene(new Scene(root, ConsultListView.getWIDTH(), ConsultListView.getHEIGHT()));
            controller.init(shoppingList);
            this.stage.setTitle(ConsultListView.getLABEL());
            //show the view
            this.stage.show();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
