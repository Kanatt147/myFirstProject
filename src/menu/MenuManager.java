package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n1. Add Cashier");
        System.out.println("2. Add Sales Assistant");
        System.out.println("3. View Employees");
        System.out.println("4. Polymorphism Demo");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addCashier();
                    case 2 -> addSalesAssistant();
                    case 3 -> viewEmployees();
                    case 4 -> demoWork();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addCashier() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.print("Experience: ");
        int exp = Integer.parseInt(scanner.nextLine());
        System.out.print("Transactions: ");
        int t = Integer.parseInt(scanner.nextLine());

        employees.add(new Cashier(id, name, rate, exp, true, t));
        System.out.println("Cashier added!");
    }

    private void addSalesAssistant() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.print("Experience: ");
        int exp = Integer.parseInt(scanner.nextLine());
        System.out.print("Items sold: ");
        int sold = Integer.parseInt(scanner.nextLine());

        employees.add(new SalesAssistant(id, name, rate, exp, true, sold));
        System.out.println("Sales Assistant added!");
    }

    private void viewEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    private void demoWork() {
        for (Employee e : employees) {
            e.work();
        }
    }
}
