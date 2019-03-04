package program.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.ListofListsController;
import program.controller.StatsController;
import program.views.ListOfListsView;
import program.views.StatsView;

import java.io.IOException;

public class CommonPageCreator {

    private Stage stage;

    private FoodGetUser user;

    public CommonPageCreator(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
    }

    public void openStats() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        StatsController controller = new StatsController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(StatsView.XML_FILE));
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, StatsView.WIDTH, StatsView.HEIGHT));
            this.stage.setTitle(StatsView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void openLists() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        ListofListsController controller = new ListofListsController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(ListOfListsView.XML_FILE));
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, ListOfListsView.WIDTH, ListOfListsView.HEIGHT));
            this.stage.setTitle(ListOfListsView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }
}
