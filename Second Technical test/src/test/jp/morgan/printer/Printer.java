package test.jp.morgan.printer;

import test.jp.morgan.dto.SaleDTO;

import java.util.List;
import java.util.Map;

public class Printer {

    public static void printTenthMessage(List<SaleDTO> tenthMessage) {
        System.out.println("----Tenth message----");
        System.out.println("----Fruit name----Total value----Total price----");
        for (SaleDTO printMessage : tenthMessage) {
            System.out.println("   " + printMessage.getFruitName() + "   " + printMessage.getQuantity() + "   " + printMessage.getPrice());
        }
    }

    public static void printFiftiethMessage(Map<String, Integer> adjustments) {
        System.out.println("\n\n----Fiftieth message----");
        System.out.println("----Fruit name----Adjustments----");
        for (String fruitName : adjustments.keySet()) {
            System.out.println("   " + fruitName + "   " + adjustments.get(fruitName));
        }
    }
}
