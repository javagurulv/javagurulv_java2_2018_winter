package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.addproduct.AddProductResponse;
import lv.javaguru.java2.businesslogic.addproduct.AddProductService;
import lv.javaguru.java2.businesslogic.addproduct.AddProductValidator;
import lv.javaguru.java2.database.ProductDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddProductServiceTest {

    private ProductDatabase database;
    private AddProductValidator validator;
    private AddProductService service;

    @Before
    public void init() {
        database = Mockito.mock(ProductDatabase.class);
        validator = Mockito.mock(AddProductValidator.class);
        service = new AddProductService(database, validator);
    }

    @Test
    public void shouldReturnSuccess() {
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("title", "desc"))
                .thenReturn(errors);

        AddProductResponse response = service.addProduct("title", "desc");

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getErrors(), null);
    }

    @Test
    public void shouldReturnFail() {
        List<Error> errors = new ArrayList<>();
        errors.add(new Error("title", "des"));
        Mockito.when(validator.validate(null, "desc"))
                .thenReturn(errors);

        AddProductResponse response = service.addProduct(null, "desc");

        assertEquals(response.isSuccess(), false);
        assertEquals(response.getErrors(), errors);
    }

}
