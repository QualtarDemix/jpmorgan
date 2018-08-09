package test.jp.morgan.strategy.impl;

import test.jp.morgan.enums.Currency;
import test.jp.morgan.strategy.SettlementDateStrategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CurrencyWeekendSettlementDateStrategy implements SettlementDateStrategy {

	@Override
	public Date getSettlementDate(Currency currency, Date settlementDate) {
		Date finalSettlementDate = new Date();
		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(settlementDate);
		if (Currency.AED.equals(currency) || Currency.SAR.equals(currency)) {
			if ("Friday".equals(dayOfWeek)) {
				finalSettlementDate = addDays(settlementDate, 2);
			} else if ("Saturday".equals(dayOfWeek)) {
				finalSettlementDate = addDays(settlementDate, 1);
			}
		} else {
			if ("Saturday".equals(dayOfWeek)) {
				finalSettlementDate = addDays(settlementDate, 2);
			} else if ("Sunday".equals(dayOfWeek)) {
				finalSettlementDate = addDays(settlementDate, 1);
			}
		}
		return finalSettlementDate;
	}
	
	private Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

}
