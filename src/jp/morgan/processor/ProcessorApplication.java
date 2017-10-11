package jp.morgan.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.morga.dto.InventoryDetail;
import jp.morga.dto.SaleDTO;
import jp.morgan.enums.MessageType;
import jp.morgan.enums.Operator;

public class ProcessorApplication {
	
	int counter=0;
	List<InventoryDetail> inventoryDetails = new ArrayList<InventoryDetail>();
	Map<String,Integer> adjustments = new HashMap<String,Integer>();
	
	public void processor(String message) {
		counter++;
		MessageType messageType = getMessageType(message);
		SaleDTO sale = parse(message, messageType);
		
		if(MessageType.type1.equals(messageType)){
			InventoryDetail inventoryDetail = new InventoryDetail();
			inventoryDetail.setFruitName(sale.getFruitName());
			inventoryDetail.setOccurences(1);
			inventoryDetail.setPrice(sale.getPrice());
			inventoryDetails.add(inventoryDetail);
		} else if (MessageType.type2.equals(messageType)){
			InventoryDetail inventoryDetail = new InventoryDetail();
			inventoryDetail.setFruitName(sale.getFruitName());
			inventoryDetail.setOccurences(sale.getQuantity());
			inventoryDetail.setPrice(sale.getPrice());
			inventoryDetails.add(inventoryDetail);
		} else if (MessageType.type3.equals(messageType)){
			String fruitName = sale.getFruitName();
			inventoryDetails.forEach(inventory -> {
				if(fruitName.equals(inventory.getFruitName())) {
					Integer currentPrice = inventory.getPrice();
					Integer newPrice = sale.getOperator().calculate(currentPrice,sale.getPrice());
					inventory.setPrice(newPrice);
				}
			});
			int totalAdjustments = adjustments.get(fruitName);
			totalAdjustments++;
			adjustments.put(fruitName, totalAdjustments);
		}
		/*for(InventoryDetail inventory : inventoryDetails){
			System.out.println("   "+inventory.getFruitName()+"   "+inventory.getOccurences()+"   "+inventory.getPrice());
		}
		System.out.println("\n\n");*/
		
		
		if(counter%10 == 0){
			Set<String> fruitNames = new HashSet<String>();
			inventoryDetails.forEach(inventory -> {
				fruitNames.add(inventory.getFruitName());
			});
			List<SaleDTO> tenthMessage = new ArrayList<SaleDTO>();
			for(String fruitName : fruitNames){
				SaleDTO saleMessage = new SaleDTO();
				saleMessage.setFruitName(fruitName);
				int totalQuantity = 0;
				int totalValue = 0;
				for(InventoryDetail inventory : inventoryDetails){
					if(fruitName.equals(inventory.getFruitName())){
						int quantity = inventory.getOccurences();
						totalQuantity+=quantity;
						int price = inventory.getPrice();
						totalValue+=(quantity*price);
					}
				}
				saleMessage.setQuantity(totalQuantity);
				saleMessage.setPrice(totalValue);
				tenthMessage.add(saleMessage);
			}
			System.out.println("----Tenth message----");
			System.out.println("----Fruit name----Total value----Total price----");
			for(SaleDTO printMessage : tenthMessage){
				System.out.println("   "+printMessage.getFruitName()+"   "+printMessage.getQuantity()+"   "+printMessage.getPrice());
			}
		}
		
		if(counter%50 == 0) {
			System.out.println("\n\n----Fiftieth message----");
			System.out.println("----Fruit name----Adjustments----");
			for(String fruitName : adjustments.keySet()){
				System.out.println("   "+fruitName+"   "+adjustments.get(fruitName));
			}
		}
	}

	private SaleDTO parse(String message, MessageType messageType) {
		SaleDTO sale = new SaleDTO();
		String[] splitMessage = message.split(" ");
		try{
		Matcher matcher =Pattern.compile("\\d+").matcher(message);
		matcher.find();
		if(MessageType.type1.equals(messageType)){
			String fruitName = splitMessage[0];
			sale.setFruitName(fruitName);
			String price = matcher.group();
			sale.setPrice(Integer.parseInt(price));
		} else if (MessageType.type2.equals(messageType)){
			String fruitName = splitMessage[3];
			sale.setFruitName(fruitName);
			String quantity = matcher.group();
			sale.setQuantity(Integer.parseInt(quantity));
			matcher.find();
			String price = matcher.group();
			sale.setPrice(Integer.parseInt(price));
		} else if (MessageType.type3.equals(messageType)){
			String fruitName = splitMessage[2];
			sale.setFruitName(fruitName);
			String price = matcher.group();
			sale.setPrice(Integer.parseInt(price));
			String operator = splitMessage[0];
			sale.setOperator(Operator.valueOf(operator));
		}
		}catch(IllegalStateException e){
		}
		return sale;
	}

	private MessageType getMessageType(String message) {
		if(message.matches("\\d.*")){
			return MessageType.type2;
		} else if (isOperator(message.split("\\s")[0])){
			return MessageType.type3;
		} 
		return MessageType.type1;
	}
	
	public boolean isOperator(String firstString){
		Operator[] values = Operator.values();
		for(Operator value : values){
			if(value.toString().equals(firstString)) {
				return true;
			}
		}
		return false;
	}
}
