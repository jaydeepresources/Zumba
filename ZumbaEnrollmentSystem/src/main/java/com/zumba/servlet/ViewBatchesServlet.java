package com.zumba.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zumba.dao.BatchDAO;
import com.zumba.model.Batch;



@WebServlet("/viewBatches")
public class ViewBatchesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BatchDAO batchDAO = new BatchDAO();
        List<Batch> batchList = batchDAO.getAllBatches();

        request.setAttribute("batches", batchList);
        request.getRequestDispatcher("viewBatches.jsp").forward(request, response);
    }
}