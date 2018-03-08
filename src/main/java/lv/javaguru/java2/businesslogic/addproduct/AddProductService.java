package lv.javaguru.java2.businesslogic.addproduct;

import lv.javaguru.java2.Product;
import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.database.ProductDatabase;

import java.util.List;

public class AddProductService {

    private ProductDatabase productDatabase;
    private AddProductValidator addProductValidator;

    public AddProductService(ProductDatabase productDatabase,
                             AddProductValidator addProductValidator) {
        this.productDatabase = productDatabase;
        this.addProductValidator = addProductValidator;
    }

    public AddProductResponse addProduct(String title,
                                         String description) {
        List<Error> validationErrors = addProductValidator.validate(title, description);
        if (!validationErrors.isEmpty()) {
            return new AddProductResponse(false, validationErrors);
        }

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        productDatabase.add(product);

        return new AddProductResponse(true, null);
    }

}
