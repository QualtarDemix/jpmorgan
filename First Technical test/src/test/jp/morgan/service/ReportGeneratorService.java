package test.jp.morgan.service;

import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.TradeType;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReportGeneratorService {

	Map<Date, Double> getTradeList(List<OrderDTO> orders, TradeType tradeType);

	Map<String, Double> getTradeRanking(List<OrderDTO> orders, TradeType tradeType);

}
