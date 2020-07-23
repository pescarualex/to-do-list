package org.fasttrackit.persistence;


import org.fasttrackit.config.DatabaseConfiguration;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DTO (Data Transfer Object)
public class TaskRepository {

    public void createTask(CreateTaskRequest request) throws SQLException {
        String sql = "INSERT INTO task (description, deadline) VALUES (?, ?)";

        // try with resources
        try (PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();
        }
    }

    public void deleteTask(long id) throws SQLException {
        String sql = "DELETE FROM task WHERE id = ?";

        try ( PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }

    }

    public void updateTask(long id, UpdateTaskRequest request) throws SQLException {
        String sql = "UPDATE task SET done = ? WHERE id = ?";

        try ( PreparedStatement preparedStatement = DatabaseConfiguration.getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(2, id);
            preparedStatement.setBoolean(1, request.isDone());

            preparedStatement.executeUpdate();
        }

    }

}
