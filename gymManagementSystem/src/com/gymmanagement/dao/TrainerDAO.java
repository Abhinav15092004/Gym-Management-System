package com.gymmanagement.dao;

import com.gymmanagement.database.DatabaseConnection;
import com.gymmanagement.model.Trainer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {
    public void addTrainer(String name, String specialty) {
        String sql = "INSERT INTO trainers (name, specialty) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, specialty);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trainer> getTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainers";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialty = rs.getString("specialty");
                trainers.add(new Trainer(id, name, specialty));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }
}
