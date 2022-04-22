package com.example.lp_lab09v2;

import com.example.lp_lab09v2.DB.ConnectorDb;
import com.example.lp_lab09v2.DB.RequestManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int group = Integer.parseInt(req.getParameter("group"));
        String auditorium = req.getParameter("auditorium");
        String subject = req.getParameter("subject");
        String teacher = req.getParameter("teacher");
        String weekDay = req.getParameter("weekDay");
        ConnectorDb connectorDb = new ConnectorDb();
        try {
            RequestManager requestManager = new RequestManager(connectorDb.getConnection("TimeTableDb"));
            requestManager.addSubject(group, auditorium, subject, teacher, weekDay);
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
            requestManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }

    }

}
