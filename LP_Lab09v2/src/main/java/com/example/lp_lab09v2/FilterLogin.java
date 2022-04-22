package com.example.lp_lab09v2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class FilterLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();
        String Login = (String) session.getAttribute("username");
        if (Login == null) {
            throw new RuntimeException("Пользователь не авторизован");
//            httpServletResponse.sendRedirect("registerForm.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}