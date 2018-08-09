package test.jp.morgan.service.impl.test;

import org.junit.Before;
import org.junit.Test;
import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.Currency;
import test.jp.morgan.enums.TradeType;
import test.jp.morgan.generator.ReportGenerator;

import java.util.Arrays;
import java.util.List;


public class ReportGeneratorTest {

    private List<OrderDTO> orders;

    @Before
    public void setUp() throws Exception {

        OrderDTO order1 = new OrderDTO("foo", TradeType.BUY, 33.54, Currency.JPY, "01-01-2016",
                "02-01-2016", 200, 100.25D);
        OrderDTO order2 = new OrderDTO("bar", TradeType.SELL, 0.22, Currency.AED, "05-01-2016",
                "07-01-2016", 450, 150.50D);
        OrderDTO order3 = new OrderDTO("bar", TradeType.BUY, 0.22, Currency.AED, "05-01-2016",
                "02-01-2016", 450, 150.50D);
        OrderDTO order4 = new OrderDTO("foo", TradeType.SELL, 0.22, Currency.AED, "05-01-2016",
                "07-01-2016", 450, 150.50D);
        OrderDTO order5 = new OrderDTO("foo", TradeType.BUY, 0.22, Currency.AED, "05-01-2016",
                "02-01-2016", 450, 150.50D);
        OrderDTO order6 = new OrderDTO("bar", TradeType.SELL, 0.22, Currency.AED, "05-01-2016",
                "07-01-2016", 450, 150.50D);

        orders = Arrays.asList(order1, order2, order3, order4, order5, order6);
    }

    @Test
    public void testGenerateReport() {
        new ReportGenerator().generateReport(orders);
        assert (true);
    }
}
