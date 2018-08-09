package test.jp.morgan.dto;

import test.jp.morgan.enums.Currency;
import test.jp.morgan.enums.TradeType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {

	private String entity;
	private TradeType tradeType;
	private Double agreedFx;
	private Currency currency;
	private Date instructionDate;
	private Date settlementDate;
	private Integer units;
	private Double pricePerUnit;

	public OrderDTO() {
		//empty constructor
	}

	public OrderDTO(String entity, TradeType tradeType, Double agreedFx, Currency currency, String instructionDate,
					String settlementDate, Integer units, Double pricePerUnit) throws Exception {
		this.entity = entity;
		this.tradeType = tradeType;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = new SimpleDateFormat("dd-MM-yyyy").parse(instructionDate);
		this.settlementDate = new SimpleDateFormat("dd-MM-yyyy").parse(instructionDate);
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public TradeType getTradeType() {
		return tradeType;
	}
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Double getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
