package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;

public class NewMailController {

    @FXML
    private Button New_mail_valider;

    @FXML
    private TextField New_mail_new_email;

    @FXML
    private Hyperlink New_mail_retour;

    @FXML
    private Label emptyFields;


    private Stage stage;
    private CommonPageCreator cr;
    private FoodGetUser user;

    public NewMailController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(this.stage, user);
    }

    public void init() {
        emptyFields.setText("");
        New_mail_valider.setOnAction(event -> checkForm());
        New_mail_retour.setOnAction(event -> cr.openMonCompte());
    }

    public void checkForm() {
        String email_Field = New_mail_new_email.getCharacters().toString();
        if (email_Field.equals("")) {
            showEmptyFieldError();
        }
        else {
            cr.openMonCompte();
        }
    }

    private void showEmptyFieldError() {
        New_mail_new_email.clear();
        emptyFields.setText("Champ vide !");
    }
}
