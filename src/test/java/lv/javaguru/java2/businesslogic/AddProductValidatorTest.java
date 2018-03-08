package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.addproduct.AddProductValidator;
import lv.javaguru.java2.database.ProductDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddProductValidatorTest {

    private ProductDatabase database;
    private AddProductValidator validator;

    @Before
    public void init() {
        database = Mockito.mock(ProductDatabase.class);
        validator = new AddProductValidator(database);
    }

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        List<Error> errors = validator.validate(null, "desc");
        assertEquals(errors.size(),1);
        assertEquals(errors.get(0).getField(),"title");
        assertEquals(errors.get(0).getErrorMessage(),"Must not be empty");
    }


}