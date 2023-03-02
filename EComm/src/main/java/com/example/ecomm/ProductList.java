package com.example.ecomm;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductList {

    public TableView<Product> productTable;

    public Pane getAllProducts(){
//        TableColumn id= new TableColumn("Id");
//        id.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn name= new TableColumn("Name");
//        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn price= new TableColumn("Price");
//        price.setCellValueFactory(new PropertyValueFactory<>("Price"));


//        ObservableList<Product> data = FXCollections.observableArrayList();
//        data.addAll(new Product(123, "laptop", 85000.0),
//                new Product(1234, "laptop", 95000.0)
//                );
        ObservableList<Product> productList= Product.getAllProducts();
//
//        productTable = new TableView<>();
//        productTable.setItems(productList);
//        productTable.getColumns().addAll(id,name,price);
//
//        Pane tablePane = new Pane();
//        tablePane.getChildren().add(productTable);
        return createTableFromList(productList);

    }

    public Pane createTableFromList(ObservableList<Product> productList){
        TableColumn id= new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name= new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price= new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        productTable = new TableView<>();
        productTable.setItems(productList);
        productTable.getColumns().addAll(id,name,price);

        Pane tablePane = new Pane();
        tablePane.getChildren().add(productTable);
        return tablePane;

    }

    public Pane productsInCart(ObservableList<Product> productList){
        return createTableFromList(productList);
    }


    public Product getSelectedProduct(){
        return productTable.getSelectionModel().getSelectedItem();
    }


}
