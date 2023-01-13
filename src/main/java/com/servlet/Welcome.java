package com.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Welcome  extends HttpServlet  {

protected void doPost(HttpServletRequestWrapper request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);
}


}
