
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
     private TableView<Model> productTable;

    @FXML
     private TableColumn<Model, String> productName;

    @FXML
     private TableColumn<Model, String> productPrice;

    @FXML
    private Button addDepense;


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
    }

    public void addDepenseMethod() {
        productTable.setItems(productModel);
    }
}
