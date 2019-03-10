package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import program.model.ProductModel;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ListViewProductCell extends ListCell<ProductModel> {

    private final AddingProductController controller;
    @FXML
    private GridPane gridProduct;

    @FXML
    private Label prodName;

    @FXML
    private Label prodPrice;

    @FXML
    private Label prodDate;

    @FXML
    private Button deleteProductButton;


    public ListViewProductCell(AddingProductController controller) {
        super();
        this.controller = controller;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/program/resources/fxml/product.fxml"));
        fxmlLoader.setController(this);
        try {
            gridProduct = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ProductModel product, boolean empty) {
        super.updateItem(product, empty);
        if (empty || product == null) {
            setGraphic(null);
        } else {
            this.setContent(product);
            setGraphic(gridProduct);
        }
    }

    public void setContent(ProductModel product) {
        prodName.setText(product.getProductName());
        String pattern = "#.##";
        DecimalFormat df = new DecimalFormat(pattern);
        prodPrice.setText(df.format(product.getProductPrice()) + "€");
        prodDate.setText(product.getAddDate().format(DateTimeFormatter.ofPattern("d MMM yyyy 'à' HH:mm", Locale.FRANCE)));
        deleteProductButton.setOnAction(event -> deleteProduct(product));
    }

    private void deleteProduct(ProductModel product) {
        this.controller.deleteProduct(product);
    }
}
