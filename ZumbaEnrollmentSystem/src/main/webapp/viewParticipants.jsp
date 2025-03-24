<%@page import="com.zumba.dao.ParticipantDAO"%>
<%@page import="com.zumba.dto.ParticipantDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Participants</title>
</head>
<body>
    <h2>Participants List</h2>

    <% 
        ParticipantDAO participantDAO = new ParticipantDAO();
        List<ParticipantDTO> participants = participantDAO.getAllParticipants();
        
        if (participants.isEmpty()) {
    %>
        <p>No participants found.</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Batch</th>
                <th>Enrollment Date</th>
                <th>Actions</th>
            </tr>
            <% for (ParticipantDTO participant : participants) { %>
            <tr>
                <td><%= participant.getId() %></td>
                <td><%= participant.getName() %></td>
                <td><%= participant.getEmail() %></td>
                <td><%= participant.getPhone() %></td>
                <td><%= participant.getBatchName() %></td>
                <td><%= participant.getEnrollmentDate() %></td>
                <td>
                    <a href="editParticipant?id=<%= participant.getId() %>">Edit</a>
                    |
                    <a href="deleteParticipant?id=<%= participant.getId() %>" 
                       onclick="return confirm('Are you sure you want to delete this participant?');">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } %>
    <br>
	<a href="index.jsp">Back to Home</a>

</body>
</html>
