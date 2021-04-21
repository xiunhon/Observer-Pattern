# Observer-Pattern
Using Observer Pattern to implement a stock market's notification system

This assignment will give you practice in using the Observer Design Pattern.
Consider a stock trading system whereby there is a stock market that keeps track of all trades of specific stocks (subjects) and must inform all traders (observers) when a new trade has been made for a certain stock.
Stocks are distinguished by short acronyms (i.e. MSFT, GOOG, AAPL.)
A trade of a specific stock can be either a buy or sell and it occurs at a certain price.
Each stock subject will maintain a list of all traders registered with it and will notify each registered trader when a trade has been made for that specific stock.
Registering/unregistering as an observer of a stock has nothing to do with buying or selling a stock. You can observe a stock even if you don't own it.
You may use either the Subject/Observer interfaces provided in the Observer lab or the observer pattern available in the Java API.
Design the Trader class (which implements either the Observer interface or java.util.Observer.)
Design the Stock class (which implements either the Subject interface or extends the java.util.Observable class.)
Write some test code that creates a StockMarket as well as 3-4 Stock objects.
Create 3-4 Trader objects.
Have the stock market register each trader with a few stocks and then have the traders make trades for those stocks. Remember trades are either a buy or sell and occur at a certain price.
Make sure your test code illustrates how each trader is notified when a trade for the stock(s) they are registered for is made.
A Trader can own many stocks. A stock can be owned by many Traders. This is very important to the design of the project.
You may find it helpful to model Trades of each stock similar to the Bid.java class.
This application is a little more involved than the Auction example from the lab.
Each stock will have its own list of observers. You will have to add the observers to each stock separately from their constructor.
The output must have not only the trader’s name and amount, it must indicate the stock symbol and the transaction type (buy or sell).
Here’s some sample output:
The latest trade is Trader: Julie sell $160.0 Stock: MSFT
The latest trade is Trader: Julie sell $160.0 Stock: MSFT
The latest trade is Trader: Amy sell $165.0 Stock: AAPL
The latest trade is Trader: Amy sell $165.0 Stock: AAPL
The latest trade is Trader: Julie buy $170.0 Stock: GOOG
