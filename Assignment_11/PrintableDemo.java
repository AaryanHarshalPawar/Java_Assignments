package Assignment_11;

public class PrintableDemo {
    interface Printable {
        void print();
    }

    static class Student implements Printable {
        String studentName;
        int rollNumber;
        String course;

        Student(String studentName, int rollNumber, String course) {
            this.studentName = studentName;
            this.rollNumber = rollNumber;
            this.course = course;
        }

        public void print() {
            System.out.println("Student Details");
            System.out.println("---------------");
            System.out.println("Name: " + studentName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Course: " + course);
        }
    }

    static class Employee implements Printable {
        String employeeName;
        int employeeId;
        double salary;

        Employee(String employeeName, int employeeId, double salary) {
            this.employeeName = employeeName;
            this.employeeId = employeeId;
            this.salary = salary;
        }

        public void print() {
            System.out.println("Employee Details");
            System.out.println("----------------");
            System.out.println("Name: " + employeeName);
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Salary: Rs. " + salary);
        }
    }

    public static void main(String[] args) {
        Printable student = new Student("Aaryan Pawar", 519, "B.Tech AIML");
        Printable employee = new Employee("XYZ", 1042, 78000.0);

        student.print();
        System.out.println();
        employee.print();
    }
}
