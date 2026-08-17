import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PatientFile {
    public static void main(String[] args) {
        String fileName = "patient.txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("P101, Rahul Sharma, 34, Diabetes\n");
            writer.write("P102, Meera Joshi, 28, Asthma\n");
            writer.write("P103, Anil Deshpande, 56, Hypertension\n");
            writer.close();

            System.out.println("Patient details written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Patient Details Read From File");
        System.out.println("------------------------------");
        System.out.println("Patient ID | Name | Age | Diagnosis");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                String[] details = line.split(", ");
                System.out.println(details[0] + " | " + details[1] + " | " + details[2] + " | " + details[3]);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error while reading from file: " + e.getMessage());
        }
    }
}
