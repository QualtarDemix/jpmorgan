package test.jp.morgan.service.impl;

import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.Currency;
import test.jp.morgan.enums.TradeType;
import test.jp.morgan.processor.OrderProcessor;
import test.jp.morgan.service.ReportGeneratorService;
import test.jp.morgan.strategy.SettlementDateStrategy;
import test.jp.morgan.strategy.impl.CurrencyWeekendSettlementDateStrategy;
import test.jp.morgan.util.JPMorganUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {

    private SettlementDateStrategy settlementDateStrategy = new CurrencyWeekendSettlementDateStrategy();

    private OrderProcessor dateOrderProcessor = new OrderProcessor<Date>();

    private OrderProcessor entityOrderProcessor = new OrderProcessor<String>();

    @Override
    public Map<Date, Double> getTradeList(List<OrderDTO> orders, TradeType tradeType) {
        Map<Date, Double> tradeList = new HashMap();
        orders.forEach(order -> {
            Currency currency = order.getCurrency();
            Date requestedSettlementDate = order.getSettlementDate();
            Date finalSettlementDate = settlementDateStrategy.getSettlementDate(currency, requestedSettlementDate);
            dateOrderProcessor.processOrder(tradeType, tradeList, order, finalSettlementDate);
        });
        return tradeList;
    }

    @Override
    public Map<String, Double> getTradeRanking(List<OrderDTO> orders, TradeType tradeType) {
        Map<String, Double> tradeRank = new HashMap();
        orders.forEach(order -> {
            String entity = order.getEntity();
            entityOrderProcessor.processOrder(tradeType, tradeRank, order, entity);
        });
        return JPMorganUtil.sortByValue(tradeRank);
    }

}
