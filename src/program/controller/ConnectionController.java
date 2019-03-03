package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.model.ConnectionCheckerModel;
import program.model.FoodGetUser;
import program.views.MainView;

import java.io.IOException;

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
    

    public ConnectionController(Stage stage) {
        this.stage = stage;
    }

    public void init(){
        connectionButton.setOnAction(event -> checkConnection());
        badCredentials.setText("");
    }

    private void checkConnection() {
        String username = usernameBox.getCharacters().toString();
        String password = passwordBox.getCharacters().toString();
        ConnectionCheckerModel checker = new ConnectionCheckerModel(username,password);
        FoodGetUser result = checker.checkCredentials();
        if(result !=null){
            openMainMenu(result);
        } else{
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
}
