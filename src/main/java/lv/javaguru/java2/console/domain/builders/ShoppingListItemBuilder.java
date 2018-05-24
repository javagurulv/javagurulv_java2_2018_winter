package lv.javaguru.java2.console.domain.builders;

import lv.javaguru.java2.console.domain.Product;
import lv.javaguru.java2.console.domain.ShoppingList;
import lv.javaguru.java2.console.domain.ShoppingListItem;

public class ShoppingListItemBuilder {

    private Long id;
    private ShoppingList shoppingList;
    private Product product;
    private Integer quantity;

    private ShoppingListItemBuilder() {}

    public static ShoppingListItemBuilder createShoppingListItem() {
        return new ShoppingListItemBuilder();
    }

    public ShoppingListItem build() {
        ShoppingListItem item = new ShoppingListItem();
        item.setId(id);
        item.setShoppingList(shoppingList);
        item.setProduct(product);
        item.setQuantity(quantity);
        return item;
    }

    public ShoppingListItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ShoppingListItemBuilder withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ShoppingListItemBuilder with(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
        return this;
    }

    public ShoppingListItemBuilder with(ShoppingListBuilder shoppingListBuilder) {
        this.shoppingList = shoppingListBuilder.build();
        return this;
    }

    public ShoppingListItemBuilder with(Product product) {
        this.product = product;
        return this;
    }

    public ShoppingListItemBuilder with(ProductBuilder productBuilder) {
        this.product = productBuilder.build();
        return this;
    }

}
