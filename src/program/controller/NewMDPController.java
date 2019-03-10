package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

public class NewMDPController {


    @FXML
    private Button New_mdp_valider;

    @FXML
    private PasswordField New_mdp_new_mdp;

    @FXML
    private PasswordField New_mdp_new_mdp1;

    @FXML
    private Hyperlink New_mdp_retour;

    @FXML
    private Label emptyFields;


    private Stage stage;
    private CommonPageCreator cr;
    private FoodGetUser user;

    public NewMDPController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(this.stage, user);
    }

    public void init() {
        emptyFields.setText("");
        New_mdp_valider.setOnAction(event -> checkForm());
        New_mdp_retour.setOnAction(event -> cr.openMonCompte());
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                checkForm();
                keyEvent.consume();
            }
        });
    }

    public void checkForm() {
        String mdp_Field = New_mdp_new_mdp.getCharacters().toString();
        String confirm_mdp_Field = New_mdp_new_mdp1.getCharacters().toString();

        if (mdp_Field.equals("") || confirm_mdp_Field.equals("")) {
            showEmptyFieldError();
        }

        else if (!mdp_Field.equals(confirm_mdp_Field) ) {
            showNotSameMDP();
        }

        else {
            this.user.setPassword(mdp_Field);
            cr.openMonCompte();
        }
    }

    private void showEmptyFieldError() {
        New_mdp_new_mdp.clear();
        New_mdp_new_mdp1.clear();
        emptyFields.setText("Champ(s) vide(s) !");
    }

    private void showNotSameMDP() {
        New_mdp_new_mdp.clear();
        New_mdp_new_mdp1.clear();
        emptyFields.setText("Les 2 mots de passes indiqués ne sont pas identiques !");
    }
}
