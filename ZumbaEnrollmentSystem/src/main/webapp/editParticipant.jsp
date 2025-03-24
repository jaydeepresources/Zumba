<%@page import="com.zumba.model.Participant"%>
<%@page import="com.zumba.model.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Participant</title>
    <script>
        function setMinDate() {
            let today = new Date();
            let day = String(today.getDate()).padStart(2, '0');
            let month = String(today.getMonth() + 1).padStart(2, '0');
            let year = today.getFullYear();
            let minDate = year + '-' + month + '-' + day;
            document.getElementById("enrollmentDate").setAttribute("min", minDate);
        }
    </script>
</head>
<body onload="setMinDate()">
    <h2>Edit Participant</h2>
    
    <%
        Participant participant = (Participant) request.getAttribute("participant");
        List<Batch> batches = (List<Batch>) request.getAttribute("batches");
    %>
    
    <form action="updateParticipant" method="post">
        <input type="hidden" name="id" value="<%= participant.getId() %>">

        <label>Name:</label> 
        <input type="text" name="name" value="<%= participant.getName() %>" required><br><br>

        <label>Email:</label> 
        <input type="email" name="email" value="<%= participant.getEmail() %>" required><br><br>

        <label>Phone:</label> 
        <input type="text" name="phone" value="<%= participant.getPhone() %>" required><br><br>

        <label>Batch:</label> 
        <select name="batchId" required>
            <% for (Batch batch : batches) { %>
                <option value="<%= batch.getId() %>" <%= batch.getId() == participant.getBatchId() ? "selected" : "" %>>
                    <%= batch.getBatchName() %>
                </option>
            <% } %>
        </select>
        <br><br>

        <label>Enrollment Date:</label> 
        <input type="date" id="enrollmentDate" name="enrollmentDate" value="<%= participant.getEnrollmentDate() %>" required><br><br>

        <button type="submit">Update</button>
    </form>
    <br>
	<a href="index.jsp">Back to Home</a>
</body>
</html>
