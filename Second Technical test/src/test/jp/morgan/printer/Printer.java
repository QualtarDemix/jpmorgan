package test.jp.morgan.printer;

import test.jp.morgan.dto.SaleDTO;

import java.util.List;
import java.util.Map;

import static test.jp.morgan.constant.MessageConstants.*;

public class Printer {

    public static void printTenthMessage(List<SaleDTO> tenthMessage) {
        System.out.println(TENTH_MESSAGE_TEXT);
        System.out.println(TENTH_MESSAGE_HEADLINE);
        for (SaleDTO printMessage : tenthMessage) {
            System.out.println("   " + printMessage.getFruitName() + "   " + printMessage.getQuantity() + "   " + printMessage.getPrice());
        }
    }

    public static void printFiftiethMessage(Map<String, Integer> adjustments) {
        System.out.println(FIFTIETH_MESSAGE_TEXT);
        System.out.println(FIFTIETH_MESSAGE_HEADLINE);
        for (String fruitName : adjustments.keySet()) {
            System.out.println("   " + fruitName + "   " + adjustments.get(fruitName));
        }
        System.out.println(EXIT_MESSAGE);
    }
}
