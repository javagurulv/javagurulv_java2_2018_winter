package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.Product;

public class ProductBuilder {

    private Long id;
    private String title;
    private String description;

    private ProductBuilder() {}

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public Product build() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        return product;
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

}
