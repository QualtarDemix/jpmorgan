package test.jp.morgan.processor;


import test.jp.morgan.dto.InventoryDetail;
import test.jp.morgan.dto.SaleDTO;
import test.jp.morgan.enums.MessageType;
import test.jp.morgan.generator.MessageReportGenerator;
import test.jp.morgan.parser.MessageParser;
import test.jp.morgan.printer.Printer;
import test.jp.morgan.util.ProcessorUtil;

import java.util.*;

public class ProcessorApplication {
	
	int counter=0;

	List<InventoryDetail> inventoryDetails = new ArrayList();
	Map<String, Integer> adjustments = new HashMap();

	private MessageParser messageParser = new MessageParser();
	private MessageReportGenerator generator = new MessageReportGenerator();
	
	public void processor(String message) {
		counter++;
		MessageType messageType = ProcessorUtil.getMessageType(message);
		SaleDTO sale = messageParser.parse(message, messageType);
		updateInventory(messageType, sale);

		/*for(InventoryDetail inventory : inventoryDetails){
			System.out.println("   "+inventory.getFruitName()+"   "+inventory.getOccurences()+"   "+inventory.getPrice());
		}
		System.out.println("\n\n");*/

		checkCounter();
	}

	private void updateInventory(MessageType messageType, SaleDTO sale) {
		String fruitName = sale.getFruitName();
		switch (messageType) {
			case type1:
				inventoryDetails.add(new InventoryDetail(fruitName, 1, sale.getPrice()));
				break;
			case type2:
				inventoryDetails.add(new InventoryDetail(fruitName, sale.getQuantity(), sale.getPrice()));
				break;
			case type3:
				modifyInventoryForType3(sale, fruitName);
		}
	}

	private void modifyInventoryForType3(SaleDTO sale, String fruitName) {
		inventoryDetails.forEach(inventory -> {
			if (fruitName.equals(inventory.getFruitName())) {
				Integer currentPrice = inventory.getPrice();
				Integer newPrice = sale.getOperator().calculate(currentPrice, sale.getPrice());
				inventory.setPrice(newPrice);
			}
		});
		Integer adjustmentForFruit = adjustments.get(fruitName);
		int totalAdjustments = adjustmentForFruit != null ? adjustmentForFruit + 1 : 1;
		adjustments.put(fruitName, totalAdjustments);
	}

	private void checkCounter() {
		if(counter%10 == 0){
			generator.updateTenthMessage(inventoryDetails);
		}
		if(counter%50 == 0) {
			Printer.printFiftiethMessage(adjustments);
			System.exit(1);
		}
	}

}
