package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.ShoppingList;
import lv.javaguru.java2.domain.User;

public class ShoppingListBuilder {

    private Long id;
    private String title;
    private User user;

    private ShoppingListBuilder() {}

    public static ShoppingListBuilder createShoppingList() {
        return new ShoppingListBuilder();
    }

    public ShoppingList build() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setId(id);
        shoppingList.setTitle(title);
        shoppingList.setUser(user);
        return shoppingList;
    }

    public ShoppingListBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ShoppingListBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ShoppingListBuilder with(User user) {
        this.user = user;
        return this;
    }

    public ShoppingListBuilder with(UserBuilder userBuilder) {
        this.user = userBuilder.build();
        return this;
    }

}
