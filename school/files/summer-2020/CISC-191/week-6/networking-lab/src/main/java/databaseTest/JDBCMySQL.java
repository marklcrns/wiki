package databaseTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC for MySQL made for Employee.
 * Implements basic CRUD operation.
 */
public class JDBCMySQL {

    private Connection connection;
    private String database;
    private String table;

    public JDBCMySQL(String database, String table, String user, String pass) {
        this.database = database;
        this.table = table;
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?serverTimezone=UTC", user, pass);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert data into table test database.
     * @param employeeName     Name of employee to insert.
     * @param employeeSalary    Salary of the employee.
     */
    public void insertData(String employeeName, BigDecimal employeeSalary) throws Exception {
        // Prepare query statement
        String sqlInsert = "INSERT INTO " + table + " (NAME, SALARY) VALUE(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        // Insert values
        preparedStatement.setString (1, employeeName);
        preparedStatement.setBigDecimal(2, employeeSalary);

        // execute query
        preparedStatement.execute();
    }

    /**
     * Gets all data in the table
     * @return List<Employee> containing Employee table data.
     */
    public List<Employee> fetchAllData() throws Exception {
        List<Employee> result = new ArrayList<>();
        String sqlSelect = "Select * from " + table;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect)) {
            ResultSet data = preparedStatement.executeQuery();

            while (data.next()) {
                int id = data.getInt("ID");
                String name           = data.getString("NAME");
                BigDecimal salary     = data.getBigDecimal("SALARY");
                Timestamp createdDate = data.getTimestamp("CREATED_DATE");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                obj.setCreatedDate(createdDate.toLocalDateTime());

                result.add(obj);
            }
        }
        catch (SQLException e) { System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage()); }
        catch (Exception e) { e.printStackTrace(); }

        return result;
    }

    public void wipeData() throws Exception {
        Statement stmt = connection.createStatement();
        String sqlDelete = "DELETE FROM " + this.table;
        // Execute deletion
        stmt.executeUpdate(sqlDelete);
    }

    public void disconnect() throws Exception {
        this.connection.close();
    }

    public String getTable()    { return this.table; }
    public String getDatabase() { return this.database; }

    /**
     * Main method to wipe, insert and print all data from the EMPLOYEE table.
     */
    public static void main(String[] args) throws Exception {
        JDBCMySQL employee = new JDBCMySQL("test", "EMPLOYEE", "root", "password");
        employee.wipeData(); // Wipe all table data first

        employee.insertData("Mark Lucernas", new BigDecimal(1000000.0));
        employee.insertData("Chesca Lucernas", new BigDecimal(150000.0));
        employee.insertData("Trevor Lucernas", new BigDecimal(100.0));
        employee.insertData("Amara Lucernas", new BigDecimal(100.0));

        // Fetch and print all data
        List<Employee> result = new ArrayList<>();
        result = employee.fetchAllData();

        // Print result list
        System.out.println(employee.getTable());
        result.forEach(x -> System.out.println(x));

        // Close connection
        employee.disconnect();
    }
}
