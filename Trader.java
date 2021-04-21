import java.util.ArrayList;
/**
 * @author Group 3: Tien N., Victoria T., Niklas K.
 * 
 * a Trader registers to observe some stocks
 * when there's a new trade submitted, this trader will get an update
 */
public class Trader implements Observer {
	private String name;
	private ArrayList<Subject> stocksOwned = new ArrayList<>(); //a Trader can register multiple stocks to observe
	
	public Trader() {
		this.name = "Anonymous";
	}
	/* default constructor create new Trader object with parameters:
	 * @param name, a list of registered stocks
	 * add all the registered stocks to stocksWatch
	 * adds this Trader to a observers list of each stock in the registered stocks list
	 */
	public Trader(String name) {
		this.name =  name;
	}
	/*
	 * register to watch/trade a specific stock
	 */
	public void addStock(Stock stock) {
		if (!stocksOwned.contains(stock)) {
			stocksOwned.add(stock);
			stock.addObserver(this);
		}
	}
	public void removeStock(Stock stock) {
			stocksOwned.remove(stock);
	}
	/* public access to Trader's name */
	public String getName() {
		return "Trader " + name;
	}
	/**
	 * turn the stocksWatch list to String for printing
	 * @return a String of all stocks that this Trader registered to observed
	 */
	public String getStocksList() {
		return stocksOwned.toString();
	}
	
	@Override
	/*
	 * call display method to print out the notification
	 * @param source where this method's called for testing
	 */
	public void update(Subject stock, Object newstate) {
			Stock latestStock = (Stock) stock;
			Trade latestTrade = (Trade) newstate;
			// if this stock is not already in the stocksOwned list, add it in
			if (latestTrade.getTrader().equals(this) && !stocksOwned.contains(latestStock)) {
				stocksOwned.add(stock);
			}
				display(latestStock, latestTrade);
	 }
	/*
	 * print out the notification
	 * @param source where this method's called for testing
	 */
	public void display(Stock latestStock, Trade latestTrade) {
		System.out.println("(" + name + " is notified) - " + latestTrade + " " + latestStock.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}

}//end of class
