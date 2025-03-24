package com.zumba.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zumba.dto.ParticipantDTO;
import com.zumba.model.Participant;

public class ParticipantDAO {

	// Add a new participant
	public boolean addParticipant(Participant participant) {
		String sql = "INSERT INTO participants (name, email, phone, batch_id, enrollment_date) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, participant.getName());
			stmt.setString(2, participant.getEmail());
			stmt.setString(3, participant.getPhone());

			if (participant.getBatchId() == 0) {
				stmt.setNull(4, Types.INTEGER);
			} else {
				stmt.setInt(4, participant.getBatchId());
			}

			stmt.setDate(5, new java.sql.Date(participant.getEnrollmentDate().getTime()));

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Retrieve all participants with batch details
	public List<ParticipantDTO> getAllParticipants() {
		List<ParticipantDTO> participants = new ArrayList<>();
		String query = "SELECT p.id, p.name, p.email, p.phone, p.enrollment_date, p.batch_id, b.batch_name "
				+ "FROM participants p LEFT JOIN batches b ON p.batch_id = b.id";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				participants.add(new ParticipantDTO(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone"), rs.getDate("enrollment_date"), rs.getInt("batch_id"),
						rs.getString("batch_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participants;
	}

	public Participant getParticipantById(int id) {
		String sql = "SELECT * FROM participants WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Participant(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone"), rs.getInt("batch_id"), rs.getTimestamp("enrollment_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 public boolean deleteParticipant(int id) {
	        String sql = "DELETE FROM participants WHERE id = ?";
	        
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setInt(1, id);
	            int rowsAffected = stmt.executeUpdate();
	            return rowsAffected > 0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	public boolean updateParticipant(Participant participant) {
		String sql = "UPDATE participants SET name=?, email=?, phone=?, batch_id=?, enrollment_date=? WHERE id=?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, participant.getName());
			stmt.setString(2, participant.getEmail());
			stmt.setString(3, participant.getPhone());
			stmt.setInt(4, participant.getBatchId());
			stmt.setTimestamp(5, participant.getEnrollmentDate());
			stmt.setInt(6, participant.getId());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
