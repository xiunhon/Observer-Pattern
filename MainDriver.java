/**
 * @author Tien N.
 * Observer Pattern Tester
 */
public class MainDriver {

	public static void main(String[] args) {
		Stock facebook = new Stock("FB");
		Stock google = new Stock("GOOGL");
		Stock tesla = new Stock("TSLA");
		Stock amazon = new Stock("AMZN");
		Trader kelvin = new Trader("Kelvin");
		Trader alexa = new Trader("Alexa");
		Trader mariana = new Trader("Mariana");
		Trader godzila = new Trader("Godzila");
		Trader noone = new Trader();
		System.out.println("Register some Traders to some stocks");
		System.out.println("- Kelvin registered:   FB                  AMZN");
		System.out.println("- Alexa registered:    FB");
		System.out.println("- Mariana registered:       GOOGL");
		System.out.println("- Godzila registered:       GOOGL   TSLA");
		System.out.println("- Anonymous registered:                    AMZN");
		kelvin.addStock(facebook);
		kelvin.addStock(amazon);
		alexa.addStock(facebook);
		mariana.addStock(google);
		godzila.addStock(google);
		godzila.addStock(tesla);
		noone.addStock(amazon);
		System.out.println("Register some Traders to observe some stocks (*)");
		System.out.println("- Kelvin registered:   FB  *GOOGL         AMZN");
		System.out.println("- Alexa registered:    FB  *GOOGL");
		System.out.println("- Mariana registered:       GOOGL        *AMZN");
		System.out.println("- Godzila registered:       GOOGL   TSLA");
		System.out.println("- Anonymous registered:    *GOOGL         AMZN");
		google.addObserver(kelvin);
		google.addObserver(alexa);
		google.addObserver(noone);
		amazon.addObserver(mariana);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Stock GOOGL has a new trade submitted by Mariana");
		System.out.println("   'Trader Mariana buy $1000.0 Stock: GOOGL");
		System.out.println("    Expected all 5 Traders get notified == ");
		google.submitTrade(new Trade(mariana, TradeOption.BUY, 1000.0));
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Kelvin removes AMZN from his trade list but still observes it");
		kelvin.removeStock(amazon);
		System.out.println("Kelvin's stocks list:\n    Expected FB == " + kelvin.getStocksList());
		System.out.println("AMZN's observers:\n    Expected Kelvin, Annonymous, Mariana == " + amazon.displayTradersList());
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("Testing unregistered trader:");
		System.out.println("Godzila's stocks list BEFORE: Expected GOOGL, TSLA == " + godzila.getStocksList());
		System.out.println();
		System.out.println("Stock AMZN has a new trade submitted by Godzila");
		System.out.println("   'Trader Godzila sell $400.0 Stock: AMZN");
		System.out.println("    Expected 4 Traders get notified: Kelvin, Anonymous, Mariana, Godzila == ");
		amazon.submitTrade(new Trade(godzila, TradeOption.SELL, 400.0));
		System.out.println();
		System.out.println("Godzila's stocks list AFTER: Expected GOOGL, TSLA, AMZN == " + godzila.getStocksList());
		System.out.println("------------------------------------------------------------------------");
		
	}//end of main

}//end of class
