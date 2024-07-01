import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
 //Part 2 test
    class TaskTest {
    // Task 1
        @Test
        public void testTaskDescript_Successful() {
            String taskD = "Create Login to authenticate users";
            assertEquals(taskD, Task.taskDs);
        }

        @Test
        public void testTaskDescript_InvalidLength() {
            String taskD = "";
            // Task description should not exceed 50 characters
            String expected = "Create Login to authenticate users";
            assertEquals(expected, Task.taskDs);
        }

        @Test
        public void testGetTaskID() {
            // taskID
            String expected = "AD:1:BYN ";
            assertEquals(expected, Task.taskIDs );
        }

        @Test
        public void testReturnTotalHours() {
            int[] durations = {10, 12, 55,11, 1};
            int expected = 18;
            int expected1 = 89;
            assertEquals(expected, Task.durations);
            assertEquals(expected1, Task.durations);
        }

    @Test
    public void testTask2Descript_Successful() {
            String taskD = "";
        // Task description should not exceed 50 characters
        String expected = "Create Add Task feature to add task  users"; // As per the implementation, invalid length returns an empty string
        assertEquals(expected, Task.taskDs );
    }

    @Test
    public void testTask2Descript_InvalidLength() {
        String taskD = "";
        // Task description exceed 50 characters
        String expected = "Create Add Task feature to add task  users"; // As per the implementation, invalid length returns an empty string
        assertEquals(expected, Task.taskDs );
    }

    @Test
    public void testGetTaskID2() {
            //Generated taskID
        String expected = "CR:2:ITH";
        assertEquals(expected, Task.taskIDs );
    }

    @Test
    public void testReturnTotalHours2() {
            //Durations
        int[] durations = {10, 12, 55,11, 1};
        int expected = 18;
        int expected1 = 89;
        assertEquals(expected, Task.durations);
        assertEquals(expected1, Task.durations);
    }


    //Part 3 test
    @Test
 public void populateArray(){
     String[] developer = {"Mike Smith","Edward Harrison","Samantha Paulson"+"Glenda Oberholzer"};
        assertEquals(developer, Task.developerDetails);
        }

 @Test
public void testLongestDuration(){
     String Developer="Glenda Oberholzer,";
     int taskNumber = 11;
     String Actual = String.valueOf(Task.developerDetails);
     int actualTask = Task.getTypeOfTask();

     assertEquals(Developer+taskNumber,Actual+ actualTask);
     System.out.println(Developer+taskNumber);
 }

 @Test
 public void searchTask(){
     String Task = "Create Login";
     String taskNames="";
     assertEquals(Task,taskNames);
     System.out.println("Mike Smith, Create Login");
        }

 @Test
public void assignedTask(){
     String developerName = "Samantha Paulson";
     String taskName = "Create Reports";
     assertEquals(developerName, Task.developerDetails);
     assertEquals(taskName, Task.taskNames);
     System.out.println("Create report");
 }

@Test
public void deleteTask(){
     String taskName = "Create Report";
     assertEquals(taskName, Task.taskNames);
}}
