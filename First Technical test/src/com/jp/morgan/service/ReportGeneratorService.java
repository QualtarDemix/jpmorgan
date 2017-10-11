package com.jp.morgan.service;

import java.util.List;

import com.jp.morgan.dto.OrderDTO;

public interface ReportGeneratorService {

	void generateReport(List<OrderDTO> orders);
}
