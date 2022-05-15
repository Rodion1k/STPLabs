package com.example.lp_lab09v2;

import com.example.lp_lab09v2.DB.ConnectorDb;
import com.example.lp_lab09v2.DB.Db;
import com.example.lp_lab09v2.DB.RequestManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginPass", value = "/loginPass")
public class LoginPassServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        HttpSession session = request.getSession();
        try {
           ConnectorDb connectorDb = new ConnectorDb();
           var connection = connectorDb.getConnection("Users");
            RequestManager requestManager = new RequestManager(connection);

            //dataBase.FillTableUsers();
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            if (requestManager.isUser(username, password, role)) {
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
            } else {
                request.setAttribute("message","Такого пользователя нет. Зарегистрируйтесь");
                getServletContext().getRequestDispatcher("/registerForm.jsp").forward(request, response);
            }

            requestManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Пользователь не авторизован");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        HttpSession session = request.getSession();
        try {
            ConnectorDb connectorDb = new ConnectorDb();
            var connection = connectorDb.getConnection("Users");
            RequestManager requestManager = new RequestManager(connection);
            //dataBase.FillTableUsers();
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            if (requestManager.isUser(username, password, role)) {
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/registerForm.jsp").forward(request, response);
            }

            requestManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
