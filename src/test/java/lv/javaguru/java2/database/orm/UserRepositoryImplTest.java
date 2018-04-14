package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.configs.SpringAppConfig;
import lv.javaguru.java2.database.ShoppingListRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static lv.javaguru.java2.domain.builders.ShoppingListBuilder.createShoppingList;
import static lv.javaguru.java2.domain.builders.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class })
@Transactional
public class UserRepositoryImplTest {

    @Autowired private UserRepository userRepository;
    @Autowired private ShoppingListRepository shoppingListRepository;

    @Test
    public void shouldFindUserShoppingLists() {
        User user = createUser()
                .withLogin("wrc")
                .withPassword("xxx").build();
        userRepository.save(user);

        ShoppingList shoppingList1 = createShoppingList()
                .with(user)
                .withTitle("One").build();
        ShoppingList shoppingList2 = createShoppingList()
                .with(user)
                .withTitle("Two").build();
        shoppingListRepository.save(shoppingList1);
        shoppingListRepository.save(shoppingList2);

        List<ShoppingList> userShoppingLists = userRepository.findShoppingLists(user);
        assertThat(userShoppingLists.size(), is(2));
        assertThat(userShoppingLists.contains(shoppingList1), is(true));
        assertThat(userShoppingLists.contains(shoppingList2), is(true));
    }

}
