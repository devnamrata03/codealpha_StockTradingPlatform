import java.util.HashMap;
import java.util.Map;

public class User {
    String username;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public void buyStock(String symbol, int quantity, double price) {
        balance -= quantity * price;
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
    }

    public void sellStock(String symbol, int quantity, double price) {
        balance += quantity * price;
        int remaining = portfolio.get(symbol) - quantity;
        if (remaining <= 0) {
            portfolio.remove(symbol);
        } else {
            portfolio.put(symbol, remaining);
        }
    }

    public void viewPortfolio() {
        System.out.println("📊 Portfolio of " + username);
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " shares");
        }
        System.out.println("💰 Balance: ₹" + balance);
    }
}
