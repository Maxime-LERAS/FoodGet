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
import program.model.CommonPageCreator;
import program.model.ConnectionCheckerModel;
import program.model.FoodGetUser;
import program.views.ConnectionView;
import program.views.MainView;

import java.io.IOException;


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

    public InscriptionController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        emptyFields.setText("");
        validateInscriptionButton.setOnAction(event -> checkForm());
        backToConnectionLink.setOnAction(event -> connectionPage());
    }

    public void checkForm() {
        String usernameField = newUsernameBox.getCharacters().toString();
        String passwordField = newPasswordBox.getCharacters().toString();
        if (usernameField.equals("") || passwordField.equals("")) {
            showEmptyFieldError();
        }
        else {
            connectionPage();
        }
    }

    private void connectionPage() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ConnectionController controller = new ConnectionController(this.stage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try{
            Parent root = loader.load(getClass().getResourceAsStream(ConnectionView.XML_FILE));
            root.getStylesheets().add(ConnectionView.CSS_FILE);
            //initialize the controller

            //create the view

            this.stage.setScene(new Scene(root, ConnectionView.WIDTH, ConnectionView.HEIGHT));
            controller.init();
            this.stage.setTitle(ConnectionView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E){
            E.printStackTrace();
        }
    }


    private void showEmptyFieldError() {
        newUsernameBox.clear();
        newPasswordBox.clear();
        emptyFields.setText("Champ(s) vide(s) !");
    }
}
