package lv.javaguru.java2.views;

import lv.javaguru.java2.database.ProductDatabase;
import lv.javaguru.java2.businesslogic.removeproduct.RemoveProductService;

import java.util.Scanner;

public class RemoveProductView implements View {

    private RemoveProductService removeProductService;

    public RemoveProductView(ProductDatabase database) {
        this.removeProductService = new RemoveProductService(database);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove product from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        final String title = sc.nextLine();

        boolean isRemoved = removeProductService.removeProduct(title);

        if (isRemoved) {
            System.out.println("Product with title " + title + " was found and will be removed from list!");
        } else {
            System.out.println("Product with title " + title + " not found and not be removed from list!");
        }
        System.out.println("Remove product from list execution end!");
        System.out.println();
    }
}
