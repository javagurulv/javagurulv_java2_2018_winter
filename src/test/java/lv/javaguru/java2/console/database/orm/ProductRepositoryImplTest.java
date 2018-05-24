package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.domain.Product;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class ProductRepositoryImplTest extends OrmIntegrationTest {

    @Test
    public void shouldSaveProductToDatabase() {
        Product product1 = saveProduct("aaa", "bbb");
        Product product2 = saveProduct("zzz", "bbb");
        Optional<Product> found = productRepository.findByTitle("zzz");
        assertTrue(found.isPresent());
    }

}
