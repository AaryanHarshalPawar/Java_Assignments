package Assignment_4;

public class MarksConverter {
     public static void main(String[] args) {
        String[] subjectNames = {"Java", "DBMS", "Networks", "Maths", "OS"};
        String[] marksInString = {"78", "85", "92", "66", "89"};

        int totalMarks = 0;

        System.out.println("Student Marks Report");
        System.out.println("--------------------");

        for (int i = 0; i < marksInString.length; i++) {
            Integer marks = Integer.valueOf(marksInString[i]);
            System.out.println(subjectNames[i] + " : " + marks);
            totalMarks = totalMarks + marks;
        }

        int maximumMarks = marksInString.length * 100;
        double percentage = (totalMarks * 100.0) / maximumMarks;

        System.out.println("--------------------");
        System.out.println("Total Marks: " + totalMarks + " out of " + maximumMarks);
        System.out.println("Percentage: " + percentage + "%");
    }
}
