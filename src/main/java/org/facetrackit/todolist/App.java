package org.facetrackit.todolist;

import org.facetrackit.todolist.persistance.TaskRepository;
import org.facetrackit.todolist.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));

        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(request);
    }
}
