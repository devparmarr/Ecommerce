package com.example.ecomm;

import javafx.collections.ObservableList;

public class Order {

    public static boolean placeOrder(Customer customer, Product product){
        try{
            String placeOrder= "INSERT INTO orders(customer_id,product_id,status) VALUES(" + customer.getId() + ","+ product.getId() + ",'Ordered')";
            DatabaseConnection dbConn = new DatabaseConnection();

            return dbConn.insertUpdate(placeOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static int placeOrderMultipleProducts(ObservableList<Product> productObservableList,Customer customer){
        int count=0;
        for(Product product: productObservableList){
            if(placeOrder(customer,product))
                count++;
        }

        return count;
    }
}
