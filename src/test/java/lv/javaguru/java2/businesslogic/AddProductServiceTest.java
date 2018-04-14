package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.addproduct.AddProductResponse;
import lv.javaguru.java2.businesslogic.addproduct.AddProductService;
import lv.javaguru.java2.businesslogic.addproduct.AddProductValidator;
import lv.javaguru.java2.database.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddProductServiceTest {

    @Mock private ProductRepository database;
    @Mock private AddProductValidator validator;

    @InjectMocks
    private AddProductService service = new AddProductService();

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
