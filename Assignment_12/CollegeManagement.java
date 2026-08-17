import student.Student;
import faculty.Faculty;

public class CollegeManagement {
    public static void main(String[] args) {
        Student student = new Student("Aaryan Pawar", 519, "B.Tech AIML");
        Faculty faculty = new Faculty("Dr. S. R. Deshmukh", 1042, "Computer Science", "Programming with Java");

        System.out.println("College Management System");
        System.out.println("=========================");

        student.display();
        System.out.println();
        faculty.display();
    }
}
