package lv.javaguru.java2.businesslogic.addproduct;

import lv.javaguru.java2.businesslogic.Error;

import java.util.List;

public class AddProductResponse {

    private boolean success;

    private List<Error> errors;


    public AddProductResponse(boolean success, List<Error> errors) {
        this.success = success;
        this.errors = errors;
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
