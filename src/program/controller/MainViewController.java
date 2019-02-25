package program.controller;
import program.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import program.model.Model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainViewController {

    @FXML
    private TableView<Model> productTable;

    @FXML
    private TableColumn<Model, String> productName;

    @FXML
    private TableColumn<Model, String> productPrice;

    @FXML
    private Button addDepense;

    @FXML
    private Button statistiques;


    @FXML
    public void initialize() {

        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        productTable.setItems(productModel);
    }

    private ObservableList<Model> productModel = FXCollections.observableArrayList(
            new Model("Legumes", "15"),
            new Model("Fruits", "20")
    );

    public void init() {
        addDepense.setOnAction(event -> initialize());
        //statistiques.setOnAction(event -> openStats());
    }

    private void openStats() {

    }

    public void addDepenseMethod() {
        productTable.setItems(productModel);
    }
}
