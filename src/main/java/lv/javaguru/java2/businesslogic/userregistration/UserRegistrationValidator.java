package lv.javaguru.java2.businesslogic.userregistration;

import lv.javaguru.java2.businesslogic.Error;

import java.util.List;

public interface UserRegistrationValidator {

    List<Error> validate(UserRegistrationRequest request);

}
