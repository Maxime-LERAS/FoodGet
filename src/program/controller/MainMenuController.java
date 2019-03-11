package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import program.model.AlertModel;
import program.model.CommonPageCreator;
import program.model.FoodGetUser;
import program.model.ProductModel;
import program.views.AddDepenseView;
import program.views.MoneyThresholdView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Comparator;


@SuppressWarnings("Duplicates")
public class MainMenuController extends AddingProductController {


    @FXML
    private Text spentMoney;

    @FXML
    private Button main_menu_stats;

    @FXML
    private Button main_menu_lists;

    @FXML
    private Button main_menu_alerts;

    @FXML
    private Button main_menu_mon_compte;

    @FXML
    private Button main_menu_accueil;

    @FXML
    private ListView historyList;

    @FXML
    private Button addDepense;

    @FXML
    private Button moneyThreshold;


    public MainMenuController(Stage stage, FoodGetUser user) {
        this.stage = stage;
        this.user = user;
        cr = new CommonPageCreator(stage, user);
        products = FXCollections.observableArrayList();
    }

    public void init() {
        products.addAll(user.getHistory());
        products.sort(Comparator.comparing(ProductModel::getAddDate).reversed());
        historyList.setItems(products);
        historyList.setCellFactory(listview -> new ListViewProductCell(this));
        addDepense.setOnAction(event -> this.addDepenseMethod());
        DecimalFormat df = new DecimalFormat("#.##");
        spentMoney.setText(spentMoney.getText().replace("%username%", user.getUsername())
                .replace("%money%", "" + df.format(user.getMoneyLastMonth()))
                .replace("%max%", df.format(user.getSpentMoneyThreshold())));
        main_menu_accueil.setOnAction(event -> openMainMenu());
        main_menu_stats.setOnAction(event -> openStats());
        main_menu_lists.setOnAction(event -> openLists());
        main_menu_alerts.setOnAction(event -> openAlertes());
        main_menu_mon_compte.setOnAction(event -> openMonCompte());
        moneyThreshold.setOnAction(event -> setThreshold());
    }


    @Override
    public void addProductToList(String productName, double productPrice) {
        double moneyBefore = user.getMoneyLastMonth();
        ProductModel p = new ProductModel(productName, productPrice);
        user.addProduct(p);
        products.add(0, p);
        user.addAlert(new AlertModel("" + p.getProductName() + "" + " au prix de " + p.getProductPrice() + "€ ajouté !"));

        DecimalFormat df = new DecimalFormat("#.##");
        if (user.getMoneyLastMonth() > user.getSpentMoneyThreshold()) {
            user.addAlert(new AlertModel(
                    "Seuil de dépense dépassé de " + df.format(user.getMoneyLastMonth() - user.getSpentMoneyThreshold()) + "€"));
        }
        spentMoney.setText(spentMoney.getText().replace("dépensé " + df.format(moneyBefore), "dépensé " + df.format(user.getMoneyLastMonth())));
    }

    @Override
    public void deleteProduct(ProductModel product) {
        double moneyBefore = user.getMoneyLastMonth();
        this.products.remove(product);
        user.getHistory().remove(product);
        DecimalFormat df = new DecimalFormat("#.##");
        spentMoney.setText(spentMoney.getText().replace(df.format(moneyBefore), df.format(user.getMoneyLastMonth())));
    }


    public void setThresholdForUser(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        String thresholdbefore = "sur " + df.format(user.getSpentMoneyThreshold());
        user.setSpentMoneyThreshold(d);
        user.addAlert(new AlertModel("Seuil de dépense fixé à " + d + "€"));
        spentMoney.setText(spentMoney.getText().replace(thresholdbefore, "sur " + df.format(user.getSpentMoneyThreshold())));
    }

    private void setThreshold() {
        FXMLLoader loader = new FXMLLoader();

        //create a controller
        SetThreshOldController controller = new SetThreshOldController(this, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream(MoneyThresholdView.XML_FILE));
            //initialize the controller
            root.getStylesheets().add(MoneyThresholdView.getCssFile());

            Stage popup = new Stage();

            //create the view
            popup.setScene(new Scene(root, MoneyThresholdView.WIDTH, MoneyThresholdView.HEIGHT));
            controller.init(popup);
            popup.setTitle(MoneyThresholdView.LABEL);
            //show the view
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void openMainMenu() {
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
