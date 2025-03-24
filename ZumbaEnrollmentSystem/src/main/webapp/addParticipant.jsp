<%@page import="com.zumba.dao.BatchDAO"%>
<%@page import="com.zumba.model.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Participant</title>

</head>
<body onload="setMinDate()">
	<h2>Add New Participant</h2>
	<form action="addParticipant" method="post">
		<label>Name:</label> <input type="text" name="name" required><br>
		<br> <label>Email:</label> <input type="email" name="email"
			required><br>
		<br> <label>Phone:</label> <input type="text" name="phone"
			required><br>
		<br> <label>Batch:</label> 
		<select name="batchId" required>
			<option value="">Select a Batch</option>
			<%
			BatchDAO batchDAO = new BatchDAO();
			List<Batch> batches =  batchDAO.getAllBatches();
			for (Batch batch : batches) {
			%>
			<option value="<%=batch.getId()%>"><%=batch.getBatchName()%></option>
			<%
			}
			%>
		</select> <label>Enrollment Date:</label> <input type="date"
			id="enrollmentDate" name="enrollmentDate" required><br>
		<br>

		<button type="submit">Add Participant</button>
	</form>
</body>
</html>