package lv.javaguru.java2.database;

import lv.javaguru.java2.configs.SpringAppConfig;
import lv.javaguru.java2.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class })
@Transactional
public class ProductRealDatabaseTest {

    @Autowired private ProductRepository database;

    @Test
    public void shouldAddProductToDatabase() {
        Product product = new Product();
        product.setTitle("aaa");
        product.setDescription("bb");

        assertNull(product.getId());

        database.add(product);

        assertNotNull(product.getId());
    }

}