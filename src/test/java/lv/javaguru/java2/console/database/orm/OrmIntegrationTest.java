package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.DatabaseCleaner;
import lv.javaguru.java2.console.configs.SpringConsoleConfig;
import lv.javaguru.java2.console.database.ProductRepository;
import lv.javaguru.java2.console.domain.Product;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConsoleConfig.class })
@Transactional
@Rollback(true)
public abstract class OrmIntegrationTest {

    @Autowired private DatabaseCleaner databaseCleaner;

    @Autowired protected ProductRepository productRepository;

    @Before
    public void init() {
        databaseCleaner.clean();
    }

    protected Product saveProduct(String title, String desc) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(desc);

        assertNull(product.getId());
        productRepository.save(product);
        assertNotNull(product.getId());

        return product;
    }

}
