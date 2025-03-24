package com.zumba.servlet;

import com.zumba.dao.ParticipantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteParticipant")
public class DeleteParticipantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ParticipantDAO participantDAO = new ParticipantDAO();
            
            boolean success = participantDAO.deleteParticipant(id);
            if (success) {
                response.sendRedirect("viewParticipants.jsp?success=Participant deleted successfully.");
            } else {
                response.sendRedirect("viewParticipants.jsp?error=Failed to delete participant.");
            }
            
        } catch (NumberFormatException e) {
            response.sendRedirect("viewParticipants.jsp");
        } catch (Exception e) {
            response.sendRedirect("viewParticipants.jsp");
        }
    }
}
