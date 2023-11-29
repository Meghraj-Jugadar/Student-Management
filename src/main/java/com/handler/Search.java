package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Register_bo;
import com.dao.Register_dao;


/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		
		 List<Register_bo> fe=Register_dao.search(std_id);
		 pw.print("<center>");   
		 
		    pw.print("Student Details <br><br>");
		    
		    pw.print("<table border='2px' width='400px'>");
		    
		    pw.print("<tr><th>Student ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Password</th></tr> ");
		    
		    for(Register_bo el:fe)
		    {
		    	pw.print("<tr><td>"+el.getStd_id()+"</td><td>"+el.getStd_name()+"</td><td>"+el.getStd_phone()+"</td><td>"+el.getStd_email()+"</td><td>"+el.getStd_password()+"</td></tr>");
		    }
		    
		    pw.print("</table>");
		    
		    pw.print("</center>");
		    pw.close();
	}

}
