package lv.javaguru.java2.database;

import lv.javaguru.java2.configs.SpringAppConfig;
import lv.javaguru.java2.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ProductRealDatabaseTest {

    private ProductDatabase database;

    @Before
    public void init() {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        database = applicationContext.getBean(ProductDatabase.class);
    }

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