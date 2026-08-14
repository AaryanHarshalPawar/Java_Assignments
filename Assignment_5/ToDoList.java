package Assignment_5;

import java.util.ArrayList;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<String>();

        tasks.add("Complete Java assignment");
        tasks.add("Revise DBMS notes");
        tasks.add("Submit project report");
        tasks.add("Prepare for viva");

        StringBuffer taskList = new StringBuffer();
        taskList.append("My To-Do List\n");
        taskList.append("-------------\n");

        for (int i = 0; i < tasks.size(); i++) {
            taskList.append(i + 1);
            taskList.append(". ");
            taskList.append(tasks.get(i));
            taskList.append("\n");
        }

        System.out.println(taskList);

        tasks.remove("Revise DBMS notes");

        StringBuffer updatedList = new StringBuffer();
        updatedList.append("Updated To-Do List\n");
        updatedList.append("------------------\n");

        for (int i = 0; i < tasks.size(); i++) {
            updatedList.append(i + 1);
            updatedList.append(". ");
            updatedList.append(tasks.get(i));
            updatedList.append("\n");
        }

        System.out.println(updatedList);
        System.out.println("Total pending tasks: " + tasks.size());
    }
}
