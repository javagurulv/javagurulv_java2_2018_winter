package lv.javaguru.java2;

import lv.javaguru.java2.database.ProductDatabase;
import lv.javaguru.java2.database.ProductInMemoryDatabase;
import lv.javaguru.java2.views.AddProductView;
import lv.javaguru.java2.views.ProgramExitView;
import lv.javaguru.java2.views.RemoveProductView;
import lv.javaguru.java2.views.ShowProductListView;
import lv.javaguru.java2.views.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit

        ProductDatabase database = new ProductInMemoryDatabase();

        View addProductView = new AddProductView(database);
        View removeProductView = new RemoveProductView(database);
        View showProductView = new ShowProductListView(database);
        View programExitView = new ProgramExitView();

        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addProductView);
        actionMap.put(2, removeProductView);
        actionMap.put(3, showProductView);
        actionMap.put(4, programExitView);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            View view = actionMap.get(menuItem);
            view.execute();
        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}
