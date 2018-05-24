package lv.javaguru.java2.console.businesslogic.createshoppinglist;

import lv.javaguru.java2.console.businesslogic.Error;

import java.util.List;

public class CreateShoppingListResponse {

    private Long shoppingListId;

    private boolean success;

    private List<Error> errors;

    public CreateShoppingListResponse(Long shoppingListId) {
        this.shoppingListId = shoppingListId;
        this.success = true;
        this.errors = null;
    }

    public CreateShoppingListResponse(List<Error> errors) {
        this.shoppingListId = null;
        this.success = false;
        this.errors = errors;
    }

    public Long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
