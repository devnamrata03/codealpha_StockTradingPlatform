import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Stock> market = new ArrayList<>();
        market.add(new Stock("TCS", "Tata Consultancy Services", 3450.0, 100));
        market.add(new Stock("INFY", "Infosys", 1450.0, 150));
        market.add(new Stock("RELI", "Reliance", 2450.0, 120));

        User user = new User("Namrata", 10000.0);

        while (true) {
            System.out.println("\n📈 Welcome to Simple Stock Trading Platform");
            System.out.println("1. View Available Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (Stock s : market) {
                    System.out.println(s);
                }
            } else if (choice == 2) {
                System.out.print("Enter Stock Symbol: ");
                String symbol = sc.next();
                System.out.print("Enter Quantity to Buy: ");
                int qty = sc.nextInt();

                for (Stock s : market) {
                    if (s.symbol.equalsIgnoreCase(symbol)) {
                        if (s.quantity >= qty && user.balance >= qty * s.price) {
                            s.quantity -= qty;
                            user.buyStock(symbol, qty, s.price);
                            System.out.println("✅ Purchase Successful!");
                        } else {
                            System.out.println("❌ Not enough stock or balance.");
                        }
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.print("Enter Stock Symbol: ");
                String symbol = sc.next();
                System.out.print("Enter Quantity to Sell: ");
                int qty = sc.nextInt();

                for (Stock s : market) {
                    if (s.symbol.equalsIgnoreCase(symbol)) {
                        Integer owned = user.portfolio.get(symbol);
                        if (owned != null && owned >= qty) {
                            s.quantity += qty;
                            user.sellStock(symbol, qty, s.price);
                            System.out.println("✅ Sell Successful!");
                        } else {
                            System.out.println("❌ You don't own enough shares.");
                        }
                        break;
                    }
                }
            } else if (choice == 4) {
                user.viewPortfolio();
            } else if (choice == 5) {
                System.out.println("👋 Exiting... Thank you!");
                break;
            } else {
                System.out.println("❌ Invalid Choice");
            }
        }
    }
}
