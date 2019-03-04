package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import program.model.FoodGetUser;


public class StatsController {

    @FXML
    private ChoiceBox durationBox;

    private Stage stage;

    private FoodGetUser user;

    private ObservableList choices;

    private Object theChoice;

    public StatsController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        choices = FXCollections.observableArrayList("1 Semaine", "1 Mois", "3 Mois", "6 Mois");
    }


    public void init() {
        durationBox.setItems(choices);
        durationBox.getSelectionModel().selectFirst();
        theChoice = durationBox.getSelectionModel().getSelectedItem();
        durationBox.setOnAction(event -> theChoice = durationBox.getSelectionModel().getSelectedItem());
    }
}
