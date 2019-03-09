package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import program.model.FoodGetUser;

public class SetThreshOldController {


    private MainMenuController controller;

    private FoodGetUser user;

    private Stage thisstage;

    @FXML
    private TextField thresholdField;


    @FXML
    private Button validate;

    @FXML
    private Label inputFailed;

    @FXML
    private Button cancel;



    public SetThreshOldController(MainMenuController controller, FoodGetUser user) {
        this.controller = controller;
        this.user = user;
    }

    public void init(Stage stage) {
        this.thisstage=stage;
        inputFailed.setText("");
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
        if(thresholdField.getText().equals("")){
            inputFailed.setText("Veuillez remplir les deux champs");
        }else{
            try{
                double d = Double.valueOf(thresholdField.getText());
                controller.setThresholdForUser(d);
                thisstage.close();
            }catch (NumberFormatException e){
                inputFailed.setText("Entrez un nombre valide pour le seuil");
                thresholdField.clear();
            }

        }
    }


}
