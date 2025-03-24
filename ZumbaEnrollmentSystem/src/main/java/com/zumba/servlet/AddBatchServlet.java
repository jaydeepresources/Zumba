package com.zumba.servlet;

import java.io.IOException;
import com.zumba.dao.BatchDAO;
import com.zumba.model.Batch;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBatch")
public class AddBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String batchName = request.getParameter("batchName");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int maxCapacity = Integer.parseInt(request.getParameter("maxCapacity"));

        Batch batch = new Batch(0, batchName, startTime, endTime, maxCapacity);
        BatchDAO batchDAO = new BatchDAO();
        boolean success = batchDAO.addBatch(batch);

        if (success) {
            response.sendRedirect("batchSuccess.jsp");
        } else {
            response.sendRedirect("batchError.jsp");
        }
    }
}