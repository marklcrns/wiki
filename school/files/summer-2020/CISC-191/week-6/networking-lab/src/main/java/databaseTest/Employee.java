package databaseTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** MySQL EMPLOYEE Table definition.

  CREATE TABLE EMPLOYEE
  (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(100) NOT NULL,
  SALARY DECIMAL(15, 2) NOT NULL,
  CREATED_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
  );

*/
public class Employee {

    private int id;
    private String name;
    private BigDecimal salary;
    private LocalDateTime createdDate;

    public Employee() {}

    public Employee(int id, String name, BigDecimal salary, LocalDateTime createdDate) {
        this.id          = id;
        this.name        = name;
        this.salary      = salary;
        this.createdDate = createdDate;
    }

    /** Accessor methods */
    public int getId()                                    { return id; }
    public String getName()                               { return name; }
    public BigDecimal getSalary()                         { return salary; }
    public LocalDateTime getCreatedDate()                 { return createdDate; }

    /** Modifier methods */
    public void setId(int id)                             { this.id = id; }
    public void setName(String name)                      { this.name = name; }
    public void setSalary(BigDecimal salary)              { this.salary = salary; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", createdDate=" + createdDate;
    }
}
