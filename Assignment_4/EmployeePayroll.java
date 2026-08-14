package Assignment_4;
import java.util.Scanner;

public class EmployeePayroll {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        Integer employeeCount = Integer.valueOf(sc.nextLine());

        for (int i = 1; i <= employeeCount; i++) {
            System.out.println();
            System.out.println("Employee " + i);

            System.out.print("Enter Employee ID: ");
            Integer employeeId = Integer.valueOf(sc.nextLine());

            System.out.print("Enter Basic Salary: ");
            Double basicSalary = Double.valueOf(sc.nextLine());

            System.out.print("Enter Bonus Amount: ");
            Double bonusAmount = Double.valueOf(sc.nextLine());

            if (basicSalary <= 0) {
                System.out.println("Invalid salary entered for Employee ID " + employeeId);
                continue;
            }

            if (bonusAmount < 0) {
                System.out.println("Invalid bonus entered for Employee ID " + employeeId);
                continue;
            }

            Double netSalary = basicSalary + bonusAmount;

            System.out.println("Employee ID: " + employeeId);
            System.out.println("Basic Salary: Rs. " + basicSalary);
            System.out.println("Bonus: Rs. " + bonusAmount);
            System.out.println("Net Salary: Rs. " + netSalary);
        }

        sc.close();
    }
}
