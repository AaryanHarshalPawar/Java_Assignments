package faculty;

public class Faculty {
    String facultyName;
    int facultyId;
    String department;
    String subject;

    public Faculty(String facultyName, int facultyId, String department, String subject) {
        this.facultyName = facultyName;
        this.facultyId = facultyId;
        this.department = department;
        this.subject = subject;
    }

    public void display() {
        System.out.println("Faculty Details");
        System.out.println("---------------");
        System.out.println("Name: " + facultyName);
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Department: " + department);
        System.out.println("Subject: " + subject);
    }
}
