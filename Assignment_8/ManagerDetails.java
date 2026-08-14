package Assignment_8;
public class ManagerDetails {
    static class Employee {
        String employeeName;
        int employeeId;
        double basicSalary;

        Employee(String employeeName, int employeeId, double basicSalary) {
            this.employeeName = employeeName;
            this.employeeId = employeeId;
            this.basicSalary = basicSalary;
        }

        void display() {
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Basic Salary: Rs. " + basicSalary);
        }
    }

    static class Manager extends Employee {
        String department;
        double allowance;

        Manager(String employeeName, int employeeId, double basicSalary, String department, double allowance) {
            super(employeeName, employeeId, basicSalary);
            this.department = department;
            this.allowance = allowance;
        }

        void display() {
            System.out.println("Manager Details");
            System.out.println("---------------");
            super.display();
            System.out.println("Department: " + department);
            System.out.println("Allowance: Rs. " + allowance);
            System.out.println("Total Salary: Rs. " + (super.basicSalary + allowance));
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Aaryan Pawar", 519, 65000.0, "Information Technology", 15000.0);
        manager.display();
    }
}
