package test.jp.morgan.generator;

import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.TradeType;
import test.jp.morgan.service.ReportGeneratorService;
import test.jp.morgan.service.impl.ReportGeneratorServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    private ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();

    public void generateReport(List<OrderDTO> orders) {

        Map<Date, Double> incoming = reportGeneratorService.getTradeList(orders, TradeType.BUY);
        System.out.println("-------Incoming report---------");
        printDailyTrade(incoming);

        Map<Date, Double> outgoing = reportGeneratorService.getTradeList(orders, TradeType.SELL);
        System.out.println("\n");
        System.out.println("-------Outgoing report---------");
        printDailyTrade(outgoing);

        Map<String, Double> sortedIncomingRank = reportGeneratorService.getTradeRanking(orders, TradeType.BUY);
        System.out.println("\n");
        System.out.println("-------Incoming Rank---------");
        printRank(sortedIncomingRank);

        Map<String, Double> sortedOutgoingRank = reportGeneratorService.getTradeRanking(orders, TradeType.SELL);
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
        System.out.println("---Entity------------Amount----");
        report.forEach((entity, amount) -> {
            System.out.println("   " + entity + "              " + amount);
        });
    }
}
