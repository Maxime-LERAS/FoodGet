package program.controller;

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
import program.model.*;
import program.views.AddDepenseView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;


public class ConsultListController extends AddingProductController {


    @FXML
    private Button List_Accueil;

    @FXML
    private Button List_Stats;

    @FXML
    private Button List_Liste;

    @FXML
    private Button List_Alertes;

    @FXML
    private Button List_MonCompte;

    @FXML
    private Button addProduct;

    @FXML
    private ListView detailListe;

    @FXML
    private Text listInfo;

    private ShoppingListModel shoppingList;


    public ConsultListController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        this.cr = new CommonPageCreator(this.stage, this.user);
        this.products = FXCollections.observableArrayList();
    }

    public void init(ShoppingListModel shoppingList) {
        this.shoppingList = shoppingList;
        DecimalFormat df = new DecimalFormat("#.##");
        listInfo.setText(listInfo.getText().replace("%list%", shoppingList.getName())
                .replace("%produits%", "" + shoppingList.getContents().size())
                .replace("%nombre%", "" + df.format(shoppingList.getTotal())));
        products.addAll(shoppingList.getContents());
        Collections.reverse(products);
        detailListe.setItems(products);
        detailListe.setCellFactory(listview -> new ListViewProductCell());
        List_Accueil.setOnAction(event -> openMainMenu());
        List_Stats.setOnAction(event -> openStats());
        List_Liste.setOnAction(event -> openLists());
        List_Alertes.setOnAction(event -> openAlertes());
        List_MonCompte.setOnAction(event -> openMonCompte());
        addProduct.setOnAction(event -> addDepenseMethod());
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

    @Override
    public void addProductToList(String productName, double productPrice) {
        DecimalFormat df = new DecimalFormat("#.##");
        String moneyBefore = "pour " + df.format(this.shoppingList.getTotal());
        String productsQuantity = "Total: " + shoppingList.getContents().size();
        ProductModel p = new ProductModel(productName, productPrice);
        shoppingList.addProduct(p);
        products.add(0, p);
        listInfo.setText(listInfo.getText().replace(moneyBefore, "pour " + df.format(shoppingList.getTotal()))
                .replace(productsQuantity, "Total: " + shoppingList.getContents().size()));
    }
}
