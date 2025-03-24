package com.zumba.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.BatchDAO;
import com.zumba.dao.ParticipantDAO;
import com.zumba.model.Batch;
import com.zumba.model.Participant;

@WebServlet("/editParticipant")
public class EditParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        ParticipantDAO participantDAO = new ParticipantDAO();
        BatchDAO batchDAO = new BatchDAO();
        
        Participant participant = participantDAO.getParticipantById(id);
        List<Batch> batches = batchDAO.getAllBatches();

        request.setAttribute("participant", participant);
        request.setAttribute("batches", batches);
        request.getRequestDispatcher("editParticipant.jsp").forward(request, response);
    }
}