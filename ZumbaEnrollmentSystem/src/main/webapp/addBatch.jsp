<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Batch</title>
</head>
<body>
	<h2>Create a New Batch</h2>
	<form action="addBatch" method="post">
		<label>Batch Name:</label> <input type="text" name="batchName"
			required> <br>
		<br> <label>Start Time:</label> <input type="time"
			name="startTime" required> <br>
		<br> <label>End Time:</label> <input type="time" name="endTime"
			required> <br>
		<br> <label>Max Capacity:</label> <input type="number"
			name="maxCapacity" required min="1"> <br>
		<br>

		<button type="submit">Create Batch</button>
	</form>
	<br>
	<a href="index.jsp">Back to Home</a>
</body>
</html>
