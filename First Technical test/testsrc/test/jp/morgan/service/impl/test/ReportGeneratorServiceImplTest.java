package test.jp.morgan.service.impl.test;

import org.junit.Before;
import test.jp.morgan.dto.OrderDTO;
import test.jp.morgan.enums.Currency;
import test.jp.morgan.enums.TradeType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorServiceImplTest {
	
	List<OrderDTO> orders;

	@Before
	public void setUp() throws Exception {
		orders = new ArrayList<OrderDTO>();
		
		OrderDTO order1 = new OrderDTO();
		order1.setEntity("foo");
		order1.setTradeType(TradeType.BUY);
		order1.setAgreedFx(33.54);
		order1.setCurrency(Currency.JPY);
		order1.setInstructionDate(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2016"));
		order1.setSettlementDate(new SimpleDateFormat("dd-MM-yyyy").parse("02-01-2016"));
		order1.setUnits(200);
		order1.setPricePerUnit(100.25D);
		
		OrderDTO order2 = new OrderDTO();
		order2.setEntity("bar");
		order2.setTradeType(TradeType.SELL);
		order2.setAgreedFx(0.22);
		order2.setCurrency(Currency.AED);
		order2.setInstructionDate(new SimpleDateFormat("dd-MM-yyyy").parse("05-01-2016"));
		order2.setSettlementDate(new SimpleDateFormat("dd-MM-yyyy").parse("07-01-2016"));
		order2.setUnits(450);
		order2.setPricePerUnit(150.50D);
		
		orders.add(order1);
		orders.add(order2);
	}

}
