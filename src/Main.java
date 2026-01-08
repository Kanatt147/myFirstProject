import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<ClothingItem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        items.add(new ClothingItem(101, "Denim Jacket", "L", 120.0, "UrbanWear", 3));
        items.add(new ClothingItem(102, "Premium Hoodie", "M", 180.0, "NorthPeak", 1));

        customers.add(new Customer(501, "Amina S.", "+77011234567", "amina@email.com", 190, false));
        customers.add(new Customer(502, "Daniyar K.", "+77019876543", "daniyar@email.com", 260, true));

        employees.add(new Employee(9000, "General Employee", 8.5, 1, true));
        employees.add(new Cashier(9001, "Mira T.", 9.0, 2, true, 45));
        employees.add(new SalesAssistant(9002, "Arman K.", 10.0, 4, true, 120));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: addClothingItem(); break;
                case 2: viewAllClothingItems(); break;
                case 3: addCustomer(); break;
                case 4: viewAllCustomers(); break;
                case 5: addEmployee(); break;
                case 6: addCashier(); break;
                case 7: addSalesAssistant(); break;
                case 8: viewAllEmployees(); break;
                case 9: demonstratePolymorphism(); break;
                case 10: viewCashiersOnly(); break;
                case 11: viewSalesAssistantsOnly(); break;
                case 0:
                    System.out.println("\nGoodbye! 👋");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! ❌");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("  CLOTHING STORE MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("----------------------------------------");
        System.out.println("5. Add Employee (General)");
        System.out.println("6. Add Cashier");
        System.out.println("7. Add Sales Assistant");
        System.out.println("8. View All Employees (Polymorphic)");
        System.out.println("9. Make All Employees Work (Polymorphism Demo)");
        System.out.println("10. View Cashiers Only");
        System.out.println("11. View Sales Assistants Only");
        System.out.println("----------------------------------------");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    private static void addClothingItem() {
        System.out.println("\n--- ADD CLOTHING ITEM ---");
        int id = readInt("Enter item ID: ");
        String name = readLine("Enter item name: ");
        String size = readLine("Enter size (S/M/L/XL/XXL): ");
        double price = readDouble("Enter price (KZT): ");
        String brand = readLine("Enter brand: ");
        int stock = readInt("Enter stock: ");

        ClothingItem item = new ClothingItem(id, name, size, price, brand, stock);
        items.add(item);

        System.out.println("\nClothing item added successfully ✅");
    }

    private static void viewAllClothingItems() {
        System.out.println("\n========================================");
        System.out.println("  ALL CLOTHING ITEMS");
        System.out.println("========================================");

        if (items.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }

        System.out.println("Total items: " + items.size());
        System.out.println();

        for (int i = 0; i < items.size(); i++) {
            ClothingItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getFormattedPrice());
            System.out.println("   ID: " + item.getItemId() + " | Size: " + item.getSize() + " | Brand: " + item.getBrand());
            System.out.println("   Stock: " + item.getStock() + " | In Stock: " + (item.isInStock() ? "Yes ✅" : "No ❌"));
            System.out.println();
        }
    }

    private static void addCustomer() {
        System.out.println("\n--- ADD CUSTOMER ---");
        int id = readInt("Enter customer ID: ");
        String name = readLine("Enter name: ");
        String phone = readLine("Enter phone number: ");
        String email = readLine("Enter email: ");
        int points = readInt("Enter loyalty points: ");

        Customer c = new Customer(id, name, phone, email, points, false);
        customers.add(c);

        System.out.println("\nCustomer added successfully ✅");
    }

    private static void viewAllCustomers() {
        System.out.println("\n========================================");
        System.out.println("  ALL CUSTOMERS");
        System.out.println("========================================");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("Total customers: " + customers.size());
        System.out.println();

        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " (ID: " + c.getCustomerId() + ")");
            System.out.println("   Contact: " + c.getContactCard());
            System.out.println("   Points: " + c.getLoyaltyPoints() + " | VIP: " + (c.isVip() ? "Yes ⭐" : "No"));
            System.out.println();
        }
    }

    private static void addEmployee() {
        System.out.println("\n--- ADD EMPLOYEE (GENERAL) ---");
        int id = readInt("Enter employee ID: ");
        String name = readLine("Enter name: ");
        double rate = readDouble("Enter hourly rate: ");
        int exp = readInt("Enter experience years: ");
        boolean active = readBoolean("Is active? (true/false): ");

        Employee e = new Employee(id, name, rate, exp, active);
        employees.add(e);

        System.out.println("\nEmployee added successfully ✅");
    }

    private static void addCashier() {
        System.out.println("\n--- ADD CASHIER ---");
        int id = readInt("Enter employee ID: ");
        String name = readLine("Enter name: ");
        double rate = readDouble("Enter hourly rate: ");
        int exp = readInt("Enter experience years: ");
        boolean active = readBoolean("Is active? (true/false): ");
        int transactions = readInt("Enter transactions: ");

        Employee e = new Cashier(id, name, rate, exp, active, transactions);
        employees.add(e);

        System.out.println("\nCashier added successfully ✅");
    }

    private static void addSalesAssistant() {
        System.out.println("\n--- ADD SALES ASSISTANT ---");
        int id = readInt("Enter employee ID: ");
        String name = readLine("Enter name: ");
        double rate = readDouble("Enter hourly rate: ");
        int exp = readInt("Enter experience years: ");
        boolean active = readBoolean("Is active? (true/false): ");
        int itemsSold = readInt("Enter items sold: ");

        Employee e = new SalesAssistant(id, name, rate, exp, active, itemsSold);
        employees.add(e);

        System.out.println("\nSales Assistant added successfully ✅");
    }

    private static void viewAllEmployees() {
        System.out.println("\n========================================");
        System.out.println("  ALL EMPLOYEES (POLYMORPHIC LIST)");
        System.out.println("========================================");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("Total employees: " + employees.size());
        System.out.println();

        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.println((i + 1) + ". " + e);

            if (e instanceof Cashier) {
                Cashier c = (Cashier) e;
                if (c.isFastCashier()) {
                    System.out.println("   Fast Cashier ⚡");
                }
            } else if (e instanceof SalesAssistant) {
                SalesAssistant s = (SalesAssistant) e;
                if (s.isTopSeller()) {
                    System.out.println("   Top Seller 🌟");
                }
            }

            System.out.println();
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling work() on all employees:\n");

        for (Employee e : employees) {
            e.work();
        }

        System.out.println("\n✨ Same method (work), different behavior = POLYMORPHISM!");
    }

    private static void viewCashiersOnly() {
        System.out.println("\n========================================");
        System.out.println("  CASHIERS ONLY");
        System.out.println("========================================");

        int count = 0;
        for (Employee e : employees) {
            if (e instanceof Cashier) {
                Cashier c = (Cashier) e;
                count++;
                System.out.println(count + ". " + c.getName() + " | Transactions: " + c.getTransactions());
            }
        }
        if (count == 0) System.out.println("No cashiers found.");
    }

    private static void viewSalesAssistantsOnly() {
        System.out.println("\n========================================");
        System.out.println("  SALES ASSISTANTS ONLY");
        System.out.println("========================================");

        int count = 0;
        for (Employee e : employees) {
            if (e instanceof SalesAssistant) {
                SalesAssistant s = (SalesAssistant) e;
                count++;
                System.out.println(count + ". " + s.getName() + " | Items Sold: " + s.getItemsSold());
            }
        }
        if (count == 0) System.out.println("No sales assistants found.");
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            try {
                return Double.parseDouble(s.trim());
            } catch (Exception e) {
                System.out.println("Invalid decimal number. Try again.");
            }
        }
    }

    private static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim().toLowerCase();
            if (s.equals("true")) return true;
            if (s.equals("false")) return false;
            System.out.println("Please type true or false.");
        }
    }
}
