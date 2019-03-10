package program.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.*;
import program.views.*;

import java.io.IOException;

@SuppressWarnings("Duplicates")
public class CommonPageCreator {

    private Stage stage;

    private FoodGetUser user;

    public CommonPageCreator(Stage stage) {
        this.stage = stage;
    }

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
            root.getStylesheets().add(StatsView.CSS_FILE);
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
            root.getStylesheets().add(ListOfListsView.CSS_FILE);
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

    public void openALerts(){
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        AlertesController controller = new AlertesController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try{
            Parent root = loader.load(getClass().getResourceAsStream(AlertesView.XML_FILE));
            root.getStylesheets().add(AlertesView.CSS_FILE);
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, AlertesView.WIDTH, AlertesView.HEIGHT));
            this.stage.setTitle(AlertesView.LABEL);
            //show the view
            this.stage.show();

        } catch (IOException E){
            E.printStackTrace();
        }
    }

    public void openMonCompte(){
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        MonCompteController controller = new MonCompteController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try{
            Parent root = loader.load(getClass().getResourceAsStream(MonCompteView.XML_FILE));
            root.getStylesheets().add(MonCompteView.CSS_FILE);
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, MonCompteView.WIDTH, MonCompteView.HEIGHT));
            this.stage.setTitle(MonCompteView.LABEL);
            //show the view
            this.stage.show();

        } catch (IOException E){
            E.printStackTrace();
        }
    }

    public void openAccueil() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        MainMenuController controller = new MainMenuController(this.stage, this.user);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void openConnection() {
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

    public void openEmailChange() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        NewMailController newMailController = new NewMailController(this.stage, this.user);

        //attach controller
        loader.setController(newMailController);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(NewMailView.XML_FILE));
            root.getStylesheets().add(NewMailView.CSS_FILE);

            this.stage.setScene(new Scene(root, NewMailView.WIDTH, NewMailView.HEIGHT));
            newMailController.init();
            this.stage.setTitle(NewMailView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void openMDPChange() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        NewMDPController newMDPController = new NewMDPController(this.stage, this.user);

        //attach controller
        loader.setController(newMDPController);

        //attach XML file
        try {
            Parent root = loader.load(getClass().getResourceAsStream(NewMDPView.XML_FILE));
            root.getStylesheets().add(NewMDPView.CSS_FILE);

            this.stage.setScene(new Scene(root, NewMDPView.WIDTH, NewMDPView.HEIGHT));
            newMDPController.init();
            this.stage.setTitle(NewMDPView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }


}
