package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import program.model.AlertModel;

import java.io.IOException;

public class ListViewAlertCell extends ListCell<AlertModel> {

    @FXML
    private GridPane gridAlert;

    @FXML
    private Label alertContent;

    @FXML
    private Label alertDate;


    public ListViewAlertCell() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/program/resources/fxml/alertComponent.fxml"));
        fxmlLoader.setController(this);
        try {
            gridAlert = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(AlertModel alert, boolean empty) {
        super.updateItem(alert, empty);
        if (empty || alert == null) {
            setGraphic(null);
        } else {
            this.setContent(alert);
            setGraphic(gridAlert);
        }
    }

    public void setContent(AlertModel alert) {
        alertContent.setText(alert.getAlertContent());
        alertDate.setText(alert.getAlertDate().toLocaleString());
    }
}
