import java.util.ArrayList;
/**
 * 
 * @author Group 3: Tien N., Victoria T., Niklas K.
 * each Stock has its own list of Traders who registered to observe it
 * must notify its observers when there are new trade has been made
 *
 */
public class Stock implements Subject {
	private String stockName;
	private Trade latestTrade;
	private ArrayList<Observer> tradersList;// maintain a list of traders who registered to observe this stock
	
	/*
	 * overloaded constructor takes in a stock's name
	 * and create an empty list of observers
	 * @param name
	 */
	public Stock(String name) {
		this.stockName = name;
		this.tradersList = new ArrayList<>();
	}
	
	/* public access to stock's name */
	public String getName() {
		return "Stock: " + stockName;
	}
	
	/* any new Trade will invoke this method to notify this Stock's observers */
	public void submitTrade(Trade latestTrade) {
		this.latestTrade = latestTrade;
		if (!tradersList.contains(latestTrade.getTrader())) {
			addObserver(latestTrade.getTrader());
		}
			notifyObservers();
	}
	
	@Override
	/* add a registered observer to this Stock's tradersList*/
	public void addObserver(Observer o) {
		Trader t = (Trader) o;
		tradersList.add(t);
	}

	@Override
	/* remove a registered observer */
	public void removeObserver(Observer o) {
		Trader t = (Trader) o;
		tradersList.remove(t);
	}

	@Override
	/* notify all registered observers */
	public void notifyObservers() {
		for (int i = 0; i<tradersList.size(); i++) {
			Observer observer = tradersList.get(i);
			observer.update(this, latestTrade);
		}
	}
	
	@Override
	/* return a String represent this Stock
	 * i.e. Stock: FB
	 */
	public String toString() {
		return stockName;
	}
	
	/* return a String of all registered Traders' name */
	public String displayTradersList() {
		return tradersList.toString();
	}
}
