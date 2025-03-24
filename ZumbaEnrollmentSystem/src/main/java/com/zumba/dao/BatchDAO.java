package com.zumba.dao;

import com.zumba.model.Batch;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
    
    public boolean addBatch(Batch batch) {
        String sql = "INSERT INTO batches (batch_name, start_time, end_time, max_capacity) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, batch.getBatchName());
            stmt.setString(2, batch.getStartTime());
            stmt.setString(3, batch.getEndTime());
            stmt.setInt(4, batch.getMaxCapacity());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Batch> getAllBatches() {
        List<Batch> batches = new ArrayList<>();
        String sql = "SELECT * FROM batches";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Batch batch = new Batch(
                        rs.getInt("id"),
                        rs.getString("batch_name"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getInt("max_capacity")
                );
                batches.add(batch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batches;
    }
    
    public boolean deleteBatch(int id) {
        String sql = "DELETE FROM batches WHERE id = ?";
        boolean rowDeleted = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            rowDeleted = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public Batch getBatchById(int id) {
        String sql = "SELECT * FROM batches WHERE id = ?";
        Batch batch = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                batch = new Batch(
                        rs.getInt("id"),
                        rs.getString("batch_name"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getInt("max_capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batch;
    }

    public boolean updateBatch(Batch batch) {
        String sql = "UPDATE batches SET batch_name = ?, start_time = ?, end_time = ?, max_capacity = ? WHERE id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, batch.getBatchName());
            stmt.setString(2, batch.getStartTime());
            stmt.setString(3, batch.getEndTime());
            stmt.setInt(4, batch.getMaxCapacity());
            stmt.setInt(5, batch.getId());

            int rowsAffected = stmt.executeUpdate();
            updated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

}
