package com.jp.morgan.dto;

import java.util.Date;

import com.jp.morgan.enums.Currency;
import com.jp.morgan.enums.TradeType;

public class OrderDTO {
	String entity;
	TradeType tradeType;
	Double agreedFx;
	Currency currency;
	Date instructionDate;
	Date settlementDate;
	Integer units;
	Double pricePerUnit;
	
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
