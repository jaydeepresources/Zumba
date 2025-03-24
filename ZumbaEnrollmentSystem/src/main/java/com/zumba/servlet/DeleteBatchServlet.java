package com.zumba.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.BatchDAO;

@WebServlet("/deleteBatch")
public class DeleteBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int batchId = Integer.parseInt(request.getParameter("id"));
        BatchDAO batchDAO = new BatchDAO();
        boolean success = batchDAO.deleteBatch(batchId);

        if (success) {
            response.sendRedirect("viewBatches"); // Refresh the batch list
        } else {
            response.sendRedirect("batchError.jsp");
        }
    }
}
