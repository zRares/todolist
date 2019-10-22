package org.facetrackit.todolist.persistance;

import org.facetrackit.todolist.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskRepository {

    public void createTask (CreateTaskRequest request) throws SQLException, IOException, ClassNotFoundException {
        // preventing SQL injection
        String sql = "INSERT INTO task (description, deadline) VALUES (?, ?)";

        //try-with-resources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();
        }
    }
}
