package test.jp.morgan.generator;

import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.TradeType;
import test.jp.morgan.service.ReportGeneratorService;
import test.jp.morgan.service.impl.ReportGeneratorServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

import static test.jp.morgan.constant.Constants.*;

public class ReportGenerator {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();

    public void generateReport(List<OrderDTO> orders) {

        Map<Date, Double> incoming = reportGeneratorService.getTradeList(orders, TradeType.BUY);
        System.out.println(INCOMING_REPORT_TEXT);
        printDailyTrade(incoming);

        Map<Date, Double> outgoing = reportGeneratorService.getTradeList(orders, TradeType.SELL);
        System.out.println(NEW_LINE);
        System.out.println(OUTGOING_REPORT_TEXT);
        printDailyTrade(outgoing);

        Map<String, Double> sortedIncomingRank = reportGeneratorService.getTradeRanking(orders, TradeType.BUY);
        System.out.println(NEW_LINE);
        System.out.println(INCOMING_RANK_TEXT);
        printRank(sortedIncomingRank);

        Map<String, Double> sortedOutgoingRank = reportGeneratorService.getTradeRanking(orders, TradeType.SELL);
        System.out.println(NEW_LINE);
        System.out.println(OUTGOING_RANK_TEXT);
        printRank(sortedOutgoingRank);
    }

    private void printDailyTrade(Map<Date, Double> report) {
        System.out.println(REPORT_HEADLINE);
        report.forEach((date, amount) ->
                System.out.println("   " + new SimpleDateFormat(DATE_FORMAT).format(date) + "        " + amount)
        );
    }

    private void printRank(Map<String, Double> report) {
        System.out.println(RANK_HEADLINE);
        report.forEach((entity, amount) -> System.out.println("   " + entity + "              " + amount));
    }
}
