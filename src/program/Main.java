package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.MainViewController;
import program.views.MainView;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        MainViewController controller = new MainViewController(primaryStage);

        //attach controller
        loader.setController(controller);

        //attach XML file
        try{
            Parent root = loader.load(getClass().getResourceAsStream(MainView.XML_FILE));
            root.getStylesheets().add(MainView.CSS_FILE);
            //initialize the controller
            controller.init();
            //create the view
            primaryStage.setScene(new Scene(root, MainView.WIDTH, MainView.HEIGHT));
            primaryStage.setTitle(MainView.LABEL);

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
