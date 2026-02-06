package menu;

import database.EmployeeDAO;
import model.Cashier;
import model.Employee;
import model.SalesAssistant;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void run() {
        int choice;

        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCashier();
                case 2 -> addSalesAssistant();
                case 3 -> viewAllEmployees();
                case 6 -> updateEmployee();
                case 7 -> deleteEmployee();
                case 8 -> searchByName();
                case 9 -> searchByHourlyRateRange();
                case 10 -> searchByMinHourlyRate();
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    // ✅ REQUIRED BY Menu INTERFACE
    @Override
    public void displayMenu() {
        System.out.println("""
                ╔════════════════════════════════════╗
                ║ CLOTHING STORE - STAFF MANAGEMENT  ║
                ╚════════════════════════════════════╝
                1. Add Cashier
                2. Add Sales Assistant
                3. View All Employees
                6. Update Employee
                7. Delete Employee
                8. Search by Name
                9. Search by Hourly Rate Range
                10. High Paid Employees (Min Rate)
                0. Exit
                """);
    }

    // ---------------- ADD ----------------

    private void addCashier() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Hourly Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience Years: ");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.print("Transactions: ");
        int transactions = Integer.parseInt(scanner.nextLine());

        Cashier cashier = new Cashier(1, name, rate, exp, true, transactions);
        employeeDAO.insertEmployee(cashier);
    }

    private void addSalesAssistant() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Hourly Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience Years: ");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.print("Items Sold: ");
        int itemsSold = Integer.parseInt(scanner.nextLine());

        SalesAssistant assistant = new SalesAssistant(1, name, rate, exp, true, itemsSold);
        employeeDAO.insertEmployee(assistant);
    }

    // ---------------- VIEW ----------------

    private void viewAllEmployees() {
        employeeDAO.displayAllEmployees();
    }

    // ---------------- UPDATE ----------------

    private void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Employee existing = employeeDAO.getEmployeeById(id);
        if (existing == null) {
            System.out.println("No employee found with ID: " + id);
            return;
        }

        System.out.println("Current Info:");
        System.out.println(existing);

        System.out.print("New Hourly Rate [" + existing.getHourlyRate() + "]: ");
        String rateInput = scanner.nextLine();
        if (!rateInput.trim().isEmpty()) {
            existing.setHourlyRate(Double.parseDouble(rateInput));
        }

        System.out.print("New Experience Years [" + existing.getExperienceYears() + "]: ");
        String expInput = scanner.nextLine();
        if (!expInput.trim().isEmpty()) {
            existing.setExperienceYears(Integer.parseInt(expInput));
        }

        boolean updated;
        if (existing instanceof Cashier cashier) {
            System.out.print("New Transactions [" + cashier.getTransactions() + "]: ");
            String trInput = scanner.nextLine();
            if (!trInput.trim().isEmpty()) {
                cashier.setTransactions(Integer.parseInt(trInput));
            }
            updated = employeeDAO.updateCashier(cashier);
        } else {
            SalesAssistant sa = (SalesAssistant) existing;
            System.out.print("New Items Sold [" + sa.getItemsSold() + "]: ");
            String soldInput = scanner.nextLine();
            if (!soldInput.trim().isEmpty()) {
                sa.setItemsSold(Integer.parseInt(soldInput));
            }
            updated = employeeDAO.updateSalesAssistant(sa);
        }

        if (updated) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }

    // ---------------- DELETE ----------------

    private void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            System.out.println("No employee found with ID: " + id);
            return;
        }

        System.out.println("Employee to delete:");
        System.out.println(employee);

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            if (employeeDAO.deleteEmployee(id)) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Delete failed!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // ---------------- SEARCH ----------------

    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Employee> results = employeeDAO.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void searchByHourlyRateRange() {
        System.out.print("Min hourly rate: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Max hourly rate: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Employee> results = employeeDAO.searchByHourlyRateRange(min, max);
        results.forEach(System.out::println);
    }

    private void searchByMinHourlyRate() {
        System.out.print("Minimum hourly rate: ");
        double min = Double.parseDouble(scanner.nextLine());

        List<Employee> results = employeeDAO.searchByMinHourlyRate(min);
        results.forEach(System.out::println);
    }
}
