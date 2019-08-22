package Exemplo1;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class PortifolioTester {

	Portfolio portfolio;
	StockService stockService;
	
	public static void main(String[] args) {
		PortifolioTester tester = new PortifolioTester();
		tester.setUp();
		System.out.println(tester.testMartketValue()?"pass":" fail");
	}

	private boolean testMartketValue() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", " Google", 10);
		Stock microsoftStrock = new Stock("2", "Microsoft", 100);
		
		stocks.add(googleStock);
		stocks.add(microsoftStrock);
		
		portfolio.setStocks(stocks);
		
		//mock o comportamento
		when(stockService.getPrice(googleStock)).thenReturn(50.00);
		when(stockService.getPrice(microsoftStrock)).thenReturn(1000.00);
		
		double marketValue = portfolio.getMarketValue();
		return marketValue == 100500.0;
	}

	private void setUp() {
		portfolio = new Portfolio();
		
		stockService = mock(StockService.class);
		
		portfolio.setStockService(stockService);
	}

}
