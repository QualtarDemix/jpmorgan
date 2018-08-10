package test.jp.morgan.dto;

public class InventoryDetail {

	private String fruitName;
	private Integer price;
	private Integer occurences;

	public InventoryDetail() {
		//default constructor
	}

	public InventoryDetail(String fruitName, Integer price, Integer occurences) {
		this.fruitName = fruitName;
		this.price = price;
		this.occurences = occurences;
	}

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
