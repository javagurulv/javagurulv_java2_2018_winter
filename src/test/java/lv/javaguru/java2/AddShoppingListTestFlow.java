package lv.javaguru.java2;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.businesslogic.createshoppinglist.CreateShoppingListRequest;
import lv.javaguru.java2.businesslogic.createshoppinglist.CreateShoppingListResponse;
import lv.javaguru.java2.businesslogic.createshoppinglist.CreateShoppingListService;
import lv.javaguru.java2.businesslogic.userregistration.UserRegistrationRequest;
import lv.javaguru.java2.businesslogic.userregistration.UserRegistrationResponse;
import lv.javaguru.java2.businesslogic.userregistration.UserRegistrationService;
import lv.javaguru.java2.configs.SpringAppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class })
public class AddShoppingListTestFlow {

    @Autowired private DatabaseCleaner databaseCleaner;
    @Autowired private UserRegistrationService userRegistrationService;
    @Autowired private CreateShoppingListService createShoppingListService;

    @Before
    public void init() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldAddUser() {
        UserRegistrationRequest request = new UserRegistrationRequest("login", "password");
        UserRegistrationResponse response = userRegistrationService.register(request);
        assertThat(response.isSuccess(), is(true));
        assertThat(response.getUserId(), is(notNullValue()));
        assertThat(response.getErrors(), is(nullValue()));
    }

    @Test
    public void shouldAddOneShoppingList() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("login", "password");
        UserRegistrationResponse userRegistrationResponse = userRegistrationService.register(userRegistrationRequest);

        CreateShoppingListRequest createShoppingListRequest = new CreateShoppingListRequest("login", "title");
        CreateShoppingListResponse createShoppingListResponse = createShoppingListService.create(createShoppingListRequest);

        assertThat(createShoppingListResponse.isSuccess(), is(true));
        assertThat(createShoppingListResponse.getShoppingListId(), is(notNullValue()));
        assertThat(createShoppingListResponse.getErrors(), is(nullValue()));
    }

    @Test
    public void shouldNotAddDuplicateShoppingList() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("login", "password");
        UserRegistrationResponse userRegistrationResponse = userRegistrationService.register(userRegistrationRequest);

        CreateShoppingListRequest createShoppingListRequest = new CreateShoppingListRequest("login", "title");
        CreateShoppingListResponse createShoppingListResponse = createShoppingListService.create(createShoppingListRequest);

        assertThat(createShoppingListResponse.isSuccess(), is(true));

        createShoppingListResponse = createShoppingListService.create(createShoppingListRequest);

        assertThat(createShoppingListResponse.isSuccess(), is(false));
        assertThat(createShoppingListResponse.getShoppingListId(), is(nullValue()));
        assertThat(createShoppingListResponse.getErrors().size(), is(1));
        Error error = createShoppingListResponse.getErrors().get(0);
        assertThat(error.getField(), is("title"));
        assertThat(error.getErrorMessage(), is("Must not be repeated"));
    }

}
