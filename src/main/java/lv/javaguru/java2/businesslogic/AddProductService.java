package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Product;
import lv.javaguru.java2.database.ProductDatabase;

public class AddProductService {

    private ProductDatabase productDatabase;

    public AddProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void addProduct(String title,
                           String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        productDatabase.add(product);
    }

}
