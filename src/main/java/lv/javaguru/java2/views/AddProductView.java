package lv.javaguru.java2.views;

import lv.javaguru.java2.businesslogic.addproduct.AddProductResponse;
import lv.javaguru.java2.businesslogic.addproduct.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddProductView implements View {

    @Autowired private AddProductService addProductService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        AddProductResponse response = addProductService.addProduct(title, description);
        if (response.isSuccess()) {
            System.out.println("Product successfully added to list!");
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Error field = " + error.getField());
                System.out.println("Error message = " + error.getErrorMessage());
            });
            System.out.println();
        }
    }

}
