package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.views.ConnectionView;

import java.io.IOException;

public class MotDePasseOublierController {

    @FXML
    private TextField yourUserName;

    @FXML
    private PasswordField newMDP;

    @FXML
    private Button validateNewMDP;

    @FXML
    private Hyperlink backToConnectionLink;

    @FXML
    private Label emptyFields;


    private Stage stage;
    private CommonPageCreator cr;

    public MotDePasseOublierController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        emptyFields.setText("");
        backToConnectionLink.setOnAction(event -> connectionPage());
        validateNewMDP.setOnAction(event -> checkForm());
    }
    public void checkForm() {
        String usernameField = yourUserName.getCharacters().toString();
        String passwordField = newMDP.getCharacters().toString();
        if (usernameField.equals("") || passwordField.equals("")) {
            showEmptyFieldError();
        }
        else {
            connectionPage();
        }
    }

    private void showEmptyFieldError() {
        yourUserName.clear();
        newMDP.clear();
        emptyFields.setText("Champ(s) vide(s) !");
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
            root.getStylesheets().add(ConnectionView.getCssFile());
            //initialize the controller

            //create the view

            this.stage.setScene(new Scene(root, ConnectionView.getWIDTH(), ConnectionView.getHEIGHT()));
            controller.init();
            this.stage.setTitle(ConnectionView.getLABEL());

            //show the view
            this.stage.show();
        } catch (IOException E){
            E.printStackTrace();
        }
    }
}
