

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

/*
        Parent root1 = FXMLLoader.load(getClass().getResource(View.XML_FILE));
        Scene scene = new Scene(root1, View.WIDTH, View.HEIGHT);
        primaryStage.setTitle(View.LABEL);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        //create a loader
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        Controller controller = new Controller();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream(View.XML_FILE));

        //initialize the controller
        controller.initialize();
controller.init();
        //create the view
        primaryStage.setScene(new Scene(root, View.WIDTH, View.HEIGHT));
        primaryStage.setTitle(View.LABEL);

        //show the view
        primaryStage.show();    }


    public static void main(String[] args) {
        launch(args);
    }
}
