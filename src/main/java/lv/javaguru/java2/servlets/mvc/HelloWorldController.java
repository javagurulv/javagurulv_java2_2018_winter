package lv.javaguru.java2.servlets.mvc;

import lv.javaguru.java2.businesslogic.addproduct.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class HelloWorldController {

    private static Logger logger = Logger.getLogger(HelloWorldController.class.getName());

    @Autowired
    private AddProductService addProductService;

    @RequestMapping(value = "hello/{id}", method = {RequestMethod.GET})
    public ModelAndView processGet(HttpServletRequest request,
                                   @PathVariable Long id) {

        logger.info("ID = " + id);

        String productTitle = request.getParameter("title");
        String productDescription = request.getParameter("description");

        addProductService.addProduct(productTitle, productDescription);

        return new ModelAndView("helloWorld", "model", "Hello from MVC!");
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET})
    public ModelAndView process(HttpServletRequest request) {

        String productTitle = request.getParameter("title");
        String productDescription = request.getParameter("description");

        addProductService.addProduct(productTitle, productDescription);

        return new ModelAndView("helloWorld", "model", "Hello from MVC!");
    }

}