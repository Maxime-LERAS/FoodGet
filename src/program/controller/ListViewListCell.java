package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import program.model.ShoppingListModel;
import program.views.AddDepenseView;
import program.views.DeleteConfirmView;

import java.io.IOException;

public class ListViewListCell extends ListCell<ShoppingListModel> {

    private ListofListsController controller;

    @FXML
    private GridPane gridLists;

    @FXML
    private Label listName;

    @FXML
    private Label prodQuantity;

    @FXML
    private Button deleteListButton;

    @FXML
    private Button shareList;

    public ListViewListCell(ListofListsController controller) {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/program/resources/fxml/listComponent.fxml"));
        fxmlLoader.setController(this);
        this.controller = controller;
        try {
            gridLists = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ShoppingListModel shoppingList, boolean empty) {
        super.updateItem(shoppingList, empty);
        if (empty || shoppingList == null) {
            setGraphic(null);
        } else {
            this.setContent(shoppingList);
            setGraphic(gridLists);
        }
    }

    public void setContent(ShoppingListModel shoppingList) {
        listName.setText(shoppingList.getName());
        shareList.setText("Partager");
        prodQuantity.setText(shoppingList.getContents().size() + " produits : "+shoppingList.getTotal()+"€");
        deleteListButton.setOnAction(event -> deleteListPopUp(shoppingList));
        shareList.setOnAction(event -> this.controller.shareList(shoppingList));
        gridLists.setOnMouseClicked(event -> this.controller.openContainedList(shoppingList));
    }

    private void deleteListPopUp(ShoppingListModel shoppingList) {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        DeleteConfirmationController controller = new DeleteConfirmationController(this, shoppingList);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(DeleteConfirmView.XML_FILE));
            //initialize the controller
            root.getStylesheets().add(DeleteConfirmView.CSS_FILE);

            Stage popup = new Stage();

            //create the view
            popup.setScene(new Scene(root, DeleteConfirmView.WIDTH, DeleteConfirmView.HEIGHT));
            controller.init(popup);
            popup.setTitle(DeleteConfirmView.LABEL);
            //show the view
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteList(ShoppingListModel shoppingList) {
        this.controller.deleteList(shoppingList);
    }
}
