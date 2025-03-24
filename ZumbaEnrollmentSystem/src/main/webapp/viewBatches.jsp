<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.zumba.model.Batch"%>
<%@ page import="com.zumba.dao.BatchDAO"%>
<!DOCTYPE html>
<html>
<head>
<title>View Batches</title>
</head>
<body>
	<h2>Batch List</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Batch Name</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Max Capacity</th>
			<th>Action</th>
		</tr>
		<%
		BatchDAO batchDAO = new BatchDAO();
		List<Batch> batchList = batchDAO.getAllBatches();
		for (Batch batch : batchList) {
		%>
		<tr>
			<td><%=batch.getId()%></td>
			<td><%=batch.getBatchName()%></td>
			<td><%=batch.getStartTime()%></td>
			<td><%=batch.getEndTime()%></td>
			<td><%=batch.getMaxCapacity()%></td>
			<td><a href="editBatch.jsp?id=<%=batch.getId()%>">Edit</a> | <a
				href="deleteBatch?id=<%=batch.getId()%>"
				onclick="return confirm('Are you sure you want to delete this batch?');">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="index.jsp">Back to Home</a>
</body>
</html>
