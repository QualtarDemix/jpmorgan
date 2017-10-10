package com.jp.morgan.service.impl.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jp.morgan.dto.OrderDTO;
import com.jp.morgan.enums.Currency;
import com.jp.morgan.enums.TradeType;
import com.jp.morgan.service.ReportGeneratorService;
import com.jp.morgan.service.impl.ReportGeneratorServiceImpl;

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

	@Test
	public void testGenerateReport() {
		ReportGeneratorService service = new ReportGeneratorServiceImpl();
		service.generateReport(orders);
		assert(true);
	}

}
