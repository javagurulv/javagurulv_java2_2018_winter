package lv.javaguru.java2.businesslogic.addproduct;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.database.ProductRepository;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AddProductService {

    @Autowired private ProductRepository productDatabase;
    @Autowired private AddProductValidator addProductValidator;

    @Transactional
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
