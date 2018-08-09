package test.jp.morgan.strategy;

import test.jp.morgan.enums.Currency;

import java.util.Date;

public interface SettlementDateStrategy {
	Date getSettlementDate(Currency currency, Date settlementDate);
}
