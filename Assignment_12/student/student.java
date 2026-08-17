package student;

public class Student {
    String studentName;
    int rollNumber;
    String course;

    public Student(String studentName, int rollNumber, String course) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public void display() {
        System.out.println("Student Details");
        System.out.println("---------------");
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}
