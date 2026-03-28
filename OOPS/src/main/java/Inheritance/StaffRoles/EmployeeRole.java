package Inheritance.StaffRoles;

public class EmployeeRole implements Role {
    private final double salary;
    private final boolean partTime;

    public EmployeeRole(double salary, boolean partTime) {
        this.salary = salary; this.partTime = partTime;
    }

    public String describe() {
        return (partTime ? "Part-time" : "Full-time") + " employee, salary " + salary;
    }
}
