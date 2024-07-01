import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public static List<String> taskNames = new ArrayList<>();
    public static List<Integer> durations = new ArrayList<>();
    public static List<String> developerDetails = new ArrayList<>();
    public static List<String> taskIDs = new ArrayList<>();
    public static List<String> taskStatuses = new ArrayList<>();
    public static List<String> taskDs = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task::questions);
    }

    public static void questions() {
        while (true) {
            String question = JOptionPane.showInputDialog("""
                    Option 1) Add tasks
                    Option 2) Show report
                    Option 3) Quit""");

            if (question.contains("1")|| question.contains("Add tasks")) {
                getTypeOfTask();
            } else if (question.contains("2")|| question.contains("Show report")) {
                showReport();
            } else if (question.contains("3")|| question.contains("Quit")) {
                JOptionPane.showMessageDialog(null, "Goodbye");
                break;
            }
        }
    }

    public static int getTypeOfTask() {
        int numberOfTasks = getNumberOfTasks();


        for (int c = 0; c < numberOfTasks; c++) {
           int taskNumber = taskNames.size() + 1;

            String taskName = JOptionPane.showInputDialog("Enter Task Name for Task " + taskNumber);
            taskNames.add(taskName);

            String taskD = getDescription(); // Capture task description
            taskDs.add(taskD); // Store description in list

            int duration = getTaskDuration(taskNumber);
            durations.add(duration);

            String taskStatus = getTaskStatus();
            taskStatuses.add(taskStatus);

            String developerDetail = JOptionPane.showInputDialog("Enter Name and Last Name");
            developerDetails.add(developerDetail);

            String taskID = generateTaskID(taskName, developerDetail, taskNumber);
            taskIDs.add(taskID);

            showTaskDetails(taskNumber,taskD);
        }

        showTotalHours();
        return numberOfTasks;
    }

    public static int getNumberOfTasks() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Enter Amount of Tasks"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            return 0;
        }
    }

    public static int getTaskDuration(int taskNumber) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Enter Duration for Task " + taskNumber));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a valid number.");
            return 0;
        }
    }

    public static String getTaskStatus() {
        String taskStatus = JOptionPane.showInputDialog("""
                Task Status
                1. To do
                2. Done
                3. Doing""");

        switch (taskStatus) {
            case "1": return "To do";
            case "2": return "Done";
            case "3": return "Doing";
            default:
                JOptionPane.showMessageDialog(null, "Invalid task status. Setting to 'To do'.");
                return "To do";
        }
    }
    public static String getDescription() {
        String taskD = "";
        while (true) {
            taskD = JOptionPane.showInputDialog("Enter Description" + "\n" + "Should not exceed 50 characters");
            if (taskD.length() <= 50) {
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of 50 characters or less");
            }
        }
        return taskD;
    }

    public static String generateTaskID(String taskName, String developerDetails, int taskNumber) {
        String firstTwoLetters = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase();
        String lastThreeLetters = developerDetails.substring(Math.max(developerDetails.length() - 3, 0)).toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    public static void showTaskDetails(int taskNumber, String taskDescription) {
        int index = taskNumber - 1;
        String printTaskDetails = "Task Status: " + taskStatuses.get(index) + "\n" +
                "Developer Details:\n" + developerDetails.get(index) + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskNames.get(index) + "\n" +
                "Description: " + taskDescription + "\n"+
                "Task ID: " + taskIDs.get(index) + "\n" +
                "Duration: " + durations.get(index);
        JOptionPane.showMessageDialog(null, printTaskDetails);
    }

    public static int returnTotalHours() {
        int totalHours = 0;
        for (int duration : durations) {
            totalHours += duration;
        }
        return totalHours;
    }

    public static void showTotalHours() {
        JOptionPane.showMessageDialog(null, "Total Hours: " + returnTotalHours());
    }

    public static void showReport() {
    String taskD = "";

    while (true) {
    String search = JOptionPane.showInputDialog("""
       1. Done
       2. Longest task Duration
       3. Enter Task Name
       4. Developer Name to Search
       5. Delete task
       6. Full task Reports""");

    //Option 1 Searches task with status (Done)
    if (search.contains("Done") || search.contains("1")) {

    //Searches through array
    for (int i = 0; i < taskStatuses.size(); i++) {
       if (taskStatuses.get(i).equals("Done")) {
         String details = "Task Status: " + taskStatuses.get(i) + "\n" +
          "Developer Details: " + developerDetails.get(i) + "\n" +
          "Task Name: " + taskNames.get(i) + "\n" +
          "Duration: " + durations.get(i);
          JOptionPane.showMessageDialog(null, details);}
       }
       break; // Exit loop after displaying results
    }
    //Option 2: Searches the array using bubble sort for longest duration
    else if (search.contains("Longest task Duration") || search.contains("2")) {

    // Sort durations to find the longest task duration
    int n = durations.size();
    for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
       if (durations.get(j) > durations.get(j + 1)) {
         int temp = durations.get(j);
         durations.set(j, durations.get(j + 1));
         durations.set(j + 1, temp);}

       // Display the longest duration (last element after sorting)
       JOptionPane.showMessageDialog(null, "Developer Details: "+ developerDetails.get(i)+"\n"+ "Longest task duration: " + durations.getLast());
    }}
    break; // Exit loop after displaying results
    }

    // Option 3: Searches array for Entered TaskName
    else if (search.contains("Enter Task Name") || search.contains("3")) {
       String searchValue = JOptionPane.showInputDialog("Enter Task Name");
       int found = 0;
       for (int i = 0; i < taskNames.size(); i++) {
           if (taskNames.get(i).equalsIgnoreCase(searchValue)) {
                        showTaskDetails(i + 1, taskD);
                        found = 1;}}

           if (found == 0) {
                    JOptionPane.showMessageDialog(null, "Task or Developer not found.");
                }}

    // Option 4: Searches array for Entered TaskName
    else if (search.contains("Developer Name to Search") || search.contains("4")) {
    String searchValue = JOptionPane.showInputDialog("Enter Developer Name to Search");
    int found = 0;
                for (int i = 0; i < developerDetails.size(); i++) {
                    if (developerDetails.get(i).equalsIgnoreCase(searchValue)) {
                        showTaskDetails(i + 1, taskD);
                        found = 1;
                    }
                }
                if (found == 0) {
                    JOptionPane.showMessageDialog(null, "Developer not found.");
                }
            }

    //Option 5: Gives the option to delete tasks
    else if (search.contains("Delete Task by Task Name") || search.contains("5")) {
         String deleteTaskName = JOptionPane.showInputDialog("Enter Task Name to Delete");
         int foundIndex = -1;
                for (int i = 0; i < taskNames.size(); i++) { //Searches through the array
                    if (taskNames.get(i).equalsIgnoreCase(deleteTaskName)) { //Searches each index to see which index in the array has the taskName needed to be deleted
                        foundIndex = i;
                    }}

                // If index is found
                if (foundIndex != -1) {
                    // Removes all the task details of the foundIndex
                    taskNames.remove(foundIndex);
                    durations.remove(foundIndex);
                    developerDetails.remove(foundIndex);
                    taskIDs.remove(foundIndex);
                    taskStatuses.remove(foundIndex);

                    JOptionPane.showMessageDialog(null, "Task '" + deleteTaskName + "' deleted successfully.");  //shows tasks has been deleted
                } else {
                    JOptionPane.showMessageDialog(null, "Task '" + deleteTaskName + "' not found.");  //if the task doesn't exist or has been deleted
                }
            }

            //Option 6: Shows all tasks
            else if (search.contains("Full task Reports")|| search.contains("6")){
                showFullTaskReports();
                }
            String continueSearch = JOptionPane.showInputDialog("Do you want to continue managing tasks? (yes/no)"); //Shows if you want to continue in report section
            if (continueSearch == null || continueSearch.equalsIgnoreCase("no")) {
                break;

            }}}


    public static void showFullTaskReports() {

     StringBuilder report = new StringBuilder();
     report.append("Full Task Reports:\n\n");
     for (int i = 0; i < taskNames.size(); i++) {
         report.append("Task ").append(i + 1).append(":\n");
         report.append("Task Status: ").append(taskStatuses.get(i)).append("\n");
         report.append("Developer Details: ").append(developerDetails.get(i)).append("\n");
         report.append("Task Name: ").append(taskNames.get(i)).append("\n");
         report.append("Description: ").append(taskDs.get(i)).append("\n");
         report.append("Task ID: ").append(taskIDs.get(i)).append("\n");
         report.append("Duration: ").append(durations.get(i)).append("\n\n");
         }
     JOptionPane.showMessageDialog(null, report.toString());}
    }
