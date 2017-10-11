package com.jp.morgan.service.impl;

import java.text.SimpleDateFormat;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.jp.morgan.dto.OrderDTO;
import com.jp.morgan.enums.Currency;
import com.jp.morgan.enums.TradeType;
import com.jp.morgan.service.ReportGeneratorService;
import com.jp.morgan.strategy.SettlementDateStrategy;

import jp.morgan.strategy.impl.CurrencyWeekendSettlementDateStrategy;
import jp.morgan.util.JPMorganUtil;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
	
	private SettlementDateStrategy settlementDateStrategy = new CurrencyWeekendSettlementDateStrategy();

	public void generateReport(List<OrderDTO> orders) {
		Map<Date, Double> incoming = new HashMap<Date, Double>();
		Map<String, Double> incomingRank = new HashMap<String, Double>();

		Map<Date, Double> outgoing = new HashMap<Date, Double>();
		Map<String, Double> outgoingRank = new HashMap<String, Double>();

		orders.forEach(order -> {
			Currency currency = order.getCurrency();
			Date requestedSettlementDate = order.getSettlementDate();
			Date finalSettlementDate = settlementDateStrategy.getSettlementDate(currency, requestedSettlementDate);
			Double amount = getTradeAmount(order);

			if (TradeType.BUY.equals(order.getTradeType())) {
				if (incoming.containsKey(finalSettlementDate)) {
					Double tradeAmount = incoming.get(finalSettlementDate);
					amount += tradeAmount;
				}
				incoming.put(finalSettlementDate, amount);
				incomingRank.put(order.getEntity(), amount);
			} else {
				if (outgoing.containsKey(finalSettlementDate)) {
					Double tradeAmount = outgoing.get(finalSettlementDate);
					amount += tradeAmount;
				}
				outgoing.put(finalSettlementDate, amount);
				outgoingRank.put(order.getEntity(), amount);
			}
		});
		printReport(incoming, incomingRank, outgoing, outgoingRank);
	}

	private void printReport(Map<Date, Double> incoming, Map<String, Double> incomingRank, Map<Date, Double> outgoing,
			Map<String, Double> outgoingRank) {
		System.out.println("-------Incoming report---------");
		printDailyTrade(incoming);
		System.out.println("\n");
		System.out.println("-------Outgoing report---------");
		printDailyTrade(outgoing);

		Map<String, Double> sortedIncomingRank = JPMorganUtil.sortByValue(incomingRank);
		System.out.println("\n");
		System.out.println("-------Incoming Rank---------");
		printRank(sortedIncomingRank);
		
		Map<String, Double> sortedOutgoingRank = JPMorganUtil.sortByValue(outgoingRank);
		System.out.println("\n");
		System.out.println("-------Outgoing Rank---------");
		printRank(sortedOutgoingRank);
	}

	private void printDailyTrade(Map<Date, Double> report) {
		System.out.println("---Date--------------Amount----");
		report.forEach((date, amount) -> {
			System.out.println("   " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "        " + amount);
		});
	}

	private void printRank(Map<String, Double> report) {
		System.out.println("---Entity--------------Amount----");
		report.forEach((entity, amount) -> {
			System.out.println("   " + entity + "        " + amount);
		});
	}

	private Double getTradeAmount(OrderDTO order) {
		Double pricePerUnit = order.getPricePerUnit();
		Integer units = order.getUnits();
		Double getAgreedFx = order.getAgreedFx();
		Double amount = pricePerUnit * units * getAgreedFx;
		return amount;
	}

}
