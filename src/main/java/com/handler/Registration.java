package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Register_bo;
import com.dao.Register_dao;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String std_id=request.getParameter("std_id");
		String std_name=request.getParameter("std_name");
		String std_phone=request.getParameter("std_phone");
		String std_email=request.getParameter("std_email");
		String std_password=request.getParameter("std_password");
		
		Register_bo rb=new Register_bo(std_id, std_name, std_phone, std_email, std_password);
		
		int status=Register_dao.insert(rb);
		if(status>0) {
			pw.print("Inserted Successfullly");
		}
		else {
			pw.print("Something is Wrong");
		}
	}

}
