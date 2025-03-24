package com.zumba.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.ParticipantDAO;
import com.zumba.model.Participant;

@WebServlet("/addParticipant")
public class AddParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String batchIdStr = request.getParameter("batchId");
        String enrollmentDateStr = request.getParameter("enrollmentDate");

        int batchId = batchIdStr == null || batchIdStr.isEmpty() ? 0 : Integer.parseInt(batchIdStr);
        
        // Validate and parse enrollmentDate
        LocalDate today = LocalDate.now();
        LocalDate enrollmentDate = LocalDate.parse(enrollmentDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        Timestamp enrollmentTimestamp = Timestamp.valueOf(enrollmentDate.atStartOfDay());

        Participant participant = new Participant(0, name, email, phone, batchId, enrollmentTimestamp);
        ParticipantDAO participantDAO = new ParticipantDAO();
        boolean success = participantDAO.addParticipant(participant);

        if (success) {
            response.sendRedirect("participantSuccess.jsp");
        } else {
            response.sendRedirect("participantError.jsp");
        }
    }
}
