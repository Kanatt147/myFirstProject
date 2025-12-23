public class Main {
    public static void main(String[] args) {
        System.out.println("=== Clothing Store Management System ===");
        System.out.println();

        ClothingItem item1 = new ClothingItem(101, "Denim Jacket", "L", 120.0, "UrbanWear", 3);
        ClothingItem item2 = new ClothingItem(102, "Premium Hoodie", "M", 180.0, "NorthPeak", 1);
        ClothingItem item3 = new ClothingItem();

        Customer customer1 = new Customer(501, "Amina S.", "+77011234567", "amina@email.com", 190, false);
        Customer customer2 = new Customer(502, "Daniyar K.", "+77019876543", "daniyar@email.com", 260, true);
        Customer customer3 = new Customer();

        Order order1 = new Order(1001, customer1.getCustomerId(), item2.getItemId(), 2, 0.0, "Pending");
        Order order2 = new Order();

        Employee emp1 = new Employee(9001, "Mira T.", "Cashier", 9.0, 9, true);

        System.out.println("--- INITIAL OBJECTS ---");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(emp1);
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        item3.setItemId(103);
        item3.setName("Basic T-Shirt");
        item3.setSize("S");
        item3.setPrice(25.0);
        item3.setBrand("Everyday");
        item3.setStock(5);
        System.out.println("Updated item3: " + item3);

        customer3.setCustomerId(503);
        customer3.setName("Sanzhar R.");
        customer3.setPhoneNumber("+77015554433");
        customer3.setEmail("sanzhar@email.com");
        customer3.setLoyaltyPoints(210);
        customer3.setVip(customer3.getLoyaltyPoints() >= 200);
        System.out.println("Updated customer3: " + customer3);

        order2.setOrderId(1002);
        order2.setCustomerId(customer2.getCustomerId());
        order2.setItemId(item1.getItemId());
        order2.setQuantity(1);
        order2.setTotalCost(0.0);
        order2.setStatus("Pending");
        System.out.println("Updated order2: " + order2);

        emp1.setSalesMade(9);
        emp1.setHourlyRate(10.0);
        System.out.println("Updated emp1: " + emp1);
        System.out.println();

        System.out.println("--- TESTING ClothingItem METHODS ---");
        System.out.println(item1.getName() + " in stock: " + item1.isInStock());
        System.out.println("Selling one " + item1.getName() + ": " + item1.sellOne());
        System.out.println("Stock after sell: " + item1.getStock());
        item2.applyDiscount(20);
        System.out.println(item2.getName() + " after 20% discount price: " + item2.getPrice());
        System.out.println();

        System.out.println("--- TESTING Customer METHODS ---");
        System.out.println(customer1.getName() + " contact: " + customer1.getContactCard());
        customer1.addPoints(30);
        System.out.println(customer1.getName() + " points: " + customer1.getLoyaltyPoints() + " vip: " + customer1.isVip());
        boolean redeemed = customer1.redeemPoints(50);
        System.out.println("Redeem 50 points success: " + redeemed);
        System.out.println(customer1.getName() + " points now: " + customer1.getLoyaltyPoints() + " vip: " + customer1.isVip());
        System.out.println();

        System.out.println("--- TESTING Order METHODS ---");
        order1.calculateTotal(item2.getPrice());
        System.out.println("Order1 after calculate total: " + order1);
        System.out.println("Order1 pending: " + order1.isPending());
        order1.complete();
        System.out.println("Order1 after complete: " + order1);

        order2.calculateTotal(item1.getPrice());
        System.out.println("Order2 after calculate total: " + order2);
        order2.cancel();
        System.out.println("Order2 after cancel: " + order2);
        System.out.println();

        System.out.println("--- TESTING Employee METHODS ---");
        emp1.recordSale();
        emp1.recordSale();
        System.out.println("emp1 salesMade after 2 sales: " + emp1.getSalesMade());
        System.out.println("emp1 top seller: " + emp1.isTopSeller());
        System.out.println("emp1 weekly pay for 35 hours: " + emp1.calculateWeeklyPay(35));
        emp1.setActive(false);
        System.out.println("emp1 active now: " + emp1.isActive());
        System.out.println("emp1 weekly pay when inactive: " + emp1.calculateWeeklyPay(35));
        System.out.println();

        System.out.println("--- FINAL STATE ---");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(emp1);

        System.out.println();
        System.out.println("=== Program Complete ===");
    }
}
