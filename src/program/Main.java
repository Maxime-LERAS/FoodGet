package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.ConnectionController;
import program.views.ConnectionView;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ConnectionController controller = new ConnectionController(primaryStage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try{
            Parent root = loader.load(getClass().getResourceAsStream(ConnectionView.XML_FILE));
            root.getStylesheets().add(ConnectionView.CSS_FILE);
            //initialize the controller

            //create the view

            primaryStage.setScene(new Scene(root, ConnectionView.WIDTH, ConnectionView.HEIGHT));
            controller.init();
            primaryStage.setTitle(ConnectionView.LABEL);

            //show the view
            primaryStage.show();
        } catch (IOException E){
            E.printStackTrace();
        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}
