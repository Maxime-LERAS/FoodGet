package program.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import program.model.Model;
import program.model.ProductModel;
import program.views.StatsView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainViewController {

    private Stage stage;

    private ObservableList<ProductModel> products;


    @FXML
    private ListView listBasket;

    @FXML
    private Button addDepense;

    @FXML
    private Button stats;

    public MainViewController(Stage stage) {
        this.stage = stage;
        products = FXCollections.observableArrayList();
    }


    private ObservableList<Model> productModel = FXCollections.observableArrayList(
            new Model("Legumes", "15"),
            new Model("Fruits", "20")
    );

    public void init() {
        ProductModel p = new ProductModel("Bananes", 15.00);
        products.add(p);
        listBasket.setItems(products);
        listBasket.setCellFactory(listview -> new ListViewProductCell());
        addDepense.setOnAction(event -> addDepenseMethod());
        stats.setOnAction(event -> openStats());
    }


    private void openStats() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        StatsController controller = new StatsController(this.stage);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(StatsView.XML_FILE));
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, StatsView.WIDTH, StatsView.HEIGHT));
            this.stage.setTitle(StatsView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

    public void addDepenseMethod() {
        ProductModel p2 = new ProductModel("Chips", 119.50);
        products.add(p2);
    }
}
