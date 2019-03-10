package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.ShoppingListModel;

public class DeleteConfirmationController {


    private final ListViewListCell controller;
    private final ShoppingListModel todelete;
    private Stage popupStage;

    @FXML
    private Button cancelDelete;

    @FXML
    private Button confirmDelete;

    @FXML
    private Text listNameField;


    public DeleteConfirmationController(ListViewListCell listViewListCell, ShoppingListModel shoppingList) {
        this.controller = listViewListCell;
        this.todelete = shoppingList;
    }

    public void init(Stage popup) {
        this.listNameField.setText(this.listNameField.getText().replace("%listeToDelete%", this.todelete.getName()));
        this.popupStage = popup;
        popup.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                confirmDeleteMethod();
                keyEvent.consume();
            }
        });
        cancelDelete.setOnAction(event -> cancelDeleteMethod());
        confirmDelete.setOnAction(event -> confirmDeleteMethod());
    }

    private void confirmDeleteMethod() {
        this.controller.deleteList(this.todelete);
        this.popupStage.close();
    }

    private void cancelDeleteMethod() {
        this.popupStage.close();
    }
}
