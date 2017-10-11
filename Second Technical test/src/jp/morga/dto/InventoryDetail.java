package jp.morga.dto;

public class InventoryDetail {
	
	public String fruitName;
	public Integer price;
	public Integer occurences;
	
	public String getFruitName()
	{
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getOccurences() {
		return occurences;
	}
	public void setOccurences(Integer occurences) {
		this.occurences = occurences;
	}
	
}
