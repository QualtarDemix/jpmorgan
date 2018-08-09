package test.jp.morgan.strategy.impl;

import test.jp.morgan.enums.Currency;
import test.jp.morgan.strategy.SettlementDateStrategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Locale.ENGLISH;
import static test.jp.morgan.constant.Constants.*;
import static test.jp.morgan.enums.Currency.AED;
import static test.jp.morgan.enums.Currency.SAR;

public class CurrencyWeekendSettlementDateStrategy implements SettlementDateStrategy {

	@Override
	public Date getFinalSettlementDate(Currency currency, Date settlementDate) {
		String lastDayOfWeek = (AED.equals(currency) || SAR.equals(currency)) ? FRIDAY : SATURDAY;
		return getNextAvailableDate(settlementDate, lastDayOfWeek);
	}

	private Date getNextAvailableDate(Date settlementDate, String lastDayOfWeek) {
		Date finalSettlementDate = new Date();
		String dayOfOrder = new SimpleDateFormat(DAY_FORMAT, ENGLISH).format(settlementDate);
		if (lastDayOfWeek.equals(dayOfOrder)) {
			finalSettlementDate = addDays(settlementDate, 2);
		} else if (getNextDay(lastDayOfWeek).equals(dayOfOrder)) {
			finalSettlementDate = addDays(settlementDate, 1);
		}
		return finalSettlementDate;
	}

	private Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	private String getNextDay(String day) {
		if (FRIDAY.equals(day)) {
			return SATURDAY;
		} else if (SATURDAY.equals(day)) {
			return SUNDAY;
		}
		return null;
	}

}
