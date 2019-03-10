package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.ProductModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StatsController {
    @FXML
    private ChoiceBox dateBox;

    @FXML
    private Button stats_Stats;

    @FXML
    private Button stats_Panier;

    @FXML
    private Button stats_Alertes;

    @FXML
    private Button stats_Mon_Compte;

    @FXML
    private Button stats_Acceuil;

    @FXML
    private LineChart graphStats;


    private Stage stage;
    private ObservableList choices;

    private FoodGetUser user;
    private CommonPageCreator cr;
    private Object theChoice;


    public StatsController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage, user);
        choices = FXCollections.observableArrayList("1 Semaine", "1 Mois", "3 Mois", "6 Mois");

    }

    public void init() {
        stats_Acceuil.setFocusTraversable(false);
        stats_Acceuil.setOnAction(event -> openAccueil());
        stats_Stats.setOnAction(event -> openStats());
        stats_Panier.setOnAction(event -> openLists());
        stats_Alertes.setOnAction(event -> openAlertes());
        stats_Mon_Compte.setOnAction(event -> openMonCompte());

        dateBox.setItems(choices);
        dateBox.getSelectionModel().selectFirst();
        theChoice = dateBox.getSelectionModel().getSelectedItem();
        dateBox.setOnAction(event -> {
            theChoice = dateBox.getSelectionModel().getSelectedItem();
            drawGraph(theChoice);
        });
        drawGraph(theChoice);
    }

    private void drawGraph(Object theChoice) {
        if (theChoice.equals(choices.get(0))) {

            //Graph sur une semaine
            graphStats.getData().clear();
            XYChart.Series series = new XYChart.Series();

            series.nameProperty().setValue("Dépenses ces 7 derniers jours");
            series = computeSeries(series, LocalDateTime.now().minusDays(7));
            graphStats.getData().addAll(series);

        } else if (theChoice.equals(choices.get(1))) {

            //Graph ce mois ci
            graphStats.getData().clear();
            XYChart.Series series = new XYChart.Series();
            series.nameProperty().setValue("Dépenses ce dernier mois");
            series = computeSeries(series, LocalDateTime.now().minusMonths(1));
            graphStats.getData().addAll(series);

        } else if (theChoice.equals(choices.get(2))) {

            //Graph ces 3 derniers mois
            graphStats.getData().clear();
            XYChart.Series series = new XYChart.Series();
            series.nameProperty().setValue("Dépenses les 3 derniers mois");
            series = computeSeries(series, LocalDateTime.now().minusMonths(3));
            graphStats.getData().addAll(series);

        } else if (theChoice.equals(choices.get(3))) {
            //Graph ces 6 derniers mois
            graphStats.getData().clear();

            XYChart.Series series = new XYChart.Series();
            series.nameProperty().setValue("Dépenses les 6 derniers mois");
            series = computeSeries(series, LocalDateTime.now().minusMonths(6));

            graphStats.getData().addAll(series);
        }
    }

    private XYChart.Series computeSeries(XYChart.Series series, LocalDateTime time) {
        List<ProductModel> lastXdaysProducts = user.getHistory()
                .stream().filter(productModel -> productModel.getAddDate().isAfter(time))
                .sorted(Comparator.comparing(ProductModel::getAddDate)).collect(Collectors.toList());
        double sum = 0;
        for (ProductModel p : lastXdaysProducts) {
            sum += p.getProductPrice();
            series.getData().add(new XYChart.Data(p.getAddDate().format(DateTimeFormatter.ofPattern("d MMM").withLocale(Locale.FRANCE)), sum));
        }
        return series;
    }

    private void openAccueil() {
        cr.openAccueil();
    }

    private void openLists() {
        cr.openLists();
    }

    private void openStats() {
        cr.openStats();
    }

    private void openAlertes() {
        cr.openALerts();
    }

    private void openMonCompte() {
        cr.openMonCompte();
    }

}
