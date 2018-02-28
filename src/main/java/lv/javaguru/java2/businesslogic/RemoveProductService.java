package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Product;
import lv.javaguru.java2.database.ProductDatabase;

import java.util.Optional;

public class RemoveProductService {

    private ProductDatabase productDatabase;

    public RemoveProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean removeProduct(String title) {
        Optional<Product> foundProduct = productDatabase.findByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            productDatabase.remove(product);
            return true;
        } else {
            return false;
        }
    }

}
