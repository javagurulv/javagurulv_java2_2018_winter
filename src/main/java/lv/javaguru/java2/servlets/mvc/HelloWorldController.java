package lv.javaguru.java2.servlets.mvc;

import lv.javaguru.java2.businesslogic.addproduct.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloWorldController implements MVCController {

    @Autowired
    private AddProductService addProductService;

    @Override
    public MVCModel processGet(HttpServletRequest request) {

        String productTitle = request.getParameter("title");
        String productDescription = request.getParameter("description");

        addProductService.addProduct(productTitle, productDescription);

        return new MVCModel("/helloWorld.jsp", "Hello from MVC!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

}