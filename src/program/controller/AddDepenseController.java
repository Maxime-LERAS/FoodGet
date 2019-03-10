package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import program.model.FoodGetUser;


public class AddDepenseController {

    private MainMenuController controller;

    private FoodGetUser user;

    private Stage thisstage;

    @FXML
    private TextField productField;

    @FXML
    private TextField priceField;

    @FXML
    private Button validate;

    @FXML
    private Label addFailed;

    @FXML
    private Button cancel;


    public AddDepenseController(MainMenuController controller, FoodGetUser user) {
        this.controller = controller;
        this.user = user;
    }

    public void init(Stage stage) {
        this.thisstage = stage;
        addFailed.setText("");
        stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                validateMethod();
                keyEvent.consume();
            }
        });
        validate.setOnAction(event -> validateMethod());
        cancel.setOnAction(event -> cancelMethod());

    }

    private void cancelMethod() {
        thisstage.close();
    }

    private void validateMethod() {
        if (productField.getText().equals("") || priceField.getText().equals("")) {
            addFailed.setText("Veuillez remplir les deux champs");
        } else {
            try {
                double d = Double.valueOf(priceField.getText());
                if (d < 0) {
                    addFailed.setText("Entrez un prix positif");
                    priceField.clear();
                    return;
                }
                controller.addProductToList(productField.getText(), d);
                thisstage.close();
            } catch (NumberFormatException e) {
                addFailed.setText("Entrez un nombre valide pour le prix");
                priceField.clear();
            }

        }
    }
}
