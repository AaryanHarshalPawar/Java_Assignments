package Assignment_5;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
     public static void main(String[] args) {
        ArrayList<String> registeredCourses = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println();
            System.out.println("Course Registration Menu");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Enter course name to add: ");
                String course = sc.nextLine();
                registeredCourses.add(course);
                System.out.println(course + " added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter course name to remove: ");
                String course = sc.nextLine();
                if (registeredCourses.remove(course)) {
                    System.out.println(course + " removed successfully.");
                } else {
                    System.out.println(course + " is not registered.");
                }
            } else if (choice == 3) {
                StringBuffer courseList = new StringBuffer();
                courseList.append("Registered Courses\n");
                courseList.append("------------------\n");

                if (registeredCourses.isEmpty()) {
                    courseList.append("No courses registered yet.\n");
                } else {
                    for (int i = 0; i < registeredCourses.size(); i++) {
                        courseList.append(i + 1);
                        courseList.append(". ");
                        courseList.append(registeredCourses.get(i));
                        courseList.append("\n");
                    }
                    courseList.append("Total courses: ");
                    courseList.append(registeredCourses.size());
                }
                System.out.println(courseList);
            } else if (choice == 4) {
                System.out.println("Exiting registration system.");
            } else {
                System.out.println("Invalid choice. Please try again.");
                                                                                                          }
        }

        sc.close();
    }
}
