package program.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import program.model.*;
import program.views.ConnectionView;
import program.views.MainView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("Duplicates")
public class InscriptionController {

    @FXML
    private TextField newUsernameBox;

    @FXML
    private TextField newEmailBox;

    @FXML
    private TextField newNameBox;

    @FXML
    private TextField newFirstNameBox;

    @FXML
    private PasswordField newPasswordBox;

    @FXML
    private PasswordField confirmationPWBox;

    @FXML
    private Button validateInscriptionButton;

    @FXML
    private Label emptyFields;

    @FXML
    private Hyperlink backToConnectionLink;


    private Stage stage;
    private CommonPageCreator cr;
    private String usernameField;
    private String passwordField;
    private String checkPasswordField;
    private String emailField;
    private String firstNameField;


    public InscriptionController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        emptyFields.setText("");
        validateInscriptionButton.setOnAction(event -> checkForm());
        backToConnectionLink.setOnAction(event -> connectionPage());
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                checkForm();
                keyEvent.consume();
            }
        });
    }

    public void checkForm() {
        usernameField = newUsernameBox.getCharacters().toString();
        passwordField = newPasswordBox.getCharacters().toString();
        checkPasswordField = confirmationPWBox.getCharacters().toString();
        emailField = newEmailBox.getCharacters().toString();
        firstNameField = newFirstNameBox.getCharacters().toString();

        if (usernameField.equals("") || passwordField.equals("") || checkPasswordField.equals("") || emailField.equals("") || firstNameField.equals("")) {
            showEmptyFieldError();
        } else if (!passwordField.equals(checkPasswordField)) {
            showPassNotEquals();

        } else if(!emailField.contains("@")) {
            showEmailInvalid();
        }else{
            addToDatabase();
            connectionPage();
        }
    }

    private void showEmailInvalid() {
        newEmailBox.clear();
        emptyFields.setText("Email invalide : abc@example.com");
    }

    private void showPassNotEquals() {
        newPasswordBox.clear();
        confirmationPWBox.clear();
        emptyFields.setText("Les mots de passe ne correspondent pas !");
    }

    private void connectionPage() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ConnectionController controller = new ConnectionController(this.stage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(ConnectionView.XML_FILE));
            root.getStylesheets().add(ConnectionView.getCssFile());
            //initialize the controller

            //create the view

            this.stage.setScene(new Scene(root, ConnectionView.getWIDTH(), ConnectionView.getHEIGHT()));
            controller.init();
            this.stage.setTitle(ConnectionView.getLABEL());

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }


    private void showEmptyFieldError() {
        newUsernameBox.clear();
        newPasswordBox.clear();
        confirmationPWBox.clear();
        newEmailBox.clear();
        newFirstNameBox.clear();
        newNameBox.clear();
        emptyFields.setText("Champ(s) vide(s) !");
    }

    private void addToDatabase() {
        ArrayList<FoodGetUser> database = UsersDatabase.getDatabase();
        List<ProductModel> newUserProducts = new ArrayList<>();
        database.add(new FoodGetUser(this.usernameField, this.emailField, this.passwordField, newUserProducts));
    }
}
