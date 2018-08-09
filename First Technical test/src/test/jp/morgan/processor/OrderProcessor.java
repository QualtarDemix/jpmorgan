package test.jp.morgan.processor;

import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.TradeType;

import java.util.Map;

public class OrderProcessor<T> {

    public void processOrder(TradeType tradeType, Map<T, Double> incomingMap, OrderDTO order, T t) {
        Double currentTradeAmount = getTradeAmount(order);
        if (tradeType.equals(order.getTradeType())) {
            Double alreadyTradedAmount = incomingMap.containsKey(t) ? incomingMap.get(t) : 0D;
            Double totalTradeAmount = currentTradeAmount + alreadyTradedAmount;
            incomingMap.put(t, totalTradeAmount);
        }
    }

    private Double getTradeAmount(OrderDTO order) {
        Double pricePerUnit = order.getPricePerUnit();
        Integer units = order.getUnits();
        Double getAgreedFx = order.getAgreedFx();
        return pricePerUnit * units * getAgreedFx;
    }
}
