package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.UsersDatabase;


public class CreateNewListController {
    @FXML
    private TextField listName;

    @FXML
    private Button New_List_valider;

    @FXML
    private Button New_List_annuler;

    @FXML
    private Label Echec;


    private Stage stage;
    private Stage thisstage;
    private CommonPageCreator cr;
    private FoodGetUser user;
    private ListofListsController controller;

    public CreateNewListController(ListofListsController controller, FoodGetUser user) {
        this.controller = controller;
        this.user = user;
    }

    public void init(Stage stage){
        this.thisstage=stage;
        stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                validateMethod();
                keyEvent.consume();
            }
        });
        New_List_valider.setOnAction(event -> validateMethod());
        New_List_annuler.setOnAction(event -> cancelMethod());


    }

    private void cancelMethod() {
        this.thisstage.close();
    }

    private void validateMethod() {
        if(listName.getText().equals("")){
            Echec.setText("Veuillez remplir le champ requis");
        }else {
            controller.addListToLists(listName.getText());
            thisstage.close();
        }
    }

}
