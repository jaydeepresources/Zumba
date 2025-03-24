package com.zumba.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.ParticipantDAO;
import com.zumba.model.Participant;

@WebServlet("/updateParticipant")
public class UpdateParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int batchId = Integer.parseInt(request.getParameter("batchId"));
        
        Timestamp enrollmentDate = null;
        try {
            String dateStr = request.getParameter("enrollmentDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            enrollmentDate = new Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Participant participant = new Participant(id, name, email, phone, batchId, enrollmentDate);
        ParticipantDAO participantDAO = new ParticipantDAO();

        if (participantDAO.updateParticipant(participant)) {
            response.sendRedirect("viewParticipants.jsp");
        } else {
            response.getWriter().println("Error updating participant.");
        }
    }
}
