import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFile {
    public static void main(String[] args) {
        String fileName = "employee.txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("101, Aaryan Pawar, Software Developer, 65000.0\n");
            writer.write("102, Harshal Pawar, Project Manager, 92000.0\n");
            writer.write("103, Sneha Kulkarni, Data Analyst, 58000.0\n");
            writer.close();

            System.out.println("Employee details written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Employee Details Read From File");
        System.out.println("-------------------------------");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading from file: " + e.getMessage());
        }
    }
}
