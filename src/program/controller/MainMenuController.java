package program.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.ProductModel;
import program.views.AddDepenseView;

import java.io.IOException;


@SuppressWarnings("Duplicates")
public class MainMenuController {

    private Stage stage;
    private FoodGetUser user;
    private CommonPageCreator cr;
    private ObservableList<ProductModel> products;
    private ObservableDoubleValue money;

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

    @FXML
    private Button main_menu_accueil;

    @FXML
    private ListView historyList;

    @FXML
    private Button addDepense;


    public MainMenuController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage,user);
        products = FXCollections.observableArrayList();
        money = new SimpleDoubleProperty();
    }

    public void init() {
        ProductModel p = new ProductModel("Bananes", 15.00);
        products.add(p);
        this.user.addProduct(p);
        historyList.setItems(products);
        historyList.setCellFactory(listview -> new ListViewProductCell());
        addDepense.setOnAction(event -> addDepenseMethod());
        spentMoney.setText(spentMoney.getText().replace("%username%", user.getUsername())
                .replace("%money%", "" + user.getMoney()));
        main_menu_accueil.setOnAction(event -> openMainMenu());
        main_menu_stats.setOnAction(event -> openStats());
        main_menu_lists.setOnAction(event -> openLists());
        main_menu_alerts.setOnAction(event -> openAlertes());
        main_menu_mon_compte.setOnAction(event -> openMonCompte());
    }

    private void addDepenseMethod() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        AddDepenseController controller = new AddDepenseController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(AddDepenseView.XML_FILE));
            //initialize the controller
            controller.init();
            Stage popup = new Stage();
            //create the view
            popup.setScene(new Scene(root, AddDepenseView.WIDTH, AddDepenseView.HEIGHT));
            popup.setTitle(AddDepenseView.LABEL);
            //show the view
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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