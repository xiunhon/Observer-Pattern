/*
 * a Trade object holds 3 variables
 * a Trader
 * a Trade option (BUY or SALE)
 * an amount
 */
public class Trade{
	private Trader trader;
	private TradeOption option;
	private double amount;
	/*
	 * default constructor will submit this Trade to notify all this Stock's observers
	 */
	public Trade(Trader trader, TradeOption option, double price) {
		this.trader = trader;
		this.option = option;
		this.amount = price;
	}
	/*
	 * public access to Trade's details 
	 * (Trader's name, trade option, price, Stock's name)
	 */
	public Trader getTrader() {
		return trader;
	}
	public TradeOption getOptions() {
		return option;
	}
	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "The latest trade is " + trader.getName() + " " + option.name().toLowerCase() + " $" + amount;
	}

}//end of class
