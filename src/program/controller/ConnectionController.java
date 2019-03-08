package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import program.model.ConnectionCheckerModel;
import program.model.FoodGetUser;
import program.views.InscriptionView;
import program.views.MDPOublierView;
import program.views.MainView;

import java.io.IOException;

@SuppressWarnings("Duplicates")
public class ConnectionController {

    private Stage stage;

    @FXML
    private TextField usernameBox;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private Button connectionButton;

    @FXML
    private Label badCredentials;

    @FXML
    private Button createAccountButton;

    @FXML
    private Hyperlink FPWLink;


    public ConnectionController(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        connectionButton.setOnAction(event -> checkConnection());
        badCredentials.setText("");
        this.stage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                checkConnection();
                keyEvent.consume();
            }
        });
        createAccountButton.setOnAction(event -> openSignUp());
        FPWLink.setOnAction(event -> openForgotPass());
    }

    private void checkConnection() {
        String username = usernameBox.getCharacters().toString();
        String password = passwordBox.getCharacters().toString();
        ConnectionCheckerModel checker = new ConnectionCheckerModel(username, password);
        FoodGetUser result = checker.checkCredentials();
        if (result != null) {
            openMainMenu(result);
        } else {
            showBadCredentialsError();
        }

    }

    private void showBadCredentialsError() {
        usernameBox.clear();
        passwordBox.clear();
        badCredentials.setText("Mauvaise combinaison Utilisateur / Mot de passe");
    }


    private void openMainMenu(FoodGetUser user) {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        MainMenuController controller = new MainMenuController(this.stage, user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(MainView.XML_FILE));
            root.getStylesheets().add(MainView.CSS_FILE);
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, MainView.WIDTH, MainView.HEIGHT));
            this.stage.setTitle(MainView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    private void openSignUp() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        InscriptionController controller = new InscriptionController(this.stage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(InscriptionView.XML_FILE));
            root.getStylesheets().add(InscriptionView.CSS_FILE);
            //initialize the controller

            //create the view

            this.stage.setScene(new Scene(root, InscriptionView.WIDTH, InscriptionView.HEIGHT));
            controller.init();
            this.stage.setTitle(InscriptionView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    private void openForgotPass() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        MotDePasseOublierController motDePasseOublierController = new MotDePasseOublierController(this.stage);

        //attach controller
        loader.setController(motDePasseOublierController);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(MDPOublierView.XML_FILE));
            root.getStylesheets().add(MDPOublierView.CSS_FILE);

            this.stage.setScene(new Scene(root, MDPOublierView.WIDTH, MDPOublierView.HEIGHT));
            motDePasseOublierController.init();
            this.stage.setTitle(MDPOublierView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }
}
