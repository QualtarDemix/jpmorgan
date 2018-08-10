package test.jp.morgan.generator;

import test.jp.morgan.dto.InventoryDetail;
import test.jp.morgan.dto.SaleDTO;
import test.jp.morgan.printer.Printer;

import java.util.*;

public class MessageReportGenerator {

    public void updateTenthMessage(List<InventoryDetail> inventoryDetails) {
        Set<String> fruitNames = new HashSet();
        inventoryDetails.forEach(inventory -> fruitNames.add(inventory.getFruitName()));
        List<SaleDTO> tenthMessage = getTenthMessage(fruitNames, inventoryDetails);
        Printer.printTenthMessage(tenthMessage);
    }

    private List<SaleDTO> getTenthMessage(Set<String> fruitNames, List<InventoryDetail> inventoryDetails) {
        List<SaleDTO> tenthMessage = new ArrayList();
        for (String fruitName : fruitNames) {
            int totalQuantity = 0;
            int totalValue = 0;
            for (InventoryDetail inventory : inventoryDetails) {
                if (fruitName.equals(inventory.getFruitName())) {
                    int quantity = inventory.getOccurences();
                    totalQuantity += quantity;
                    int price = inventory.getPrice();
                    totalValue += (quantity * price);
                }
            }
            tenthMessage.add(new SaleDTO(fruitName, totalValue, totalQuantity, null));
        }
        return tenthMessage;
    }
}
