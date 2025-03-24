<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zumba.dao.BatchDAO, com.zumba.model.Batch" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Batch</title>
</head>
<body>
    <h2>Edit Batch</h2>

    <%
        int batchId = Integer.parseInt(request.getParameter("id"));
        BatchDAO batchDAO = new BatchDAO();
        Batch batch = batchDAO.getBatchById(batchId);
    %>

    <form action="updateBatch" method="post">
        <input type="hidden" name="id" value="<%= batch.getId() %>">
        
        <label>Batch Name:</label>
        <input type="text" name="batchName" value="<%= batch.getBatchName() %>" required>
        <br><br>

        <label>Start Time:</label>
        <input type="time" name="startTime" value="<%= batch.getStartTime() %>" required>
        <br><br>

        <label>End Time:</label>
        <input type="time" name="endTime" value="<%= batch.getEndTime() %>" required>
        <br><br>

        <label>Max Capacity:</label>
        <input type="number" name="maxCapacity" value="<%= batch.getMaxCapacity() %>" required>
        <br><br>

        <button type="submit">Update Batch</button>
    </form>

    <br>
    <a href="viewBatches.jsp">Back to Batches</a>
</body>
</html>
