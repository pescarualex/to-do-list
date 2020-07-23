package org.fasttrackit;

import org.fasttrackit.persistence.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );


          TaskRepository taskRepository = new TaskRepository();
//        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
//
//        createTaskRequest.setDescription("Learn JDBC");
//        createTaskRequest.setDeadline(LocalDate.now().plusWeeks(1));
//
//        taskRepository.createTask(createTaskRequest);

        taskRepository.deleteTask(1);
    }
}
