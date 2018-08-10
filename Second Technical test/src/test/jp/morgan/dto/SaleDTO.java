package test.jp.morgan.dto;

import test.jp.morgan.enums.Operator;

public class SaleDTO {

	private String fruitName;
	private Integer price;
	private Integer quantity;
	private Operator operator;

	public SaleDTO() {
		//default constructor
	}

	public SaleDTO(String fruitName, Integer price, Integer quantity, Operator operator) {
		this.fruitName = fruitName;
		this.price = price;
		this.quantity = quantity;
		this.operator = operator;
	}

	public String getFruitName() {
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}
