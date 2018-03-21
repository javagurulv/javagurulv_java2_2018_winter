package lv.javaguru.java2;

import lv.javaguru.java2.configs.SpringAppConfig;
import lv.javaguru.java2.views.AddProductView;
import lv.javaguru.java2.views.ProgramExitView;
import lv.javaguru.java2.views.RemoveProductView;
import lv.javaguru.java2.views.ShowProductListView;
import lv.javaguru.java2.views.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, applicationContext.getBean(AddProductView.class));
        actionMap.put(2, applicationContext.getBean(RemoveProductView.class));
        actionMap.put(3, applicationContext.getBean(ShowProductListView.class));
        actionMap.put(4, applicationContext.getBean(ProgramExitView.class));

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
