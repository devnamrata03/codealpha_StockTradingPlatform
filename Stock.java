public class Stock {
    String symbol;
    String name;
    double price;
    int quantity;

    public Stock(String symbol, String name, double price, int quantity) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return symbol + " - " + name + " | Price: ₹" + price + " | Available: " + quantity;
    }
}
