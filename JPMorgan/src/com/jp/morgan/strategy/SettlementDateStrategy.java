package com.jp.morgan.strategy;

import java.util.Date;

import com.jp.morgan.enums.Currency;

public interface SettlementDateStrategy {
	public Date getSettlementDate(Currency currency, Date settlementDate);
}
