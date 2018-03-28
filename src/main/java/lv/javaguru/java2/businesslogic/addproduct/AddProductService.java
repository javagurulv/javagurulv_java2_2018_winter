package lv.javaguru.java2.businesslogic.addproduct;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.database.ProductDatabase;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddProductService {

    @Autowired private ProductDatabase productDatabase;
    @Autowired private AddProductValidator addProductValidator;

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
