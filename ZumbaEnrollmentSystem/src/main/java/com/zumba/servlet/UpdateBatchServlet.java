package com.zumba.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.BatchDAO;
import com.zumba.model.Batch;

@WebServlet("/updateBatch")
public class UpdateBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String batchName = request.getParameter("batchName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int maxCapacity = Integer.parseInt(request.getParameter("maxCapacity"));

        Batch updatedBatch = new Batch(id, batchName, startTime, endTime, maxCapacity);
        BatchDAO batchDAO = new BatchDAO();
        boolean success = batchDAO.updateBatch(updatedBatch);

        if (success) {
            response.sendRedirect("viewBatches.jsp");
        } else {
            response.sendRedirect("batchError.jsp");
        }
    }
}
