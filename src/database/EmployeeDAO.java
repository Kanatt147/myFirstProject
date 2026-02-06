package database;

import model.Cashier;
import model.Employee;
import model.SalesAssistant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // ---------------- CREATE (Week 7) ----------------
    public boolean insertEmployee(Employee employee) {

        String sql = """
                INSERT INTO employee
                (name, hourly_rate, experience_years, active, role, transactions, items_sold)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setDouble(2, employee.getHourlyRate());
            ps.setInt(3, employee.getExperienceYears());
            ps.setBoolean(4, employee.isActive());
            ps.setString(5, employee.getRole());

            if (employee instanceof Cashier c) {
                ps.setInt(6, c.getTransactions());
                ps.setNull(7, Types.INTEGER);
            } else if (employee instanceof SalesAssistant s) {
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, s.getItemsSold());
            } else {
                ps.setNull(6, Types.INTEGER);
                ps.setNull(7, Types.INTEGER);
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    // ---------------- READ ----------------
    public void displayAllEmployees() {
        String sql = "SELECT * FROM employee ORDER BY employee_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(formatEmployee(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractEmployee(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    // ---------------- UPDATE ----------------
    public boolean updateCashier(Cashier cashier) {

        String sql = """
                UPDATE employee
                SET name = ?, hourly_rate = ?, experience_years = ?, active = ?, transactions = ?
                WHERE employee_id = ? AND role = 'Cashier'
                """;

        return updateCommon(sql, cashier, cashier.getTransactions(), null);
    }

    public boolean updateSalesAssistant(SalesAssistant sa) {

        String sql = """
                UPDATE employee
                SET name = ?, hourly_rate = ?, experience_years = ?, active = ?, items_sold = ?
                WHERE employee_id = ? AND role = 'SalesAssistant'
                """;

        return updateCommon(sql, sa, null, sa.getItemsSold());
    }

    private boolean updateCommon(String sql, Employee e, Integer transactions, Integer itemsSold) {

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDouble(2, e.getHourlyRate());
            ps.setInt(3, e.getExperienceYears());
            ps.setBoolean(4, e.isActive());

            if (transactions != null) ps.setInt(5, transactions);
            else if (itemsSold != null) ps.setInt(5, itemsSold);

            ps.setInt(6, e.getEmployeeId());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    // ---------------- DELETE ----------------
    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM employee WHERE employee_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    // ---------------- SEARCH ----------------
    public List<Employee> searchByName(String name) {
        return search(
                "SELECT * FROM employee WHERE name ILIKE ? ORDER BY name",
                "%" + name + "%"
        );
    }

    public List<Employee> searchByHourlyRateRange(double min, double max) {
        return search(
                "SELECT * FROM employee WHERE hourly_rate BETWEEN ? AND ? ORDER BY hourly_rate DESC",
                min, max
        );
    }

    public List<Employee> searchByMinHourlyRate(double min) {
        return search(
                "SELECT * FROM employee WHERE hourly_rate >= ? ORDER BY hourly_rate DESC",
                min
        );
    }

    // ---------------- HELPERS ----------------
    private List<Employee> search(String sql, Object... params) {

        List<Employee> list = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return list;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractEmployee(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return list;
    }

    private Employee extractEmployee(ResultSet rs) throws SQLException {

        int id = rs.getInt("employee_id");
        String name = rs.getString("name");
        double rate = rs.getDouble("hourly_rate");
        int exp = rs.getInt("experience_years");
        boolean active = rs.getBoolean("active");
        String role = rs.getString("role");

        if ("Cashier".equals(role)) {
            return new Cashier(id, name, rate, exp, active, rs.getInt("transactions"));
        } else {
            return new SalesAssistant(id, name, rate, exp, active, rs.getInt("items_sold"));
        }
    }

    private String formatEmployee(ResultSet rs) throws SQLException {
        return rs.getInt("employee_id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("role") + " | Rate: " +
                rs.getDouble("hourly_rate");
    }
}
