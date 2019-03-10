package program.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListModel {

    private String name;
    private List<ProductModel> contents;


    public ShoppingListModel(String name, List<ProductModel> contents) {
        this.name = name;
        this.contents = contents;
    }

    public ShoppingListModel(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<ProductModel> getContents() {
        return contents;
    }
}
