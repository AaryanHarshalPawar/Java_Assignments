package Assignment_2;

public class Student{
    String studentName;
    int rollNumber;

    Student(){
        studentName = "Not Assigned";
        rollNumber = 0;
    }

    Student(String studentName, int rollNumber){
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }
    void display(){
        System.out.println("Student name: "+studentName + " Rollno: "+rollNumber);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Aaryan", 519);

        System.out.println("Student initialized using default constructor");
        s1.display();
        
        System.out.println("Student initialized using parameterized constructor");
        s2.display();
        
    }
}
