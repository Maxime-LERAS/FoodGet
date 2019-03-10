package program.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.ProductModel;
import program.views.AddDepenseView;

import java.io.IOException;

public abstract class AddingProductController {

    protected Stage stage;
    protected FoodGetUser user;
    protected CommonPageCreator cr;
    protected ObservableList<ProductModel> products;


    protected void addDepenseMethod() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        AddDepenseController controller = new AddDepenseController(this, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(AddDepenseView.XML_FILE));
            //initialize the controller
            root.getStylesheets().add(AddDepenseView.CSS_FILE);

            Stage popup = new Stage();

            //create the view
            popup.setScene(new Scene(root, AddDepenseView.WIDTH, AddDepenseView.HEIGHT));
            controller.init(popup);
            popup.setTitle(AddDepenseView.LABEL);
            //show the view
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void addProductToList(String productName, double productPrice);

    public abstract void deleteProduct(ProductModel product);
}
