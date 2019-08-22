package Exemplo1;

public class Stock {

	private String stockID;
	private String name;
	private int quantity;
	
	public Stock(String stockID, String name, int quantity) {
		this.stockID = stockID;
		this.name = name;
		this.quantity = quantity;
	}

	public String getStockID() {
		return stockID;
	}

	public void setStockID(String stockID) {
		this.stockID = stockID;
	}

	public String getTicker() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

}
